import objectdraw.*;
import java.awt.*;

public class AllFishClient extends WindowController{

  public static void main(String[] args) {
    new AllFishClient().startController( 800,850 );
  }


  private Fish_AC ac;
  private Fish_CK ck;
  private Fish_DP dp;
  private Fish_FD fd;
  private Fish_HA ha;
  private Fish_PC pc;
  private Fish_RH rh;
  private Fish_SM sm;
  private Fish_TB tb;

  private Location AC_LOCATION = 
                   new Location ( canvas.getWidth()/4+200,
                                  canvas.getHeight()/6+50 );
  private Location CK_LOCATION = 
                   new Location ( canvas.getWidth()/4+200,
                                  canvas.getHeight()/6+170 );
  private Location DP_LOCATION = 
                   new Location ( canvas.getWidth()/4+200,
                                  canvas.getHeight()/6+290 );
  private Location FD_LOCATION = 
                   new Location ( canvas.getWidth()/4+200,
                                  canvas.getHeight()/6+410 );
  private Location HA_LOCATION = 
                   new Location ( canvas.getWidth()/4+200,
                                  canvas.getHeight()/6+530 );
  private Location PC_LOCATION = 
                   new Location ( canvas.getWidth()/4+200,
                                  canvas.getHeight()/6+650 );
  private Location RH_LOCATION = 
                   new Location ( canvas.getWidth()/4+650,
                                  canvas.getHeight()/6+110 );
  private Location SM_LOCATION = 
                   new Location ( canvas.getWidth()/4+650,
                                  canvas.getHeight()/6+220 );
  private Location TB_LOCATION = 
                   new Location ( canvas.getWidth()/4+650,
                                  canvas.getHeight()/6+340 );

  private Text namesAC 
              ,namesCK 
              ,namesDP 
              ,namesFD
              ,namesHA
              ,namesPC 
              ,namesRH
              ,namesSM
              ,namesTB;

  private FilledRoundedRect moveButton, 
                            colorButton;

  private FramedRoundedRect moveFrame,
                            colorFrame;

  private Text moveText,
               colorText;

  private RandomIntGenerator rgb = new RandomIntGenerator ( 0,255 );

  private RandomIntGenerator xy = new RandomIntGenerator ( -4,4 );

  private FilledRect bg;
  

  public void begin(){
    bg = new FilledRect( 0,0, canvas.getWidth(), canvas.getHeight(), canvas );
    bg.setColor( new Color( 229, 239, 255 ) ); 

    moveButton = new FilledRoundedRect( 5, 6, 60, 30, 10, 10, canvas);
    moveFrame = new FramedRoundedRect( 5, 6, 60, 30, 10, 10, canvas);
    moveButton.setColor(Color.YELLOW);
    moveText = new Text("Move", 13, 11, canvas);
    moveText.setFontSize( 15 ); 

    colorButton = new FilledRoundedRect( 80, 6, 60, 30, 10, 10, canvas);
    colorFrame = new FramedRoundedRect( 80, 6, 60, 30, 10, 10, canvas);
    colorButton.setColor(Color.YELLOW);
    colorText = new Text("Color", 88, 11, canvas);
    colorText.setFontSize( 15 );  
  
    ac = new Fish_AC ( AC_LOCATION, 50,50, canvas );
    namesAC = new Text("Aidan and Celia", 35, 50, canvas);
    namesAC.setFontSize(18);

    ck = new Fish_CK ( CK_LOCATION, 50,50, canvas );
    namesCK = new Text("Cordell and Cait", 35, 170, canvas); 
    namesCK.setFontSize(18);

    dp = new Fish_DP ( DP_LOCATION, 50,50, canvas );
    namesDP = new Text("Petros and Dylan", 35, 290, canvas);
    namesDP.setFontSize(18);

    fd = new Fish_FD ( FD_LOCATION, 50,50, canvas );
    namesFD = new Text("Fleming and Derek", 35, 410, canvas);
    namesFD.setFontSize(18);

    ha = new Fish_HA ( HA_LOCATION, 50,50, canvas );
    namesHA = new Text("Harry and Alyssa", 35, 530, canvas);
    namesHA.setFontSize(18);

    pc = new Fish_PC ( PC_LOCATION, 50,50, canvas );
    namesPC = new Text("Phillip and Carlton", 35, 650, canvas);
    namesPC.setFontSize(18);

    rh = new Fish_RH ( RH_LOCATION, 50,50, canvas );
    namesRH = new Text("Ron and Owen", 490, 110, canvas);
    namesRH.setFontSize(18);

    sm = new Fish_SM ( SM_LOCATION, 50,50, canvas );
    namesSM = new Text("Sophie and Maria", 490, 220, canvas);
    namesSM.setFontSize(18);

    tb = new Fish_TB ( TB_LOCATION, 50,50, canvas );
    namesTB = new Text("Thomas", 490, 340, canvas);
    namesTB.setFontSize(18);
  }

   public void onMouseClick(Location p){
     if(moveButton.contains(p)){
       ck.move(-5, 0);
       dp.move(-5, 0);
       fd.move(-5, 0);
       sm.move(-5, 0);
       ha.move(5, 0);
       pc.move(5, 0);
       ac.move(xy.nextValue(), xy.nextValue() );


     }if(colorButton.contains(p)){
       Color fishColor = new Color(rgb.nextValue()
                                  ,rgb.nextValue()
                                  ,rgb.nextValue());
       ac.setColor(fishColor);
       fd.setColor(fishColor);
       pc.setColor(fishColor);
       sm.setColor(fishColor);
   }
  }

  public void onMouseExit( Location p ){
   canvas.clear();
   begin(); 
  }

}
