import java.util.Scanner;
import java.io.console;

public abstract class TextDevice {
  public abstract TextDevice printf(String fmt, Object... params)
      throws ConsoleException;

  public abstract String readLine() throws ConsoleException;

  public abstract char[] readPassword() throws ConsoleException;

  public abstract Reader reader() throws ConsoleException;

  public abstract PrintWriter writer() throws ConsoleException;
}

 private static TextDevice DEFAULT = (System.console() == null) ? streamDevice(
      System.in, System.out)
      : new ConsoleDevice(System.console());

  public static TextDevice defaultTextDevice() {
    return DEFAULT;
  }

  public static TextDevice streamDevice(InputStream in, OutputStream out) {
    BufferedReader reader = new BufferedReader(new InputStreamReader(in));
    PrintWriter writer = new PrintWriter(out, true);
    return new CharacterDevice(reader, writer);
  }

public class Login{
static console c = System.console;
static Scanner S = new Scanner(System.in);
static String UN,PS;
 public boolean log(){
  System.out.println("UserName : ");
   UN=S.nextLine();
  System.out.println("Password : ");
  
  
    
  }
 
 public validate(){
  }
 
 }
