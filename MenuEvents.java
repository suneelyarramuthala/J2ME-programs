import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
public class MenuEvents extends MIDlet implements CommandListener,ItemStateListener {
public ChoiceGroup ch;
public ChoiceGroup ch1;
public Form form;
public Form form1;
public Display display;
public Command View;
public Command Exit;
public Command Back;
public StringItem options;
public Item item;
public MenuEvents()
{
display=Display.getDisplay(this);
form=new Form("");
form1=new Form("Selcted Options are");
ch=new ChoiceGroup("Preferences",Choice.MULTIPLE);
ch.append("cut",null);
ch.append("copy",null);
ch.append("paste",null);
ch.append("delete",null);
form.append(ch);
ch1=new ChoiceGroup("",Choice.EXCLUSIVE);
ch1.append("select all",null);
ch1.append("unselect all",null);
form.append(ch1);
View=new Command("View",Command.OK,1);
Exit =new Command("Exit",Command.EXIT,1);
Back=new Command("Back",Command.BACK,1);
form.addCommand(View);
form.addCommand(Exit);
form1.addCommand(Back);
form.setCommandListener(this);
form1.setCommandListener(this);
form.setItemStateListener(this);
}
public void startApp()
{
display.setCurrent(form);
}
public void pauseApp() {
}
public void destroyApp(boolean unconditional) {
}
public void commandAction(Command command,Displayable displayable)
{
if(displayable==form)
{
if(command==View)
{
boolean opt[]=new boolean[ch.size()];
options=new StringItem("","");
String values="";
ch.getSelectedFlags(opt);
options.setText("");
for(int i=0;i<opt.length;i++)
{
if(opt[i])
{
values+=ch.getString(i)+"\n";
}
}
options.setText(values);
form1.append(options);
display.setCurrent(form1);
}
else if(command==Exit)
{
destroyApp(true);
notifyDestroyed();
}
}
else if(displayable==form1)
{
if(command==Back)
{
display.setCurrent(form);
options.setText("");
}
}
}
public void itemStateChanged(Item item)
{
if(item==ch1)
{
int i=0;
int size=ch.size();
while(i<size)
{
if(ch1.getSelectedIndex()==0)
ch.setSelectedIndex(i, true);
else
ch.setSelectedIndex(i, false);
i++;
}
}
}
}
