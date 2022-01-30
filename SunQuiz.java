import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
public class SunQuiz extends MIDlet implements
CommandListener
{
private Display display;
private Form form1,form2,form3,form4,form5;
private ChoiceGroup ch1,ch2,ch3,ch4;
private Command next;
private Command back;
private Command ok;
private Command exit;
private StringItem st;
int count=0;
public SunQuiz()
{
display=Display.getDisplay(this);
next=new Command("Next",Command.OK,1);
back=new Command("Back",Command.BACK,1);

st=new StringItem("Total correct answers","0");
form1=new Form("1.J2ME is?");
ch1=new ChoiceGroup("",Choice.EXCLUSIVE);
ch1.append("mobile java", null);
ch1.append("java automatic", null);
ch1.append("standard java", null);
ch1.append("for serverside", null);
form1.append(ch1);
form1.addCommand(next);
form1.setCommandListener(this);

form2=new Form("2.What is JAVA?");
ch2=new ChoiceGroup("",Choice.EXCLUSIVE);
ch2.append("Object Oriented Program",null);
ch2.append("Assembly Language",null);
ch2.append("Modeling Language",null);
ch2.append("System Software",null);
form2.append(ch2);
form2.addCommand(next);
form2.addCommand(back);
form2.setCommandListener(this);

form3=new Form("3.Root of 625?");
ch3=new ChoiceGroup("",Choice.EXCLUSIVE);
ch3.append("15", null);
ch3.append("35", null);
ch3.append("45", null);
ch3.append("25", null);
form3.append(ch3);
form3.addCommand(next);
form3.addCommand(back);
form3.setCommandListener(this);

form4=new Form("4.Class is a collection of ?");
ch4=new ChoiceGroup("",Choice.EXCLUSIVE);
ch4.append("variables", null);
ch4.append("objects ", null);
ch4.append("operations", null);
ch4.append("interfaces", null);
form4.append(ch4);
form4.addCommand(next);
form4.addCommand(back);
form4.setCommandListener(this);

form5=new Form("Score");
exit=new Command("Exit",Command.SCREEN,1);
ok=new Command("Submit",Command.OK,2);
form5.addCommand(ok);
form5.addCommand(exit);
form5.setCommandListener(this);


}
public void startApp()
{
display.setCurrent(form1);
}
public void pauseApp()
{
}
public void destroyApp(boolean unconditional)
{
}
public void commandAction(Command cmd,Displayable
displayable)
{

if(displayable==form1)
{
if(cmd==next)
display.setCurrent(form2);
}
else if(displayable==form2)
{
if(cmd==next)
display.setCurrent(form3);
else if(cmd==back)
display.setCurrent(form1);
}
else if(displayable==form3)
{
if(cmd==next)
display.setCurrent(form4);
else if(cmd==back)
display.setCurrent(form2);
}
else if(displayable==form4)
{
if(cmd==next)
{
if(ch1.getSelectedIndex()==0)
count++;
if(ch2.getSelectedIndex()==0)
count++;
if(ch3.getSelectedIndex()==3)
count++;
if(ch4.getSelectedIndex()==1)
count++;
st.setText(String.valueOf(count));
form5.append(st);
display.setCurrent(form5);
}

}
else if(displayable==form5)
{
if(cmd==ok)
{
display.setCurrent(form5);
}
else if(cmd==exit)
{
destroyApp(false);
notifyDestroyed();
}
}
}
}