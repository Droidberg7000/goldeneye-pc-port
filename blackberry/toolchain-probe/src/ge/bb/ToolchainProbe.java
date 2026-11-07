package ge.bb;
import javax.microedition.midlet.MIDlet;
import javax.microedition.lcdui.*;
/** Toolchain test only. No GoldenEye code or assets. */
public final class ToolchainProbe extends MIDlet implements CommandListener {
 private final Command exit=new Command("Exit",Command.EXIT,1);
 private Screen screen;
 protected void startApp(){if(screen==null){screen=new Screen();screen.addCommand(exit);screen.setCommandListener(this);}Display.getDisplay(this).setCurrent(screen);}
 protected void pauseApp(){}
 protected void destroyApp(boolean force){}
 public void commandAction(Command c,Displayable d){if(c==exit){destroyApp(true);notifyDestroyed();}}
 private static final class Screen extends Canvas {
  private int key,events;
  protected void keyPressed(int code){key=code;events++;repaint();}
  protected void paint(Graphics g){
   g.setColor(0);g.fillRect(0,0,getWidth(),getHeight());g.setColor(0xffffff);
   int y=2,h=g.getFont().getHeight()+2;
   g.drawString("Java ME toolchain probe",2,y,Graphics.TOP|Graphics.LEFT);y+=h;
   g.drawString("Not GoldenEye",2,y,Graphics.TOP|Graphics.LEFT);y+=h;
   g.drawString("Screen: "+getWidth()+" x "+getHeight(),2,y,Graphics.TOP|Graphics.LEFT);y+=h;
   g.drawString("Key: "+key+" events: "+events,2,y,Graphics.TOP|Graphics.LEFT);y+=h;
   g.drawString("Free heap: "+Runtime.getRuntime().freeMemory(),2,y,Graphics.TOP|Graphics.LEFT);
  }
 }
}
