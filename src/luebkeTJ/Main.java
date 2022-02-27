package luebkeTJ;





import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.imageio.ImageIO;

import org.lwjgl.BufferUtils;
import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.openal.AL;
import org.lwjgl.openal.AL10;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.PixelFormat;
import org.lwjgl.util.vector.Quaternion;
import org.lwjgl.util.vector.Vector4f;

import static org.lwjgl.util.glu.GLU.*;

import org.newdawn.slick.openal.Audio;
import org.newdawn.slick.openal.AudioLoader;
import org.newdawn.slick.openal.SoundStore;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;


public class Main {
	//Character
	double changeRotBy = 0;
	Vector lastCamRot = new Vector();
	Vector cameraRotations = new Vector();
	int particleX = 200;
	int DetailX = 300;
	double RenderDisX = 300;
	boolean options = false;
	int optionsMode = 0;
	boolean optionsButton = false;
	double maxDetail = 2;
	double maxParticles = 100;
	double fade = 0;
	double dirVivid = 90;
	double healDirY = 0;
	double healDirX = 0;
	int renderType = 0;
	int surfacesRendered = 0;
	boolean noDetail = false;
	double riseEffectSpeed = 0;
	double riseEffect = -1;
	int riseEffectSpot = -1;
	int touchingThisSpot = 0;
	int dropTime = 0;
	int waitTime = 0;
	Vector respawnPoint = new Vector();
	double ballHealth = 1000;
	int lightningAmount = 99;
	Vector lightningFromAt = new Vector();
	Vector lightningFrom = new Vector();
	int lightningOn = 0;
	int shapesType = 0;
	int shapesHeight = 250;
	int shapesWidth = 250;
	boolean shapesEditor = false;
	boolean schematicLoaded = false;
	double alphaX = 700;
	Vector light0Dif = new Vector();
	Vector FogColor = new Vector();
	int dropAt = 0;
	boolean slowMoKey = false;
	boolean slowMoOn = false;
	float spinX = 0;
	float spinY = 0;
	float spinZ = 0;
	boolean pDown = false;
	int renderDistance = 150;
	int fogType = 0;
	int PlaythisTime = 0;
	int Level = 0;
	int obtainNail = 0;
	boolean blackFog = true;
	Map TJ = new Map();
	Vector lastBallPos = new Vector();
	double light0Dir = 0;
	int IntroTime = 0;
	int lastCollisionTime = 0;
	boolean lastCollision = false;
	//Vector light0Dir = new Vector();
	double times = 100000;
	boolean torchLight = false;
	Vector light0Pos = new Vector();
	Vector light0Amb = new Vector();
	double light0Intensity = 1;
	boolean printOut = false;
	Vector newerPosition = new Vector();
	double averageEdge = 0;
	double averagePlane = 0;
	Rotators box = new Rotators();
	int movementSpeed = 5;
	int[] switchMovement = {0,0,0};
	int[] onThisMovement = {0,0};
	int editMovementNum = 0;
	boolean newMovement = false;
	boolean KeyDDown = false;
	int CharacterPart = 0;
	boolean KeyNewFrame = false;
	int Frame = 0;
	int CharacterEditMode = 0;
	double PlayerDirY = 0;
	boolean setVelocity = false;
	float RotateYW = 0;
	Vector SelectedPos = new Vector();
	List<Vector> SavedPos = new ArrayList<Vector>();
	boolean KeyVDown = false;
	boolean MouseSensedDown2 = false;
	boolean PauseAll = false;
	boolean MouseSensedDown = false;
	String currentSchematicName = new String();
	int EditTool = 0;
	Map currentSchematic = new Map();
	String[] listSchematics = Map.ListSchematics();
	int MapType = 1;
	Vector pointSet1 = new Vector();
	Vector pointSet2 = new Vector();
	Vector pointSet3 = new Vector();
	Vector ballLastPos = new Vector();
	double scrollItem = 0;
	int itemNumber = 0;
	boolean selectItem = false;
	boolean screenShotDown = false;
	boolean KeyMDown = false;
	int totalCollect = 0;
	int collected = 0;
	Data touchingThis = new Data();
	double sensitiveX = 300;
	double anySliderSelected = 0;
	double sensitive = 3;
	double collidedZoom = 0;
	double changeAndUpdate = 0;
	boolean touchingKeyN = false;
	double slowMo = 1;
	boolean touchingNoKey = false;
	Vector touchingPlaneNormal = new Vector();
	MyTime timeSinceTouched = new MyTime();
	double BallSpeed = 0.05;
	Vector Jump = new Vector();
	int powerUpType = 0;
	double sunLightDirX = 0;
	Vector ballRotation = new Vector();
	Vector rot = new Vector();
	MyTime startTime = new MyTime();
	MyTime playTime = new MyTime();
	MyTime powerUpTime = new MyTime();
	boolean foundMap = false;
	boolean PauseButton = false;
	boolean Paused = false;
	int screenWidth = 0;
	int screenHeight = 0;
	double CamY = 0;
	String mapName = "";
	double zoom = -3;
	int mode = 0;
	double characterDir = 0;
	//Map Vars
	Vector lastPos = new Vector();
	Map EditorMap = new Map();
	Map currentMap = new Map();
	//Audio Vars
	
	double MouseX = 0;
	double MouseY = 0;
	//Collision vars
	Texture text;
	Texture ball;
	double veloXGravi = 0;
	double veloYGravi = -0.003;
	double veloZGravi = 0;
	int sliderVelo = 0;

	double sliderXVeloX = 190;
	double sliderYVeloX = 80;
	double sliderXVeloY = 170;
	double sliderYVeloY = 50;
	double sliderXVeloZ = 190;
	double sliderYVeloZ = 20;
	Vector newerVelocityVector = new Vector();
	double collisionTime = 0;
	Vector jumpNormal = new Vector();
	Vector vStor = new Vector();
	double newT = 0;
	CollisionPacket collisionPackage = new CollisionPacket();
	boolean firstCollide = false;
	Vector holdVelo = new Vector();
	int x = 0;
	double collisionRecursionDepth = 0;
	double totLegDir = 0;
	double legDir = 90;
	double legTurn = 0;
	boolean touching = false;
	Vector veloNorm = new Vector();
	//Editor
	boolean switchFrom = false;
	double editMove = 0.2;
	boolean EditBlockPlace = false;
	int ColorMouse = 0;
	double sliderXMove = 620;
	double sliderYMove = 30;
	double sliderXRed = 340;
	double sliderYRed = 80;
	double sliderXGreen = 340;
	double sliderYGreen = 50;
	double sliderXBlue = 340;
	double sliderYBlue = 20;
	double EditRed = 1000;
	double EditGreen = 1000;
	double EditBlue = 1000;
	boolean pointConnections = false;
	boolean renderOne = false;
	connections EditorConnect = new connections();
	boolean EditConnect = false;
	boolean editDel = false;
	Vector editPos = new Vector();
	Data editD = new Data();
	int editData = 1;
	boolean editKey2 = false;
	boolean editKey = false;
	int connectNumber = 1;
	boolean onlyRenderOne = false;
	int RenderingNum = 0;
	Data renderOnlyData = new Data();
	//introVars
	int intro = 2;
	//Lighting vars
	double gamma = 0.2;
	//Position vars
	double cameraDirX = 0;
	double cameraDirY = 0;
	double cameraDirZ = 0;
	Vector light = new Vector();
	double tmpx;
	double tmpy;
	double tmpz;
	Vector velo = new Vector();
	Vector FlashLightLeft = new Vector();
	Vector FlashLightRight = new Vector();
	double lightDir = -210;
	double lightDirTurn = 0.1;
	double cameraX = 1;
	double cameraY = 1;
	double cameraZ = -15;
	Vector pos = new Vector();
	Vector gravity = new Vector();
	double HorizontalSpeed = 0;
	double VerticalSpeed = 0;
	double RollingSpeed = 0;
	int viewFactor = 600;
	double LightDirY = 180;
	double LightDirX = 145;
	double lightX = 0;
	double lightY = 10;
	double lightZ = 0;
	//Angle vars
	double XarX = 1;
	double XarY = 0;
	double XarZ = 0;
	double YarX = 0;
	double YarY = 1;
	double YarZ = 0;
	double ZarX = 0;
	double ZarY = 0;
	double ZarZ = 1;
	//Drawing vars
	double drawX = 0;
	double drawY = 0;
	double drawZ = 0;
	double checkReX = 0;
	double checkReY = 0;
	//Other vars
	double turnVelo = 0;
	double Distance = 0;
	int storyTime = 0;
	int storyTimeSec = 0;
	int sideStory = 0;
	int storyLine = 0;
	int eyeCloseTime = 0;
	boolean pauseGamePlay = false;
	Rotators sphere = new Rotators();
	Texture VividEye;
	Texture LogoStuff;
	Texture DM;
	Texture SleepBall;
	Texture Ransom;
	Texture BallEnemy;
	Audio Hit;
	Audio IntroMusic;
	Audio Rolling;
	Audio Pop;
	Audio Drops;
	Audio Firework;
	//List's
	List<Data> data = new ArrayList<Data>();
	List<Data> vividEye = new ArrayList<Data>();
	List<Ball> ballList = new ArrayList<Ball>();
	List<Items> items = new ArrayList<Items>();
	List<Lights> lights = new ArrayList<Lights>();
	List<Data> render = new ArrayList<Data>();
	List<Data> Nail = new ArrayList<Data>();
	List<Data> particleCollides = new ArrayList<Data>();
	List<Particle> particles = new ArrayList<Particle>();
	List<Rotators> Player = new ArrayList<Rotators>();
	public static void main(String[] args) {
		Main displayMain = new Main();
		 
		   
		displayMain.start();
	}
	public Vector slider(double x, double y,double maxX, double minX,int num)
	{
		Make2D();
		draw2DQuad(minX - 7,y + 7,maxX + 7,y + 7,maxX + 7,y - 7,minX - 7,y - 7,1,1,1,0.5,0.5,1,1);
		draw2DQuad(x - 5, y + 5,x + 5, y + 5,x + 5, y - 5,x - 5, y - 5,0,1,0,1,1,0.5,0.5);

		Vector outPut = new Vector();
		outPut.x = x;
		if(Mouse.isButtonDown(0))
		{


			if(anySliderSelected == 0)
			{

				double distance = distance2D((x / 1000) * screenWidth,(y / 800) * screenHeight,MouseX,MouseY);
				if(distance < 10)
				{
					anySliderSelected = num;
					outPut.x = (MouseX / screenWidth) * 1000;
					outPut.z = 1;
				}
			}
		}
		else
		{
			anySliderSelected = 0;
		}
		if(anySliderSelected == num)
		{
			outPut.x = (MouseX / screenWidth) * 1000;
			if(outPut.x > maxX)
			{
				outPut.x = maxX;
			}
			if(outPut.x < minX)
			{
				outPut.x = minX;
			}
			outPut.z = 1;
		}
		else
		{
			outPut.z = 0;
		}
		Make3D();
		return outPut;

	}
	public Rotators setUpPart(int part)
	{
		Rotators parts = new Rotators();
		if(part == 1)
		{
			parts.pos.y = 0 * 3;
			parts.RotateAround.x = 0;
			parts.RotateAround.y = 0;
			parts.RotateAround.z = 0;
			parts.points = returnValueSphere(0.15 * 3,0.25 * 3,0.1 * 3,4.5,11,20,8,18,parts.RotateAround,0.4,0.7,1,0);
		}
		if(part == 2)
		{
			
			parts.RotateAround.x = 0;
			parts.RotateAround.y = 0.125 * 3;
			parts.RotateAround.z = 0;
			parts.pos.y = 0.39 * 3;
			parts.points = returnValueSphere(0.15 * 3,0.15 * 3,0.15 * 3,9,10,10,18,36,parts.RotateAround,1,1,0.5,0);
		}
		if(part == 3)
		{
			
			parts.RotateAround.x = 0;
			parts.RotateAround.y = -0.05 * 3;
			parts.RotateAround.z = 0;
			parts.pos.y = 0.1 * 3;
			parts.points = returnValueSphere(0.05 * 3,0.1 * 3,0.05 * 3,18,10,10,18,36,parts.RotateAround,1,1,0.5,0);
		}
		if(part == 4)
		{
			
			parts.RotateAround.x = 0;
			parts.RotateAround.y = -0.05 * 3;
			parts.RotateAround.z = 0;
			parts.pos.y = 0.1 * 3;
			parts.points = returnValueSphere(0.05 * 3,0.1 * 3,0.05 * 3,18,10,10,18,36,parts.RotateAround,1,1,0.5,0);
		}
		if(part == 5)
		{
			
			parts.RotateAround.x = 0;
			parts.RotateAround.y = 0.125 * 3;
			parts.RotateAround.z = 0;
			parts.pos.y = 0.2 * 3.1;
			parts.points = returnValueSphere(0.04 * 3,0.04 * 3,0.04 * 3,90,10,10,0.01,36,parts.RotateAround,1,1,0.5,1);
		}
		if(part == 6)
		{
			
			parts.RotateAround.x = 0;
			parts.RotateAround.y = 0;
			parts.RotateAround.z = 0;
			parts.pos.y = 0.01 * 3;
			parts.points = returnValueSphere(0.15 * 3,0.1 * 3,0.1 * 3,90,20,20,-4.5,18,parts.RotateAround,0.4,0.7,1,0);
		}
		if(part == 7)
		{
			
			parts.RotateAround.x = 0;
			parts.RotateAround.y = -0.1 * 3;
			parts.RotateAround.z = 0;
			parts.pos.y = -0.15 * 3;
			parts.points = returnValueSphere(0.05 * 3,0.15 * 3,0.05 * 3,18,10,10,18,36,parts.RotateAround,0.4,0.7,1,0);
		}
		if(part == 8)
		{
			
			parts.RotateAround.x = 0;
			parts.RotateAround.y = -0.1 * 3;
			parts.RotateAround.z = 0;
			parts.pos.y = -0.15 * 3;
			parts.points = returnValueSphere(0.05 * 3,0.15 * 3,0.05 * 3,18,10,10,18,36,parts.RotateAround,0.4,0.7,1,0);
		}
		parts.RotateAngles = returnMovements(part - 1);
		parts.pos = parts.pos.subtract(parts.RotateAround);
		Vector Rotate = new Vector();
		Rotate.x = 0;
		Rotate.y = 0;
		Rotate.z = 0;
		
		//Angles angle = new Angles();
		//angle.angles.add(Rotate);
		//parts.RotateAngles.add(angle);
		return parts;
	}
	public List<Angles> returnMovements(int part)
	{
		List<Angles> angles = new ArrayList<Angles>();
			boolean fileExists = true;
			int fileNum = -1;
			while(fileExists)
			{
				fileNum ++;
				String userhome = System.getProperty("user.home");
				File characterMovement = new File(userhome + "/BallRoll/Player Characteristics/Player Movements/" + part + "/" + fileNum);
				if(!characterMovement.exists())
				{
					fileExists = false;
				}
				else
				{
					System.out.println("FileLoaded");
					Angles a = new Angles();
					a.angles = (returnDecodedMovement(part,fileNum));
					a.Type = 0;
					angles.add(a);
				}
			}
		
		return angles;
	}
	public void loadSounds()
	{
		String userHome = System.getProperty("user.home");
		 try {
			 	Firework = AudioLoader.getAudio("WAV", ResourceLoader.getResourceAsStream(userHome + "/BallRoll/Sounds/Firework.wav"));
			 	Drops = AudioLoader.getAudio("WAV", ResourceLoader.getResourceAsStream(userHome + "/BallRoll/Sounds/Drop.wav"));
			 	Pop = AudioLoader.getAudio("WAV", ResourceLoader.getResourceAsStream(userHome + "/BallRoll/Sounds/Pop.wav"));
			 	Hit = AudioLoader.getAudio("WAV", ResourceLoader.getResourceAsStream(userHome + "/BallRoll/Sounds/Hit.wav"));
			 	IntroMusic = AudioLoader.getAudio("WAV", ResourceLoader.getResourceAsStream(userHome + "/BallRoll/Sounds/FallP.wav"));
			 	System.out.println(IntroMusic.getPosition());
			 	SoundStore.get().init();
			 	
		    } catch (IOException e) {
			    e.printStackTrace();
			}
		
	}
	public List<Vector> returnDecodedMovement(int part, int movement)
	{
		List<Vector> vectors = new ArrayList<Vector>();
		String line = "";
		String userHome = System.getProperty("user.home");
		File file = new File(userHome + "/BallRoll/" + "/Player Characteristics/" + "/Player Movements/" + part + "/" + movement);
		String totalString = "";
		try (InputStream in = new FileInputStream(file);
			    BufferedReader reader =
			      new BufferedReader(new InputStreamReader(in))) {
			    line = null;
			    while ((line = reader.readLine()) != null) {
			    	totalString = line + totalString;
			        
			    }
			} catch (IOException x) {
			    System.err.println(x);
		}
		String current = "";
		int numberOn = 0;
		double vX = 0;
		double vY = 0;
		double vZ = 0;
		for(int i = 0; i < totalString.length(); i ++)
		{
			if(totalString.substring(i, i + 1).equalsIgnoreCase(" "))
			{
				if(numberOn == 0)
				{
					vX = Double.parseDouble(current);
				}
				else if(numberOn == 1)
				{
					vY = Double.parseDouble(current);
				}
				else if(numberOn == 2)
				{
					vZ = Double.parseDouble(current);
					numberOn = -1;
				}
				current = "";
				numberOn ++;
			}
			else if(totalString.substring(i, i + 1).equalsIgnoreCase("j"))
			{
				Vector v = new Vector();
				v.x = vX;
				v.y = vY;
				v.z = vZ;
				vectors.add(v);
			}
			else
			{
				current = current + totalString.substring(i, i + 1);
			}
		}
		return vectors;
	}
	public List<Data> returnValueSphere(double XWidth, double YHeight, double ZWidth,double startY, int repeatY, int repeatX,double detailY, double detailX,Vector RotateAround,double Red, double Green, double Blue,int Type)
	{
		List<Data> points = new ArrayList<Data>();
		double dirY = 0;
		double dirX = startY;
		double addY = 0;
		for(int i = 0; i < repeatY; i ++)
		{
			if(Type == 1)
			{
				addY = addY + detailY;
			}
			else
			{
				dirX = dirX - detailY;
			}
			for(int t = 0; t < repeatX; t ++)
			{
				Data d = new Data();
				d.v3.x = (Math.sin(Math.toRadians(dirX)) * Math.sin(Math.toRadians(dirY))) * XWidth;
				d.v3.y = (Math.cos(Math.toRadians(dirX)) * YHeight) + addY;
				d.v3.z = (Math.sin(Math.toRadians(dirX)) * Math.cos(Math.toRadians(dirY))) * ZWidth;
				dirY = dirY + detailX;
				d.v2.x = (Math.sin(Math.toRadians(dirX)) * Math.sin(Math.toRadians(dirY))) * XWidth;
				d.v2.y = (Math.cos(Math.toRadians(dirX)) * YHeight) + addY;
				d.v2.z = (Math.sin(Math.toRadians(dirX)) * Math.cos(Math.toRadians(dirY))) * ZWidth;
				if(Type == 1)
				{
					addY = addY - detailY;
				}
				else
				{
					dirX = dirX - detailY;
				}
				d.v1.x = (Math.sin(Math.toRadians(dirX)) * Math.sin(Math.toRadians(dirY))) * XWidth;
				d.v1.y = (Math.cos(Math.toRadians(dirX)) * YHeight) + (addY);
				d.v1.z = (Math.sin(Math.toRadians(dirX)) * Math.cos(Math.toRadians(dirY))) * ZWidth;
				dirY = dirY - detailX;
				d.v4.x = (Math.sin(Math.toRadians(dirX)) * Math.sin(Math.toRadians(dirY))) * XWidth;
				d.v4.y = (Math.cos(Math.toRadians(dirX)) * YHeight) + (addY);
				d.v4.z = (Math.sin(Math.toRadians(dirX)) * Math.cos(Math.toRadians(dirY))) * ZWidth;
				if(Type == 1)
				{
					addY = addY + detailY;
				}
				else
				{
					dirX = dirX + detailY;
				}
				dirY = dirY + detailX;
				Data d2 = new Data();
				d.v1 = d.v1.add(RotateAround);
				d.v2 = d.v2.add(RotateAround);
				d.v3 = d.v3.add(RotateAround);
				d.v4 = d.v4.add(RotateAround);
				
				d2.v1.x = d.v4.x;
				d2.v1.y = d.v4.y;
				d2.v1.z = d.v4.z;
				d2.v2.x = d.v1.x;
				d2.v2.y = d.v1.y;
				d2.v2.z = d.v1.z;
				d2.v3.x = d.v3.x;
				d2.v3.y = d.v3.y;
				d2.v3.z = d.v3.z;
				d2.Red = Red;
				d2.Green = Green;
				d2.Blue = Blue;
				d.Red = Red;
				d.Green = Green;
				d.Blue = Blue;
				d.mid = d.v1.add(d.v2.add(d.v3));
				d.mid = d.mid.divideNon(3);
				d2.mid = d2.v1.add(d2.v2.add(d2.v3));
				d2.mid = d2.mid.divideNon(3);
				d.normal = getSurfaceNormal(d);
				d2.normal = getSurfaceNormal(d2);
				d.v1Normal = d.normal;
				d.v2Normal = d.normal;
				d.v3Normal = d.normal;
				d2.v1Normal = d2.normal;
				d2.v2Normal = d2.normal;
				d2.v3Normal = d2.normal;
				
				points.add(d);
				points.add(d2);
			}
		}
		
		
		return points;
	}
	public void switchSlowMo()
	{
		if(Keyboard.isKeyDown(Keyboard.KEY_Y))
		{
			if(slowMoKey == false)
			{
				if(slowMoOn == false)
				{
					slowMo = 1.5;
					slowMoOn = true;
					if(IntroMusic.isPlaying())
					{
						float soundPos = IntroMusic.getPosition();
						IntroMusic.stop();
						IntroMusic.playAsMusic((float)1 / (float)slowMo, 1,true);
						IntroMusic.setPosition(soundPos);
					}
					if(Hit.isPlaying())
					{
						float soundPos = Hit.getPosition();
						Hit.stop();
						Hit.playAsMusic((float)1 / (float)slowMo, 1,false);
						Hit.setPosition(soundPos);
					}
				}
				else
				{
					slowMo = 1;
					slowMoOn = false;
					if(IntroMusic.isPlaying())
					{
						
						float soundPos = IntroMusic.getPosition();
						IntroMusic.stop();
						IntroMusic.playAsMusic((float)1, 1,true);
						IntroMusic.setPosition(soundPos);
					}
					if(Hit.isPlaying())
					{
						float soundPos = Hit.getPosition();
						Hit.stop();
						Hit.playAsMusic((float)1, 1,false);
						Hit.setPosition(soundPos);
					}
				}
				slowMoKey = true;
			}
		}
		else
		{
			slowMoKey = false;
		}
	}
	public void sunDraw()
	{
		double dir = 0;
		GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glBegin(GL11.GL_TRIANGLE_FAN);
			GL11.glColor3d(1,1,1);
			
			GL11.glVertex3d(light0Pos.x,light0Pos.y,light0Pos.z);
			for(int i = 0; i < 21; i ++)
			{
				GL11.glColor3d(1,1,0.8);
				GL11.glVertex3d(light0Pos.x,light0Pos.y + (Math.cos(Math.toRadians(dir)) * 200),light0Pos.z + (Math.sin(Math.toRadians(dir)) * 200));
				dir = dir - 18;
			}
		GL11.glEnd();
	}
	public void start()
	{
		
		String userHome = System.getProperty("user.home");
		screenWidth = 1000;
		screenHeight = 800;
		

		try {

			Display.setDisplayMode(new DisplayMode(screenWidth,screenHeight));
			//Display.setFullscreen(true);
			int depthBufferBits = 24;
			Display.create(new PixelFormat(0, depthBufferBits, 0));
			//Display.create();
		}catch (LWJGLException e) {
			e.printStackTrace();
		}
		sunLightDirX = 80;
		Make2D();
		Jump.x = 0.07;
		Jump.y = 0.07;
		Jump.z = 0.07;
		

		pos.z = 0;
		pos.x = 0;
		pos.y = 0;
		cameraY = 0;
		cameraZ = -5;
		cameraX = 0;
		screenWidth = Display.getWidth();
		screenHeight = Display.getHeight();
		collisionPackage.eRadius.x = 1;
		collisionPackage.eRadius.y = 1;
		collisionPackage.eRadius.z = 1;
		vividEye = setUpSphere(0,0,0,1,20,0);
		sphere.points = setUpSphere(0,0,0,collisionPackage.eRadius.x,20,0);
		loadTextures();
		loadSounds();
		
			//intro = 0;
		Display.sync(60);
			TJ = TJ.returnMapNum(3);
		
		createLightAt(10000,10000,0,10000,1,0.3,0);
		box.points = createBox();
		//box.pos = new Vector();
		box.torque.x = 0.01;
		
		box.pos.y = -2;
		box.pos.z = -2;
		pos.y = 20;
		box.velocity.y = -0.001;
		//Player.add(setUpPart(1));
		//Player.add(setUpPart(2));
		//Player.add(setUpPart(3));
		//Player.add(setUpPart(4));
		//Player.add(setUpPart(5));
		//Player.add(setUpPart(6));
		//Player.add(setUpPart(7));
		//Player.add(setUpPart(8));
		//createLightAt(0,0.8,0,1,1,1,1);
		createLightAt(10000,10000,0,10000,1,0.3,0);
		GL11.glTranslatef(0, (float)-0.6,-3);
		System.out.println("Welcome");
		//Make3D();
		Display.setResizable(true);
		Display.setTitle("Ball Engine");
		LocalDateTime date = LocalDateTime.now();
		startTime.Second = date.getSecond();
		startTime.Minute = date.getMinute();
		startTime.Hour = date.getHour();
		intro = 10;
		//newMovement = false;
		//editMovementNum = 1;
		
		//IntroMusic.playAsMusic(1, 1, true);
		
		pos.x = 10;
		light0Amb.x = 0;
        light0Amb.y = 0;
        light0Amb.z = 0;
        FogColor.x = 0.4;
        FogColor.y = 0.5;
        FogColor.z = 1.0;
        light0Dif.x = 0.5;
        light0Dif.y = 0.5;
        light0Dif.z = 0.5;
		//IntroMusic.------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		while (!Display.isCloseRequested())
		{
			surfacesRendered = 0;
			/**
			if(Math.round(Math.random() * 1000) == 10)
			{
				dropAt = (int)Math.round(Math.random() * 9);
				Drops.playAsSoundEffect(1, 1, false);
				Drops.setPosition(dropAt);
			}
			if(Drops.isPlaying())
			{
				if(Drops.getPosition() >= dropAt + 1)
				{
					Drops.stop();
				}
			}
			*/
			eyeCloseTime ++;
			if(pauseGamePlay)
			{
				storyTime ++;
				if(storyTime >= 60)
				{
					storyTime = 0;
					storyTimeSec ++;
				}
			}
			/**
			if(cameraDirY > 180)
			{
				cameraDirY =  -180 + (cameraDirY - 180);
			}
			if(cameraDirY < -180)
			{
				cameraDirY =  180 + (cameraDirY + 180);
			}
			*/
			date = LocalDateTime.now();
			MyTime newTime = new MyTime();
			newTime.Second = date.getSecond();
			newTime.Minute = date.getMinute();
			newTime.Hour = date.getHour();
			playTime = startTime.getTimeSubtractTime(newTime);
			MouseX = Mouse.getX();
			MouseY = Mouse.getY();
			screenWidth = Display.getWidth();
			screenHeight = Display.getHeight();
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
			
			if(intro == 10)
			{
				setUpIntro();
			}
			if(intro == 7)
			{
				mainMenu();
			}
			if(intro == 9)
			{
				loadLevel();
			}
			if(intro == 8)
			{
				if(selectItem)
				{
					double scrollD = Mouse.getDWheel();
					scrollItem = scrollItem + (scrollD / 10);
					if(scrollItem < 0)
					{
						scrollItem = 0;
					}
					if(scrollItem > 2000)
					{
						scrollItem = 2000;
					}
				}
				GamePlay();
			}
			if(intro == 0)
			{
				
				if(selectItem)
				{
					double scrollD = Mouse.getDWheel();
					scrollItem = scrollItem + (scrollD / 10);
					if(scrollItem < 0)
					{
						scrollItem = 0;
					}
					if(scrollItem > 2000)
					{
						scrollItem = 2000;
					}
				}
				
				
				intro();
				
				foundMap = true;
			}
			else if(intro == 1)
			{
				draw();
				foundMap = true;
			}
			else if(intro == 2)
			{
				
				//testSound.playAsSoundEffect(1, 1, false);
				//SoundStore.get().poll(0);
				loadingScreen();
				foundMap = false;
			}
			else if(intro == 3)
			{
				loadingSchematics();
				foundMap = false;
			}
			else if(intro == 4)
			{
				EditCharacterMovement();
			}
			//DrawText(DisplayThis,20,500,5,1,1,1);
			if(pauseGamePlay == false)
			{
				if(Keyboard.isKeyDown(Keyboard.KEY_RSHIFT))
				{
					if(screenShotDown == false)
					{
						screenShotDown = true;
						ScreenShot();
					}
				}
				else
				{
					screenShotDown = false;
				}
			}
			
			switchSlowMo();
			SoundStore.get().poll(0);
			Display.sync(60);
			Display.update();

		}
		if(Hit.isPlaying())
		{
			Hit.stop();
		}
		if(IntroMusic.isPlaying())
		{
			IntroMusic.stop();
		}
		System.out.println("Plane " + averagePlane);
		System.out.println("Edge " + averageEdge);
		Make2D();
		DrawText("Saving Data",100,500,10,1,1,1);
		Display.update();
		if(intro == 1000)
		{
			for(int i = 0; i < Player.size(); i ++)
			{
				
				File part = new File(userHome + "/BallRoll/" + "/Player Characteristics/Player Movements/" + i);
				if(!part.exists())
				{
					//System.out.println("Part: " + i);
					part.mkdirs();
				}
				for(int t = 0; t < Player.get(i).RotateAngles.size(); t ++)
				{
					//System.out.println("Movement: " + t);
					String content = "";
					for(int z = 0; z < Player.get(i).RotateAngles.get(t).angles.size(); z ++)
					{
						Vector v = Player.get(i).RotateAngles.get(t).angles.get(z);
						//System.out.println("vectors.add(Vector.newVector(" + v.x + "," + v.y + "," + v.z + "));");
						content = content + ("" + v.x + " " + v.y + " " + v.z + " j");
						
					}
					
					File file = new File(userHome + "/BallRoll/" + "/Player Characteristics/Player Movements/" + i + "/"+ t + "");
					if(newMovement)
					{
						if(file.exists())
						{
							while(file.exists())
							{
								t ++;
								file = new File(userHome + "/BallRoll/" + "/Player Characteristics/Player Movements/" + i + "/"+ t + "");
							}
						}
					}
					else
					{
						System.out.println("true");
						//file = new File(userHome + "/BallRoll/" + "/Player Characteristics/Player Movements/" + i + "/"+ editMovementNum + "");
					}
					try(FileOutputStream fop = new FileOutputStream(file))
					{
						
						if(!file.exists())
						{
							file.createNewFile();
						}
						else
						{
							
						}
						byte[] contentInBytes = content.getBytes();
						fop.write(contentInBytes);
						
						fop.flush();
						fop.close();
						
						//System.out.println("Done Saving Map '" + t + "'");
					}catch (IOException e)
					{
						e.printStackTrace();
					}
					file.setReadable(true);
				}
				
			}
		}
		if(MapType == 1)
		{
			
			if(foundMap)
			{
				/**
				for(int i = 0; i < EditorMap.mapData.size(); i ++)
				{
					Data d = EditorMap.mapData.get(i);
					System.out.println("setUpTriangle(" + d.v1.x + "," + d.v1.y + "," + d.v1.z + "," + d.v2.x + "," + d.v2.y + "," + d.v2.z + "," + d.v3.x + "," + d.v3.y + "," + d.v3.z + "," + d.Red + "," + d.Green + "," + d.Blue + ",true);");
				}
				*/
				Map.saveData(EditorMap,mapName,items);
				
			}
			
		}
		else
		{
			Vector Middle = new Vector();
			for(int i = 0; i < EditorMap.mapData.size(); i ++)
			{
				Data d = EditorMap.mapData.get(i);
				Middle = Middle.add(d.mid);
			}
			Middle = Middle.divideNon(EditorMap.mapData.size());
			for(int i = 0; i < EditorMap.mapData.size(); i ++)
			{
				Data d = EditorMap.mapData.get(i);
				d.v1 = d.v1.subtract(Middle);
				d.v2 = d.v2.subtract(Middle);
				d.v3 = d.v3.subtract(Middle);
				d.mid = d.v1.add(d.v2.add(d.v3));
				d.mid = d.mid.divideNon(3);
			}
			Map.createSchematic(EditorMap, mapName);
		}
		
		Display.destroy();
		//System.out.println();
		AL.destroy();
		
		System.exit(0);

	}
	public void loadLevel()
	{
		//EditorMap = new Map();
		//EditorMap.mapData = new ArrayList<Data>();
		EditorMap.mapData.clear();
		FogColor.x = 0;
		FogColor.y = 0;
		FogColor.z = 0;
		//items = new ArrayList<Items>();
		items.clear();
		light0Pos.x = 24;
		light0Pos.y = 51;
		light0Pos.z = 17;
		pos.x = 32;
		pos.y = 3;
		pos.z = -12;
		//torchLight = true;
		//light0Intensity = 10;
		IntroMusic.stop();
		EditorMap = Map.returnDecodedMap("CrystalCaves");
		items = Map.returnDecodedItems("CrystalCaves");
		double dirY = 0;
		for(int i = 0; i < 20; i ++)
		{
			
			Data d = new Data();
			d.v1.x = 0;
			d.v1.y = -0.5;
			d.v1.z = 0;
			d.v2.x = Math.sin(Math.toRadians(dirY)) * 0.2;
			d.v2.y = 0.5;
			d.v2.z = Math.cos(Math.toRadians(dirY)) * 0.2;
			dirY = dirY + 18;
			d.v3.x = Math.sin(Math.toRadians(dirY)) * 0.2;
			d.v3.y = 0.5;
			d.v3.z = Math.cos(Math.toRadians(dirY)) * 0.2;
			d.normal = getSurfaceNormal(d);
			d.v1Normal = d.normal;
			d.v2Normal = d.normal;
			d.v3Normal = d.normal;
			d.Shine = 128;
			d.Red = 1;
			d.Blue = 1;
			d.Green = 1;
			d.mid = d.v1.add(d.v2.add(d.v3));
			d.mid = d.mid.divideNon(3);
			Nail.add(d);
			
		}
		for(int i = 0; i < items.size(); i ++)
		{
			Items item = items.get(i);
			if(Math.round(Math.random() * 1) == 0)
			{
				item.changeY = -0.01;
			}
			else
			{
				item.changeY = 0.01;
			}
			if(item.Type == 1)
			{

				item.rotate.points = setUpSphere(0,0,0,0.3,4,1);
			}
			else if(item.Type == 2)
			{
				totalCollect = totalCollect + 1;
				item.rotate.points = setUpSphere(0,0,0,1,4,1);
			}
			else if(item.Type == 3)
			{

				item.rotate.points = setUpSphere(0,0,0,0.8,3,1);
			}
			else if(item.Type == 4)
			{
				item.rotate.points = setUpSphere(0,0,0,1,2,1);
			}

		}
		intro = 8;
	
	}
	public void loadMain()
	{
		EditorMap = Map.returnDecodedMap("Cliff");
		rotateSphere(0,1,0,(float)0.05);
		rotateSphere(1,0,0,(float)-0.5);
		light0Amb.x = 0.2;
        light0Amb.y = 0.1;
        light0Amb.z = 0;
        FogColor.x = 0.2;
        FogColor.y = 0.3;
        FogColor.z = 0.5;
        light0Dif.x = 0.1;
        light0Dif.y = 0.1;
        light0Dif.z = 0.1;
	}
	public void mainMenu()
	{
		renderDistance = 200;
		light0Pos.x = 10000;
		light0Pos.z = 0;
		light0Pos.y = 100;
		//drawBackDrop(0.7,0.5,0.3,0.8,1,0.7,0.5);
		pos.x = -1;
		pos.y = 1;
		pos.z = 9;
		cameraX = -13;
		cameraY = 1;
		cameraZ = 8;
		pointCameraAt(2,-4,-24);
		Make3D();
		
		renderSort();
		
		
		if(Math.round(Math.random() * 90) == 2)
		{
			addFireworkParticle(2 + (Math.random() * 100 - 50),2 - 15,51 + (Math.random() * 100 - 50));
		}
		particles();
		drawRotatedSphere();
		Make2D();
		
		boolean load = false;
		if(draw2DQuadDec(100,650,100,700,400,700,400,650,0.5,0.8,1,0.6,0.9,0.6,0.4))
		{
			if(Mouse.isButtonDown(0))
			{
				load = true;
			}
		}
		DrawText("Start",175,675,20,1,1,1);
		
		if(load == true)
		{
			particles.clear();
			light0Dif.x = 0.5;
	        light0Dif.y = 0.5;
	        light0Dif.z = 0.5;
			rotateSphere(1,0,0,(float)0.5);
			light0Amb.x = 0;
	        light0Amb.y = 0;
	        light0Amb.z = 0;
			light0Pos.x = -10000;
			light0Pos.y = 10000;
			light0Pos.z = 0;
			//fogType = 1;
			Ball ball = new Ball();
			ball.pos.x = -18;
			ball.pos.y = 4;
			ball.pos.z = -37;
			ball.velo.y = 0;
			//fogType = 1;
			ball.points = setUpSphere(0,0,0,1,10,0);
			Vector v = new Vector();
			v.x = -11;
			v.y = 2;
			v.z = -17;
			ball.goTo.add(v);
			v = new Vector();
			v.x = -10;
			v.y = 3;
			v.z = 10;
			ball.goTo.add(v);
			v = new Vector();
			v.x = -16;
			v.y = 5;
			v.z = 25;
			ball.goTo.add(v);
			v = new Vector();
			v.x = -18;
			v.y = 7;
			v.z = 42;
			ball.goTo.add(v);
			v = new Vector();
			v.x = -11;
			v.y = 8;
			v.z = 55;
			ball.goTo.add(v);
			v = new Vector();
			v.x = 3;
			v.y = 11;
			v.z = 63;
			ball.goTo.add(v);
			v = new Vector();
			v.x = 33;
			v.y = 16;
			v.z = 52;
			ball.goTo.add(v);
			v = new Vector();
			v.x = 42;
			v.y = 23;
			v.z = 26;
			ball.goTo.add(v);
			v = new Vector();
			v.x = 28;
			v.y = 34;
			v.z = -4;
			ball.goTo.add(v);
			v = new Vector();
			v.x = 8;
			v.y = 41;
			v.z = -5;
			ball.goTo.add(v);
			ballList.add(ball);
			light0Pos.x = -10000;
			light0Pos.y = 10000;
			light0Pos.z = 0;
			IntroMusic.stop();
			EditorMap.mapData.clear();
			EditorMap = Map.returnDecodedMap("Mountain");
			items = Map.returnDecodedItems("Mountain");
			double dirY = 0;
			for(int i = 0; i < 20; i ++)
			{
				
				Data d = new Data();
				d.v1.x = 0;
				d.v1.y = -0.5;
				d.v1.z = 0;
				d.v2.x = Math.sin(Math.toRadians(dirY)) * 0.2;
				d.v2.y = 0.5;
				d.v2.z = Math.cos(Math.toRadians(dirY)) * 0.2;
				dirY = dirY + 18;
				d.v3.x = Math.sin(Math.toRadians(dirY)) * 0.2;
				d.v3.y = 0.5;
				d.v3.z = Math.cos(Math.toRadians(dirY)) * 0.2;
				d.normal = getSurfaceNormal(d);
				d.v1Normal = d.normal;
				d.v2Normal = d.normal;
				d.v3Normal = d.normal;
				d.Shine = 128;
				d.Red = 1;
				d.Blue = 1;
				d.Green = 1;
				d.mid = d.v1.add(d.v2.add(d.v3));
				d.mid = d.mid.divideNon(3);
				Nail.add(d);
				
			}
			for(int i = 0; i < items.size(); i ++)
			{
				Items item = items.get(i);
				if(Math.round(Math.random() * 1) == 0)
				{
					item.changeY = -0.01;
				}
				else
				{
					item.changeY = 0.01;
				}
				if(item.Type == 1)
				{
	
					item.rotate.points = setUpSphere(0,0,0,0.3,4,1);
				}
				else if(item.Type == 2)
				{
					totalCollect = totalCollect + 1;
					item.rotate.points = setUpSphere(0,0,0,1,4,1);
				}
				else if(item.Type == 3)
				{
	
					item.rotate.points = setUpSphere(0,0,0,0.8,3,1);
				}
				else if(item.Type == 4)
				{
					item.rotate.points = setUpSphere(0,0,0,1,2,1);
				}
	
			}
			intro = 8;
		}
	}
	public static void detachBuffer(int sourceID) {
        //detach a buffer if it exists
        AL10.alSourceStop(sourceID);
        AL10.alSourcei(sourceID, AL10.AL_BUFFER, 0);
    }
	public List<Data> createBox()
	{
		List<Data> boxs = new ArrayList<Data>();
		Data d = new Data();
		d.v1.x = 1;
		d.v1.y = 0.5;
		d.v1.z = -1;
		d.v2.x = -1;
		d.v2.y = 0.5;
		d.v2.z = -1;
		d.v3.x = -1;
		d.v3.y = -0.5;
		d.v3.z = -1;
		d.v4.x = 1;
		d.v4.y = -0.5;
		d.v4.z = -1;
		d.Red = 1;
		d.Green = 1;
		d.Blue = 1;
		boxs.add(d);
		d = new Data();
		d.v1.x = 1;
		d.v1.y = 0.5;
		d.v1.z = -1;
		d.v2.x = 1;
		d.v2.y = 0.5;
		d.v2.z = 1;
		d.v3.x = 1;
		d.v3.y = -0.5;
		d.v3.z = 1;
		d.v4.x = 1;
		d.v4.y = -0.5;
		d.v4.z = -1;
		d.Red = 1;
		d.Green = 1;
		d.Blue = 1;
		boxs.add(d);
		d = new Data();
		d.v1.x = 1;
		d.v1.y = 0.5;
		d.v1.z = 1;
		d.v2.x = -1;
		d.v2.y = 0.5;
		d.v2.z = 1;
		d.v3.x = -1;
		d.v3.y = -0.5;
		d.v3.z = 1;
		d.v4.x = 1;
		d.v4.y = -0.5;
		d.v4.z = 1;
		d.Red = 1;
		d.Green = 1;
		d.Blue = 1;
		boxs.add(d);
		d = new Data();
		d.v1.x = -1;
		d.v1.y = 0.5;
		d.v1.z = -1;
		d.v2.x = -1;
		d.v2.y = 0.5;
		d.v2.z = 1;
		d.v3.x = -1;
		d.v3.y = -0.5;
		d.v3.z = 1;
		d.v4.x = -1;
		d.v4.y = -0.5;
		d.v4.z = -1;
		d.Red = 1;
		d.Green = 1;
		d.Blue = 1;
		boxs.add(d);
		d = new Data();
		d.v1.x = -1;
		d.v1.y = 0.5;
		d.v1.z = -1;
		d.v2.x = -1;
		d.v2.y = 0.5;
		d.v2.z = 1;
		d.v3.x = 1;
		d.v3.y = 0.5;
		d.v3.z = 1;
		d.v4.x = 1;
		d.v4.y = 0.5;
		d.v4.z = -1;
		d.Red = 1;
		d.Green = 1;
		d.Blue = 1;
		boxs.add(d);
		d = new Data();
		d.v1.x = -1;
		d.v1.y = -0.5;
		d.v1.z = -1;
		d.v2.x = -1;
		d.v2.y = -0.5;
		d.v2.z = 1;
		d.v3.x = 1;
		d.v3.y = -0.5;
		d.v3.z = 1;
		d.v4.x = 1;
		d.v4.y = -0.5;
		d.v4.z = -1;
		d.Red = 1;
		d.Green = 1;
		d.Blue = 1;
		boxs.add(d);
		return boxs;
	}
	public void EditCharacterMovement()
	{
		if(!Keyboard.isKeyDown(Keyboard.KEY_LSHIFT))
		{
			if(Keyboard.isKeyDown(Keyboard.KEY_RIGHT))
			{
				Rotators r = Player.get(CharacterPart);
				Vector v = r.RotateAngles.get(0).angles.get(Frame);
				v.y = v.y + 1;
			}
			if(Keyboard.isKeyDown(Keyboard.KEY_LEFT))
			{
				Rotators r = Player.get(CharacterPart);
				Vector v = r.RotateAngles.get(0).angles.get(Frame);
				v.y = v.y  - 1;
			}
		}
		else
		{
			if(Keyboard.isKeyDown(Keyboard.KEY_RIGHT))
			{
				Rotators r = Player.get(CharacterPart);
				Vector v = r.RotateAngles.get(0).angles.get(Frame);
				v.z = v.z + 1;
			}
			if(Keyboard.isKeyDown(Keyboard.KEY_LEFT))
			{
				Rotators r = Player.get(CharacterPart);
				Vector v = r.RotateAngles.get(0).angles.get(Frame);
				v.z = v.z - 1;
			}
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_UP))
		{
			Rotators r = Player.get(CharacterPart);
			Vector v = r.RotateAngles.get(0).angles.get(Frame);
			v.x = v.x + 1;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_DOWN))
		{
			Rotators r = Player.get(CharacterPart);
			Vector v = r.RotateAngles.get(0).angles.get(Frame);
			v.x = v.x - 1;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_R))
		{
			Rotators r = Player.get(CharacterPart);
			Vector v = r.RotateAngles.get(0).angles.get(Frame);
			v.x = 0;
			v.y = 0;
			v.z = 0;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_D))
		{
			if(KeyDDown == false)
			{	
				KeyDDown = true;
				CharacterPart ++;
			}
			if(CharacterPart >= Player.size())
			{
				CharacterPart = 0;
			}
		}
		else if(Keyboard.isKeyDown(Keyboard.KEY_A))
		{
			if(KeyDDown == false)
			{	
				KeyDDown = true;
				CharacterPart --;
			}
			if(CharacterPart < 0)
			{
				CharacterPart = Player.size() - 1;
			}
		}
		else
		{
			KeyDDown = false;
		}
		
		if(Keyboard.isKeyDown(Keyboard.KEY_N))
		{
			if(KeyNewFrame == false)
			{
				KeyNewFrame = true;
				
				for(int i = 0; i < Player.size(); i ++)
				{
					Vector newFrame = new Vector();
					Rotators r = Player.get(i);
					Vector lastFrame = r.RotateAngles.get(onThisMovement[0]).angles.get(r.RotateAngles.get(0).angles.size() - 1);
					newFrame.x = lastFrame.x;
					newFrame.y = lastFrame.y;
					newFrame.z = lastFrame.z;
					r.RotateAngles.get(0).angles.add(newFrame);
					
				}
				Frame ++;
				
			}
		}
		else
		{
			KeyNewFrame = false;
		}
		Make3D();
		Lights light = lights.get(0);
		light.light.x = 0;
		light.light.y = 10;
		light.light.z = 10;
		light.intensity = 20;
		light.Red = 1;
		light.Blue = 1;
		light.Green = 1;
		if(Keyboard.isKeyDown(Keyboard.KEY_M))
		{
			CharacterEditMode = 1;
		}
		List<Rotators> rotating = new ArrayList<Rotators>();
		for(int i = 0; i < Player.size(); i ++)
		{
			Rotators r = Player.get(i);
			Rotators j = new Rotators();
			if(CharacterEditMode == 0)
			{
				r.RotateOn = Frame;
				r.RotateOn2 = movementSpeed - 1;
			}
			else
			{
				Frame = r.RotateOn;
			}
			
			j.facing.x = r.facing.x + 0;
			j.facing.y = r.facing.y + 0;
			j.facing.z = r.facing.z + 0;
			j.pos.x = r.pos.x + 0;
			j.pos.y = r.pos.y + 0;
			j.pos.z = r.pos.z + 0;
			j.Rotate.x = r.Rotate.x + 0;
			j.Rotate.y = r.Rotate.y + 0;
			j.Rotate.z = r.Rotate.z + 0;
			j.RotateAround.x = r.RotateAround.x + 0;
			j.RotateAround.y = r.RotateAround.y + 0;
			j.RotateAround.z = r.RotateAround.z + 0;
			j.RotateAngles = r.RotateAngles;
			j.RotateOn = r.RotateOn;
			j.RotateOn2 = r.RotateOn2;
			j.position = pos;
			for(int t = 0; t < r.points.size(); t ++)
			{
				Data d = r.points.get(t);
				Data k = new Data();
				k.v1.x = d.v1.x + 0;
				k.v1.y = d.v1.y + 0;
				k.v1.z = d.v1.z + 0;
				k.v2.x = d.v2.x + 0;
				k.v2.y = d.v2.y + 0;
				k.v2.z = d.v2.z + 0;
				k.v3.x = d.v3.x + 0;
				k.v3.y = d.v3.y + 0;
				k.v3.z = d.v3.z + 0;
				k.normal.x = d.normal.x + 0;
				k.normal.y = d.normal.y + 0;
				k.normal.z = d.normal.z + 0;
				k.v1Normal = d.v1Normal;
				k.v2Normal = d.v2Normal;
				k.v3Normal = d.v3Normal;
				
				
				if(i == CharacterPart)
				{
					k.Red = 1;
					k.Green = 1;
					k.Blue = 1;
				}
				else
				{
					k.Red = d.Red;
					k.Green = d.Green;
					k.Blue = d.Blue;
				}
				j.points.add(k);
			}
			rotating.add(j);
		}
		drawPlayer(1,rotating);
		Make2D();
		DrawText("Frame " + Frame,20,20,10,1,1,1);
		//boolean MouseMove = true;
		
		if(draw2DQuadDec(800,10,800,90,980,90,980,10,1,1,1,0.2,1,1,0.2))
		{
			if(Mouse.isButtonDown(0))
			{
				if(MouseSensedDown == false)
				{
					Frame ++;
					if(Frame > Player.get(0).RotateAngles.get(onThisMovement[0]).angles.size() - 1)
					{
						Frame = 0;
					}
					MouseSensedDown = true;
				}
			}
			else
			{
				MouseSensedDown = false;
			}
		}
		if(draw2DQuadDec(600,10,600,90,780,90,780,10,1,1,1,0.2,1,1,0.2))
		{
			if(Mouse.isButtonDown(0))
			{
				if(MouseSensedDown == false)
				{
					Frame --;
					if(Frame < 0)
					{
						Frame = Player.get(0).RotateAngles.get(onThisMovement[0]).angles.size() - 1;
					}
					MouseSensedDown = true;
				}
			}
			else
			{
				MouseSensedDown = false;
			}
		}
		if(draw2DQuadDec(700,720,700,780,780,780,780,720,1,1,1,0.2,1,1,0.2))
		{
			if(Mouse.isButtonDown(0))
			{
				if(MouseSensedDown == false)
				{
					MouseSensedDown = true;
					cameraX = 10;
					cameraZ = 0;
					cameraY = 0;
					pointCameraAt(pos.x,pos.y,pos.z);
				}
			}
			else
			{
				MouseSensedDown = false;
			}
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_G))
		{
			if(editDel == false)
			{
				if(Frame != 0)
				{
					editDel = true;
					for(int i = 0; i < Player.size(); i ++)
					{
						Rotators r = Player.get(i);
						r.RotateAngles.get(onThisMovement[0]).angles.remove(Frame);
					}
					Frame --;
				}
			}
		}
		else
		{
			editDel = false;
		}
	}
	public void pointCameraAt(double x, double y, double z)
	{
		Vector v = new Vector();
		v.x = x - cameraX;
		//v.y = y + cameraY;
		v.y = 0;
		v.z = z - cameraZ;
		v = v.normalize();
		cameraDirY = Math.toDegrees(Math.acos(v.z));
		if(v.x < 0)
		{
			cameraDirY = cameraDirY * -1;
		}
		v = new Vector();
		v.x = x - cameraX;
		v.y = y - cameraY;
		v.z = z - cameraZ;
		v = v.normalize();
		cameraDirX = -Math.toDegrees(Math.asin(v.y));
		//System.out.println("CameraDirX: " + cameraDirX);
		//System.out.println("CameraDirY: " + cameraDirY);
		//System.out.println("x: " + v.x + " y: " + v.y + " z: " + v.z);
	}
	public void loadingSchematics()
	{
		MapType = 0;
		String[] s = Map.ListSchematics();
		draw2DQuad(0,0,0,800,1000,800,1000,0,0.2,0.2,0.2,1,1,0.2,0.2);
		double Y = 600;
		double MouseDWheel = Mouse.getDWheel();
		CamY = CamY + (MouseDWheel / 100);
		String loadingMap = "";
		if(CamY > 0)
		{
			CamY = 0;
		}
		if(CamY < s.length * -35)
		{
			CamY = s.length * -35;
		}
		for(int i = 0; i < s.length; i ++)
		{

			if(draw2DQuadDec(100,(0 + Y) - CamY,100,(Y + 35) - CamY,700,(Y + 35) - CamY,700,(Y + 0) - CamY,0.3,0.7,1,0.2,1,0.8,0))
			{

				loadingMap = s[i];
				Y = Y - 3;
			}
			String currentName = s[i];

			DrawText(currentName,120,(int)Math.round(Y + 15) - (int)Math.round(CamY),10,1,1,1);
			Y = Y - 50;
			if(currentName == loadingMap)
			{
				Y = Y + 3;
			}
		}
		int subtractY = 0;
		if(draw2DQuadDec(20,20,20,60,250,60,250,20,0.3,0.5,0.9,0.2,1,0.9,0.1))
		{
			if(Mouse.isButtonDown(0))
			{
				
				loadingMap = "newSchematic";
				int notCreatedYet = 0;
				boolean MapNameNotTaken = true;
				while(MapNameNotTaken)
				{
					MapNameNotTaken = false;
					for(int i = 0; i < s.length; i ++)
					{
						if(loadingMap.equalsIgnoreCase(s[i]))
						{
							MapNameNotTaken = true;
							loadingMap = "newSchematic" + notCreatedYet;

						}
					}
					notCreatedYet ++;
				}
				EditorMap = new Map();
				mapName = loadingMap;
				Mouse.setCursorPosition(screenWidth / 2, screenHeight / 2);
				Mouse.setGrabbed(true);
				MapType = 0;
				intro = 0;
				CamY = 0;
			}
			subtractY = 3;
		}
		
		DrawText("Create new Schematic",35,40 - subtractY,5,1,1,1);
		if(Mouse.isButtonDown(0) && !loadingMap.equalsIgnoreCase(""))
		{

			EditorMap = Map.returnSchematic(loadingMap);
			
			intro = 0;
			mapName = loadingMap;

			Mouse.setCursorPosition(screenWidth / 2, screenHeight / 2);
			Mouse.setGrabbed(true);
			CamY = 0;
		}
	}
	public void dropDownControls()
	{
		Make2D();
		draw2DQuad(0,0,0,800,1000,800,1000,0,1,1,1,1,0.2,0.2,1);
		DrawText("Controls",200,575,10,0,0,0);
		DrawText("Move with W,A,S,D,E,Q",100,550,5,0,0,0);
		DrawText("Rotate Camera With Arrow Keys",100,525,5,0,0,0);
		DrawText("Editor Controls:",100,500,5,0,0,0);
		DrawText("Z: to switch surface normals",100,475,5,0,0,0);
		DrawText("T: to get color of nearest surface",100,450,5,0,0,0);
		DrawText("K: to combine points at that area",100,425,5,0,0,0);
		DrawText("G: to delete surfaces",100,400,5,0,0,0);
		DrawText("Press F three times in different spots to create surface",100,375,5,0,0,0);
		DrawText("Space: to go to the nearest surface normal",100,350,5,0,0,0);
		DrawText("O: to set color of nearset surface normal",100,325,5,0,0,0);
		DrawText("B: to create a block",100,300,5,0,0,0);
		DrawText("U: to switch from editor to ball",100,275,5,0,0,0);
		Make3D();
	}
	public void loadTextures()
	{
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		String userHome = System.getProperty("user.home");
		try
		{
			LogoStuff = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream(userHome + "/BallRoll/Textures/LogoStuff.png"));
			VividEye = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream(userHome + "/BallRoll/Textures/Vivid-Eye.png"));
			BallEnemy = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream(userHome + "/BallRoll/Textures/Enemy.png"));
			Ransom = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream(userHome + "/BallRoll/Textures/Ransom.png"));
			SleepBall = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream(userHome + "/BallRoll/Textures/BallSleep.png"));
			DM = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream(userHome + "/BallRoll/Textures/DM.png"));
			ball = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream(userHome + "/BallRoll/Textures/Ball.png"));
			text = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream(userHome + "/BallRoll/Textures/Text.png"));
			
			
			System.out.println("Width " + ball.getWidth());
			System.out.println("Height " + ball.getHeight());
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		GL11.glDisable(GL11.GL_TEXTURE_2D);

	}

	public void mouseControls()
	{
		
		cameraDirY = cameraDirY - (Math.cos(Math.toRadians(cameraDirZ)) * ((Mouse.getX() - (screenWidth / 2)) / sensitive));
		cameraDirX = cameraDirX + ((Mouse.getY() - (screenHeight / 2)) / sensitive);
		
		Mouse.setCursorPosition(screenWidth / 2, screenHeight / 2);
	}
	public void loadingScreen()
	{
		draw2DQuad(0,0,0,800,1000,800,1000,0,1,1,1,1,1,0.2,0.2);
		double Y = 600;
		String[] s = Map.ListMaps();
		String loadingMap = "";
		double MouseDWheel = Mouse.getDWheel();
		CamY = CamY + (MouseDWheel / 100);
		if(CamY > 0)
		{
			CamY = 0;
		}
		if(CamY < s.length * -35)
		{
			CamY = s.length * -35;
		}
		for(int i = 0; i < s.length; i ++)
		{

			if(draw2DQuadDec(100,(0 + Y) - CamY,100,(Y + 35) - CamY,700,(Y + 35) - CamY,700,(Y + 0) - CamY,0,1,1,0.2,1,1,0.2))
			{

				loadingMap = s[i];
				Y = Y - 3;
			}
			String currentName = s[i];

			DrawText(currentName,120,(int)Math.round(Y + 15) - (int)Math.round(CamY),10,1,1,1);
			Y = Y - 50;
			if(currentName == loadingMap)
			{
				Y = Y + 3;
			}
		}
		int subtractY = 0;
		if(draw2DQuadDec(720,20,720,60,950,60,950,20,1,0,0,0.2,1,1,0.2))
		{
			if(Mouse.isButtonDown(0))
			{
				IntroMusic.stop();
				intro = 3;
				CamY = 0;
			}
			subtractY = 3;
		}
		DrawText("Schematics",735,40 - subtractY,5,1,1,1);
		subtractY = 0;
		if(draw2DQuadDec(20,20,20,60,150,60,150,20,1,0,0,0.2,1,1,0.2))
		{
			if(Mouse.isButtonDown(0))
			{
				
				loadingMap = "newMap";
				int notCreatedYet = 0;
				boolean MapNameNotTaken = true;
				while(MapNameNotTaken)
				{
					MapNameNotTaken = false;
					for(int i = 0; i < s.length; i ++)
					{
						if(loadingMap.equalsIgnoreCase(s[i]))
						{
							MapNameNotTaken = true;
							loadingMap = "newMap" + notCreatedYet;

						}
					}
					notCreatedYet ++;
				}
				EditorMap = Map.createNewMap(loadingMap);
				mapName = loadingMap;
				Mouse.setCursorPosition(screenWidth / 2, screenHeight / 2);
				Mouse.setGrabbed(true);
				intro = 0;
				IntroMusic.stop();
			}
			subtractY = 3;
		}
		
		DrawText("Create Map",35,40 - subtractY,5,1,1,1);
		if(Mouse.isButtonDown(0) && !loadingMap.equalsIgnoreCase(""))
		{

			EditorMap = Map.returnDecodedMap(loadingMap);
			items = Map.returnDecodedItems(loadingMap);
			for(int i = 0; i < items.size(); i ++)
			{
				Items item = items.get(i);
				if(Math.round(Math.random() * 1) == 0)
				{
					item.changeY = -0.01;
				}
				else
				{
					item.changeY = 0.01;
				}
				if(item.Type == 1)
				{

					item.rotate.points = setUpSphere(0,0,0,0.3,4,1);
				}
				else if(item.Type == 2)
				{
					totalCollect = totalCollect + 1;
					item.rotate.points = setUpSphere(0,0,0,1,4,1);
				}
				else if(item.Type == 3)
				{

					item.rotate.points = setUpSphere(0,0,0,0.8,3,1);
				}
				else if(item.Type == 4)
				{
					item.rotate.points = setUpSphere(0,0,0,1,2,1);
				}

			}
			intro = 0;
			IntroMusic.stop();
			mapName = loadingMap;

			Mouse.setCursorPosition(screenWidth / 2, screenHeight / 2);
			Mouse.setGrabbed(true);
		}


	} 
	public List<Data> setUpBox(double x, double y, double z,int size)
	{
		List<Data> outCome = new ArrayList<Data>();
		double dir = 0;
		double dirY = 90;
		double x1 = x + Math.sin(Math.toRadians(dirY)) * (Math.sin(Math.toRadians(dir)) * size);
		double y1 = y + Math.cos(Math.toRadians(dirY)) * size;
		double z1 = z + Math.sin(Math.toRadians(dirY)) * (Math.cos(Math.toRadians(dir)) * size);

		double x2 = x + Math.sin(Math.toRadians(dirY)) * (Math.sin(Math.toRadians(dir)) * 1);
		double y2 = y + Math.cos(Math.toRadians(dirY)) * 1;
		double z2 = z + Math.sin(Math.toRadians(dirY)) * (Math.cos(Math.toRadians(dir)) * 1);


		double x3 = x + Math.sin(Math.toRadians(dirY)) * (Math.sin(Math.toRadians(dir)) * 1);
		double y3 = z + Math.cos(Math.toRadians(dirY)) * 1;
		double z3 = z + Math.sin(Math.toRadians(dirY)) * (Math.cos(Math.toRadians(dir)) * 1);

		double x4 = x + Math.sin(Math.toRadians(dirY)) * (Math.sin(Math.toRadians(dir)) * 1);
		double y4 = y + Math.cos(Math.toRadians(dirY)) * 1;
		double z4 = z + Math.sin(Math.toRadians(dirY)) * (Math.cos(Math.toRadians(dir)) * 1);



		for(int t = 0; t < 4; t ++)
		{

			x1 = x +  Math.sin(Math.toRadians(dirY)) * (Math.sin(Math.toRadians(dir)) * size);
			y1 = y +  Math.cos(Math.toRadians(dirY)) * size;
			z1 = z + Math.sin(Math.toRadians(dirY)) * (Math.cos(Math.toRadians(dir)) * size);
			dir = dir + 90;
			x2 = x + Math.sin(Math.toRadians(dirY)) * (Math.sin(Math.toRadians(dir)) * size);
			y2 = y + Math.cos(Math.toRadians(dirY)) * size;
			z2 = z + Math.sin(Math.toRadians(dirY)) * (Math.cos(Math.toRadians(dir)) * size);

			y = y + size * 1.5;
			x3 = x + Math.sin(Math.toRadians(dirY)) * (Math.sin(Math.toRadians(dir)) * size);
			y3 = y + Math.cos(Math.toRadians(dirY)) * size;
			z3 = z + Math.sin(Math.toRadians(dirY)) * (Math.cos(Math.toRadians(dir)) * size);
			dir = dir - 90;
			x4 = x + Math.sin(Math.toRadians(dirY)) * (Math.sin(Math.toRadians(dir)) * size);
			y4 = y + Math.cos(Math.toRadians(dirY)) * size;
			z4 = z + Math.sin(Math.toRadians(dirY)) * (Math.cos(Math.toRadians(dir)) * size);
			dir = dir + 90;
			y = y - size * 1.5;

			Data j = returnDataTri(x1,y1,z1,x2,y2,z2,x3,y3,z3,Math.random() * 0.1 + 0.2,Math.random() * 0.2 + 0.5,Math.random() * 0.5 + 0.5);
			outCome.add(j);

			Data k = returnDataTri(x3,y3,z3,x4,y4,z4,x1,y1,z1,j.Red,j.Green,j.Blue);
			outCome.add(k);


		}

		return outCome;
	}
	public void DrawText(String write,int startingX,int startingY,int size,double Red, double Green, double Blue)
	{

		GL11.glEnable(GL11.GL_TEXTURE_2D);
		int x = startingX;
		for(int i = 0; i < write.length(); i ++)
		{
			double Y2 = startingY;
			double X2 = x;
			//Y2 = (Y2 / 1000) * screenHeight;
			//X2 = (X2 / 1000) * screenWidth;
			String sub = write.substring(i, i + 1);
			drawSubString(sub,X2,Y2,size,Red,Green,Blue);
			x = x + (size * 2);
		}

		GL11.glDisable(GL11.GL_TEXTURE_2D);
	}
	public void drawSubString(String s,double x, double y, int size,double Red, double Green, double Blue)
	{
		double texPosX = 0;
		double texPosY = 0;
		if(s.equalsIgnoreCase("a"))
		{
			texPosX = 0.063;
			texPosY = 0.1;
		}
		if(s.equalsIgnoreCase("b"))
		{
			texPosX = 0.1;
			texPosY = 0.1;
		}
		if(s.equalsIgnoreCase("c"))
		{
			texPosX = 0.134;
			texPosY = 0.1;
		}
		if(s.equalsIgnoreCase("d"))
		{
			texPosX = 0.17;
			texPosY = 0.1;
		}
		if(s.equalsIgnoreCase("e"))
		{
			texPosX = 0.205;
			texPosY = 0.1;
		}
		if(s.equalsIgnoreCase("f"))
		{
			texPosX = 0.24;
			texPosY = 0.1;
		}
		if(s.equalsIgnoreCase("g"))
		{
			texPosX = 0.2787;
			texPosY = 0.1;
		}
		if(s.equalsIgnoreCase("h"))
		{
			texPosX = 0.315;
			texPosY = 0.1;
		}
		if(s.equalsIgnoreCase("i"))
		{
			texPosX = 0.345;
			texPosY = 0.1;
		}
		if(s.equalsIgnoreCase("j"))
		{
			texPosX = 0.377;
			texPosY = 0.1;
		}
		if(s.equalsIgnoreCase("k"))
		{
			texPosX = 0.407;
			texPosY = 0.1;
		}
		if(s.equalsIgnoreCase("l"))
		{
			texPosX = 0.4385;
			texPosY = 0.1;
		}
		if(s.equalsIgnoreCase("m"))
		{
			texPosX = 0.475;
			texPosY = 0.1;
		}
		if(s.equalsIgnoreCase("n"))
		{
			texPosX = 0.02;
			texPosY = 0.168;
		}
		if(s.equalsIgnoreCase("o"))
		{
			texPosX = 0.055;
			texPosY = 0.168;
		}
		if(s.equalsIgnoreCase("p"))
		{
			texPosX = 0.09;
			texPosY = 0.168;
		}
		if(s.equalsIgnoreCase("q"))
		{
			texPosX = 0.12;
			texPosY = 0.168;
		}
		if(s.equalsIgnoreCase("r"))
		{
			texPosX = 0.158;
			texPosY = 0.168;
		}
		if(s.equalsIgnoreCase("s"))
		{
			texPosX = 0.195;
			texPosY = 0.168;
		}
		if(s.equalsIgnoreCase("t"))
		{
			texPosX = 0.23;
			texPosY = 0.168;
		}
		if(s.equalsIgnoreCase("u"))
		{
			texPosX = 0.27;
			texPosY = 0.168;
		}
		if(s.equalsIgnoreCase("v"))
		{
			texPosX = 0.308;
			texPosY = 0.168;
		}
		if(s.equalsIgnoreCase("w"))
		{
			texPosX = 0.346;
			texPosY = 0.168;
		}
		if(s.equalsIgnoreCase("x"))
		{
			texPosX = 0.383;
			texPosY = 0.168;
		}
		if(s.equalsIgnoreCase("y"))
		{
			texPosX = 0.42;
			texPosY = 0.168;
		}
		if(s.equalsIgnoreCase("z"))
		{
			texPosX = 0.46;
			texPosY = 0.168;
		}
		if(s.equalsIgnoreCase("1"))
		{
			texPosX = 0.0523;
			texPosY = 0.246;
		}
		if(s.equalsIgnoreCase("2"))
		{
			texPosX = 0.095;
			texPosY = 0.246;
		}
		if(s.equalsIgnoreCase("3"))
		{
			texPosX = 0.137;
			texPosY = 0.246;
		}
		if(s.equalsIgnoreCase("4"))
		{
			texPosX = 0.174;
			texPosY = 0.246;
		}
		if(s.equalsIgnoreCase("5"))
		{
			texPosX = 0.214;
			texPosY = 0.246;
		}
		if(s.equalsIgnoreCase("6"))
		{
			texPosX = 0.259;
			texPosY = 0.246;
		}
		if(s.equalsIgnoreCase("7"))
		{
			texPosX = 0.306;
			texPosY = 0.246;
		}
		if(s.equalsIgnoreCase("8"))
		{
			texPosX = 0.352;
			texPosY = 0.246;
		}

		if(s.equalsIgnoreCase("9"))
		{
			texPosX = 0.398;
			texPosY = 0.246;
		}
		if(s.equalsIgnoreCase("0"))
		{
			texPosX = 0.443;
			texPosY = 0.246;
		}
		if(s.equalsIgnoreCase("."))
		{
			texPosX = 0.095;
			texPosY = 0.32;
		}
		if(s.equalsIgnoreCase("-"))
		{
			texPosX = 0.0523;
			texPosY = 0.32;
		}
		if(s.equalsIgnoreCase(":"))
		{
			texPosX = 0.137;
			texPosY = 0.32;
		}
		if(s.equalsIgnoreCase("/"))
		{
			texPosX = 0.175;
			texPosY = 0.33;
		}
		if(s.equalsIgnoreCase("!"))
		{
			texPosX = 0.214;
			texPosY = 0.33;
		}

		double texX1 = texPosX;
		double texY1 = texPosY;
		double texX2 = texPosX + 0.02;
		double texY2 = texPosY;
		double texX3 = texPosX + 0.02;
		double texY3 = texPosY + 0.05;
		double texX4 = texPosX;
		double texY4 = texPosY + 0.05;


		GL11.glBegin(GL11.GL_QUADS);
		text.bind();
		GL11.glColor3d(Red,Green,Blue);
		GL11.glTexCoord2d(texX4,texY4);
		GL11.glVertex2d(((x - size) / 1000) * screenWidth, ((y - size) / 1000) * screenHeight);

		// Right & Green
		GL11.glColor3d(Red,Green,Blue);
		GL11.glTexCoord2d(texX3,texY3);
		GL11.glVertex2d(((x + size) / 1000) * screenWidth, ((y - size) / 1000) * screenHeight);

		// Left & Blue
		GL11.glColor3d(Red,Green,Blue);
		GL11.glTexCoord2d(texX2,texY2);
		GL11.glVertex2d(((x + size) / 1000) * screenWidth, ((y + size) / 1000) * screenHeight);
		GL11.glColor3d(Red,Green,Blue);
		GL11.glTexCoord2d(texX1,texY1);
		GL11.glVertex2d(((x - size) / 1000) * screenWidth, ((y + size) / 1000) * screenHeight);
		GL11.glEnd();
	}
	public void setUpIntro()
	{
		
		int addIntro = 27;
		if(IntroTime == 0)
		{
			IntroMusic.playAsMusic(1f, 1f, true);
		}
		/**
		if(IntroTime == 0)
		{
			//EditorMap = EditorMap.returnMapNum(3);
			//Make3D();
			cameraX = 0;
			cameraY = 0;
			cameraZ = 24;
			light0Pos.x = 0;
			light0Pos.y = 0;
			light0Pos.z = -20;
			torchLight = true;
			pointCameraAt(0,0,0);
			light0Intensity = 1;
			//IntroTime = 400;
			
			
		}
		
		if(IntroTime < 260 + addIntro)
		{
			cameraZ = cameraZ - 0.01;
			light0Intensity = light0Intensity + 0.005;
			pointCameraAt(0,0,0);
			System.out.println(IntroTime);
			
			
		}
		if(IntroTime == 260 + addIntro)
		{
			cameraZ = 15;
			light0Intensity = 13;
			
			
			
		}
		if(IntroTime == 350 + addIntro)
		{
			
			light0Dir = 180;
			light0Pos.x = Math.sin(Math.toRadians(light0Dir)) * 20;
			light0Pos.z = Math.cos(Math.toRadians(light0Dir)) * 20;
			
			
		}
		if(IntroTime > 350 + addIntro && IntroTime < 380 + addIntro)
		{
			
			light0Intensity = light0Intensity - 0.1;
			light0Dir = light0Dir + 5;
			light0Pos.x = Math.sin(Math.toRadians(light0Dir)) * 20;
			light0Pos.z = Math.cos(Math.toRadians(light0Dir)) * 20;
			
			
		}
		if(IntroTime == 380 + addIntro)
		{
			cameraZ = 20;
			light0Intensity = 1;
		}
		
		//data = returnDataList(EditorMap.mapData);
		//Make3D();
		//renderSort();
		//Make2D();
		IntroTime ++;
		
		Make3D();
		System.out.println(IntroTime);
		if(IntroTime > 510 + addIntro && IntroTime < 640 + addIntro)
		{
			
			light0Pos.x = 0;
			light0Pos.y = 0;
			light0Pos.z = -20;
			light0Intensity = 20;
			light0Dir = 180;
		}
		if(IntroTime < 640 + addIntro && IntroTime > 620 + addIntro)
		{
			light0Intensity = light0Intensity + ((Math.random() * 1) - 0.5);
			light0Dir = (light0Dir + ((Math.random() * 40) - 20));
			light0Pos.x = Math.sin(Math.toRadians(light0Dir)) * 20;
			light0Pos.z = Math.cos(Math.toRadians(light0Dir)) * 20;
		}
		if(IntroTime < 700 + addIntro && IntroTime > 640 + addIntro)
		{
			light0Pos.x = 0;
			light0Pos.y = 0;
			light0Pos.z = -20;
			light0Intensity = 1;
		}
		
		
		if(IntroTime < 430 + addIntro)
		{
			data = returnDataList(TJ.mapData);
		}
		else if(IntroTime < 640 + addIntro)
		{
			data.clear();
			Data d = new Data();
			d.v4.x = -3;
			d.v4.y = -2;
			d.v4.z = -9;
			d.v1.x = -3;
			d.v1.y = 2;
			d.v1.z = -9;
			d.v2.x = 3;
			d.v2.y = 2;
			d.v2.z = -9;
			d.v3.x = 3;
			d.v3.y = -2;
			d.v3.z = -9;
			d.normal.z = 1;
			d.v1Normal = d.normal;
			d.v2Normal = d.normal;
			d.v3Normal = d.normal;
			d.v4Normal = d.normal;
			d.Red = 1;
			d.Green = 1;
			d.Blue = 1;
			d.tex1.x = 0;
			d.tex1.y = 0;
			d.tex2.x = 1 * ball.getWidth();
			d.tex2.y = 0;
			d.tex3.x = 1 * ball.getWidth();
			d.tex3.y = 1 * ball.getHeight();
			d.tex4.x = 0;
			d.tex4.y = 1 * ball.getHeight();
			draw3DQuad(d,1);
		}
		else
		{
			data.clear();
		}
		*/
		data = returnDataList(TJ.mapData);
		
		renderSort();
		data.clear();
		
		
		IntroTime ++;
		Make3D();
		cameraX = 0;
		cameraZ = -10;
		pointCameraAt(0,0,0);
	
		GL11.glLight(GL11.GL_LIGHT0, GL11.GL_DIFFUSE, floatBuffer((float)0,(float)0,(float)0, 1.0f));
		GL11.glLight(GL11.GL_LIGHT0, GL11.GL_AMBIENT, floatBuffer((float)0,(float)0,(float)0, 1.0f));
		 GL11.glLight(GL11.GL_LIGHT0,GL11.GL_POSITION,floatBuffer((float)-1000,1,(float)(float)0,1));
		if(IntroTime > 267)
		{
			GL11.glDisable(GL11.GL_LIGHT0);
			GL11.glEnable(GL11.GL_LIGHTING);
			GL11.glEnable(GL11.GL_LIGHT6);
			GL11.glLight(GL11.GL_LIGHT6, GL11.GL_DIFFUSE, floatBuffer((float)0.8,(float)0.8,(float)0.8, 1.0f));
			GL11.glLight(GL11.GL_LIGHT6, GL11.GL_AMBIENT, floatBuffer((float)1,(float)1,(float)1, 1.0f));
	        GL11.glLight(GL11.GL_LIGHT6,GL11.GL_POSITION,floatBuffer((float)(Math.sin(Math.toRadians(dirVivid - 10)) * 5),1,(float)(float)(Math.cos(Math.toRadians(dirVivid)) * 5),1));
	        GL11.glEnable(GL11.GL_LIGHT7);
			GL11.glLight(GL11.GL_LIGHT7, GL11.GL_DIFFUSE, floatBuffer((float)1,(float)1,(float)1, 1.0f));
	        GL11.glLight(GL11.GL_LIGHT7,GL11.GL_POSITION,floatBuffer((float)(Math.sin(Math.toRadians(dirVivid + 10)) * 5),(float)1,(float)(Math.cos(Math.toRadians(dirVivid)) * 5),1));
	        GL11.glLineWidth(10);
	        
		}
		
		if(IntroTime > 100 && IntroTime < 160)
		{
			dirVivid = dirVivid - 1.5;
		}
		for(int i = 0; i < vividEye.size(); i ++)
		{
			
			Data d = vividEye.get(i);
			if(IntroTime < 267)
			{
				d.Red = 0.3;
				d.Green = 0.3;
				d.Blue = 0.3;
			}
			else if(IntroTime > 450)
			{
				d.Red = fade;
				d.Green = fade;
				d.Blue = fade;
			}
			else
			{
				d.Red = 1;
				d.Green = 1;
				d.Blue = 1;
			}
			draw3DQuad(d,8);
			if(IntroTime > 100 && IntroTime < 160)
			{
				Quaternion q = new Quaternion();
				q.setFromAxisAngle(new Vector4f((float)0,(float)-1,(float)0,(float)(Math.PI*0.01)));
				Quaternion p = new Quaternion((float)d.v1.x,(float)d.v1.y,(float)d.v1.z,0);
				p = Quaternion.mulInverse(Quaternion.mul(q,p,p),q,p);
				d.v1.x = p.x;
				d.v1.y = p.y;
				d.v1.z = p.z;
				q = new Quaternion();
				q.setFromAxisAngle(new Vector4f((float)0,(float)-1,(float)0,(float)(Math.PI*0.01)));
				p = new Quaternion((float)d.v2.x,(float)d.v2.y,(float)d.v2.z,0);
				p = Quaternion.mulInverse(Quaternion.mul(q,p,p),q,p);
				d.v2.x = p.x;
				d.v2.y = p.y;
				d.v2.z = p.z;
				q = new Quaternion();
				q.setFromAxisAngle(new Vector4f((float)0,(float)-1,(float)0,(float)(Math.PI*0.01)));
				p = new Quaternion((float)d.v3.x,(float)d.v3.y,(float)d.v3.z,0);
				p = Quaternion.mulInverse(Quaternion.mul(q,p,p),q,p);
				d.v3.x = p.x;
				d.v3.y = p.y;
				d.v3.z = p.z;
				q = new Quaternion();
				q.setFromAxisAngle(new Vector4f((float)0,(float)-1,(float)0,(float)(Math.PI*0.01)));
				p = new Quaternion((float)d.v4.x,(float)d.v4.y,(float)d.v4.z,0);
				p = Quaternion.mulInverse(Quaternion.mul(q,p,p),q,p);
				d.v4.x = p.x;
				d.v4.y = p.y;
				d.v4.z = p.z;
			}
		}
		if(IntroTime == 267 || IntroTime == 268)
		{
			Make2D();
			draw2DQuad(0,0,0,1000,1000,1000,1000,0,1,1,1,1,1,1,1);
			
		}
		if(IntroTime > 300 && IntroTime <= 450)
		{
			
			Make2D();
			fade = fade + 0.01;
			draw2DQuadAlpha(300,100,300,200,700,200,700,100,fade,fade,fade,1,1,1,1,1);
			if(fade >= 1)
			{
				fade = 1;
			}
		}
		if(IntroTime > 450)
		{
			Make2D();
			fade = fade - 0.01;
			draw2DQuadAlpha(300,100,300,200,700,200,700,100,fade,fade,fade,1,1,1,1,1);
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_SPACE))
		{
			
			intro = 7;
			torchLight = false;
			light0Pos.x = -10000;
			light0Pos.y = 10000;
			light0Pos.z = 0;
			data.clear();
			blackFog = false;
			EditorMap.mapData.clear();
			TJ.mapData.clear();
			renderType = 1;
			loadMain();
			GL11.glDisable(GL11.GL_LIGHT6);
			GL11.glDisable(GL11.GL_LIGHT7);
			
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_0))
		{
			GL11.glDisable(GL11.GL_LIGHT6);
			GL11.glDisable(GL11.GL_LIGHT7);
			blackFog = false;
			intro = 2;
			torchLight = false;
			light0Pos.x = -10000;
			light0Pos.y = 10000;
			light0Pos.z = 0;
			data.clear();
			EditorMap.mapData.clear();
			TJ.mapData.clear();
			renderType = 1;
			
		}
		if(IntroTime >= 540 + addIntro)
		{
			Make3D();
			cameraZ = 20;
			GL11.glDisable(GL11.GL_LIGHT6);
			GL11.glDisable(GL11.GL_LIGHT7);
			blackFog = false;
			intro = 7;
			torchLight = false;
			light0Pos.x = -10000;
			light0Pos.y = 10000;
			light0Pos.z = 0;
			data.clear();
			EditorMap.mapData.clear();
			TJ.mapData.clear();
			loadMain();
			renderType = 1;
			//EditorMap = new Map();
		}
	

	}
	public void changeScreenSize()
	{
		GL11.glViewport(0, 0, screenWidth, screenHeight); //NEW
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GL11.glOrtho(0, screenWidth, 0, screenHeight, -1, 1);
	}
	public void Make3D()
	{


		GL11.glDisable(GL11.GL_BLEND);
		//GL11.glBlendFunc(GL11.GL_ONE, GL11.GL_ZERO);
		//GL11.glEnable(GL11.GL_ALPHA);
		//GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		/**
		    GL11.glEnable(GL11.GL_LIGHTING);
		    GL11.glEnable(GL11.GL_LIGHT0);
		    GL11.glLightModel(GL11.GL_LIGHT_MODEL_AMBIENT, asFloatBuffer(new float[]{0.05f,0.05f,0.05f,1f}));
		    GL11.glLight(GL11.GL_LIGHT0, GL11.GL_DIFFUSE, asFloatBuffer(new float[]{1.5f,1.5f,1.5f,1}));
		    GL11.glEnable(GL11.GL_CULL_FACE);
		    GL11.glCullFace(GL11.GL_BACK);
		    GL11.glEnable(GL11.GL_COLOR_MATERIAL);
		    GL11.glColorMaterial(GL11.GL_FRONT, GL11.GL_DIFFUSE);
		 */
		GL11.glLoadIdentity(); // Reset The Projection Matrix
		GL11.glEnable(GL11.GL_CULL_FACE);
	    GL11.glCullFace(GL11.GL_FRONT);
		gluPerspective(45.0f, ((float) screenWidth / (float) screenHeight), 0.1f, renderDistance); // Calculate The Aspect Ratio Of The Window
		GL11.glViewport(0, 0, screenWidth,screenHeight);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		GL11.glEnable(GL11.GL_DEPTH_TEST);
		GL11.glEnable(GL11.GL_COLOR_MATERIAL);
		FloatBuffer fogColor = BufferUtils.createFloatBuffer(4);
		if(fogType == 0)
		{
			if(blackFog == false)
			{
				fogColor.put((float)FogColor.x).put((float)(FogColor.y)).put((float)FogColor.z).put(1.0f).flip();
			}
			else
			{
				fogColor.put(0.0f).put(0.0f).put(0.0f).put(1.0f).flip();
			}
		}
		else
		{
			fogColor.put(0.0f).put(0.0f).put(0.0f).put(1.0f).flip();
		}
 
        //GL11.glFogi(GL11.GL_FOG_MODE, fogMode[fogfilter]);          // Fog Mode
        //temp.asFloatBuffer().put(fogColor).flip();
       GL11.glFog(GL11.GL_FOG_COLOR, fogColor);            //
        
        //GL11.glFogf(GL11.GL_FOG_DENSITY, 0.10f);
        // How Dense Will The Fog Be
        GL11.glHint(GL11.GL_FOG_HINT, GL11.GL_DONT_CARE);
        
		GL11.glLoadIdentity();
		GL11.glHint(GL11.GL_PERSPECTIVE_CORRECTION_HINT, GL11.GL_NICEST);
		
		
	
		GL11.glTranslated(0, (float)0,collidedZoom);
		//light0Pos.x = 100000;
		//light0Pos.y = 100000;
		
		
		
		Vector gravitys = new Vector();
		gravitys.x = -Math.abs(veloXGravi);
		gravitys.y = Math.abs(veloYGravi);
		gravitys.z = -Math.abs(veloZGravi);
		//gravitys = touchingPlaneNormal;
		gravitys = gravitys.normalize();
		if(touching)
		{
			//cameraDirZ = 90 * gravitys.x;
			//cameraDirZ = cameraDirZ + (Math.cos(Math.toRadians(cameraDirY)) * 180) * gravitys.x;
		}
		if(cameraDirX > 90)
		{
			cameraDirX = 90;
		}
		if(cameraDirX < -90)
		{
			cameraDirX = -90;
		}
		if(cameraDirY > 180)
		{
			cameraDirY = -180 + (cameraDirY - 180);
		}
		if(cameraDirY < -180)
		{
			cameraDirY = 180 + (cameraDirY + 180);
		}
		//cameraDirZ = 90;
		if(mode == 0)
		{
			gravitys.x = 0;
			gravitys.y = 1;
			gravitys.z = 0;
		}
		/**
		if(Math.round(gravitys.x) == 1)
		{
			gravitys.x = 1;
			gravitys.y = 0;
			gravitys.z = 0;
		}
		
		if(Math.round(gravitys.z) == 1)
		{
			gravitys.x = 0;
			gravitys.y = 0;
			gravitys.z = 1;
		}
		*/
		if(Math.round(gravitys.y) == 1)
		{
			gravitys.x = 0;
			gravitys.y = 1;
			gravitys.z = 0;
		}
		gravitys.x = 0;
		gravitys.y = 1;
		gravitys.z = 0;
		double camDirXX = cameraDirX;//+ (90 * ((1 - gravitys.y)));
		//camDirXX = //camDirXX + 90 * ((1 - gravitys.y));
		double camDirYX = cameraDirY;
		//GL11.glRotated(cameraDirZ, -Math.cos(Math.toRadians(cameraDirY)) ,-Math.sin(Math.toRadians(cameraDirY)),0);
		//cameraDirZ = camDirYX * -gravitys.z;
		//GL11.glRotated(camDirXX,0,0);
		
		//GL11.glRotated(camDirXX,0,(float)-(gravitys.x * Math.sin(Math.toRadians(camDirYX))),(float)(gravitys.x * Math.cos(Math.toRadians(camDirYX))));
		
		//
		if(Math.abs(gravitys.x) > 0)
		{
			GL11.glRotated(180 * gravitys.x, 0, 0,1);
			
		}
		if(Math.abs(gravitys.y) > 0 || Math.abs(gravitys.z) > 0)
		{
			cameraRotations.y = (camDirYX * -gravitys.y);
			GL11.glRotated(camDirYX,0 ,-gravitys.y, -gravitys.z);
			cameraRotations.x = (gravitys.y * -Math.cos(Math.toRadians(camDirYX))) * camDirXX;
			cameraRotations.z = (gravitys.y * Math.sin(Math.toRadians(camDirYX))) * camDirXX;
			GL11.glRotated(camDirXX,(float)(gravitys.y * -Math.cos(Math.toRadians(camDirYX))) + (float)(gravitys.z * Math.cos(Math.toRadians(camDirYX))) ,(float)-(gravitys.z * Math.sin(Math.toRadians(camDirYX))), (float)(gravitys.y * Math.sin(Math.toRadians(camDirYX))));
		}
		
		//GL11.glRotated(camDirXX,(float)(gravitys.y * -Math.cos(Math.toRadians(camDirYX))) + (float)(gravitys.z * Math.cos(Math.toRadians(camDirYX))) ,(float)-(gravitys.z * Math.sin(Math.toRadians(camDirYX))), (float)(gravitys.y * Math.sin(Math.toRadians(camDirYX))) + (-gravitys.x * Math.cos(Math.toRadians(camDirYX))));
		
		//GL11.glRotated(cameraDirZ, Math.sin(Math.toRadians(cameraDirY)) ,0, Math.cos(Math.toRadians(cameraDirY)));
		//GL11.glRotated(camDirXX,(float)(gravitys.y * -Math.cos(Math.toRadians(camDirYX))) + (float)(gravitys.z * Math.cos(Math.toRadians(camDirYX))) ,(float)-(gravitys.z * Math.sin(Math.toRadians(camDirYX))) + (float)(gravitys.x * Math.sin(Math.toRadians(camDirYX))), (float)(gravitys.y * Math.sin(Math.toRadians(camDirYX))) + (float)-(gravitys.x * Math.cos(Math.toRadians(camDirYX))));
		
		//GL11.glRotated(camDirXX,((float)(1 - gravitys.x) * -Math.cos(Math.toRadians(camDirYX))),(float)((gravitys.z) * Math.sin(Math.toRadians(camDirYX))) + ((float)((gravitys.x) * -Math.sin(Math.toRadians(camDirYX)))), (float)(1 - gravitys.z) * Math.sin(Math.toRadians(cameraDirY)) + ((float)((gravitys.x) * Math.cos(Math.toRadians(camDirYX)))));
		
		/**
		//Rotate Y X
		GL11.glRotated(camDirYX * (float)gravitys.x,-1, 0, 0);
		//Rotate Y Y
		GL11.glRotated(cameraDirY * (float)gravitys.y,0, -1, 0);
		//Rotate Y Z
		GL11.glRotated(cameraDirY * (float)gravitys.z,0, 0, -1);
		//Rotate X X
		GL11.glRotated(camDirXX * (float)gravitys.x, 0,  -Math.cos(Math.toRadians(camDirYX)),Math.sin(Math.toRadians(camDirYX)));
		//Rotate X Y
		GL11.glRotated(cameraDirX * (float)gravitys.y, -Math.cos(Math.toRadians(cameraDirY)), 0, Math.sin(Math.toRadians(cameraDirY)));
		//Rotate X Z
		GL11.glRotated(cameraDirX * (float)gravitys.z, Math.cos(Math.toRadians(cameraDirY)),  Math.sin(Math.toRadians(cameraDirY)),0);
		//Rotate Z X
		GL11.glRotated(cameraDirZ * (float)gravitys.x, 0,-Math.cos(Math.toRadians(camDirYX + 90)) , Math.sin(Math.toRadians(camDirYX + 90)));
		//Rotate Z Y
		GL11.glRotated(cameraDirZ * (float)gravitys.y, -Math.cos(Math.toRadians(cameraDirY + 90)) ,0, Math.sin(Math.toRadians(cameraDirY + 90)));
		//Rotate Z Z
		GL11.glRotated(cameraDirZ * (float)gravitys.z, -Math.sin(Math.toRadians(cameraDirY + 90)),Math.cos(Math.toRadians(cameraDirY + 90)) , 0);
		*/
		//GL11.glTranslated(cameraX,cameraY,cameraZ);
		//System.out.println(cameraDirX);
		//System.out.println(cameraDirY);
		//enable light 0
		 gravitys = new Vector();
			gravitys.x = (veloXGravi);
			gravitys.y = -(veloYGravi);
			gravitys.z = (veloZGravi);
			//gravitys = touchingPlaneNormal;
			gravitys = gravitys.normalize();
			if(mode == 1)
			{
				
				if(lastCamRot.x != -90 * ((gravitys.x)))	
				{
					
					changeRotBy = (((-90 * ((gravitys.x))) - lastCamRot.x) / 30);
					lastCamRot.x = lastCamRot.x + changeRotBy;
					GL11.glRotated(lastCamRot.x, 0, 0,1);
					//GL11.glRotated(90 * ((gravitys.z)), 1, 0,0);
				}
				if(lastCamRot.z != 90 * ((gravitys.z)))
				{
					changeRotBy = (((90 * ((gravitys.z))) - lastCamRot.z) / 30);
					lastCamRot.z = lastCamRot.z + changeRotBy;
					GL11.glRotated(lastCamRot.z, 1, 0,0);
				}
				if(lastCamRot.z == 90 * ((gravitys.z)) && lastCamRot.x != -90 * ((gravitys.x)))
				{
					GL11.glRotated(90 * ((gravitys.x)), 0, 0,-1);
					GL11.glRotated(90 * ((gravitys.z)), 1, 0,0);
					cameraRotations.z = cameraRotations.z + -(90 * ((gravitys.x)));
					cameraRotations.x = cameraRotations.x + (90 * ((gravitys.z)));
				}
				
				
				
				
			}
			
			GL11.glTranslated(cameraX,cameraY,cameraZ);
			GL11.glDisable(GL11.GL_CULL_FACE);
			if(Keyboard.isKeyDown(Keyboard.KEY_CAPITAL))
			{
				for(int i = 0; i < 15; i ++)
				{
					System.out.println("");
				}
				System.out.println("cameraRotX " + cameraRotations.x);
				System.out.println("cameraRotY " + cameraRotations.y);
				System.out.println("cameraRotZ " + cameraRotations.z);
			}
        // Fog End Depth
        GL11.glEnable(GL11.GL_FOG);
        GL11.glFogi(GL11.GL_FOG_MODE, GL11.GL_LINEAR);
        if(fogType == 0)
        {
	        GL11.glFogf(GL11.GL_FOG_START, renderDistance / 1.4f);
	        // Fog Start Depth
	        GL11.glFogf(GL11.GL_FOG_END, renderDistance / 1.01f);
        }
        else
        {
        	 GL11.glFogf(GL11.GL_FOG_START, 15f);
 	        // Fog Start Depth
 	        GL11.glFogf(GL11.GL_FOG_END, 25f);
        }
        //GL11.glFogf(GL11.GL_FOG_DENSITY, 2.f);
       
        if(blackFog == false || fogType == 1)
        {
        	GL11.glClearColor((float)FogColor.x,(float)FogColor.y,(float)FogColor.z, 1.0f);
        }
        else
        {
        	GL11.glClearColor(0.0f,0.0f,0f, 1.0f);
        }
        
		//GL11.glShadeModel(GL11.GL_SMOOTH);
		 	GL11.glEnable(GL11.GL_LIGHTING);
	        GL11.glEnable(GL11.GL_LIGHT0);
	        
	       // GL11.glEnable(GL11.GL_COLOR_MATERIAL);
	        //GL11.glColorMaterial(GL11.GL_FRONT_AND_BACK, GL11.GL_AMBIENT_AND_DIFFUSE);
	        GL11.glLight(GL11.GL_LIGHT0, GL11.GL_DIFFUSE, floatBuffer((float)(light0Dif.x),(float)light0Dif.y,(float)light0Dif.z, 1.0f));
	        GL11.glLight(GL11.GL_LIGHT0,GL11.GL_POSITION,floatBuffer((float)light0Pos.x,(float)light0Pos.y,(float)light0Pos.z,1));
	        GL11.glLight(GL11.GL_LIGHT0, GL11.GL_AMBIENT, floatBuffer((float)(light0Amb.x),(float)light0Amb.y,(float)light0Amb.z,1));
	        GL11.glLight(GL11.GL_LIGHT0, GL11.GL_SPECULAR, floatBuffer(0.5f, 0.5f, 0.5f, 1.0f));
	        GL11.glLight(GL11.GL_LIGHT0, GL11.GL_EMISSION, floatBuffer(0f, 0f, 0f, 1.0f));
	        //GL11.glLight(GL11.GL_LIGHT0, GL11.GL_SPECULAR, floatBuffer(1.0f, 1.0f, 1.0f, 1.0f));
	        //enable light 1
	        /**
	        GL11.glEnable(GL11.GL_LIGHT1);
	        GL11.glEnable(GL11.GL_COLOR_MATERIAL);
	        GL11.glColorMaterial(GL11.GL_FRONT_AND_BACK, GL11.GL_AMBIENT_AND_DIFFUSE);
	        GL11.glLight(GL11.GL_LIGHT1, GL11.GL_DIFFUSE, floatBuffer(0.0f, 0.0f, 1.0f, 1.0f));
	        GL11.glLight(GL11.GL_LIGHT1,GL11.GL_POSITION,floatBuffer(0,10,0,1));
	        GL11.glLight(GL11.GL_LIGHT1, GL11.GL_SPECULAR, floatBuffer(1.0f, 1.0f, 1.0f, 1.0f));
	        */
	       // GL11.GL_
	        //GL11.glLight(GL11.GL_LIGHT0, GL11.GL_INTENSITY, floatBuffer(0.0f, 0.0f, 0.0f, 0.0f));
	       


	}
	public FloatBuffer floatBuffer(float a, float b, float c, float d)
    {
	    float[] data = new float[]{a,b,c,d};
	    FloatBuffer fb = BufferUtils.createFloatBuffer(data.length);
	    fb.put(data);
	    fb.flip();
	    return fb;
     }
	public FloatBuffer asFloatBuffer(float[] values)
	{
		FloatBuffer buffer = BufferUtils.createFloatBuffer(values.length);
		buffer.put(values);
		buffer.flip();
		return buffer;
	}
	
	public void Make2D()
	{
		GL11.glDisable(GL11.GL_CULL_FACE);
		GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		//GL11.glClearColor(0.0f,0.0f,0.0f,0.0f);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);

		GL11.glViewport(0, 0, screenWidth,screenHeight);
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GL11.glOrtho(0, screenWidth, 0, screenHeight * 0.8, 1, -1);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		GL11.glDisable(GL11.GL_DEPTH_TEST);
		GL11.glLoadIdentity();
	}
	public void schematicInEditor()
	{
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glDisable(GL11.GL_CULL_FACE);
		//GL11.glDisable(GL11.GL_DEPTH_TEST);
		for(int i = 0; i < currentSchematic.mapData.size(); i ++)
		{
			Data d = new Data();
			d = currentSchematic.mapData.get(i);
			Data d2 = new Data();
			d2.v1 = d.v1.add(editPos);
			d2.v2 = d.v2.add(editPos);
			d2.v3 = d.v3.add(editPos);
			d2.mid = d.v1.add(d.v2.add(d.v3));
			d2.mid = d.mid.divideNon(3);
			d2.Red = d.Red;
			d2.Blue = d.Blue;
			d2.Green = d.Green;
			d2.Alpha = d.Alpha - 0.3;
			d2.v1Normal = d.v1Normal;
			d2.v2Normal = d.v2Normal;
			d2.v3Normal = d.v3Normal;
			d2.Collide = true;
			draw3DTriangle(d2);
			
		}
		GL11.glDisable(GL11.GL_BLEND);
		if(Keyboard.isKeyDown(Keyboard.KEY_RIGHT) && !Keyboard.isKeyDown(Keyboard.KEY_B))
		{
			double rotateX = -Math.sin(Math.toRadians(cameraDirY));
			double rotateZ = -Math.cos(Math.toRadians(cameraDirY));
			for(int i = 0; i < currentSchematic.mapData.size(); i ++)
			{
				Data d = new Data();
				d = currentSchematic.mapData.get(i);
				Quaternion q = new Quaternion();
				q.setFromAxisAngle(new Vector4f((float)rotateX,(float)0,(float)rotateZ,(float)((float)Math.PI *(0.01))));
				Quaternion p = new Quaternion((float)d.v1.x,(float)d.v1.y,(float)d.v1.z,0);
				p = Quaternion.mulInverse(Quaternion.mul(q,p,p),q,p);
				d.v1.x = p.x;
				d.v1.y = p.y;
				d.v1.z = p.z;
				q = new Quaternion();
				q.setFromAxisAngle(new Vector4f((float)rotateX,(float)0,(float)rotateZ,(float)((float)Math.PI *(0.01))));
				p = new Quaternion((float)d.v2.x,(float)d.v2.y,(float)d.v2.z,0);
				p = Quaternion.mulInverse(Quaternion.mul(q,p,p),q,p);
				d.v2.x = p.x;
				d.v2.y = p.y;
				d.v2.z = p.z;
				q = new Quaternion();
				q.setFromAxisAngle(new Vector4f((float)rotateX,(float)0,(float)rotateZ,(float)((float)Math.PI *(0.01))));
				p = new Quaternion((float)d.v3.x,(float)d.v3.y,(float)d.v3.z,0);
				p = Quaternion.mulInverse(Quaternion.mul(q,p,p),q,p);
				d.v3.x = p.x;
				d.v3.y = p.y;
				d.v3.z = p.z;
				d.mid = d.v1.add(d.v2.add(d.v3));
				d.mid = d.mid.divideNon(3);
				d.normal = getSurfaceNormal(d);
				d.v1Normal = d.normal;
				d.v2Normal = d.normal;
				d.v3Normal = d.normal;
				//draw3DTriangle(d2);
				
			}
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_LEFT) && !Keyboard.isKeyDown(Keyboard.KEY_B))
		{
			double rotateX = Math.sin(Math.toRadians(cameraDirY));
			double rotateZ = Math.cos(Math.toRadians(cameraDirY));
			for(int i = 0; i < currentSchematic.mapData.size(); i ++)
			{
				Data d = new Data();
				d = currentSchematic.mapData.get(i);
				Quaternion q = new Quaternion();
				q.setFromAxisAngle(new Vector4f((float)rotateX,(float)0,(float)rotateZ,(float)((float)Math.PI *(0.01))));
				Quaternion p = new Quaternion((float)d.v1.x,(float)d.v1.y,(float)d.v1.z,0);
				p = Quaternion.mulInverse(Quaternion.mul(q,p,p),q,p);
				d.v1.x = p.x;
				d.v1.y = p.y;
				d.v1.z = p.z;
				q = new Quaternion();
				q.setFromAxisAngle(new Vector4f((float)rotateX,(float)0,(float)rotateZ,(float)((float)Math.PI *(0.01))));
				p = new Quaternion((float)d.v2.x,(float)d.v2.y,(float)d.v2.z,0);
				p = Quaternion.mulInverse(Quaternion.mul(q,p,p),q,p);
				d.v2.x = p.x;
				d.v2.y = p.y;
				d.v2.z = p.z;
				q = new Quaternion();
				q.setFromAxisAngle(new Vector4f((float)rotateX,(float)0,(float)rotateZ,(float)((float)Math.PI *(0.01))));
				p = new Quaternion((float)d.v3.x,(float)d.v3.y,(float)d.v3.z,0);
				p = Quaternion.mulInverse(Quaternion.mul(q,p,p),q,p);
				d.v3.x = p.x;
				d.v3.y = p.y;
				d.v3.z = p.z;
				d.mid = d.v1.add(d.v2.add(d.v3));
				d.mid = d.mid.divideNon(3);
				d.normal = getSurfaceNormal(d);
				d.v1Normal = d.normal;
				d.v2Normal = d.normal;
				d.v3Normal = d.normal;
				//draw3DTriangle(d2);
				
			}
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_LEFT) && Keyboard.isKeyDown(Keyboard.KEY_B))
		{
			
			for(int i = 0; i < currentSchematic.mapData.size(); i ++)
			{
				Data d = new Data();
				d = currentSchematic.mapData.get(i);
				Quaternion q = new Quaternion();
				q.setFromAxisAngle(new Vector4f((float)0,(float)-1,(float)0,(float)((float)Math.PI *(0.01))));
				Quaternion p = new Quaternion((float)d.v1.x,(float)d.v1.y,(float)d.v1.z,0);
				p = Quaternion.mulInverse(Quaternion.mul(q,p,p),q,p);
				d.v1.x = p.x;
				d.v1.y = p.y;
				d.v1.z = p.z;
				q = new Quaternion();
				q.setFromAxisAngle(new Vector4f((float)0,(float)-1,(float)0,(float)((float)Math.PI *(0.01))));
				p = new Quaternion((float)d.v2.x,(float)d.v2.y,(float)d.v2.z,0);
				p = Quaternion.mulInverse(Quaternion.mul(q,p,p),q,p);
				d.v2.x = p.x;
				d.v2.y = p.y;
				d.v2.z = p.z;
				q = new Quaternion();
				q.setFromAxisAngle(new Vector4f((float)0,(float)-1,(float)0,(float)((float)Math.PI *(0.01))));
				p = new Quaternion((float)d.v3.x,(float)d.v3.y,(float)d.v3.z,0);
				p = Quaternion.mulInverse(Quaternion.mul(q,p,p),q,p);
				d.v3.x = p.x;
				d.v3.y = p.y;
				d.v3.z = p.z;
				d.mid = d.v1.add(d.v2.add(d.v3));
				d.mid = d.mid.divideNon(3);
				d.normal = getSurfaceNormal(d);
				d.v1Normal = d.normal;
				d.v2Normal = d.normal;
				d.v3Normal = d.normal;
				//draw3DTriangle(d2);
				
			}
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_RIGHT) && Keyboard.isKeyDown(Keyboard.KEY_B))
		{
			
			for(int i = 0; i < currentSchematic.mapData.size(); i ++)
			{
				Data d = new Data();
				d = currentSchematic.mapData.get(i);
				Quaternion q = new Quaternion();
				q.setFromAxisAngle(new Vector4f((float)0,(float)1,(float)0,(float)((float)Math.PI *(0.01))));
				Quaternion p = new Quaternion((float)d.v1.x,(float)d.v1.y,(float)d.v1.z,0);
				p = Quaternion.mulInverse(Quaternion.mul(q,p,p),q,p);
				d.v1.x = p.x;
				d.v1.y = p.y;
				d.v1.z = p.z;
				q = new Quaternion();
				q.setFromAxisAngle(new Vector4f((float)0,(float)1,(float)0,(float)((float)Math.PI *(0.01))));
				p = new Quaternion((float)d.v2.x,(float)d.v2.y,(float)d.v2.z,0);
				p = Quaternion.mulInverse(Quaternion.mul(q,p,p),q,p);
				d.v2.x = p.x;
				d.v2.y = p.y;
				d.v2.z = p.z;
				q = new Quaternion();
				q.setFromAxisAngle(new Vector4f((float)0,(float)1,(float)0,(float)((float)Math.PI *(0.01))));
				p = new Quaternion((float)d.v3.x,(float)d.v3.y,(float)d.v3.z,0);
				p = Quaternion.mulInverse(Quaternion.mul(q,p,p),q,p);
				d.v3.x = p.x;
				d.v3.y = p.y;
				d.v3.z = p.z;
				d.mid = d.v1.add(d.v2.add(d.v3));
				d.mid = d.mid.divideNon(3);
				d.normal = getSurfaceNormal(d);
				d.v1Normal = d.normal;
				d.v2Normal = d.normal;
				d.v3Normal = d.normal;
				//draw3DTriangle(d2);
				
			}
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_UP))
		{
			for(int i = 0; i < currentSchematic.mapData.size(); i ++)
			{
				Data d = new Data();
				d = currentSchematic.mapData.get(i);
				
				d.v1.x = d.v1.x * 1.03;
				d.v1.y = d.v1.y * 1.03;
				d.v1.z = d.v1.z * 1.03;
				d.v2.x = d.v2.x * 1.03;
				d.v2.y = d.v2.y * 1.03;
				d.v2.z = d.v2.z * 1.03;
				d.v3.x = d.v3.x * 1.03;
				d.v3.y = d.v3.y * 1.03;
				d.v3.z = d.v3.z * 1.03;
				d.mid = d.v1.add(d.v2.add(d.v3));
				d.mid = d.mid.divideNon(3);
				
				//draw3DTriangle(d2);
				
			}
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_DOWN))
		{
			for(int i = 0; i < currentSchematic.mapData.size(); i ++)
			{
				Data d = new Data();
				d = currentSchematic.mapData.get(i);
				
				d.v1.x = d.v1.x * 0.97;
				d.v1.y = d.v1.y * 0.97;
				d.v1.z = d.v1.z * 0.97;
				d.v2.x = d.v2.x * 0.97;
				d.v2.y = d.v2.y * 0.97;
				d.v2.z = d.v2.z * 0.97;
				d.v3.x = d.v3.x * 0.97;
				d.v3.y = d.v3.y * 0.97;
				d.v3.z = d.v3.z * 0.97;
				d.mid = d.v1.add(d.v2.add(d.v3));
				d.mid = d.mid.divideNon(3);
				
				//draw3DTriangle(d2);
				
			}
		}
		
	}
	public void Shapes()
	{
		
		Make2D();
		draw2DQuad(150,150,150,850 - 100,850,850 - 100,850,150,0.4,0.4,0.4,0.3,1,1,0.3);
		if(draw2DQuadDec(170,800 - 100,170,820 - 100,190,820 - 100,190,800 - 100,0.1,0.5,1,1,0.3,0.3,1))
		{
			if(Mouse.isButtonDown(0))
			{
				schematicLoaded = true;
				currentSchematic.mapData = setUpSphere(0,0,0,3,10,1);
				shapesEditor = false;
			}
			
		}
		if(draw2DQuadDec(170 + 30,800 - 100,170 + 30,820 - 100,190 + 30,820 - 100,190 + 30,800 - 100,0.1,0.5,1,1,0.3,0.3,1))
		{
			
			if(Mouse.isButtonDown(0))
			{
				schematicLoaded = true;
				double dir = 0;
				shapesEditor = false;
				for(int i = 0; i < 10; i ++)
				{
					Data d = new Data();
					d.v1.x = 0;
					d.v1.y = (shapesHeight - 249) / 10;
					d.v1.z = 0;
					d.v2.x = Math.sin(Math.toRadians(dir)) * ((shapesWidth - 249) / 10);
					d.v2.y = 0;
					d.v2.z = Math.cos(Math.toRadians(dir)) * ((shapesWidth - 249) / 10);
					dir = dir + 36;
					d.v3.x = Math.sin(Math.toRadians(dir)) * ((shapesWidth - 249) / 10);
					d.v3.y = 0;
					d.v3.z = Math.cos(Math.toRadians(dir)) * ((shapesWidth - 249) / 10);
					d.Red = EditRed / 1000;
					d.Green = EditGreen / 1000;
					d.Blue = EditBlue / 1000;
					d.Alpha = ((alphaX - 500) / 200);
					d.mid = d.v1.add(d.v2.add(d.v3));
					d.mid = d.mid.divideNon(3);
					d.normal = getSurfaceNormal(d);
					d.v1Normal = d.normal;
					d.v2Normal = d.normal;
					d.v3Normal = d.normal;
					currentSchematic.mapData.add(d);
					dir = dir - 36;
					d = new Data();
					d.v3.x = 0;
					d.v3.y = 0;
					d.v3.z = 0;
					d.v2.x = Math.sin(Math.toRadians(dir)) * ((shapesWidth - 249) / 10);
					d.v2.y = 0;
					d.v2.z = Math.cos(Math.toRadians(dir)) * ((shapesWidth - 249) / 10);
					dir = dir + 36;
					d.v1.x = Math.sin(Math.toRadians(dir)) * ((shapesWidth - 249) / 10);
					d.v1.y = 0;
					d.v1.z = Math.cos(Math.toRadians(dir)) * ((shapesWidth - 249) / 10);
					d.Red = EditRed / 1000;
					d.Green = EditGreen / 1000;
					d.Blue = EditBlue / 1000;
					d.Alpha = ((alphaX - 500) / 200);
					d.mid = d.v1.add(d.v2.add(d.v3));
					d.mid = d.mid.divideNon(3);
					d.normal = getSurfaceNormal(d);
					d.v1Normal = d.normal;
					d.v2Normal = d.normal;
					d.v3Normal = d.normal;
					currentSchematic.mapData.add(d);
					
				}
				
			}
		}
		if(draw2DQuadDec(170 + 60,800 - 100,170 + 60,820 - 100,190 + 60,820 - 100,190 + 60,800 - 100,0.1,0.5,1,1,0.3,0.3,1))
		{
			
			if(Mouse.isButtonDown(0))
			{
				schematicLoaded = true;
				double dir = 0;
				shapesEditor = false;
				
				for(int i = 0; i < 10; i ++)
				{
					Data d = new Data();
					d.v1.x = (Math.sin(Math.toRadians(dir)) * ((shapesWidth - 249) / 10));
					d.v1.y = (shapesHeight - 249) / 10;
					d.v1.z = Math.cos(Math.toRadians(dir)) * ((shapesWidth - 249) / 10);
					d.v2.x = Math.sin(Math.toRadians(dir)) * ((shapesWidth - 249) / 10);
					d.v2.y = -0.5;
					d.v2.z = Math.cos(Math.toRadians(dir)) * ((shapesWidth - 249) / 10);
					dir = dir + 36;
					d.v3.x = Math.sin(Math.toRadians(dir)) * ((shapesWidth - 249) / 10);
					d.v3.y = -0.5;
					d.v3.z = Math.cos(Math.toRadians(dir)) * ((shapesWidth - 249) / 10);
					d.Red = EditRed / 1000;
					d.Green = EditGreen / 1000;
					d.Blue = EditBlue / 1000;
					d.Alpha = ((alphaX - 500) / 200);
					d.mid = d.v1.add(d.v2.add(d.v3));
					d.mid = d.mid.divideNon(3);
					d.normal = getSurfaceNormal(d);
					d.v1Normal = d.normal;
					d.v2Normal = d.normal;
					d.v3Normal = d.normal;
					currentSchematic.mapData.add(d);
					dir = dir - 36;
					d = new Data();
					d.v1.x = Math.sin(Math.toRadians(dir)) * ((shapesWidth - 249) / 10);
					d.v1.y = (shapesHeight - 249) / 10;;
					d.v1.z = Math.cos(Math.toRadians(dir)) * ((shapesWidth - 249) / 10);
					dir = dir + 36;
					d.v2.x = Math.sin(Math.toRadians(dir)) * ((shapesWidth - 249) / 10);
					d.v2.y = -0.5;
					d.v2.z = Math.cos(Math.toRadians(dir)) * ((shapesWidth - 249) / 10);
					
					d.v3.x = Math.sin(Math.toRadians(dir)) * ((shapesWidth - 249) / 10);
					d.v3.y = (shapesHeight - 249) / 10;;
					d.v3.z = Math.cos(Math.toRadians(dir)) * ((shapesWidth - 249) / 10);
					d.Red = EditRed / 1000;
					d.Green = EditGreen / 1000;
					d.Blue = EditBlue / 1000;
					d.Alpha = ((alphaX - 500) / 200);
					d.mid = d.v1.add(d.v2.add(d.v3));
					d.mid = d.mid.divideNon(3);
					d.normal = getSurfaceNormal(d);
					d.v1Normal = d.normal;
					d.v2Normal = d.normal;
					d.v3Normal = d.normal;
					currentSchematic.mapData.add(d);
					
					
				}
				System.out.println("width " + ((shapesWidth - 249) / 10));
				
			}
		}
		Vector Height = new Vector();
		Height = slider(shapesHeight,500,750,250,3);
		shapesHeight = (int)Math.round(Height.x);
		Vector Width = new Vector();
		Width = slider(shapesWidth,450,750,250,4);
		shapesWidth = (int)Math.round(Width.x);
	}
	public void drawLightningAt(Vector pos1, Vector pos2)
	{
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glLineWidth(4);
		Vector dir = new Vector();
		dir.x =  pos2.x - pos1.x;
		dir.z =  pos2.z - pos1.z;
		dir = dir.normalize();
		double dirY = Math.toDegrees(Math.acos(dir.z));
		if(dir.x < 0)
		{
			dirY = dirY * -1;
		}
		dir = new Vector();
		dir.x =  pos2.x - pos1.x;
		dir.y =  pos2.y - pos1.y;
		dir.z =  pos2.z - pos1.z;
		dir = dir.normalize();
		double dirX = Math.toDegrees(Math.asin(dir.y));
		Distance(pos2.x,pos2.y,pos2.z,pos1.x,pos1.y,pos1.z);
		Distance = Distance / 20;
		Vector lightning = new Vector();
		lightning.x = pos1.x;
		lightning.y = pos1.y;
		lightning.z = pos1.z;
		dirX = dirX + ((Math.random() * 80) - 40);
		dirY = dirY + ((Math.random() * 80) - 40);
		for(int i = 0; i < 10; i ++)
		{
			
			dirY = dirY + (((Math.random() * 10) - 5));
			dirX = dirX + ((Math.random() * 10) - 5);
			draw3DLine(lightning.x,lightning.y,lightning.z,lightning.x + ((Math.cos(Math.toRadians(dirX)) * Math.sin(Math.toRadians(dirY))) * Distance),lightning.y + ((Math.sin(Math.toRadians(dirX))) * Distance),lightning.z + ((Math.cos(Math.toRadians(dirX)) * Math.cos(Math.toRadians(dirY))) * Distance),0.6,0.7,1,0.6);
			lightning.x = lightning.x + (((Math.cos(Math.toRadians(dirX)) * Math.sin(Math.toRadians(dirY))) * Distance) / 2);
			lightning.y = lightning.y + (((Math.sin(Math.toRadians(dirX))) * Distance) / 2);
			lightning.z = lightning.z + (((Math.cos(Math.toRadians(dirX)) * Math.cos(Math.toRadians(dirY))) * Distance) / 2);
			if(Math.round(Math.random() * 5) == 2)
			{
				GL11.glLineWidth(2);
				double oldDirX = dirX;
				double oldDirY = dirY;
				dirX = (dirX + ((Math.random() * 90) - 45));
				dirY = (dirY + ((Math.random() * 90) - 45));
				draw3DLine(lightning.x,lightning.y,lightning.z,lightning.x + ((Math.cos(Math.toRadians(dirX)) * Math.sin(Math.toRadians(dirY))) * (Distance * 3)),lightning.y + ((Math.sin(Math.toRadians(dirX))) * (Distance * 3)),lightning.z + ((Math.cos(Math.toRadians(dirX)) * Math.cos(Math.toRadians(dirY))) * (Distance * 3)),0.6,0.7,1,0.6);
				dirX = oldDirX;
				dirY = oldDirY;
			}
			lightning.x = lightning.x + (((Math.cos(Math.toRadians(dirX)) * Math.sin(Math.toRadians(dirY))) * Distance) / 2);
			lightning.y = lightning.y + (((Math.sin(Math.toRadians(dirX))) * Distance) / 2);
			lightning.z = lightning.z + (((Math.cos(Math.toRadians(dirX)) * Math.cos(Math.toRadians(dirY))) * Distance) / 2);
		}
		Vector dir2 = new Vector();
		dir2.x =  pos2.x - lightning.x;
		dir2.z =  pos2.z - lightning.z;
		dir2 = dir2.normalize();
		double dirY2 = Math.toDegrees(Math.acos(dir2.z));
		if(dir2.x < 0)
		{
			dirY2 = dirY2 * -1;
		}
		dir2 = new Vector();
		dir2.x =  pos2.x - lightning.x;
		dir2.y =  pos2.y - lightning.y;
		dir2.z =  pos2.z - lightning.z;
		dir2 = dir2.normalize();
		double dirX2 = Math.toDegrees(Math.asin(dir2.y));
		double changeXBy = (dirX2 - dirX) / 10;
		double changeYBy = (dirY2 - dirY) / 10;
		for(int i = 0; i < 10; i ++)
		{
			
			dirY = dirY + ((Math.random() * 5) - 2.5) + changeYBy;
			dirX = dirX + ((Math.random() * 5) - 2.5) + changeXBy;
			draw3DLine(lightning.x,lightning.y,lightning.z,lightning.x + ((Math.cos(Math.toRadians(dirX)) * Math.sin(Math.toRadians(dirY))) * Distance),lightning.y + ((Math.sin(Math.toRadians(dirX))) * Distance),lightning.z + ((Math.cos(Math.toRadians(dirX)) * Math.cos(Math.toRadians(dirY))) * Distance),0.6,0.7,1,0.6);
			lightning.x = lightning.x + (((Math.cos(Math.toRadians(dirX)) * Math.sin(Math.toRadians(dirY))) * Distance) / 2);
			lightning.y = lightning.y + (((Math.sin(Math.toRadians(dirX))) * Distance) / 2);
			lightning.z = lightning.z + (((Math.cos(Math.toRadians(dirX)) * Math.cos(Math.toRadians(dirY))) * Distance) / 2);
			if(Math.round(Math.random() * 5) == 2)
			{
				GL11.glLineWidth(2);
				double oldDirX = dirX;
				double oldDirY = dirY;
				dirX = (dirX + ((Math.random() * 90) - 45));
				dirY = (dirY + ((Math.random() * 90) - 45));
				draw3DLine(lightning.x,lightning.y,lightning.z,lightning.x + ((Math.cos(Math.toRadians(dirX)) * Math.sin(Math.toRadians(dirY))) * (Distance * 3)),lightning.y + ((Math.sin(Math.toRadians(dirX))) * (Distance * 3)),lightning.z + ((Math.cos(Math.toRadians(dirX)) * Math.cos(Math.toRadians(dirY))) * (Distance * 3)),0.6,0.7,1,0.6);
				dirX = oldDirX;
				dirY = oldDirY;
			}
			lightning.x = lightning.x + (((Math.cos(Math.toRadians(dirX)) * Math.sin(Math.toRadians(dirY))) * Distance) / 2);
			lightning.y = lightning.y + (((Math.sin(Math.toRadians(dirX))) * Distance) / 2);
			lightning.z = lightning.z + (((Math.cos(Math.toRadians(dirX)) * Math.cos(Math.toRadians(dirY))) * Distance) / 2);
		}
		draw3DLine(lightning.x,lightning.y,lightning.z,pos2.x,pos2.y,pos2.z,0.6,0.7,1,0.6);
		GL11.glLineWidth(1);
		//System.out.println((0.5 * 0.9));
		GL11.glDisable(GL11.GL_BLEND);
	}
	public void editor()
	{
		if(Keyboard.isKeyDown(Keyboard.KEY_APOSTROPHE))
		{
			editD.Alpha = 0.79;
			editD.Blue = 0.8066666666666666;
			editD.Green = 0.0;
			editD.Red = 0.47;
			sliderXRed = ((0.47 * 300) + 40);
			sliderXGreen = ((0 * 300) + 40);
			sliderXBlue = (((Math.abs(0.8066666666666666)) * 300) + 40);
			EditRed = (sliderXRed - 40) / 300 * 1000;
			EditGreen = (sliderXGreen - 40) / 300 * 1000;
			EditBlue = (sliderXBlue - 40) / 300 * 1000;
			alphaX = ((0.79 * 200) + 500);
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_SLASH))
		{
			drawLightningAt(editPos,pos);
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_COMMA))
		{
			if(schematicLoaded == true)
			{
				currentSchematic.mapData.clear();
				schematicLoaded = false;
				
			}
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_PERIOD))
		{
			shapesEditor = true;
		}
		if(schematicLoaded == true)
		{
			schematicInEditor();
			if(Keyboard.isKeyDown(Keyboard.KEY_V))
			{
				if(KeyVDown == false)
				{
					KeyVDown = true;
					for(int i = 0; i < currentSchematic.mapData.size(); i ++)
					{
						Data d = new Data();
						d = currentSchematic.mapData.get(i);
						Data d2 = new Data();
						d2.v1 = d.v1.add(editPos);
						d2.v2 = d.v2.add(editPos);
						d2.v3 = d.v3.add(editPos);
						d2.mid = d2.v1.add(d2.v2.add(d2.v3));
						d2.mid = d2.mid.divideNon(3);
						d2.Red = d.Red;
						d2.Blue = d.Blue;
						d2.Green = d.Green;
						d2.Alpha = d.Alpha;
						d2.normal = d.normal;
						d2.v1Normal = d.v1Normal;
						d2.v2Normal = d.v2Normal;
						d2.v3Normal = d.v3Normal;
						d2.Collide = true;
						
						EditorMap.mapData.add(d2);
					}
				}
			}
			else
			{
				KeyVDown = false;
			}
		}
		int numa = -1;
		double smallestDistance = 10;
		if(Keyboard.isKeyDown(Keyboard.KEY_P))
		{
			if(pDown == false)
			{
				pDown = true;
				addFireworkParticle(editPos.x,editPos.y,editPos.z);
			}
		}
		else
		{
			pDown = false;
		}
		for(int i = 0; i < items.size(); i ++)
		{
			Items item = items.get(i);

			Distance3D(item.pos.x,item.pos.y,item.pos.z,editPos.x,editPos.y,editPos.z);
			if(Distance < smallestDistance)
			{
				numa = i;
				smallestDistance = Distance;;
			}
		}
		if(numa != -1)
		{
			if(Keyboard.isKeyDown(Keyboard.KEY_1))
			{
				if(KeyMDown == false)
				{
					KeyMDown = true;
					selectItem = true;
					itemNumber = numa;
				}
			}
			else if(Keyboard.isKeyDown(Keyboard.KEY_M))
			{
				if(KeyMDown == false)
				{
					KeyMDown = true;
					items.remove(numa);
					totalCollect = totalCollect - 1;
				}
			}
			else
			{
				KeyMDown = false;
			}
		}
		MyColor color = new MyColor();
		color.Red = EditRed / 1000;
		color.Green = EditGreen / 1000;
		color.Blue = EditBlue / 1000;
		if(Keyboard.isKeyDown(Keyboard.KEY_R))
		{
			editData = 1;
		}
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glDisable(GL11.GL_CULL_FACE);
		GL11.glDisable(GL11.GL_DEPTH_TEST);
		GL11.glDisable(GL11.GL_LIGHTING);
		if(editData == 2)
		{
			draw3DLine(editPos.x,editPos.y,editPos.z,editD.v1.x,editD.v1.y,editD.v1.z,color.Red,color.Green,color.Blue,1);
		}

		if(editData == 3)
		{
			editD.Red = EditRed / 1000;
			editD.Green = EditGreen / 1000;
			editD.Blue = EditBlue / 1000;
			editD.v3.x = editPos.x;
			editD.v3.y = editPos.y;
			editD.v3.z = editPos.z;
			draw3DTriangle(editD);
		}
		GL11.glEnable(GL11.GL_CULL_FACE);
		GL11.glEnable(GL11.GL_DEPTH_TEST);
		GL11.glEnable(GL11.GL_LIGHTING);
		if(Keyboard.isKeyDown(Keyboard.KEY_I))
		{
			addParticles(editPos.x,editPos.y,editPos.z,1,1,1,1,0.01,false,0.007,2);
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_W))
		{
			editPos.x = editPos.x - (Math.sin(Math.toRadians(cameraDirY)) * editMove);

			editPos.z = editPos.z - (Math.cos(Math.toRadians(cameraDirY)) * editMove);
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_A))
		{
			editPos.x = editPos.x - (Math.sin(Math.toRadians(cameraDirY + 90)) * editMove);
			editPos.z = editPos.z - (Math.cos(Math.toRadians(cameraDirY + 90)) * editMove);
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_D))
		{
			editPos.x = editPos.x - (Math.sin(Math.toRadians(cameraDirY - 90)) * editMove);
			editPos.z = editPos.z - (Math.cos(Math.toRadians(cameraDirY - 90)) * editMove);
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_S))
		{
			editPos.x = editPos.x + (Math.sin(Math.toRadians(cameraDirY)) * editMove);
			editPos.z = editPos.z + (Math.cos(Math.toRadians(cameraDirY)) * editMove);
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_N))
		{
			if(touchingKeyN == false)
			{
				totalCollect = totalCollect + 1;
				touchingKeyN = true;
				Items item = new Items();
				item.pos.x = editPos.x;
				item.pos.y = editPos.y;
				item.pos.z = editPos.z;
				item.rotate.points = setUpSphere(0,0,0,1,4,1);
				item.Type = 2;
				items.add(item);
			}
		}
		else
		{
			touchingKeyN = false;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT))
		{
			editPos.y = editPos.y - editMove;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_SPACE))
		{
			editPos.y = editPos.y + editMove;
		}

		int num = -1;
		int iNum = 1;
		double closeDis = 10000;
		for(int i = 0; i < EditorMap.mapData.size(); i ++)
		{

			Data d = EditorMap.mapData.get(i);
			double dis1 = distance(d.v1,editPos);
			double dis2 = distance(d.v2,editPos);
			double dis3 = distance(d.v3,editPos);
			double dis4 = distance(d.mid,editPos);
			Data f = new Data();
			int numI = 1;
			if(dis1 < dis2)
			{
				if(dis1 < dis3)
				{
					if(dis1 < dis4)
					{
						numI = 1;
						f.v1 = d.v1;
					}
					else
					{
						numI = 4;
						f.v1 = d.mid;
					}
				}
				else
				{
					if(dis3 < dis4)
					{
						numI = 3;
						f.v1 = d.v3;
					}
					else
					{
						numI = 4;
						f.v1 = d.mid;
					}

				}
			}
			else if(dis2 < dis3)
			{
				if(dis2 < dis4)
				{
					numI = 2;
					f.v1 = d.v2;
				}
				else
				{
					numI = 4;
					f.v1 = d.mid;
				}

			}
			else if(dis3 < dis1)
			{
				if(dis3 < dis4)
				{
					numI = 3;
					f.v1 = d.v3;
				}
				else
				{
					numI = 4;
					f.v1 = d.mid;
				}
			}
			double dis = distance(f.v1,editPos);
			if(dis < closeDis)
			{
				if(onlyRenderOne == false)
				{
					closeDis = dis;
					num = i;
					iNum = numI;
				}
				else if(i == RenderingNum)
				{
					closeDis = dis;
					num = i;
					iNum = numI;
				}
			}


		}
		if(num != -1)
		{
			closeTri(num,iNum,false);
		}


		if(Keyboard.isKeyDown(Keyboard.KEY_F))
		{
			if(editKey == false)
			{
				editKey = true;
				if(editData == 1)
				{
					editD.v1.x = editPos.x;
					editD.v1.y = editPos.y;
					editD.v1.z = editPos.z;
					editData ++;
				}
				else if(editData == 2)
				{
					editD.v2.x = editPos.x;
					editD.v2.y = editPos.y;
					editD.v2.z = editPos.z;
					editData ++;
				}
				else if(editData == 3)
				{
					editD.v3.x = editPos.x;
					editD.v3.y = editPos.y;
					editD.v3.z = editPos.z;
					editD.Red = EditRed / 1000;
					editD.Green = EditGreen / 1000;
					editD.Blue = EditBlue / 1000;
					
					editData = 1;
					
					editD.v1Normal = getSurfaceNormal(editD);
					editD.v2Normal = editD.v1Normal;
					editD.v3Normal = editD.v1Normal;
					EditorMap.mapData = EditorMap.addTriangleA(editD.v1.x,editD.v1.y,editD.v1.z,editD.v2.x,editD.v2.y,editD.v2.z,editD.v3.x,editD.v3.y,editD.v3.z,editD.Red,editD.Green,editD.Blue,editD.Alpha,true);



				}
			}
		}
		else
		{
			editKey = false;
		}
		/**
		if(Keyboard.isKeyDown(Keyboard.KEY_B))
		{
			if(EditBlockPlace == false)
			{
				EditBlockPlace = true;
				EditRed = 600;
				EditGreen = 400;
				EditBlue = 0;
				EditorMap.addTriangle(editPos.x,editPos.y,editPos.z,editPos.x - 2, editPos.y,editPos.z,editPos.x - 2,editPos.y - 2, editPos.z,EditRed / 1000,EditGreen / 1000,EditBlue / 1000,true);
				EditorMap.addTriangle(editPos.x - 2,editPos.y - 2,editPos.z,editPos.x, editPos.y - 2,editPos.z,editPos.x,editPos.y, editPos.z,EditRed / 1000,EditGreen / 1000,EditBlue / 1000,true);
				EditorMap.addTriangle(editPos.x - 2,editPos.y - 2,editPos.z - 2,editPos.x - 2, editPos.y,editPos.z - 2,editPos.x,editPos.y, editPos.z - 2,EditRed / 1000,EditGreen / 1000,EditBlue / 1000,true);
				EditorMap.addTriangle(editPos.x,editPos.y,editPos.z - 2,editPos.x, editPos.y - 2,editPos.z - 2,editPos.x - 2,editPos.y - 2, editPos.z - 2,EditRed / 1000,EditGreen / 1000,EditBlue / 1000,true);
				EditorMap.addTriangle(editPos.x,editPos.y,editPos.z,editPos.x, editPos.y - 2,editPos.z,editPos.x,editPos.y - 2, editPos.z - 2,EditRed / 1000,EditGreen / 1000,EditBlue / 1000,true);
				EditorMap.addTriangle(editPos.x,editPos.y - 2,editPos.z - 2,editPos.x, editPos.y,editPos.z - 2,editPos.x,editPos.y, editPos.z,EditRed / 1000,EditGreen / 1000,EditBlue / 1000,true);
				EditorMap.addTriangle(editPos.x - 2,editPos.y - 2,editPos.z - 2,editPos.x - 2, editPos.y - 2,editPos.z,editPos.x - 2,editPos.y, editPos.z,EditRed / 1000,EditGreen / 1000,EditBlue / 1000,true);
				EditorMap.addTriangle(editPos.x - 2,editPos.y,editPos.z,editPos.x - 2, editPos.y,editPos.z - 2,editPos.x - 2,editPos.y - 2, editPos.z - 2,EditRed / 1000,EditGreen / 1000,EditBlue / 1000,true);
				EditRed = 0;
				EditGreen = 600;
				EditBlue = 0;
				EditorMap.addTriangle(editPos.x - 2,editPos.y,editPos.z - 2,editPos.x - 2, editPos.y,editPos.z,editPos.x,editPos.y, editPos.z,EditRed / 1000,EditGreen / 1000,EditBlue / 1000,true);
				EditorMap.addTriangle(editPos.x,editPos.y,editPos.z,editPos.x, editPos.y,editPos.z - 2,editPos.x - 2,editPos.y, editPos.z - 2,EditRed / 1000,EditGreen / 1000,EditBlue / 1000,true);
				EditorMap.addTriangle(editPos.x,editPos.y - 2,editPos.z,editPos.x - 2, editPos.y - 2,editPos.z,editPos.x - 2,editPos.y - 2, editPos.z - 2,EditRed / 1000,EditGreen / 1000,EditBlue / 1000,true);
				EditorMap.addTriangle(editPos.x - 2,editPos.y - 2,editPos.z - 2,editPos.x, editPos.y - 2,editPos.z - 2,editPos.x,editPos.y - 2, editPos.z,EditRed / 1000,EditGreen / 1000,EditBlue / 1000,true);
			}
		}
		else
		{
			EditBlockPlace = false;
		}
		*/


	}

	public double distance2D(double x, double y, double x2, double y2)
	{
		return Math.sqrt(((x - x2) * (x - x2)) + ((y - y2) * (y - y2)));
	}
	public void OperateAndDrawPopUpBall()
	{
		Make2D();

		draw2DQuad(0,100,1000,100,1000,0,0,0,1,1,1,1,1,0.5,0.5);
		draw2DQuad(33,sliderYVeloZ + 7,347,sliderYVeloZ + 7,347,sliderYVeloZ - 7,33,sliderYVeloZ - 7,1,1,1,0.5,0.5,1,1);
		DrawText("Z " + veloZGravi,355,(int)Math.round(sliderYVeloZ),6,0,0,0);
		draw2DQuad(33,sliderYVeloY + 7,347,sliderYVeloY + 7,347,sliderYVeloY - 7,33,sliderYVeloY - 7,1,1,1,0.5,0.5,1,1);
		DrawText("Y " + veloYGravi,355,(int)Math.round(sliderYVeloY),6,0,0,0);
		draw2DQuad(33,sliderYVeloX + 7,347,sliderYVeloX + 7,347,sliderYVeloX - 7,33,sliderYVeloX - 7,1,1,1,0.5,0.5,1,1);
		DrawText("X " + veloXGravi,355,(int)Math.round(sliderYVeloX),6,0,0,0);

		draw2DQuad(sliderXVeloY - 5, sliderYVeloY + 5,sliderXVeloY + 5, sliderYVeloY + 5,sliderXVeloY + 5, sliderYVeloY - 5,sliderXVeloY - 5, sliderYVeloY - 5,0,1,0,1,1,0.5,0.5);
		draw2DQuad(sliderXVeloZ - 5, sliderYVeloZ + 5,sliderXVeloZ + 5, sliderYVeloZ + 5,sliderXVeloZ + 5, sliderYVeloZ - 5,sliderXVeloZ - 5, sliderYVeloZ - 5,0,0,1,1,1,0.5,0.5);
		draw2DQuad(sliderXVeloX - 5, sliderYVeloX + 5,sliderXVeloX + 5, sliderYVeloX + 5,sliderXVeloX + 5, sliderYVeloX - 5,sliderXVeloX - 5, sliderYVeloX - 5,1,0,0,1,1,0.5,0.5);



		if(Mouse.isButtonDown(0))
		{


			if(sliderVelo == 0)
			{

				double distance = distance2D((sliderXVeloX / 1000) * screenWidth,(sliderYVeloX / 800) * screenHeight,MouseX,MouseY);
				if(distance < 10)
				{
					sliderVelo = 1;
					sliderXVeloX = (MouseX / screenWidth) * 1000;;
				}
				else
				{
					distance = distance2D((sliderXVeloY / 1000) * screenWidth,(sliderYVeloY / 800) * screenHeight,MouseX,MouseY);
					if(distance < 10)
					{
						sliderVelo = 2;
						sliderXVeloY = (MouseX / screenWidth) * 1000;;
					}
					else
					{
						distance = distance2D((sliderXVeloZ / 1000) * screenWidth,(sliderYVeloZ / 800) * screenHeight,MouseX,MouseY);
						if(distance < 10)
						{
							sliderVelo = 3;
							sliderXVeloZ = (MouseX / screenWidth) * 1000;;
						}

					}
				}
			}
		}
		else
		{
			sliderVelo = 0;
		}
		if(sliderVelo == 1)
		{
			sliderXVeloX = (MouseX / screenWidth) * 1000;;
			if(Keyboard.isKeyDown(Keyboard.KEY_F))
			{
				sliderXVeloX = 190;
			}
			if(sliderXVeloX < 40)
			{
				sliderXVeloX = 40;
			}
			if(sliderXVeloX > 340)
			{
				sliderXVeloX = 340;
			}
			//veloXGravi = ((sliderXVeloX - 190) / 5700);
		}
		else if(sliderVelo == 2)
		{
			sliderXVeloY = (MouseX / screenWidth) * 1000;
			if(Keyboard.isKeyDown(Keyboard.KEY_F))
			{
				sliderXVeloY = 190;
			}
			if(sliderXVeloY < 40)
			{
				sliderXVeloY = 40;
			}
			if(sliderXVeloY > 340)
			{
				sliderXVeloY = 340;
			}
			//veloYGravi = ((sliderXVeloY - 190) / 5700);
		}
		else  if(sliderVelo == 3)
		{

			sliderXVeloZ = (MouseX / screenWidth) * 1000;
			if(Keyboard.isKeyDown(Keyboard.KEY_F))
			{
				sliderXVeloZ = 190;
			}
			if(sliderXVeloZ < 40)
			{
				sliderXVeloZ = 40;
			}
			if(sliderXVeloZ > 340)
			{
				sliderXVeloZ = 340;
			}
			//veloZGravi = ((sliderXVeloZ - 190) / 5700);
		}

		Make3D();
	}
	public void OperateAndDrawPopUp()
	{
		Make2D();

		draw2DQuad(0,100,1000,100,1000,0,0,0,1,1,1,1,1,0.5,0.5);
		draw2DQuad(370,70,420,70,420,30,370,30,EditRed / 1000,EditGreen / 1000,EditBlue / 1000,1,1,1,1);

		draw2DQuad(33,sliderYBlue + 7,347,sliderYBlue + 7,347,sliderYBlue - 7,33,sliderYBlue - 7,1,1,1,0.5,0.5,1,1);
		draw2DQuad(33,sliderYGreen + 7,347,sliderYGreen + 7,347,sliderYGreen - 7,33,sliderYGreen - 7,1,1,1,0.5,0.5,1,1);
		draw2DQuad(33,sliderYRed + 7,347,sliderYRed + 7,347,sliderYRed - 7,33,sliderYRed - 7,1,1,1,0.5,0.5,1,1);


		draw2DQuad(593,sliderYMove + 7,707,sliderYMove + 7,707,sliderYMove - 7,593,sliderYMove - 7,1,1,1,0.5,0.5,1,1);
		draw2DQuad(sliderXMove - 5, sliderYMove + 5,sliderXMove + 5, sliderYMove + 5,sliderXMove + 5, sliderYMove - 5,sliderXMove - 5, sliderYMove - 5,1,1,1,1,1,0.5,0.5);
		draw2DQuad(sliderXRed - 5, sliderYRed + 5,sliderXRed + 5, sliderYRed + 5,sliderXRed + 5, sliderYRed - 5,sliderXRed - 5, sliderYRed - 5,1,0,0,1,1,0.5,0.5);

		draw2DQuad(sliderXBlue - 5, sliderYBlue + 5,sliderXBlue + 5, sliderYBlue + 5,sliderXBlue + 5, sliderYBlue - 5,sliderXBlue - 5, sliderYBlue - 5,0,0,1,1,1,0.5,0.5);
		draw2DQuad(sliderXGreen - 5, sliderYGreen + 5,sliderXGreen + 5, sliderYGreen + 5,sliderXGreen + 5, sliderYGreen - 5,sliderXGreen - 5, sliderYGreen - 5,0,1,0,1,1,0.5,0.5);







		if(Mouse.isButtonDown(0))
		{


			if(ColorMouse == 0)
			{
				double distance = distance2D((sliderXMove / 1000) * screenWidth,(sliderYMove / 800) * screenHeight,MouseX,MouseY);
				if(distance < 10)
				{
					sliderXMove = (MouseX / screenWidth) * 1000;;
					if(sliderXMove < 600)
					{
						sliderXMove = 600;
					}
					if(sliderXMove > 700)
					{
						sliderXMove = 700;
					}
					ColorMouse = 4;

				}
				distance = distance2D((sliderXRed / 1000) * screenWidth,(sliderYRed / 800) * screenHeight,MouseX,MouseY);
				if(distance < 10)
				{
					ColorMouse = 1;
					sliderXRed = (MouseX / screenWidth) * 1000;
				}
				else
				{
					distance = distance2D((sliderXGreen / 1000) * screenWidth,(sliderYGreen / 800) * screenHeight,MouseX,MouseY);
					if(distance < 10)
					{
						ColorMouse = 2;
						sliderXGreen = (MouseX / screenWidth) * 1000;;
					}
					else
					{
						distance = distance2D((sliderXBlue / 1000) * screenWidth,(sliderYBlue / 800) * screenHeight,MouseX,MouseY);
						if(distance < 10)
						{
							ColorMouse = 3;
							sliderXBlue = (MouseX / screenWidth) * 1000;;
						}
					}
				}
			}
		}
		else
		{
			ColorMouse = 0;
		}
		if(ColorMouse == 1)
		{
			sliderXRed = (MouseX / screenWidth) * 1000;
			if(sliderXRed < 40)
			{
				sliderXRed = 40;
			}
			if(sliderXRed > 340)
			{
				sliderXRed = 340;
			}
			EditRed = (sliderXRed - 40) / 300 * 1000;
		}
		else if(ColorMouse == 2)
		{
			sliderXGreen= (MouseX / screenWidth) * 1000;
			if(sliderXGreen < 40)
			{
				sliderXGreen = 40;
			}
			if(sliderXGreen > 340)
			{
				sliderXGreen = 340;
			}
			EditGreen = (sliderXGreen - 40) / 300 * 1000;
		}
		else  if(ColorMouse == 3)
		{
			sliderXBlue= (MouseX / screenWidth) * 1000;
			if(sliderXBlue < 40)
			{
				sliderXBlue = 40;
			}
			if(sliderXBlue > 340)
			{
				sliderXBlue = 340;
			}
			EditBlue = (sliderXBlue - 40) / 300 * 1000;
		}
		else  if(ColorMouse == 4)
		{

			sliderXMove = (MouseX / screenWidth) * 1000;
			if(sliderXMove < 600)
			{
				sliderXMove = 600;
			}
			if(sliderXMove > 700)
			{
				sliderXMove = 700;
			}
			editMove = (sliderXMove - 600) / 100;
		}

		Make3D(); 
	}
	public void closeTri(int num,int iNum,boolean foundCollision)
	{

		Data closestTri = EditorMap.mapData.get(num);

		if(Keyboard.isKeyDown(Keyboard.KEY_E))
		{
			Data d = EditorMap.mapData.get(num);

			if(foundCollision == false)
			{
				Vector edge = new Vector();

				/**
				if(v1Dis < v3Dis && v2Dis < v3Dis)
				{
					edgeType = 1;
					edge = d.v1.subtract(d.v2);
				}
				else if(v1Dis > v3Dis && v2Dis < v1Dis)
				{
					edgeType = 2;
					edge = d.v3.subtract(d.v2);
				}
				else if(v1Dis < v2Dis && v3Dis < v2Dis)
				{
				 */
				edge = d.v2.subtract(d.v1);
				Vector baseToVertex = d.v1.subtract(editPos);
				double edgeSquaredLength = edge.length();
				double edgeDotBaseToVertex = edge.dot(baseToVertex);
				double f = (edgeDotBaseToVertex) / edgeSquaredLength;

				Vector v1 = new Vector();
				if(-f > 0 && -f < 1)
				{
					v1 = d.v1.add(edge.multiplyNonVec(-f));
				}

				edge = d.v3.subtract(d.v2);
				baseToVertex = d.v2.subtract(editPos);
				edgeSquaredLength = edge.length();
				edgeDotBaseToVertex = edge.dot(baseToVertex);
				f = (edgeDotBaseToVertex) / edgeSquaredLength;

				Vector v2 = new Vector();
				if(-f > 0 && -f < 1)
				{
					v2 = d.v2.add(edge.multiplyNonVec(-f));
				}
				edge = d.v1.subtract(d.v3);
				baseToVertex = d.v3.subtract(editPos);
				edgeSquaredLength = edge.length();
				edgeDotBaseToVertex = edge.dot(baseToVertex);
				f = (edgeDotBaseToVertex) / edgeSquaredLength;

				Vector v3 = new Vector();
				if(-f > 0 && -f < 1)
				{
					v3 = d.v3.add(edge.multiplyNonVec(-f));
				}
				Distance(editPos.x,editPos.y,editPos.z,v3.x,v3.y,v3.z);
				double v3Dist = Distance;
				Distance(editPos.x,editPos.y,editPos.z,v2.x,v2.y,v2.z);
				double v2Dist = Distance;
				Distance(editPos.x,editPos.y,editPos.z,v1.x,v1.y,v1.z);
				double v1Dist = Distance;
				/**
					if(v1Dist < v3Dist && v1Dist < v2Dist)
					{
						draw3DLine(editPos.x,editPos.y,editPos.z,v1.x,v1.y,v1.z,1,1,1);
					}
					else if(v2Dist < v1Dist && v2Dist < v3Dist)
					{
						draw3DLine(editPos.x,editPos.y,editPos.z,v2.x,v2.y,v2.z,1,1,1);
					}
					else if(v3Dist < v1Dist && v3Dist < v2Dist)
					{
						draw3DLine(editPos.x,editPos.y,editPos.z,v3.x,v3.y,v3.z,1,1,1);editPos = v3;
					}
				 */

				if(v1Dist < v3Dist && v1Dist < v2Dist)
				{
					editPos = v1;
				}
				else if(v2Dist < v1Dist && v2Dist < v3Dist)
				{
					editPos = v2;
				}
				else if(v3Dist < v1Dist && v3Dist < v2Dist)
				{
					editPos = v3;
				}
			}


		}
		//draw3DLine(collisionPoint.x,collisionPoint.y,collisionPoint.z,collisionPoint.x,collisionPoint.y + 1,collisionPoint.z, 1, 1, 1);
		Data d = new Data();

		if(iNum == 1)
		{
			d.v1 = closestTri.v1;
			d.v1Normal = closestTri.v1Normal;
		}
		else if(iNum == 2)
		{
			d.v1 = closestTri.v2;
			d.v1Normal = closestTri.v2Normal;
		}
		else if(iNum == 3)
		{
			d.v1 = closestTri.v3;
			d.v1Normal = closestTri.v3Normal;
		}
		else if(iNum == 4)
		{
			d.v1 = closestTri.mid;
			d.v1Normal = closestTri.normal;
		}

		if(Keyboard.isKeyDown(Keyboard.KEY_Z))
		{
			if(editKey2 == false)
			{
				editKey2 = true;
				Data j = EditorMap.mapData.get(num);
				Vector tmpV = j.v3;
				j.v3 = j.v1;
				j.v1 = tmpV;
				j.v1Normal = getSurfaceNormal(j);
				j.v2Normal = j.v1Normal;
				j.v3Normal = j.v1Normal;
				j.normal = j.v1Normal;
				EditorMap.mapData.set(num, j);
			}
		}
		else
		{
			editKey2 = false;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_T))
		{
			sliderXRed = ((closestTri.Red * 300) + 40);
			sliderXGreen = ((closestTri.Green * 300) + 40);
			sliderXBlue = (((Math.abs(closestTri.Blue)) * 300) + 40);
			EditRed = (sliderXRed - 40) / 300 * 1000;
			EditGreen = (sliderXGreen - 40) / 300 * 1000;
			EditBlue = (sliderXBlue - 40) / 300 * 1000;
			alphaX = ((closestTri.Alpha * 200) + 500);
			editD.Alpha = closestTri.Alpha;

		}

		if(Keyboard.isKeyDown(Keyboard.KEY_K))
		{
			if(pointConnections == false)
			{
				pointConnections = true;
				List<connections> connecting = new ArrayList<connections>();
				for(int i = 0; i < EditorMap.mapData.size(); i ++)
				{
					Data j = EditorMap.mapData.get(i);
					if(j.v1.x == d.v1.x && j.v1.y == d.v1.y && j.v1.z == d.v1.z)
					{
						connections c = new connections();
						c.connectNum1 = i;
						c.pointConnect1 = 1;
						c.normal = j.v1Normal;
						connecting.add(c);
					}
					else if(j.v2.x == d.v1.x && j.v2.y == d.v1.y && j.v2.z == d.v1.z)
					{
						connections c = new connections();
						c.connectNum1 = i;
						c.pointConnect1 = 2;
						c.normal = j.v2Normal;
						connecting.add(c);
					}
					else if(j.v3.x == d.v1.x && j.v3.y == d.v1.y && j.v3.z == d.v1.z)
					{
						connections c = new connections();
						c.connectNum1 = i;
						c.pointConnect1 = 3;
						c.normal = j.v3Normal;
						connecting.add(c);
					}
				}
				if(connecting.size() > 1)
				{	
					boolean allReadyHas = false;
					for(int i = 0; i < EditorMap.connectionPoints.size(); i ++)
					{
						Vector v = EditorMap.connectionPoints.get(i);
						if(v.x == d.v1.x && v.y == d.v1.y && d.v1.z == v.z)
						{
							allReadyHas = true;
						}
					}
					if(allReadyHas == false)
					{
						EditorMap.connectionPoints.add(d.v1);
					}
				}



				System.out.println(connecting.size());
				Vector overAllNormal = new Vector();
				for(int i = 0; i < connecting.size(); i ++)
				{
					connections c = connecting.get(i);
					overAllNormal = overAllNormal.add(c.normal);
				}
				overAllNormal = overAllNormal.normalize();
				for(int i = 0; i < connecting.size(); i ++)
				{
					connections c = connecting.get(i);
					Data m = EditorMap.mapData.get(c.connectNum1);
					if(c.pointConnect1 == 1)
					{
						m.v1Normal = overAllNormal;
					}
					else if(c.pointConnect1 == 2)
					{
						m.v2Normal = overAllNormal;
					}
					else if(c.pointConnect1 == 3)
					{
						m.v3Normal = overAllNormal;
					}
				}
			}
		}
		else
		{
			pointConnections = false;
		}

		draw3DLine(d.v1.x,d.v1.y,d.v1.z,d.v1.x + d.v1Normal.x,d.v1.y + d.v1Normal.y,d.v1.z + d.v1Normal.z,1,0,0,1);


		if(Keyboard.isKeyDown(Keyboard.KEY_Q))
		{
			editPos.x = d.v1.x;
			editPos.y = d.v1.y;
			editPos.z = d.v1.z;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_G))
		{
			if(editDel == false)
			{
				editDel = true;
				if(data.size() > 0)
				{
					EditorMap.mapData.remove(num);
					System.out.println("removing " + num);
				}
			}
		}
		else
		{
			editDel = false;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_O))
		{
			closestTri.Red = EditRed / 1000;
			closestTri.Green = EditGreen / 1000;
			closestTri.Blue = EditBlue / 1000;
			closestTri.Alpha = ((alphaX - 500) / 200);
		}
		if(Mouse.getY() < 200)
		{
			OperateAndDrawPopUp();
			Vector Alphas = new Vector();
			Alphas = slider(alphaX,70,700,500,2);
			alphaX = Alphas.x;
			if(Alphas.z == 1)
			{
				
				editD.Alpha = ((alphaX - 500) / 200);
				
			}
			editD.Alpha = ((alphaX - 500) / 200);
		}
	}

	public void draw2DQuad(double x, double y, double x2, double y2, double x3, double y3, double x4, double y4,double Red, double Green, double Blue, double shade1, double shade2, double shade3, double shade4)
	{

		GL11.glBegin(GL11.GL_QUADS);
		GL11.glColor3d(Red * shade1,Green * shade1,Blue * shade1);
		GL11.glVertex2d((x / 1000) * screenWidth, (y / 1000) * screenHeight);

		// Right & Green
		GL11.glColor3d(Red * shade2,Green * shade2,Blue * shade2);
		GL11.glVertex2d((x2 / 1000) * screenWidth, (y2 / 1000) * screenHeight);

		// Left & Blue
		GL11.glColor3d(Red * shade3,Green * shade3,Blue * shade3);
		GL11.glVertex2d((x3 / 1000) * screenWidth, (y3 / 1000) * screenHeight);
		GL11.glColor3d(Red * shade4,Green * shade4,Blue * shade4);
		GL11.glVertex2d((x4 / 1000) * screenWidth, (y4 / 1000) * screenHeight);
		GL11.glEnd();

	}
	public void draw2DQuadAlpha(double x, double y, double x2, double y2, double x3, double y3, double x4, double y4,double Red, double Green, double Blue,double Alpha, double shade1, double shade2, double shade3, double shade4)
	{
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		LogoStuff.bind();
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBegin(GL11.GL_QUADS);
		GL11.glTexCoord2d(0,0);
		GL11.glColor4d(Red * shade1,Green * shade1,Blue * shade1,Alpha);
		GL11.glVertex2d((x / 1000) * screenWidth, (y / 1000) * screenHeight);
		GL11.glTexCoord2d(LogoStuff.getWidth(),0);
		// Right & Green
		GL11.glColor4d(Red * shade2,Green * shade2,Blue * shade2,Alpha);
		GL11.glVertex2d((x2 / 1000) * screenWidth, (y2 / 1000) * screenHeight);

		// Left & Blue
		GL11.glTexCoord2d(LogoStuff.getWidth(),LogoStuff.getHeight());
		GL11.glColor4d(Red * shade3,Green * shade3,Blue * shade3,Alpha);
		GL11.glVertex2d((x3 / 1000) * screenWidth, (y3 / 1000) * screenHeight);
		GL11.glTexCoord2d(0,LogoStuff.getHeight());
		GL11.glColor4d(Red * shade4,Green * shade4,Blue * shade4,Alpha);
		GL11.glVertex2d((x4 / 1000) * screenWidth, (y4 / 1000) * screenHeight);
		GL11.glEnd();
		text.bind();
		GL11.glDisable(GL11.GL_TEXTURE_2D);
	}
	public boolean draw2DQuadDec(double x, double y, double x2, double y2, double x3, double y3, double x4, double y4,double Red, double Green, double Blue, double shade1, double shade2, double shade3, double shade4)
	{
		Make2D();
		boolean Inside = false;


		if(MouseY >  (y / 800) * screenHeight && MouseY <  (y2 / 800) * screenHeight && MouseY <  (y3 / 800) * screenHeight && MouseY >  (y4 / 800) * screenHeight)
		{
			if(MouseX > (x / 1000) * screenWidth && MouseX > (x2 / 1000) * screenWidth && MouseX <  (x3 / 1000) * screenWidth && MouseX < (x4 / 1000) * screenWidth)
			{
				shade1 = 1 - shade1;
				shade2 = 1 - shade2;
				shade3 = 1 - shade3;
				shade4 = 1 - shade4;
				Inside = true;
			}

		}
		x = (x / 1000) * screenWidth;
		GL11.glBegin(GL11.GL_QUADS);
		GL11.glColor3d(Red * shade1,Green * shade1,Blue * shade1);
		GL11.glVertex2d(x, (y / 1000) * screenHeight);

		// Right & Green
		GL11.glColor3d(Red * shade2,Green * shade2,Blue * shade2);
		GL11.glVertex2d((x2 / 1000) * screenWidth, (y2 / 1000) * screenHeight);

		// Left & Blue
		GL11.glColor3d(Red * shade3,Green * shade3,Blue * shade3);
		GL11.glVertex2d((x3 / 1000) * screenWidth, (y3 / 1000) * screenHeight);
		GL11.glColor3d(Red * shade4,Green * shade4,Blue * shade4);
		GL11.glVertex2d((x4 / 1000) * screenWidth, (y4 / 1000) * screenHeight);
		GL11.glEnd();
		return Inside;

	}
	public void Options()
	{
		Make2D();
		draw2DQuad(100,100,100,700,900,700,900,100,0.5,0.5,0.5,1,1,1,1);
		if(optionsMode == 0)
		{
			if(draw2DQuadDec(300,600,300,620,700,620,700,600,0,0.6,1,0.3,1,1,0.3))
			{
				if(Mouse.isButtonDown(0))
				{
					if(optionsButton == false)
					{
						optionsButton = true;
						optionsMode = 1;
					}
				}
				else
				{
					optionsButton = false;
				}
			}
			DrawText("Mouse Sensitivity",350,590,10,1,1,1);
			if(draw2DQuadDec(300,500,300,520,700,520,700,500,0,0.6,1,0.3,1,1,0.3))
			{
				if(Mouse.isButtonDown(0))
				{
					if(optionsButton == false)
					{
						optionsButton = true;
						optionsMode = 2;
					}
				}
				else
				{
					optionsButton = false;
				}
			}
			DrawText("Graphics",350,490,10,1,1,1);
		}
		if(optionsMode == 1)
		{
			Vector MouseSlide = new Vector();
			MouseSlide = slider(sensitiveX,600,800,200,1);
			sensitiveX = MouseSlide.x;
			if(MouseSlide.z == 1)
			{
				sensitive = (9.2 - ((sensitiveX - 120) / 75));
			}
			Make2D();
			DrawText("Mouse Sensitivity",300,580,10,1,1,1);
			DrawText("" + sensitive,300,560,10,1,1,1);
		}
		if(optionsMode == 2)
		{
			Vector RenderSlide = new Vector();
			RenderSlide = slider(RenderDisX,600,800,200,6);
			RenderDisX = RenderSlide.x;
			if(RenderSlide.z == 1)
			{
				renderDistance = (int)Math.round((RenderDisX - 150));
			}
			Make2D();
			DrawText("RenderDistance",300,580,10,1,1,1);
			DrawText("" + renderDistance,300,560,10,1,1,1);
			Vector DetailSlide = new Vector();
			DetailSlide = slider(DetailX,540,800,200,7);
			DetailX = (int) DetailSlide.x;
			if(DetailSlide.z == 1)
			{
				maxDetail = (int)Math.round((DetailX - 150) / 100);
			}
			Make2D();
			DrawText("Detail",300,520,10,1,1,1);
			DrawText("" + maxDetail,300,500,10,1,1,1);
		}
		if(optionsMode != 0)
		{
			if(Keyboard.isKeyDown(Keyboard.KEY_ESCAPE))
			{
				if(PauseButton == false)
				{
					PauseButton = true;
					optionsMode = 0;
				}
			}
			else
			{
				PauseButton = false;
			}
		}
	}
	public double distance(Vector v, Vector v2)
	{
		return Math.sqrt(((v.x - v2.x) * (v.x - v2.x)) + ((v.y - v2.y) * (v.y - v2.y)) + ((v.z - v2.z) * (v.z - v2.z)));
	}

	public boolean collideCamera()
	{
		/**
		double testCamX = -cameraX;
		double testCamY = -cameraY;
		double testCamZ = -cameraZ;
		double fakeZoom = 0;
		for(int t = 0; t < Math.abs(zoom * 20); t ++)
		{
			
			fakeZoom = fakeZoom - 0.05;
			//testCamX = testCamX + (Math.cos(Math.toRadians(cameraDirX)) * Math.sin(Math.toRadians(cameraDirY)) * 0.05);
			//testCamY = testCamY + (Math.sin(Math.toRadians(cameraDirX)) * -0.05);
			//testCamZ = testCamZ + (Math.cos(Math.toRadians(cameraDirX)) * Math.cos(Math.toRadians(cameraDirY)) * 0.05);
			Vector gravitys = new Vector();
			gravitys.x = -Math.abs(veloXGravi);
			gravitys.y = -Math.abs(veloYGravi);
			gravitys.z = (veloZGravi);
			//gravitys = touchingPlaneNormal;
			gravitys = gravitys.normalize();
			
		if(gravitys.z > 0)
		{
			//testCamY = testCamY + (gravitys.z * (Math.sin(Math.toRadians(cameraRotations.x)) * Math.cos(Math.toRadians(cameraRotations.y)) * 0.05));
			//testCamX = testCamX + -(gravitys.z * (Math.sin(Math.toRadians(cameraRotations.x)) * Math.sin(Math.toRadians(cameraRotations.y)) * 0.05));
		}
		else
		{
			//testCamY = testCamY - (gravitys.z * (Math.sin(Math.toRadians(cameraRotations.x)) * Math.cos(Math.toRadians(cameraRotations.y)) * 0.05));
			//testCamX = testCamX - (gravitys.z * (Math.sin(Math.toRadians(cameraRotations.x)) * Math.sin(Math.toRadians(cameraRotations.y)) * 0.05));
		}
			testCamX = testCamX + (gravitys.y * (Math.cos(Math.toRadians(cameraDirX)) * Math.sin(Math.toRadians(cameraRotations.y)) * 0.05));
			testCamY = testCamY + (gravitys.y * (Math.sin(Math.toRadians(cameraDirX))) * 0.05);
			testCamZ = testCamZ - (gravitys.y * (Math.cos(Math.toRadians(cameraDirX)) * Math.cos(Math.toRadians(cameraRotations.y)) * 0.05));
			if(gravitys.x > 0)
			{
				//testCamY = testCamY - (gravitys.x * (Math.cos(Math.toRadians(cameraDirX)) * Math.sin(Math.toRadians(cameraDirY)) * 0.05));
				//testCamX = testCamX + (gravitys.x * (Math.sin(Math.toRadians(cameraDirX))) * 0.05);
				//testCamZ = testCamZ + (gravitys.x * (Math.cos(Math.toRadians(cameraDirX)) * Math.cos(Math.toRadians(cameraDirY)) * 0.05));
			}
			else
			{
				testCamY = testCamY - (gravitys.x * (Math.cos(Math.toRadians(cameraDirX)) * Math.sin(Math.toRadians(cameraRotations.y)) * 0.05));
				testCamX = testCamX + (gravitys.x * (Math.sin(Math.toRadians(cameraDirX))) * 0.05);
				testCamZ = testCamZ - (gravitys.x * (Math.cos(Math.toRadians(cameraDirX)) * Math.cos(Math.toRadians(cameraRotations.y)) * 0.05));
			}
			Vector cameraVelo = new Vector();
			cameraVelo.x = testCamX - (-cameraX);
			cameraVelo.y = testCamY - (-cameraY);
			cameraVelo.z = testCamZ - (-cameraZ);


			for(int i = 0; i < particleCollides.size(); i ++)
			{
				Data d = particleCollides.get(i);
				if(cameraVelo.normalize().dot(d.normal) <= 0)
				{
					Vector v = new Vector();
					v.x = testCamX;
					v.y = testCamY;
					v.z = testCamZ;
					Vector v1 = v.subtract(d.mid);

					double result = v1.dot(d.normal);
					if( result < 0.4 && result > -0.4)
					{
						if(checkPointInTriangle(v,d.v1,d.v2,d.v3))
						{
							collidedZoom = fakeZoom + 0.5;
							return true;
						}
					}
				}
			}
		}
		*/
		collidedZoom = zoom;
		
		return false;
	}
	public boolean collideWithCharacter()
	{
		for(int i = 0; i < data.size(); i ++)
		{
			Data d = data.get(i);
			Vector v1 = pos.add(velo).subtract(d.mid);

			double result = v1.dot(d.normal);
			if(result < 0)
			{

				if(checkPointInTriangle(pos,d.v1,d.v2,d.v3))
				{
					return true;
				}
			}
		}
		return false;
	}

	public void collideAndSlide(Vector vel, Vector gravi)
	{

		
		//vel.y = gravi.y;
		collisionPackage.R3Position = pos;
		collisionPackage.R3Velocity = vel;
		Vector eSpacePosition = collisionPackage.R3Position.divide(collisionPackage.eRadius);
		Vector eSpaceVelocity = collisionPackage.R3Velocity.divide(collisionPackage.eRadius);
		collisionRecursionDepth = 0;
		//setVelocity = true;
		Vector finalPosition = collideWithWorld(eSpacePosition,eSpaceVelocity);
		//setVelocity = false;
		//gravi.x = velo.x;
		//gravi.z = velo.z;
		velo = newerVelocityVector.multiply(collisionPackage.eRadius);
		
			//collisionPackage.R3Position = finalPosition.multiply(collisionPackage.eRadius);
			collisionPackage.R3Velocity = gravi;
			eSpaceVelocity = gravi.divide(collisionPackage.eRadius);
			collisionRecursionDepth = 0;
		//finalPosition = collideWithWorld(finalPosition,eSpaceVelocity);
		//velo.x = gravity.x;
		//velo.z = gravity.z;
		


		finalPosition = finalPosition.multiply(collisionPackage.eRadius);
		//gravity = newerVelocityVector.multiply(collisionPackage.eRadius);
		pos = finalPosition;
		
		


	}
	public void collideCam(Vector vel, Vector gravi)
	{

		collisionPackage.eRadius.x = 1;
		collisionPackage.eRadius.y = 1;
		collisionPackage.eRadius.z = 1;
		Vector cameraPos = new Vector();
		cameraPos.x = cameraX;
		cameraPos.y = cameraY;
		cameraPos.z = cameraZ;
		collisionPackage.R3Position = cameraPos;
		collisionPackage.R3Velocity = vel;
		Vector eSpacePosition = collisionPackage.R3Position.divide(collisionPackage.eRadius);
		Vector eSpaceVelocity = collisionPackage.R3Velocity.divide(collisionPackage.eRadius);
		collisionRecursionDepth = 0;
		Vector finalPosition = collideWithWorld(eSpacePosition,eSpaceVelocity);

		/**
			collisionPackage.R3Position = finalPosition.multiply(collisionPackage.eRadius);
			collisionPackage.R3Velocity = gravi;
			eSpaceVelocity = gravi.divide(collisionPackage.eRadius);
			collisionRecursionDepth = 0;
		 */
		finalPosition = collideWithWorld(finalPosition,eSpaceVelocity);



		finalPosition = finalPosition.multiply(collisionPackage.eRadius);
		cameraPos = finalPosition;
		cameraX = (float)cameraPos.x;
		cameraY = (float)cameraPos.y;
		cameraZ = (float)cameraPos.z;


	}
	public Vector collideWithWorld(Vector pos, Vector vel)
	{
		double unitsPerMeter = 100;
		double unitScale = unitsPerMeter / 100.0;
		double veryCloseDistance = 0.00005 * unitScale;

		if(collisionRecursionDepth > 5) return pos;
		collisionPackage.velocity = vel;
		//collisionPackage.velocity.y = collisionPackage.velocity.y - 0.01;
		collisionPackage.nearestDistance = 1000000;
		//collisionPackage.nearestDistance = 10000;
		collisionPackage.normalizedVelocity = vel;
		collisionPackage.normalizedVelocity = collisionPackage.normalizedVelocity.normalize();
		collisionPackage.BasePoint = pos;
		//collisionPackage.intersectionPoint = pos;
		newerVelocityVector = vel;
		collisionPackage.foundCollision = false;
		collideWithWorld();
		collisionPackage.velocity = vel;
		lastCollisionTime ++;
		if(collisionPackage.foundCollision == false)
		{
			
			if(lastCollision == true)
			{
				lastCollision = false;
			}
			
			if(collisionRecursionDepth == 0)
			{
				//System.out.println("no Collision");
			}
			return pos.add(vel.divideNon(slowMo));
		}
		if(collisionPackage.foundCollision == true)
		{

			touching = true;
		}
		
		
		
		Vector destinationPoint = pos.add(vel);
		Vector newBasePoint = pos;
		//System.out.println(collisionPackage.nearestDistance);
		/**
		if(collisionPackage.nearestDistance >= veryCloseDistance)
		{
			
			Vector V = vel;
			//V = V.normalize();
			V = V.setLength((collisionPackage.nearestDistance - (veryCloseDistance)));
			//V = V.multiplyNonVec((collisionPackage.nearestDistance - veryCloseDistance));
			newBasePoint = pos.add(V);//.divideNon(slowMo));
			V = V.normalize();
			V = V.multiplyNonVec(veryCloseDistance);
			collisionPackage.intersectionPoint = collisionPackage.intersectionPoint.subtract((V));
			
		}
		*/
		Vector slidePlaneOrgin = collisionPackage.intersectionPoint;
		Vector slidePlaneNormal = newBasePoint.subtract(collisionPackage.intersectionPoint);
		slidePlaneNormal = slidePlaneNormal.normalize();
		touchingPlaneNormal = slidePlaneNormal;

		Plane slidingPlane = new Plane();
		slidingPlane = slidingPlane.returnPlane(slidePlaneOrgin, slidePlaneNormal);
		Vector newDestinationPoint = new Vector();// = destinationPoint.subtract(slidePlaneNormal.multiplyNonVec(slidingPlane.signedDistanceTo(destinationPoint)));
		newDestinationPoint.x = destinationPoint.x - slidingPlane.signedDistanceTo(destinationPoint) * slidePlaneNormal.x;
		newDestinationPoint.y = destinationPoint.y - slidingPlane.signedDistanceTo(destinationPoint) * slidePlaneNormal.y;
		newDestinationPoint.z = destinationPoint.z - slidingPlane.signedDistanceTo(destinationPoint) * slidePlaneNormal.z;
		//newerPosition = newDestinationPoint;
		Vector newVelocityVector = newDestinationPoint.subtract(collisionPackage.intersectionPoint);
		//newerVelocityVector = new Vector();
		newerVelocityVector = newVelocityVector;
		//draw3DLine(collisionPackage.intersectionPoint.x,collisionPackage.intersectionPoint.y,collisionPackage.intersectionPoint.z,newDestinationPoint.x,newDestinationPoint.y,newDestinationPoint.z,1,1,1);
		
		if(setVelocity)
		{
			
			//velo = newVelocityVector.multiply(collisionPackage.eRadius);
			//velo.y = ;
			//velo.y = 0;
			
		}
		else
		{
			//gravity = newVelocityVector.multiply(collisionPackage.eRadius);
			//gravity = newVelocityVector.multiply(collisionPackage.eRadius);
			//gravity.x = 0;
			//gravity.z = 0;
			//gravity.y = gravity.y - 0.01;
		}
		double dotted = velo.normalize().dot(newVelocityVector.normalize());
		if(lastCollision == false)
		{
			lastCollision = true;
			Distance(pos.x,pos.y,pos.z,-cameraX,-cameraY,-cameraZ);
			if(Hit.isPlaying() == false)
				if(lastCollisionTime > 40)
				{
					Hit.playAsSoundEffect(1 / (float)slowMo, (float)(1 / (Distance / 4)), false);
					eyeCloseTime = 301;
				}
				//testSound.
			lastCollisionTime = 0;
		}
		
		if(dotted < 0.9)
		{
			
			
				//System.out.println(dotted);
				//lastCollisionTime = 0;
				Distance(pos.x,pos.y,pos.z,-cameraX,-cameraY,-cameraZ);
				if(Hit.isPlaying() == false)
				{
					dotted = 0 - dotted;
					dotted = 1 + dotted;
					//System.out.println(dotted);
					if(Distance < 1)
					{
						Distance = 1;
					}
					//Hit.playAsSoundEffect(1f, (float)(dotted / (Distance / 4)), false);
				}
			
		}
		
		if(newVelocityVector.magnitude() < veryCloseDistance)
		{
			
			return newBasePoint;
		}
		
		collisionRecursionDepth ++;
		return collideWithWorld(newBasePoint,newVelocityVector);
	}
	public void collideWithWorld()
	{
		for(int i = 0; i < EditorMap.mapData.size(); i ++)
		{
			Data d = EditorMap.mapData.get(i);
			Vector p1 = d.v1.divide(collisionPackage.eRadius);
			Vector p2 = d.v2.divide(collisionPackage.eRadius);
			Vector p3 = d.v3.divide(collisionPackage.eRadius);
			checkCollision(collisionPackage,p1,p2,p3,d);
			if(touchingThis.mid.equals(d.mid))
			{
				touchingThisSpot = i;
			}
		}
	}

	public void checkCollision(CollisionPacket colPackage,Vector p1, Vector p2, Vector p3, Data d)
	{
		
		Plane trianglePlane = new Plane();
		trianglePlane = trianglePlane.fromTri(p1, p2, p3);
		//Distance3D(collisionPackage.BasePoint.x,collisionPackage.BasePoint.y,collisionPackage.BasePoint.z,d.mid.x,d.mid.y,d.mid.z);
		if(trianglePlane.isFrontFactingTo(collisionPackage.normalizedVelocity))// && Distance < 150)
		{

			double t0, t1;
			boolean embeddedInPlane = false; 
			double signedDistToTrianglePlane = trianglePlane.signedDistanceTo(collisionPackage.BasePoint);
			double normalDotVelocity = trianglePlane.normal.dot(collisionPackage.velocity);
			if(normalDotVelocity == 0)
			{
				if(Math.abs(signedDistToTrianglePlane) >= 1.0)
				{

					return;

				}
				else
				{
					embeddedInPlane = true;
					t0 = 0.0;
					t1 = 1.0;
				}

			}
			else
			{

				t0 = (1.0 - signedDistToTrianglePlane) / normalDotVelocity;
				t1 = (-1.0 - signedDistToTrianglePlane) / normalDotVelocity;
				if(t0 > t1)
				{
					double temp = t1;
					t1 = t0;
					t0 = temp;
				}
				if(t0 > 1.0 || t1 < 0.0)
				{
					return;
				}
				if(t0 < 0.0) t0 = 0.0;
				if(t1 < 0.0) t1 = 0.0;
				if(t0 > 1.0) t0 = 1.0;
				if(t1 > 1.0) t1 = 1.0;
			}
			Vector collisionPoint = new Vector();
			boolean foundCollision = false;
			double t = 1.0;
			if(!embeddedInPlane)
			{
				Vector planeIntersectionPoint = new Vector();//(collisionPackage.BasePoint.subtract(trianglePlane.normal)).add(collisionPackage.velocity.multiplyNonVec(t0));
				planeIntersectionPoint.x = (collisionPackage.BasePoint.x - trianglePlane.normal.x) + t0 * collisionPackage.velocity.x;
				planeIntersectionPoint.y = (collisionPackage.BasePoint.y - trianglePlane.normal.y) + t0 * collisionPackage.velocity.y;
				planeIntersectionPoint.z = (collisionPackage.BasePoint.z - trianglePlane.normal.z) + t0 * collisionPackage.velocity.z;
				//Vector planeIntersectionPoint = (collisionPackage.BasePoint.add((collisionPackage.velocity.multiplyNonVec(t0)))).subtract(trianglePlane.normal);
				if(checkPointInTriangle(planeIntersectionPoint,p1,p2,p3))
				{
					foundCollision = true;
					t = t0;
					if(averagePlane != 0)
					{
						averagePlane = (t + averagePlane) / 2;
					}
					else
					{
						averagePlane = t + averagePlane;
					}
					//System.out.println("Plane " + t);
					collisionPoint = planeIntersectionPoint;
					
				}
			}
			if(foundCollision == false)
			{
				
				Vector velocity = new Vector();
				velocity.x = collisionPackage.velocity.x;
				velocity.y = collisionPackage.velocity.y;
				velocity.z = collisionPackage.velocity.z;
				Vector base = collisionPackage.BasePoint;
				double velocitySquaredLength = velocity.squaredLength();
				double a,b,c;
				newT = 0;
				a = velocitySquaredLength;
				b = 2.0*(velocity.dot((base.subtract(p1))));
				c = (p1.subtract(base)).squaredLength() - 1.0;
				if(getLowestRoot(a,b,c,t))
				{
					t = newT;
					foundCollision = true;
					collisionPoint = p1;
				}
				b = 2.0*(velocity.dot(base.subtract(p2)));
				c = (p2.subtract(base)).squaredLength() - 1.0;
				if(getLowestRoot(a,b,c,t))
				{
					t = newT;
					foundCollision = true;
					collisionPoint = p2;
				}
				b = 2.0*(velocity.dot(base.subtract(p3)));
				c = (p3.subtract(base)).squaredLength() - 1.0;
				if(getLowestRoot(a,b,c,t))
				{
					t = newT;
					foundCollision = true;
					collisionPoint = p3;
				}
				
				Vector edge = p2.subtract(p1);
				Vector baseToVertex = p1.subtract(base);
				double edgeSquaredLength = edge.squaredLength();
				double edgeDotVelocity = edge.dot(velocity);
				double edgeDotBaseToVertex = edge.dot(baseToVertex);
				a = edgeSquaredLength * -velocitySquaredLength + edgeDotVelocity * edgeDotVelocity;
				b = edgeSquaredLength * (2*velocity.dot(baseToVertex)) - 2.0 * edgeDotVelocity * edgeDotBaseToVertex;
				c = edgeSquaredLength * (1-baseToVertex.squaredLength()) + edgeDotBaseToVertex * edgeDotBaseToVertex;
				if(getLowestRoot(a,b,c,t))
				{
					double f = ((edgeDotVelocity*newT-edgeDotBaseToVertex)/edgeSquaredLength);
					if(f >= 0.0 && f <= 1.0)
					{
						t = newT;
						foundCollision = true;
						collisionPoint = p1.add(edge.multiplyNonVec(f));
					}
				}
				edge = p3.subtract(p2);
				baseToVertex = p2.subtract(base);
				edgeSquaredLength = edge.squaredLength();
				edgeDotVelocity = edge.dot(velocity);
				edgeDotBaseToVertex = edge.dot(baseToVertex);
				a = edgeSquaredLength * -velocitySquaredLength + edgeDotVelocity * edgeDotVelocity;
				b = edgeSquaredLength * (2*velocity.dot(baseToVertex)) - 2.0 * edgeDotVelocity * edgeDotBaseToVertex;
				c = edgeSquaredLength * (1-baseToVertex.squaredLength()) + edgeDotBaseToVertex * edgeDotBaseToVertex;
				if(getLowestRoot(a,b,c,t))
				{
					double f = ((edgeDotVelocity*newT-edgeDotBaseToVertex) / edgeSquaredLength);
					if(f >= 0 && f <= 1.0)
					{
						t = newT;
						foundCollision = true;
						collisionPoint = p2.add(edge.multiplyNonVec(f));
					}
				}
				edge = new Vector();
				edge = p1.subtract(p3);
				baseToVertex = p3.subtract(base);
				edgeSquaredLength = edge.squaredLength();
				edgeDotVelocity = edge.dot(velocity);
				edgeDotBaseToVertex = edge.dot(baseToVertex);
				a = edgeSquaredLength * -velocitySquaredLength + (edgeDotVelocity * edgeDotVelocity);
				b = edgeSquaredLength * (2 * velocity.dot(baseToVertex)) - 2.0 * edgeDotVelocity * edgeDotBaseToVertex;
				c = edgeSquaredLength * (1-baseToVertex.squaredLength()) + edgeDotBaseToVertex * edgeDotBaseToVertex;
				if(getLowestRoot(a,b,c,t))
				{
					double f = ((edgeDotVelocity*newT-edgeDotBaseToVertex) / edgeSquaredLength);

					if(f >= 0.0 && f <= 1.0)
					{
						t = newT;
						//System.out.println(newT);
						foundCollision = true;
						collisionPoint = p3.add(edge.multiplyNonVec(f));
					}
				}
				if(t != 1)
				{
					averageEdge = (t + averageEdge) / 2;
					
				}
			}
			
			if(foundCollision == true)
			{

				double distToCollision = Math.abs(t * (collisionPackage.velocity.magnitude()));
				
				
				if(collisionPackage.foundCollision == false || distToCollision < collisionPackage.nearestDistance)
				{
					//System.out.println(distToCollision);
					touchingThis = d;
					collisionTime = t;
					jumpNormal = d.normal;
					collisionPackage.nearestDistance = distToCollision;
					collisionPackage.intersectionPoint = collisionPoint;
					collisionPackage.foundCollision = true;
					
				}

			}
			
			


		}
	}
	public void checkCollisionTriangles(Data d)
	{

	}
	public boolean getLowestRoot(double a, double b, double c, double t)
	{
		double det = b * b - 4 * a * c;

		if(det < 0) return false;

		double sqrtD = Math.sqrt(det);
		double r1 = (-b - sqrtD) / (2 * a);
		double r2 = (-b + sqrtD) / (2 * a);
		if(r1 > r2)
		{
			double temp = r2;
			r2 = r1;
			r1 = temp;

		}
		if(r1 > 0 && r1 < t)
		{

			newT = r1;
			return true;
		}
		if(r2 > 0 && r2 < t)
		{
			newT = r2;
			return true;
		}

		return false;




	}

	public boolean checkPointInTriangle(Vector point, Vector pa, Vector pb,Vector pc)
	{
		Vector e10 = pb.subtract(pa);
		Vector e20 = pc.subtract(pa);
		double a = e10.dot(e10);
		double b = e10.dot(e20);
		double c = e20.dot(e20);
		double ac_bb = (a*c) - (b * b);
		Vector vp = new Vector();
		vp.x = point.x - pa.x;
		vp.y = point.y - pa.y;
		vp.z = point.z - pa.z;
		double d = vp.dot(e10);
		double e = vp.dot(e20);
		double x = Math.round((d*c) - (e*b));
		double y = Math.round((e*a) - (d*b));
		double z = Math.round(x + y - ac_bb);
		if(Keyboard.isKeyDown(Keyboard.KEY_I) && printOut)
		{
			//System.out.println("z " + z + " y " + y + " x " + x);
		}
		if((z < 0 && x > 0 && y > 0))
		{
			return true;
		}
		else
		{
			if(printOut)
			{
				//System.out.println("z " + z + " y " + y + " x " + x);
			}
			return false;
		}
	}

	public Data setUpSquareTriStructure(double x, double y, double z, double x2, double y2, double z2, double x3, double y3, double z3,double Red, double Green, double Blue, boolean collide)
	{
		Data d = new Data();
		d.v1.x = x;
		d.v1.y = y;
		d.v1.z = z;
		d.v2.x = x2;
		d.v2.y = y2;
		d.v2.z = z2;
		d.v3.x = x3;
		d.v3.y = y3;
		d.v3.z = z3;
		d.mid.x = (d.v1.x + d.v2.x + d.v3.x) / 3;
		d.mid.y = (d.v1.y + d.v2.y + d.v3.y) / 3;
		d.mid.z = (d.v1.z + d.v2.z + d.v3.z) / 3;
		d.Red = Red;
		d.Green = Green;
		d.Blue = Blue;
		d.normal = getSurfaceNormal(d);
		d.Collide = collide;
		return d;
	}
	public void setUpLeg(double x, double y, double z, double dir, double dir2)
	{

		int dir3 = 0;
		for(int i = 0; i < 10; i ++)
		{

			double x1 = x + Math.cos(Math.toRadians(dir)) * (Math.sin(Math.toRadians(dir3)) * 0.2); 
			double y1 = y + ((Math.sin(Math.toRadians(dir2))) * (Math.cos(Math.toRadians(dir3)) * 0.2));
			double z1 = z + (Math.sin(Math.toRadians(dir))) * (Math.sin(Math.toRadians(dir3)) * 0.2) + Math.cos(Math.toRadians(dir2)) * (Math.cos(Math.toRadians(dir3)) * 0.2);
			dir3 = dir3 + 36;
			double x2 = x + Math.cos(Math.toRadians(dir)) * (Math.sin(Math.toRadians(dir3)) * 0.2);
			double y2 = y + ((Math.sin(Math.toRadians(dir2))) * (Math.cos(Math.toRadians(dir3)) * 0.2));
			double z2 = z + (Math.sin(Math.toRadians(dir))) * (Math.sin(Math.toRadians(dir3)) * 0.2) + Math.cos(Math.toRadians(dir2)) * (Math.cos(Math.toRadians(dir3)) * 0.2);


			double x3 = x2 + (Math.sin(Math.toRadians(dir2)) * (Math.sin(Math.toRadians(dir)) * 1));
			double y3 = y2 + Math.cos(Math.toRadians(dir2)) * -1;
			double z3 = z2 + (Math.sin(Math.toRadians(dir2)) * (Math.cos(Math.toRadians(dir)) * 1));
			double x4 = x1 + (Math.sin(Math.toRadians(dir2)) * (Math.sin(Math.toRadians(dir)) * 1));
			double y4 = y1 + Math.cos(Math.toRadians(dir2)) * -1;
			double z4 = z1 + (Math.sin(Math.toRadians(dir2)) * (Math.cos(Math.toRadians(dir)) * 1));

			setUpSquareTri(x1,y1,z1,x2,y2,z2,x3,y3,z3,x4,y4,z4,0.3,0.3,0.7);
		}
	}
	public void setUpPerson(double x, double y, double z, double plaDir, double legDirection)
	{
		setUpLeg(Math.sin(Math.toRadians(plaDir + 90)) * 0.3,0,Math.cos(Math.toRadians(plaDir + 90)) * 0.3,plaDir,legDirection);
		//setUpLeg(Math.sin(Math.toRadians(plaDir - 90)) * 0.3,0,Math.cos(Math.toRadians(plaDir - 90)) * 0.3,plaDir,-legDirection);
	}
	public void clouds()
	{

	}
	public void dayAndNight()
	{

		sunLightDirX = sunLightDirX + 0.01;
		Lights light = lights.get(0);
		Lights light2 = lights.get(1);
		Lights light3 = lights.get(2);
		light.light.x = Math.cos(Math.toRadians(sunLightDirX)) * 10000;
		light.light.y = Math.sin(Math.toRadians(sunLightDirX)) * 10000;
		//gamma = light.light.y / 10000;
		gamma = 0.2;
		if(light.light.y < 100)
		{
			gamma = 0.1;
			sunLightDirX = sunLightDirX + 0.01;
			light2.light.x = 0;
			light2.light.y = 1;
			light2.light.z = 0;
			light2.Red = 1;
			light2.Green = 0.1;
			light2.Blue = 0;
			light2.intensity = (Math.random() * 0.4) + 2;
			light3.light.x = 0;
			light3.light.y = 1;
			light3.light.z = 0;
			light3.Red = 1;
			light3.Green = 0.1;
			light3.Blue = 0;
			light3.intensity = (Math.random() * 0.4) + 2;
			light.light.x = 0;
			light.light.y = 1;
			light.light.z = 0;
			light.Red = 1;
			light.Green = 0.1;
			light.Blue = 0;
			light.intensity = (Math.random() * 0.4) + 2;
			drawBackDrop(0.4 * (light.light.y / 10000),0.6 * (light.light.y / 10000),1 * (light.light.y / 10000),0.6,1,1,0.6);


		}
		else
		{
			if(light.light.y < 3000)
			{
				light2.light.x = 0;
				light2.light.y = 1;
				light2.light.z = 0;
				light2.Red = 1;
				light2.Green = 0.1;
				light2.Blue = 0;
				light2.intensity = ((Math.random() * 0.4) + 2) * (((light.light.y) - 3000) / -3000);
				light3.light.x = 0;
				light3.light.y = 1;
				light3.light.z = 0;
				light3.Red = 1;
				light3.Green = 0.1;
				light3.Blue = 0;
				light3.intensity = ((Math.random() * 0.4) + 2) * (((light.light.y) - 3000) / -3000);
			}
			else
			{
				light2.light.x = light.light.x;
				light2.light.y = light.light.y;
				light2.light.z = light.light.z;
				light2.Red = 1;
				light2.Green = 1;
				light2.Blue = 1;
				light2.intensity = light.intensity;
				light3.light.x = light.light.x;
				light3.light.y = light.light.y;
				light3.light.z = light.light.z;
				light3.Red = 1;
				light3.Green = 1;
				light3.Blue = 1;
				light3.intensity = light.intensity;
			}
			light.Red = 1;
			light.Green = 1;
			light.Blue = 1;
			if(light.light.y < 600)
			{
				light.intensity = 10000 * ((light.light.y - 100) / 500);
			}
			else
			{
				light.intensity = 10000;
			}
			drawBackDrop(0.4 * (light.light.y / 10000),0.6 * (light.light.y / 10000),1 * (light.light.y / 10000),0.6,1,1,0.6);
		}
	}
	public void ItemTime()
	{
		for(int i = 0; i < items.size(); i ++)
		{

			Items item = items.get(i);
			Distance3D(item.pos.x,item.pos.y,item.pos.z,-cameraX,-cameraY,-cameraZ);
			if(item.NoMore && Distance < 100)
			{
				item.rotate.points = RotateRotatable(item.rotate,1,0,0,0.01 / slowMo);
				item.changedY = item.changedY + item.changeY;
				if(item.changedY > 0)
				{
					item.changeY = item.changeY - (0.001 / slowMo);
				}
				if(item.changedY < 0)
				{
					item.changeY = item.changeY + (0.001 / slowMo);
				}
				Vector posi = new Vector();
				posi.x = item.pos.x;
				posi.y = item.pos.y + item.changedY;
				posi.z = item.pos.z;
				//Data t = item.rotate.points.get(1);
				//System.out.println(t.v4.x);
				if(item.Type == 1 && item.coolDown.ifTimeIsGreater(playTime))
				{
					
					drawRotatable(item.rotate,posi,0.5,0.5,0.5,0);
					
				}
				if(item.Type == 3 && item.coolDown.ifTimeIsGreater(playTime))
				{

					drawRotatable(item.rotate,posi,0.4,0.86,1,0);
				}
				if(item.Type == 2 && item.coolDown.ifTimeIsGreater(playTime))
				{
					drawRotatable(item.rotate,posi,1,0.9,0,128);
				}
				if(item.Type == 4 && item.coolDown.ifTimeIsGreater(playTime))
				{
					drawRotatable(item.rotate,posi,0.9,0.9,0.9,0);
				}
				Distance3D(pos.x,pos.y,pos.z,item.pos.x,item.pos.y,item.pos.z);
				if(Distance <= 1.3 && item.coolDown.ifTimeIsGreater(playTime) && item.Type != 2)
				{
					addRing(item.pos.x,item.pos.y,item.pos.z,1,1,1,0.09,0,0.09,0,0.09);
					powerUpType = item.Type;



					item.coolDown = playTime.futureTime(40, 0, 0);
					powerUpTime = playTime.futureTime(30, 0, 0);

				}
				else if(Distance <= 2 && item.Type == 2)
				{
					addRing(item.pos.x,item.pos.y,item.pos.z,1,0.9,0,0.09,0,0.09,0,0.09);
					collected = collected + 1;
					item.NoMore = false;

				}
			}
		}
		//Make2D();
		if(playTime.ifTimeIsGreater(powerUpTime))
		{
			if(powerUpType == 1)
			{
				MyTime touchad = new MyTime();
				touchad = timeSinceTouched.getTimeSubtractTime(playTime);
				if(touching || touchad.Second == 0)
				{
					if(touching && touchingNoKey)
					{
						//velo = velo.multiplyNonVec(0.97);
					}
					veloXGravi = touchingPlaneNormal.x * -0.0035;
					veloYGravi = touchingPlaneNormal.y * -0.0035;
					veloZGravi = touchingPlaneNormal.z * -0.0035;
				}
			}
			else
			{
				//veloXGravi = ((sliderXVeloX - 190) / 5700);
				//veloYGravi = ((sliderXVeloY - 190) / 5700);
				//veloZGravi = ((sliderXVeloZ - 190) / 5700);
			}
			if(powerUpType == 3)
			{
				BallSpeed = 0.03;
				Vector change = new Vector();
				change.x = ((pos.x - ballLastPos.x) / (4 / slowMo));
				change.y = ((pos.y - ballLastPos.y) / (4 / slowMo));
				change.z = ((pos.z - ballLastPos.z) / (4 / slowMo));
				Vector ParticlePos = new Vector();
				ParticlePos.x = ballLastPos.x;
				ParticlePos.y = ballLastPos.y;
				ParticlePos.z = ballLastPos.z;
				for(int i = 0; i < 4 / slowMo; i ++)
				{
					ParticlePos = ParticlePos.add(change);
					addParticle(ParticlePos.x,ParticlePos.y,ParticlePos.z,0,0,0,0.1,0.4,1,0.2,0,0,0,0.002,false);
				}
			}
			else
			{
				BallSpeed = 0.005;
			}
			if(powerUpType == 4)
			{
				Jump.x = 0.2;
				Jump.y = 0.2;
				Jump.z = 0.2;
			}
			else
			{
				Jump.x = 0.07;
				Jump.y = 0.07;
				Jump.z = 0.07;
			}



			MyTime timeLeft = new MyTime();
			timeLeft = playTime.getTimeSubtractTime(powerUpTime);
			DrawText("Power Time: " + timeLeft.Hour + "." + timeLeft.Minute + "." + timeLeft.Second,500,720,10,0,0,0);
		}
		else
		{
			powerUpType = 0;
			BallSpeed = 0.005;
			Jump.x = 0.07;
			Jump.y = 0.07;
			Jump.z = 0.07;
		}


		//Make3D();
	}
	public void Distance3D(double x, double y, double z, double x2, double y2, double z2)
	{
		Distance = Math.sqrt(((x - x2) * (x - x2)) + ((y - y2) * (y - y2)) + ((z - z2) * (z - z2)));
	}
	public void addFireworkParticle(double x, double y, double z)
	{
		Particle p = new Particle();
		p.pos.x = x;
		p.pos.y = y;
		p.pos.z = z;
		p.velo.x = (Math.random() * 0.01) - 0.005;
		p.velo.y = (Math.random() * 0.9) + 0.4;
		p.velo.z = (Math.random() * 0.01) - 0.005;
		p.gravity.x = 0;
		p.gravity.y = 0.01;
		p.gravity.z = 0;
		int RandomN = (int)Math.round(Math.random() * 1);
		if(RandomN == 0)
		{
			p.Red = (Math.random() * 1);
			p.Green = (Math.random() * (1 - p.Red));
			p.Blue = (Math.random() * (1 - p.Green));
		}
		else if(RandomN == 1)
		{
			p.Blue = (Math.random() * 1);
			p.Green = (Math.random() * (1 - p.Blue));
			p.Red = (Math.random() * (1 - p.Green));
		}
		p.size = 0.4;
		p.Type = 1;
		p.sizeChange = 0;
		p.airForce = false;
		particles.add(p);
	}
	public void particles()
	{
		noDetail = true;
		for(int i = 0; i < particles.size(); i ++)
		{
			Particle p = particles.get(i);
			Vector lastPos = new Vector();
			lastPos.x = p.pos.x;
			lastPos.y = p.pos.y;
			lastPos.z = p.pos.z;
			p.pos = p.pos.add(p.velo.divideNon(slowMo));
			p.velo = p.velo.subtract(p.gravity.divideNon(slowMo));
			p.size = p.size - (p.sizeChange/ slowMo);
			if(p.Type == 3)
			{
				Vector dir = new Vector();
				dir.x = p.pos.x - pos.x;
				dir.z = p.pos.z - pos.z;
				dir = dir.normalize();
				double dirY = Math.toDegrees(Math.acos(dir.z));
				if(dir.x < 0)
				{
					dirY = dirY * -1;
				}
				dir = new Vector();
				dir.x = p.pos.x - pos.x;
				dir.y = p.pos.y - pos.y;
				dir.z = p.pos.z - pos.z;
				dir = dir.normalize();
				double dirX = Math.toDegrees(Math.asin(dir.y));
				p.velo.x = p.velo.x + (Math.cos(Math.toRadians(dirX)) * (Math.sin(Math.toRadians(dirY))) * -0.01);
				p.velo.y = p.velo.y + (Math.sin(Math.toRadians(dirX)) * -0.001);
				p.velo.z = p.velo.z + (Math.cos(Math.toRadians(dirX)) * (Math.cos(Math.toRadians(dirY))) * -0.01);
				p.velo.x = p.velo.x * 0.97;
				p.velo.z = p.velo.z * 0.97;
				Distance(p.pos.x,p.pos.y,p.pos.z,pos.x,pos.y,pos.z);
				if(Distance < 1)
				{
					p.delete = true;
					//particles.remove(i);
					//i = i - 1;
					ballHealth = ballHealth + 1;
					if(ballHealth >= 1000)
					{
						ballHealth = 1000;
					}
				}
			}
			if(p.Type == 2)
			{
				Vector dir = new Vector();
				dir.x = p.pos.x - p.orbitPoint.x;
				dir.z = p.pos.z - p.orbitPoint.z;
				dir = dir.normalize();
				double dirY = Math.toDegrees(Math.acos(dir.z));
				if(dir.x < 0)
				{
					dirY = dirY * -1;
				}
				dir = new Vector();
				dir.x = p.pos.x - pos.x;
				dir.y = p.pos.y - pos.y;
				dir.z = p.pos.z - pos.z;
				dir = dir.normalize();
				double dirX = Math.toDegrees(Math.asin(dir.y));
				dirX = 0;
				p.gravity.x = (Math.cos(Math.toRadians(dirX)) * (Math.sin(Math.toRadians(dirY))) * 0.01);
				p.gravity.y = (Math.sin(Math.toRadians(dirX)) * 0.01);
				p.gravity.z = (Math.cos(Math.toRadians(dirX)) * (Math.cos(Math.toRadians(dirY))) * 0.01);
				p.velo.x = p.velo.x * 0.99;
				p.velo.z = p.velo.z * 0.99;
				Distance(p.pos.x,p.pos.y,p.pos.z,p.orbitPoint.x,p.orbitPoint.y,p.orbitPoint.z);
				if(Distance > 3)
				{
					p.gravity.x = 0;
					p.gravity.y = 0;
					p.gravity.z = 0;
					p.velo.x = 0;
					p.velo.y = 0;
					p.velo.z = 0;
					p.velo.x = (Math.cos(Math.toRadians(dirX)) * (Math.sin(Math.toRadians(dirY + 90))) * -0.1);
					p.velo.y = 0;
					p.velo.z = (Math.cos(Math.toRadians(dirX)) * (Math.cos(Math.toRadians(dirY + 90))) * -0.1);
					p.Type = 3;
				}
					//p.velo = p.velo.multiplyNonVec(0.99);
				
				
					
				
				p.size = 0.1;
			}
			if(p.Type == 1)
			{
				if(p.velo.y < 0)
				{
					p.velo.y = -0.0001;
					if(GL11.glIsEnabled(GL11.GL_LIGHT1) == false || p.lightEnable == 1)
					{
						if(p.lightEnable == 1 || p.lightEnable == 0)
						{
							GL11.glEnable(GL11.GL_LIGHT1);
							GL11.glLight(GL11.GL_LIGHT1, GL11.GL_DIFFUSE, floatBuffer((float)(p.Red / (p.spawned + 4)),(float)(p.Green / (p.spawned + 4)),(float)(p.Blue  / (p.spawned + 4)),1));
						    GL11.glLight(GL11.GL_LIGHT1,GL11.GL_POSITION,floatBuffer((float)p.pos.x,(float)p.pos.y,(float)p.pos.z,1));
						    GL11.glLight(GL11.GL_LIGHT1, GL11.GL_AMBIENT, floatBuffer((float)(p.Red / (p.spawned + 4)),(float)(p.Green / (p.spawned + 4)),(float)(p.Blue  / (p.spawned + 4)),1));
						    GL11.glLight(GL11.GL_LIGHT1, GL11.GL_SPECULAR, floatBuffer((float)(p.Red / ((p.spawned + 4) / 3)),(float)(p.Green / ((p.spawned + 4) / 3)),(float)(p.Blue  / ((p.spawned + 4) / 3)),1));
						    p.lightEnable = 1;
						}
					}
					if(GL11.glIsEnabled(GL11.GL_LIGHT2) == false || p.lightEnable == 2)
					{
						if(p.lightEnable == 2 || p.lightEnable == 0)
						{
							GL11.glEnable(GL11.GL_LIGHT2);
							GL11.glLight(GL11.GL_LIGHT2, GL11.GL_DIFFUSE, floatBuffer((float)(p.Red / (p.spawned + 4)),(float)(p.Green / (p.spawned + 4)),(float)(p.Blue  / (p.spawned + 4)),1));
						    GL11.glLight(GL11.GL_LIGHT2,GL11.GL_POSITION,floatBuffer((float)p.pos.x,(float)p.pos.y,(float)p.pos.z,1));
						    GL11.glLight(GL11.GL_LIGHT2, GL11.GL_AMBIENT, floatBuffer((float)(p.Red / (p.spawned + 4)),(float)(p.Green / (p.spawned + 4)),(float)(p.Blue  / (p.spawned + 4)),1));
						    GL11.glLight(GL11.GL_LIGHT2, GL11.GL_SPECULAR, floatBuffer((float)(p.Red / ((p.spawned + 4) / 3)),(float)(p.Green / ((p.spawned + 4) / 3)),(float)(p.Blue  / ((p.spawned + 4) / 3)),1));
						    p.lightEnable = 2;
						}
					}
					if(GL11.glIsEnabled(GL11.GL_LIGHT3) == false || p.lightEnable == 3)
					{
						if(p.lightEnable == 3 || p.lightEnable == 0)
						{
							GL11.glEnable(GL11.GL_LIGHT3);
							GL11.glLight(GL11.GL_LIGHT3, GL11.GL_DIFFUSE, floatBuffer((float)(p.Red / (p.spawned + 4)),(float)(p.Green / (p.spawned + 4)),(float)(p.Blue  / (p.spawned + 4)),1));
						    GL11.glLight(GL11.GL_LIGHT3,GL11.GL_POSITION,floatBuffer((float)p.pos.x,(float)p.pos.y,(float)p.pos.z,1));
						    GL11.glLight(GL11.GL_LIGHT3, GL11.GL_AMBIENT, floatBuffer((float)(p.Red / (p.spawned + 4)),(float)(p.Green / (p.spawned + 4)),(float)(p.Blue  / (p.spawned + 4)),1));
						    GL11.glLight(GL11.GL_LIGHT3, GL11.GL_SPECULAR, floatBuffer((float)(p.Red / ((p.spawned + 4) / 3)),(float)(p.Green / ((p.spawned + 4) / 3)),(float)(p.Blue  / ((p.spawned + 4) / 3)),1));
						    p.lightEnable = 3;
						}
					}
					if(GL11.glIsEnabled(GL11.GL_LIGHT4) == false || p.lightEnable == 4)
					{
						if(p.lightEnable == 4 || p.lightEnable == 0)
						{
							GL11.glEnable(GL11.GL_LIGHT4);
							GL11.glLight(GL11.GL_LIGHT4, GL11.GL_DIFFUSE, floatBuffer((float)(p.Red / (p.spawned + 4)),(float)(p.Green / (p.spawned + 4)),(float)(p.Blue  / (p.spawned + 4)),1));
						    GL11.glLight(GL11.GL_LIGHT4,GL11.GL_POSITION,floatBuffer((float)p.pos.x,(float)p.pos.y,(float)p.pos.z,1));
						    GL11.glLight(GL11.GL_LIGHT4, GL11.GL_AMBIENT, floatBuffer((float)(p.Red / (p.spawned + 4)),(float)(p.Green / (p.spawned + 4)),(float)(p.Blue  / (p.spawned + 4)),1));
						    GL11.glLight(GL11.GL_LIGHT4, GL11.GL_SPECULAR, floatBuffer((float)(p.Red / ((p.spawned + 4) / 3)),(float)(p.Green / ((p.spawned + 4) / 3)),(float)(p.Blue  / ((p.spawned + 4) / 3)),1));
						    p.lightEnable = 4;
						}
					}
				    //GL11.glLight(GL11.GL_LIGHT1, GL11.GL_SPECULAR, floatBuffer(0.5f, 0.5f, 0.5f, 1.0f));
					double compare = p.Red / (p.spawned + 4);
					compare = compare + p.Green / (p.spawned + 4);
					compare = compare + p.Blue / (p.spawned + 4);
					compare = compare / 3;
					if(compare < 0.01)
					{
						
						if(p.lightEnable == 1)
						{
							GL11.glDisable(GL11.GL_LIGHT1);
						}
						else if(p.lightEnable == 2)
						{
							GL11.glDisable(GL11.GL_LIGHT2);
						}
						else if(p.lightEnable == 3)
						{
							GL11.glDisable(GL11.GL_LIGHT3);
						}
						else if(p.lightEnable == 4)
						{
							GL11.glDisable(GL11.GL_LIGHT4);
						}
						p.delete = true;
						//particles.remove(i);
						//i = i - 1;
					}
					if(p.spawned == 0)
					{
						Distance(p.pos.x,p.pos.y,p.pos.z,cameraX,cameraY,cameraZ);
						Firework.playAsSoundEffect(1 / (float)slowMo,1 / (float)(Distance / 20), false);
					}
					p.spawned = p.spawned + (float)(1 / slowMo);
					
					if(p.spawned <= 2 / slowMo)
					{
						
						MyColor color = new MyColor();
						color.Red = p.Red;
						color.Green = p.Green;
						color.Blue = p.Blue;
						addFireWork(p.pos.x,p.pos.y,p.pos.z,(Math.random() * 0.4) + 0.2,color);
					}
					else
					{
						//p.spawned = 3;
					}
				}
			}
			if(p.airForce)
			{
				if(slowMo < 1.6)
				{
					if(p.airForceType == 1)
					{
						p.velo.x = p.velo.x * ( 0.96);
						p.velo.y = p.velo.y * ( 0.96);
						p.velo.z = p.velo.z * (0.96);
					}
					else
					{
						p.velo.x = p.velo.x * 0.9;
						p.velo.z = p.velo.z * 0.9;
					}
				}
				else
				{
					p.velo.x = p.velo.x * (0.975);
					p.velo.y = p.velo.y * (0.975);
					p.velo.z = p.velo.z * (0.975);
				}
			}
			if(p.size < 0)
			{
				p.size = 0;
				p.delete = true;
				//particles.remove(i);
				//i = i - 1;
			}
			if(particleCollide(p) == true)
			{
				if(p.Type == 2 || p.Type == 3)
				{
					
					//particles.remove(i);
					//i = i - 1;
					p.delete = true;
				}
				p.velo.y = 0;
				p.velo.x = 0;
				p.velo.z = 0;

				p.pos = lastPos;

			}

			MyColor color = new MyColor();

			Data d = returnDataTri(p.pos.x + (Math.sin(Math.toRadians(cameraDirY)) * (Math.sin(Math.toRadians(cameraDirX)) * p.size)),p.pos.y + (Math.cos(Math.toRadians(cameraDirX)) * p.size),p.pos.z + (Math.cos(Math.toRadians(cameraDirY)) * (Math.sin(Math.toRadians(cameraDirX)) * p.size)),p.pos.x - (Math.sin(Math.toRadians(cameraDirY + 90)) * p.size),p.pos.y,p.pos.z - (Math.cos(Math.toRadians(cameraDirY + 90)) * p.size),p.pos.x + (Math.sin(Math.toRadians(cameraDirY + 90)) * p.size),p.pos.y,p.pos.z + (Math.cos(Math.toRadians(cameraDirY + 90)) * p.size),p.Red,p.Green,p.Blue);
			for(int t = 0; t < lights.size(); t ++)
			{
				Lights l = lights.get(t);
				Distance3D(d.mid.x,d.mid.y,d.mid.z,l.light.x,l.light.y,l.light.z);
				color.Red = ((((l.Red / Distance) + d.Red) / 2) / (Distance / l.intensity) + color.Red) / 2;
				color.Green = ((((l.Green / Distance) + d.Green) / 2) / (Distance / l.intensity) + color.Green) / 2;
				color.Blue = ((((l.Blue / (Distance)) + d.Blue) / 2) / (Distance / l.intensity) + color.Blue) / 2;
			}
			
				GL11.glDisable(GL11.GL_LIGHTING);
				//GL11.glLineWidth(3);
			if(p.Type == 1 && p.velo.y >= 0)
			{
				draw3DTriangle(d);
			}
			else if(p.Type == 0)
			{
				draw3DTriangle(d);
			}
			else if(p.Type == 2)
			{
				//draw3DLine(p.pos.x,p.pos.y,p.pos.z,lastPos.x,lastPos.y,lastPos.z,0,1,0,0.9);
				draw3DTriangle(d);
			}
			else if(p.Type == 3)
			{
				//draw3DLine(p.pos.x,p.pos.y,p.pos.z,lastPos.x,lastPos.y,lastPos.z,0,1,0,0.9);
				draw3DTriangle(d);
			}
			
			//draw3DSphere(p.pos.x,p.pos.y,p.pos.z,0.1,p.Red,p.Green,p.Blue,3);

		}
		GL11.glEnable(GL11.GL_LIGHTING);
		noDetail = false;
		
		for(int i = 0; i < particles.size(); i ++)
		{
			Particle p = particles.get(i);
			if(p.delete == true)
			{
				particles.remove(i);
			}
		}
		
	}
	public boolean particleCollide(Particle p)
	{
		for(int i = 0; i < particleCollides.size(); i ++)
		{
			Data d = particleCollides.get(i);

			if(p.velo.normalize().dot(d.normal) <= 0)
			{
				Vector v = new Vector();
				v = (p.pos).subtract(d.mid);
				//v = v.normalize();
				double Result = v.dot(d.normal);
				if(Result < 0.15 && Result > -1)
				{
					if(checkPointInTriangle(p.pos,d.v1,d.v2,d.v3))
					{

						return true;
					}


				}
			}

			//if(p.velo)
		}
		return false;
	}
	public void addRing(double x, double y, double z,double Red, double Green, double Blue,double speed, double gravity,double xSpeed, double ySpeed, double zSpeed)
	{
		int dir = 0;

		for(int i = 0; i < 180; i ++)
		{


			dir = dir + 2;

			addParticle(x,y,z, (Math.sin(Math.toRadians(dir))) * xSpeed,(Math.tan(Math.toRadians(dir)) * ySpeed),( Math.cos(Math.toRadians(dir))) * zSpeed,Red,Green,Blue,0.1,0,gravity,0,0.001,false);
		}
	}
	public void addParticle(double x, double y, double z, double xSpeed, double ySpeed, double zSpeed, double Red, double Green, double Blue, double size,double gravityX, double gravityY,double gravityZ,double changeSize,boolean SlowDown)
	{
		Particle p = new Particle();
		p.pos.x = x;
		p.pos.y = y;
		p.pos.z = z;
		p.velo.x = xSpeed;
		p.velo.y = ySpeed;
		p.velo.z = zSpeed;
		p.gravity.x = gravityX;
		p.gravity.y = gravityY;
		p.gravity.z = gravityZ;
		p.Red = Red;
		p.Green = Green;
		p.Blue = Blue;
		p.size = size;
		p.Type = 0;
		p.sizeChange = changeSize;
		p.airForce = SlowDown;
		if(SlowDown)
		{
			p.airForceType = 1;
		}
		particles.add(p);
	}
	public void addFireWork(double x, double y, double z, double size, MyColor color)
	{
		double dirY = -18;
		double dirX = 0;
		for(int t = 0; t < 15; t ++)
		{
			dirY = dirY + 18;
			for(int i = 0; i < 10; i ++)
			{
				dirX = dirX + 36;
				addParticle(x,y,z, (Math.cos(Math.toRadians(dirY)) * Math.sin(Math.toRadians(dirX))) * size + ((Math.random() * 0.1) - 0.05),(Math.sin(Math.toRadians(dirY)) * size) + ((Math.random() * 0.1) - 0.05),(Math.cos(Math.toRadians(dirY)) *  Math.cos(Math.toRadians(dirX))) * size + ((Math.random() * 0.1) - 0.05),color.Red + ((Math.random() * 0.2) - 0.1),color.Green + ((Math.random() * 0.2) - 0.1),color.Blue + ((Math.random() * 0.2) - 0.1),0.12,0,0.005,0,0.001,true);
			}
		}
	}
	public void addParticles(double x, double y, double z,double Red,double Green,double Blue, int ammount,double changeSize,boolean AirForce,double gravity,double randomY)
	{
		for(int i = 0; i < ammount; i ++)
		{
			Particle p = new Particle();
			p.pos.x = x;
			p.pos.y = y;
			p.pos.z = z;
			p.velo.x = ((Math.random() * 2) - 1) / 10;
			p.velo.y = ((Math.random() * randomY) - (randomY / 2)) / 10;
			p.velo.z = ((Math.random() * 2) - 1) / 10;
			p.Red = Red;
			p.Green = Green;
			p.Blue = Blue;
			p.size = (1 / ((Math.random() * 6) + 3));
			p.gravity.x = 0;
			p.gravity.y = gravity;
			p.gravity.z = 0;
			p.Type = 0;
			p.sizeChange = changeSize;
			p.airForce = AirForce;
			particles.add(p);
		}
	}
	public void ScreenShot()
	{
		GL11.glReadBuffer(GL11.GL_FRONT);

		int width = Display.getDisplayMode().getWidth();

		int height= Display.getDisplayMode().getHeight();

		int bpp = 4; // Assuming a 32-bit display with a byte each for red, green, blue, and alpha.

		ByteBuffer buffer = BufferUtils.createByteBuffer(width * height * bpp);

		GL11.glReadPixels(0, 0, width, height, GL11.GL_RGBA, GL11.GL_UNSIGNED_BYTE, buffer );
		String userHome = System.getProperty("user.home");
		LocalDateTime date = LocalDateTime.now();
		MyTime time = new MyTime();
		time.Hour = date.getHour();
		time.Minute = date.getMinute();
		time.Second = date.getSecond();
		File file = new File(userHome + "/BallRoll/" + "/ScreenShots/" + time.Hour + "." + time.Minute + "." + time.Second + ".PNG"); // The file to save to.

		String format = "PNG"; // Example: "PNG" or "JPG"

		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

		for(int x = 0; x < width; x++)

		{

			for(int y = 0; y < height; y++)

			{

				int i = (x + (width * y)) * bpp;

				int r = buffer.get(i) & 0xFF;

				int g = buffer.get(i + 1) & 0xFF;

				int b = buffer.get(i + 2) & 0xFF;

				image.setRGB(x, height - (y + 1), (0xFF << 24) | (r << 16) | (g << 8) | b);

			}

		}



		try {

			ImageIO.write(image, format, file);

		} catch (IOException e) { e.printStackTrace(); }
	}
	public void switchMovement(int movement, int index, int divide)
	{
		if(onThisMovement[0] != movement)
		{
			onThisMovement[0] = movement;
			onThisMovement[1] = index;
			for(int i = 0; i < Player.size(); i ++)
			{
				Rotators r = Player.get(i);
				r.RotateOn = 0;
				r.RotateOn2 = 1;
			}
		}
	}
	public void CPU()
	{
		Vector fakePos = pos;
		Vector fakeVel = velo;
		boolean fakeCollision = lastCollision;
		int fakeTime = lastCollisionTime;
		Vector eRadius = new Vector();
		eRadius.x = collisionPackage.eRadius.x;
		eRadius.y = collisionPackage.eRadius.y;
		eRadius.z = collisionPackage.eRadius.z;
		collisionPackage.eRadius.x = 1;
		collisionPackage.eRadius.y = 1;
		collisionPackage.eRadius.z = 1;
		Vector fakeTouchingPlane = touchingPlaneNormal;
		if(ballList.size() > 0)
		{
		for(int i = 0; i < ballList.size(); i ++)
		{
			
			Ball ball = ballList.get(i);
			
			Vector goTo = ball.goTo.get(ball.goToOn);
			Distance(goTo.x,goTo.y,goTo.z,ball.pos.x,ball.pos.y,ball.pos.z);
			if(Distance <= 1.5)
			{
				ball.goToOn ++;
				if(ball.goToOn >= ball.goTo.size())
				{
					ball.goToOn = 0;
				}
			}
			Distance(ball.pos.x,ball.pos.y,ball.pos.z,fakePos.x,fakePos.y,fakePos.z);
			if(Distance < 20)
			{
				Vector dirAt = new Vector();
				dirAt.x = ball.pos.x - fakePos.x;
				dirAt.z = ball.pos.z - fakePos.z;
				dirAt = dirAt.normalize();
				double dirY = Math.toDegrees(Math.acos(dirAt.z));
				if(dirAt.x < 0)
				{
					dirY = dirY * -1;
				}
				dirAt.y = ball.pos.y - fakePos.y;
				dirAt = dirAt.normalize();
				//double dirX = Math.toDegrees(Math.asin(dirAt.y));
				ball.velo.x = ball.velo.x - (Math.sin(Math.toRadians(dirY)) * 0.004);
				ball.velo.z = ball.velo.z - (Math.cos(Math.toRadians(dirY)) * 0.004);
				double closeDis = 10000;
				for(int k = 0; k < ball.goTo.size(); k ++)
				{
					Vector point = ball.goTo.get(k);
					Distance(ball.pos.x,ball.pos.y,ball.pos.z,point.x,point.y,point.z);
					if(Distance < closeDis)
					{
						ball.goToOn = k;
						closeDis = Distance;
					}
				}
			}
			else
			{
				Vector point = new Vector();
				point.x = ball.pos.x - goTo.x;
				point.z = ball.pos.z - goTo.z;
				point = point.normalize();
				double dirY = Math.toDegrees(Math.acos(point.z));
				if(point.x < 0)
				{
					
					dirY = dirY * -1;
					
				}
				//double dirX = Math.toDegrees(Math.asin(point.y));
				
				
					ball.velo.x = -(Math.sin(Math.toRadians(dirY)) * 0.3);
					ball.velo.z = -(Math.cos(Math.toRadians(dirY)) * 0.3);
				
				
			}
			ball.velo.y = ball.velo.y - 0.01;
			Distance(fakePos.x,fakePos.y,fakePos.z,ball.pos.x,ball.pos.y,ball.pos.z);
			if(Distance < collisionPackage.eRadius.x + eRadius.x)
			{
				if(obtainNail == 0)
				{
					Vector dirAt = new Vector();
					dirAt.x = ball.pos.x - fakePos.x;
					dirAt.z = ball.pos.z - fakePos.z;
					dirAt = dirAt.normalize();
					double dirY = Math.toDegrees(Math.acos(dirAt.z));
					if(dirAt.x < 0)
					{
						dirY = dirY * -1;
					}
					//System.out.println(dirY);
					dirAt = new Vector();
					dirAt.x = ball.pos.x - fakePos.x;
					dirAt.z = ball.pos.z - fakePos.z;
					dirAt.y = ball.pos.y - fakePos.y;
					
					dirAt = dirAt.normalize();
					double dirX = -Math.toDegrees(Math.asin(dirAt.y));
					
					if((Math.abs(fakeVel.x) + Math.abs(fakeVel.y) + Math.abs(fakeVel.z)) / 3 > (Math.abs(ball.velo.x) + Math.abs(ball.velo.y) + Math.abs(ball.velo.z)) / 3)
					{
						//System.out.println("faster");
						double timesBy = (Math.abs(fakeVel.x) + Math.abs(fakeVel.y) + Math.abs(fakeVel.z)) / 3;
						timesBy = timesBy + 0.1;
						ball.velo.x = ((Math.cos(Math.toRadians(dirX)) * Math.sin(Math.toRadians(dirY))) * Math.abs(timesBy));
						ball.velo.y = ((Math.sin(Math.toRadians(dirX)) * Math.sin(Math.toRadians(dirY))) * Math.abs(timesBy));
						ball.velo.y = ball.velo.y + ((Math.sin(Math.toRadians(dirX)) * Math.cos(Math.toRadians(dirY))) * Math.abs(timesBy));
						ball.velo.y = ball.velo.y / 2;
						ball.velo.z = ((Math.cos(Math.toRadians(dirX)) * Math.cos(Math.toRadians(dirY))) * Math.abs(timesBy));
						//fakeVel.x = switchVelo.x * ((Math.sin(Math.toRadians(dirX)) * Math.cos(Math.toRadians(dirY))) * Math.abs(fakeVel.x));
						//fakeVel.y = switchVelo.y * (Math.cos(Math.toRadians(dirX)) * -1);
						//fakeVel.z = switchVelo.z * ((Math.sin(Math.toRadians(dirX)) * Math.sin(Math.toRadians(dirY))) * -1);
						fakeVel = fakeVel.multiplyNonVec(-0.7);
						
					}
					else
					{
						double timesBy = (Math.abs(ball.velo.x) + Math.abs(ball.velo.y) + Math.abs(ball.velo.z)) / 3;
						timesBy = timesBy + 0.1;
						fakeVel.x = ((Math.cos(Math.toRadians(dirX)) * Math.sin(Math.toRadians(dirY))) * -Math.abs(timesBy));
						//fakeVel.y = (Math.sin(Math.toRadians(dirX)) * Math.abs(ball.velo.y));
						fakeVel.y = ((Math.sin(Math.toRadians(dirX)) * Math.sin(Math.toRadians(dirY))) * -Math.abs(timesBy));
						fakeVel.y = fakeVel.y + ((Math.sin(Math.toRadians(dirX)) * Math.cos(Math.toRadians(dirY))) * -Math.abs(timesBy));
						fakeVel.y = fakeVel.y / 2;
						fakeVel.z = ((Math.cos(Math.toRadians(dirX)) * Math.cos(Math.toRadians(dirY))) * -Math.abs(timesBy));
						//fakeVel.x = switchVelo.x;
						//fakeVel.z = switchVelo.z;
						//fakeVel.y = switchVelo.y;
						ball.velo.x = ball.velo.x * -0.7;
						ball.velo.y = ball.velo.y * -0.7;
						ball.velo.z = ball.velo.z * -0.7;
						if(Math.abs(dirX) > 80)
						{
							fakeVel.x = 0.2;
							fakeVel.y = 0.1;
						}
						ballHealth = ballHealth - 20;
					}
					double moveBy = ((collisionPackage.eRadius.x + eRadius.x) + 0.1) - Distance;
					fakePos.x = fakePos.x - ((Math.cos(Math.toRadians(dirX)) * Math.sin(Math.toRadians(dirY))) * (moveBy));
					fakePos.y = fakePos.y + (Math.sin(Math.toRadians(dirX)) * (moveBy));
					fakePos.z = fakePos.z - ((Math.cos(Math.toRadians(dirX)) * Math.cos(Math.toRadians(dirY))) * (moveBy));
					fakePos.y = fakePos.y + 0.05;
				}
				else
				{
					ball.Popped = true;
					ball.points = new ArrayList<Data>();
					
				}
			}
			pos = ball.pos;
			velo = ball.velo;
			lastCollision = ball.lastTouching;
			lastCollisionTime = ball.lastTouchingTime;
			collideAndSlide(velo,gravity);
			if(ball.Popped == true)
			{
				MyColor color = new MyColor();
				color.Red = 1;
				color.Green = 1;
				color.Blue = 1;
				addFireWork(ball.pos.x,ball.pos.y,ball.pos.z,0.2,color);
				ballList.remove(i);
				obtainNail = 2;
				eRadius.x = 1;
				eRadius.y = 1;
				eRadius.z = 1;
				Vector dirAt = new Vector();
				dirAt.x = ball.pos.x - fakePos.x;
				dirAt.z = ball.pos.z - fakePos.z;
				dirAt = dirAt.normalize();
				double dirY = Math.toDegrees(Math.acos(dirAt.z));
				if(dirAt.x < 0)
				{
					dirY = dirY * -1;
				}
				//System.out.println(dirY);
				dirAt = new Vector();
				dirAt.x = ball.pos.x - fakePos.x;
				dirAt.z = ball.pos.z - fakePos.z;
				dirAt.y = ball.pos.y - fakePos.y;
				
				dirAt = dirAt.normalize();
				//double dirX = -Math.toDegrees(Math.asin(dirAt.y));
				fakeVel.x = Math.sin(Math.toRadians(dirY)) * -0.5;
				fakeVel.y = 0.1;
				fakeVel.z = Math.cos(Math.toRadians(dirY)) * -0.5;
				Distance(pos.x,pos.y,pos.z,cameraX,cameraY,cameraZ);
				Pop.playAsSoundEffect(1 / (float)slowMo, 1 / (float)(Distance / 20), false);
				if(storyLine == 2)
				{
					sideStory = 6;
				}
				
			}
			ball.lastTouching = lastCollision;
			ball.lastTouchingTime = lastCollisionTime;

			ball.velo = velo;
			ball.pos = pos;
			//System.out.println(ball.goToOn);
			//System.out.println("x " + ball.pos.x + " y " + ball.pos.y + " z " + ball.pos.z);
			if(ball.Popped == false)
			{
				for(int t = 0; t < ball.points.size(); t ++)
				{
					
					
					Data d = ball.points.get(t);
					//Rotate X
					Quaternion q = new Quaternion();
					q.setFromAxisAngle(new Vector4f((float)0,(float)0,(float)-1,(float)Math.PI *(float)(((ball.velo.x + gravity.x) / 2) / 2.1)));
					Quaternion p = new Quaternion((float)d.v1.x,(float)d.v1.y,(float)d.v1.z,0);
					p = Quaternion.mulInverse(Quaternion.mul(q,p,p),q,p);
					d.v1.x = p.x;
					d.v1.y = p.y;
					d.v1.z = p.z;
					p = new Quaternion((float)d.v2.x,(float)d.v2.y,(float)d.v2.z,0);
					p = Quaternion.mulInverse(Quaternion.mul(q,p,p),q,p);
					d.v2.x = p.x;
					d.v2.y = p.y;
					d.v2.z = p.z;
					p = new Quaternion((float)d.v3.x,(float)d.v3.y,(float)d.v3.z,0);
					p = Quaternion.mulInverse(Quaternion.mul(q,p,p),q,p);
					d.v3.x = p.x;
					d.v3.y = p.y;
					d.v3.z = p.z;
					p = new Quaternion((float)d.v4.x,(float)d.v4.y,(float)d.v4.z,0);
					p = Quaternion.mulInverse(Quaternion.mul(q,p,p),q,p);
					d.v4.x = p.x;
					d.v4.y = p.y;
					d.v4.z = p.z;
					//Rotate Z
					q = new Quaternion();
					q.setFromAxisAngle(new Vector4f((float)1,(float)0,(float)0,(float)Math.PI *(float)(((ball.velo.z + gravity.z) / 2) / 2.1)));
					p = new Quaternion((float)d.v1.x,(float)d.v1.y,(float)d.v1.z,0);
					p = Quaternion.mulInverse(Quaternion.mul(q,p,p),q,p);
					d.v1.x = p.x;
					d.v1.y = p.y;
					d.v1.z = p.z;
					p = new Quaternion((float)d.v2.x,(float)d.v2.y,(float)d.v2.z,0);
					p = Quaternion.mulInverse(Quaternion.mul(q,p,p),q,p);
					d.v2.x = p.x;
					d.v2.y = p.y;
					d.v2.z = p.z;
					p = new Quaternion((float)d.v3.x,(float)d.v3.y,(float)d.v3.z,0);
					p = Quaternion.mulInverse(Quaternion.mul(q,p,p),q,p);
					d.v3.x = p.x;
					d.v3.y = p.y;
					d.v3.z = p.z;
					p = new Quaternion((float)d.v4.x,(float)d.v4.y,(float)d.v4.z,0);
					p = Quaternion.mulInverse(Quaternion.mul(q,p,p),q,p);
					d.v4.x = p.x;
					d.v4.y = p.y;
					d.v4.z = p.z;
					d.mid = d.v1.add(d.v2.add(d.v3.add(d.v4)));
					d.mid = d.mid.divideNon(4);
					d.normal = getSurfaceNormal(d);
					Data j = new Data();
					j.v1 = d.v1.add(ball.pos);
					j.v2 = d.v2.add(ball.pos);
					j.v3 = d.v3.add(ball.pos);
					j.v4 = d.v4.add(ball.pos);
					j.tex1.x = d.tex1.x * BallEnemy.getWidth();
					j.tex1.y = d.tex1.y * BallEnemy.getHeight();
					j.tex2.x = d.tex2.x * BallEnemy.getWidth();
					j.tex2.y = d.tex2.y * BallEnemy.getHeight();
					j.tex3.x = d.tex3.x * BallEnemy.getWidth();
					j.tex3.y = d.tex3.y * BallEnemy.getHeight();
					j.tex4.x = d.tex4.x * BallEnemy.getWidth();
					j.tex4.y = d.tex4.y * BallEnemy.getHeight();
					j.Red = 1;
					j.Green = 1;
					j.Blue = 1;
					j.normal = d.normal;
					j.v1Normal = d.normal;
					j.v2Normal = d.normal;
					j.v3Normal = d.normal;
					j.v4Normal = d.normal;
					j.mid = d.mid;
					
					draw3DQuad(j,5);
				}
			}
		}
		}
		touchingPlaneNormal = fakeTouchingPlane;
		collisionPackage.eRadius = eRadius;
		lastCollisionTime = fakeTime;
		lastCollision = fakeCollision;
		pos = fakePos;
		velo = fakeVel;
	}
	public void healthBar()
	{
		Make2D();
		draw2DQuad(100,770,100,790,900,790,900,770,1,1,1,0.4,1,1,0.4);
		draw2DQuad(105,775,105,785,895,785,895,775,0.6,0.6,0.6,1,0.4,0.4,1);
		if(ballHealth <= 0 && waitTime == 0)
		{
			velo.x = 0;
			velo.y = 0;
			velo.z = 0;
			MyColor color = new MyColor();
			color.Red = 1;
			color.Green = 1;
			color.Blue = 1;
			addFireWork(pos.x,pos.y,pos.z,0.2,color);
			Pop.playAsSoundEffect(1 / (float)slowMo, 1 / (float)(Distance / 20), false);
			lightningOn = 0;
			waitTime = 80;
		}
		if(waitTime > 0)
		{
			velo.x = 0;
			velo.y = 0;
			velo.z = 0;
			waitTime = waitTime - 1;
		}
		if(waitTime == 1)
		{
			ballHealth = 20;
			pos = respawnPoint;
		}
		
		double displayBar = (ballHealth / 1000) * (895 - 105);
		draw2DQuad(105,775,105,785,105 + displayBar,785,105 + displayBar,775,(1 - (ballHealth / 1000)) + 0.5,(ballHealth / 500) - 0.25,0,0.5,1,1,0.5);
	}
	public void story()
	{
		
		if(storyLine == 0)
		{
			
			
			draw2DQuad(190,0,190,210,810,210,810,0,0.4,0.4,0.4,1,1,1,1);
			draw2DQuad(200,0,200,200,800,200,800,0,0.2,0.2,0.2,1,1,1,1);
			if(storyTimeSec <= 2 && storyTimeSec >= 1)
			{
				
				DrawText("wake up",300,100,10,1,1,1);
			}
			if(storyTimeSec <= 4 && storyTimeSec >= 3)
			{
				
				DrawText("wake up.",300,100,10,1,1,1);
			}
			if(storyTimeSec <= 5 && storyTimeSec >= 4)
			{
				
				DrawText("wake up..",300,100,10,1,1,1);
			}
			if(storyTimeSec <= 6 && storyTimeSec >= 5)
			{
				
				DrawText("wake up...",300,100,10,1,1,1);
			}
			if(storyTimeSec <= 11 && storyTimeSec >= 10)
			{
				
				DrawText("WAKE UP!!!",280,100,25,1,1,1);
			}
			if(storyTimeSec < 13 && storyTimeSec >= 12)
			{
				
				DrawText("huh what",280,180,10,1,1,1);
				
			}
			if(storyTimeSec <= 14 && storyTimeSec >= 13)
			{
				
				DrawText("what are you",280,180,10,1,1,1);
				DrawText("doing in here!",280,160,10,1,1,1);
			}
			if(storyTimeSec == 15 && storyTime >= 15)
			{
				
				DrawText("Ive come to warn you.",280,180,10,1,1,1);
				//DrawText("doing in here!",280,160,10,1,1,1);
			}
			if(storyTimeSec == 16)
			{
				
				DrawText("Ive come to warn you.",280,180,10,1,1,1);
				//DrawText("doing in here!",280,160,10,1,1,1);
			}
			if(storyTimeSec == 17)
			{
				
				DrawText("Warn me of what.",280,180,10,1,1,1);
				//DrawText("doing in here!",280,160,10,1,1,1);
			}
			if(storyTimeSec == 18)
			{
				if(storyTime <= 10)
				{
					DrawText("of",280,180,10,1,1,1);
				}
				else if(storyTime <= 40)
				{
					DrawText("of.",280,180,10,1,1,1);
				}
				else if(storyTime <= 60)
				{
					DrawText("of..",280,180,10,1,1,1);
				}
				else if(storyTime <= 60)
				{
					DrawText("of...",280,180,10,1,1,1);
				}
				//DrawText("doing in here!",280,160,10,1,1,1);
			}
			if(storyTimeSec == 19)
			{
				
					DrawText("of...",280,180,10,1,1,1);
				
			}
			if(storyTimeSec == 20)
			{
				
					DrawText("ME!",300,100,30,1,1,1);
				
			}
			if(sideStory == 0)
			{
				
				pauseGamePlay = true;
				velo.x = 0;
				velo.y = 0;
				velo.z = 0;
				pos.x = 2;
				pos.y = 3;
				pos.z = 15;
				cameraX = -11;
				cameraY = -6;
				cameraZ = -4;
				pointCameraAt(-3,-3,-15);
				sideStory = 1;
			}
			if(sideStory == 1 && storyTimeSec >= 2)
			{
				sideStory = 2;
				velo.x = 0.001;
			}
			if(sideStory == 2 && storyTimeSec >= 2 && storyTime >= 20)
			{
				sideStory = 2;
				velo.x = -0.001;
				if(storyTimeSec >= 3)
				{
					sideStory = 3;
				}
			}
			if(sideStory == 3 && storyTimeSec >= 6)
			{
				sideStory = 4;
				velo.x = -0.01;
			}
			if(sideStory == 4 && storyTimeSec >= 10)
			{
				sideStory = 5;
				velo.y = 0.1;
				velo.z = -0.001;
				rotateSphere(0,1,0,0.04f);
			}
			if(sideStory == 5 && storyTimeSec >= 11)
			{
				sideStory = 6;
				rotateSphere(-1,0,0,0.5f);
				
			}
			if(sideStory == 6 && storyTimeSec >= 11 && storyTime >= 20)
			{
				sideStory = 7;
				rotateSphere(1,0,0,0.5f);
				
			}
			if(sideStory == 7 && storyTimeSec >= 12)
			{
				sideStory = 8;
				rotateSphere(-1,0,0,0.3f);
				
			}
			if(storyTimeSec == 20 && storyTime <= 50)
			{
				cameraX = cameraX + (Math.cos(Math.toRadians(cameraDirX)) * Math.sin(Math.toRadians(cameraDirY)) * 0.3);
				cameraY = cameraY + (Math.sin(Math.toRadians(cameraDirX)) * -0.3);
				cameraZ = cameraZ + (Math.cos(Math.toRadians(cameraDirX)) * Math.cos(Math.toRadians(cameraDirY)) * 0.3);
				cameraDirZ = cameraDirZ + 2;
			}
			if(storyTimeSec == 20 && storyTime >= 50)
			{
				draw2DQuad(0,0,0,1000,1000,1000,1000,0,0,0,0,1,1,1,1);
			}
			if(storyTimeSec > 20)
			{
				draw2DQuad(0,0,0,1000,1000,1000,1000,0,0,0,0,1,1,1,1);
			}
			if(storyTimeSec > 22)
			{
				storyLine = 1;
				storyTime = 0;
				storyTimeSec = 0;
				sideStory = 0;
				
			}
			//storyLine = 1;
		}
		if(storyLine == 1)
		{
			Make3D();
			Data d = new Data();
			d.v1.x = 3.7;
			d.v1.y = 2.8;
			d.v1.z = 15;
			d.v2.x = 3.7;
			d.v2.y = 2.8;
			d.v2.z = 15 + 0.8;
			d.v3.x = 3.7;
			d.v3.y = 2.8 - 1;
			d.v3.z = 15 + 0.8;
			d.v4.x = 3.7;
			d.v4.y = 2.8 - 1;
			d.v4.z = 15;
			d.mid = d.v1.add(d.v2.add(d.v3.add(d.v4)));
			d.mid = d.mid.divideNon(4);
		
			d.Red = 1;
			d.Green = 1;
			d.Blue = 1;
			d.normal = getSurfaceNormal(d);
			d.v1Normal = d.normal;
			d.v2Normal = d.normal;
			d.v3Normal = d.normal;
			d.v4Normal = d.normal;
			d.tex1.x = 0; 
			d.tex1.y = 0; 
			d.tex2.x = Ransom.getWidth();
			d.tex2.y = 0;
			d.tex3.x = Ransom.getWidth(); 
			d.tex3.y = Ransom.getHeight(); 
			d.tex4.x = 0;
			d.tex4.y = Ransom.getHeight();
			draw3DQuad(d,3);
			Make2D();
			
			if(storyTimeSec <= 5)
			{
				pos.x = 1000;
				pos.y = 1000;
				pos.z = 1000;
				velo.x = 0;
				velo.y = 0;
				velo.z = 0;
			}
			if(sideStory == 0)
			{
				storyTime = 0;
				storyTimeSec = 0;
				cameraX = -5;
				cameraY = -2;
				cameraZ = -15;
				cameraDirZ = 0;
				pointCameraAt(-3,-4,-13);
				sideStory = 1;
				
			}
			if(sideStory == 1)
			{
				if(storyTimeSec == 0)
				{
					if(storyTime <= 20)
					{
						draw2DQuad(0,0,0,1000,1000,1000,1000,0,0,0,0,1,1,1,1);
					}
					if(storyTime >= 40 && storyTime <= 50)
					{
						draw2DQuad(0,0,0,1000,1000,1000,1000,0,0,0,0,1,1,1,1);
					}
				}
				else if(storyTimeSec == 2)
				{
					
					//cameraDirX = cameraDirX - 1;
					cameraDirX = cameraDirX - 0.45;
				}
				else if(storyTimeSec >= 3)
				{
					draw2DQuad(190,0,190,180,810,180,810,0,0.4,0.4,0.4,1,1,1,1);
					draw2DQuad(200,0,200,170,800,170,800,0,0.2,0.2,0.2,1,1,1,1);	
					
				}
				if(storyTimeSec == 3)
				{
					cameraDirY = cameraDirY + 1;
					DrawText("ugh what happened",300,100,10,1,1,1);
				}
				if(storyTimeSec == 4)
				{
					
					DrawText("Whats this",300,100,10,1,1,1);
				}
				if(storyTimeSec == 5 || storyTimeSec == 6)
				{
					
					DrawText("A Ransom note",300,100,10,1,1,1);
				}
				if(storyTimeSec == 7 || storyTimeSec == 8)
				{
					
					DrawText("Nooo My Pet Rock!!",300,100,10,1,1,1);
				}
				if(storyTimeSec == 9 || storyTimeSec == 10)
				{
					
					DrawText("300 Golden Orbs How!!!",300,100,10,1,1,1);
				}
				
				if(storyTimeSec == 12)
				{
					pauseGamePlay = false;
					pos.x = 5;
					pos.y = 2;
					pos.z = 15;
					velo.x = 0;
					velo.y = 0;
					velo.z = 0;
					zoom = 0;
					storyLine = 2;
					sideStory = 0;
					Mouse.setCursorPosition(screenWidth / 2,screenHeight / 2);
					Mouse.setGrabbed(true);
				}
				
			}
		}
		if(storyLine == 2)
		{
			Make3D();
			if(obtainNail == 0)
			{
				for(int i = 0; i < Nail.size(); i ++)
				{
					
					Data d = Nail.get(i);
					Data t = new Data();
					Vector nailPos = new Vector();
					nailPos.x = 14;
					nailPos.y = 58;
					nailPos.z = 21;
					t.v1 = d.v1.add(nailPos);
					t.v2 = d.v2.add(nailPos);
					t.v3 = d.v3.add(nailPos);
					t.mid = d.mid.add(nailPos);
					t.Red = d.Red;
					t.Green = d.Green;
					t.Blue = d.Blue;
					t.v1Normal = d.normal;
					t.v2Normal = d.normal;
					t.v3Normal = d.normal;
					t.Shine = d.Shine;
					
					draw3DTriangle(t);
				}
				Distance(14,58,21,pos.x,pos.y,pos.z);
				if(Distance < 2)
				{
					pos.y = pos.y + 1.1;
					collisionPackage.eRadius.x = 2;
					collisionPackage.eRadius.y = 2;
					collisionPackage.eRadius.z = 2;
					obtainNail = 1;
					sideStory = 5;
				}
			}
			Make2D();
			
				
			if(sideStory == 0)
			{
				draw2DQuad(190,0,190,180,810,180,810,0,0.4,0.4,0.4,1,1,1,1);
				draw2DQuad(200,0,200,170,800,170,800,0,0.2,0.2,0.2,1,1,1,1);
				DrawText("Move with W,A,S,D",300,100,10,1,1,1);
				if(Keyboard.isKeyDown(Keyboard.KEY_W) || Keyboard.isKeyDown(Keyboard.KEY_A) || Keyboard.isKeyDown(Keyboard.KEY_D)|| Keyboard.isKeyDown(Keyboard.KEY_S))
				{
					sideStory = 1;
				}
			}
			if(sideStory == 1)
			{
				draw2DQuad(190,0,190,180,810,180,810,0,0.4,0.4,0.4,1,1,1,1);
				draw2DQuad(200,0,200,170,800,170,800,0,0.2,0.2,0.2,1,1,1,1);
				DrawText("Move camera with mouse",300,100,10,1,1,1);
				if(Mouse.getDX() > 10)
				{
					sideStory = 2;
				}
			}
			if(sideStory == 2)
			{
				draw2DQuad(190,0,190,180,810,180,810,0,0.4,0.4,0.4,1,1,1,1);
				draw2DQuad(200,0,200,170,800,170,800,0,0.2,0.2,0.2,1,1,1,1);
				DrawText("Zoom in and out with scroll",210,100,10,1,1,1);
				if(Math.abs(zoom) > 0)
				{
					sideStory = 3;
				}
			}
			if(sideStory == 3)
			{
				draw2DQuad(190,0,190,180,810,180,810,0,0.4,0.4,0.4,1,1,1,1);
				draw2DQuad(200,0,200,170,800,170,800,0,0.2,0.2,0.2,1,1,1,1);
				DrawText("Jump with space",300,100,10,1,1,1);
				if(Keyboard.isKeyDown(Keyboard.KEY_SPACE))
				{
					storyTime = 0;
					storyTimeSec = 0;
					sideStory = 4;
				}
			}
			if(sideStory == 4)
			{
				if(storyTimeSec <= 16)
				{
					draw2DQuad(190,0,190,180,810,180,810,0,0.4,0.4,0.4,1,1,1,1);
					draw2DQuad(200,0,200,170,800,170,800,0,0.2,0.2,0.2,1,1,1,1);
				}
				storyTime ++;
				if(storyTime >= 60)
				{
					storyTime = 0;
					storyTimeSec ++;
				}
				if(storyTimeSec <= 3)
				{
					DrawText("Now that you know the",210,150,10,1,1,1);
					DrawText("controls lets go and",210,120,10,1,1,1);
					DrawText("find some golden orbs",210,90,10,1,1,1);
				}
				if(storyTimeSec >= 5 && storyTimeSec <= 10)
				{
					DrawText("So youve met that red",210,150,10,1,1,1);
					DrawText("ball huh. Theres got to",210,120,10,1,1,1);
					DrawText("be a way to get rid of him.",210,90,10,1,1,1);
				}
				if(storyTimeSec >= 11 && storyTimeSec <= 16)
				{
					DrawText("Hey I think I saw a nail",210,150,10,1,1,1);
					DrawText("at the top of the mountain",210,120,10,1,1,1);
					DrawText("that should burst his bubble.",210,90,10,1,1,1);
				}
			}
			if(sideStory == 5)
			{
				draw2DQuad(190,0,190,180,810,180,810,0,0.4,0.4,0.4,1,1,1,1);
				draw2DQuad(200,0,200,170,800,170,800,0,0.2,0.2,0.2,1,1,1,1);
				DrawText("Nice job you got the nail.",210,150,10,1,1,1);
				DrawText("now if he tries to run into",210,120,10,1,1,1);
				DrawText("you he will pop.",210,90,10,1,1,1);
			}
			if(sideStory == 6)
			{
				draw2DQuad(190,0,190,180,810,180,810,0,0.4,0.4,0.4,1,1,1,1);
				draw2DQuad(200,0,200,170,800,170,800,0,0.2,0.2,0.2,1,1,1,1);
				DrawText("Good job you got him",210,150,10,1,1,1);
				DrawText("now we can finish collecting",210,120,10,1,1,1);
				DrawText("those golden orbs",210,90,10,1,1,1);
				if(collected == totalCollect)
				{
					sideStory = 7;
					storyTimeSec = 0;
					storyTime = 0;
				}
			}
			if(sideStory == 7)
			{
				storyTime ++;
				if(storyTime >= 60)
				{
					storyTime = 0;
					storyTimeSec ++;
				}
				draw2DQuad(190,0,190,180,810,180,810,0,0.4,0.4,0.4,1,1,1,1);
				draw2DQuad(200,0,200,170,800,170,800,0,0.2,0.2,0.2,1,1,1,1);
				if(storyTimeSec <= 8)
				{
					DrawText("Looks like we got all",210,150,10,1,1,1);
					DrawText("the golden orbs here",210,120,10,1,1,1);
					DrawText("we should try the crystal",210,90,10,1,1,1);
					DrawText("caverns for more",210,60,10,1,1,1);
				}
				if(storyTimeSec <= 20 && storyTimeSec >= 9)
				{
					DrawText("Crystal Caverns is up",210,150,10,1,1,1);
					DrawText("the mountain and across",210,120,10,1,1,1);
					DrawText("the bridge in a cave",210,90,10,1,1,1);
					//DrawText("caverns for more",210,60,10,1,1,1);
				}
			}
			
				
			
		}
		//System.out.println(storyTimeSec);
	}
	public void GamePlay()
	{
		
		if(pos.y < -40)
		{
			if(Level == 0)
			{
				pos.x = -1;
				pos.y = 1;
				pos.z = 9;
			}
			else if(Level == 1)
			{
				pos.x = 32;
				pos.y = 3;
				pos.z = -12;
			}
		}
		mode = 1;
		sunLightDirX = 40;
		particleCollides.clear();
		//drawBackDrop(0.4,0.5,1,0.7,1,1,0.7);
		if(Paused == false)
		{
			if(pauseGamePlay == false)
			{
				mouseControls();
			}
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_ESCAPE) && optionsMode == 0)
		{
			if(PauseButton == false)
			{
				PauseButton = true;
				if(Paused == false)
				{
					
					Paused = true;
					Mouse.setGrabbed(false);
				}
				else
				{
					PauseAll = false;
					EditTool = 0;
					Paused = false;
					Mouse.setCursorPosition(screenWidth / 2,screenHeight / 2);
					Mouse.setGrabbed(true);

				}
			}
		}
		else
		{
			PauseButton = false;
		}
		if(Paused == false)
		{
			
			if(pauseGamePlay == false)
			{
				keyControl();
			}
		}
		
		if(touching)
		{
			timeSinceTouched.Second = playTime.Second;
			timeSinceTouched.Minute = playTime.Minute;
			timeSinceTouched.Hour = playTime.Hour;
		}
		if(Level == 0)
		{
			Distance(pos.x,pos.y,pos.z,226,87,-181);
			if(Distance < 20)
			{
				if(collected == totalCollect)
				{
					Level = 1;
					intro = 9;
					storyLine = 3;
					sideStory = 0;
					storyTimeSec = 0;
					storyTime = 0;
				}
				else
				{
					
				}
			}
		}
		if(Level == 1)
		{
			
			if(dropTime > 0)
			{
				dropTime = dropTime - 1;
			}
			if(dropTime == 0)
			{
				dropAt = (int)Math.round(Math.random() * 5) * 2;
				Drops.playAsSoundEffect(1, (float)0.5, false);
				Drops.setPosition(dropAt);
				dropTime = 120;
			}
			if(Drops.isPlaying())
			{
				if(Drops.getPosition() >= dropAt + 1)
				{
					Drops.stop();
				}
			}
		}
		Make3D();
		//List<Data> stretch = new ArrayList<Data>();
		
		if(Math.abs(collidedZoom) > 1.2 || mode == 0)
		{
			if(ballHealth > 0)
			{
				drawRotatedSphere();
			}
		}
		
		data = returnDataList(EditorMap.mapData);
		goThroughTris();
		if(pauseGamePlay == false || storyLine == 0)
		{
			
			if(mode == 1)
			{
				if(collideCamera())
				{
					
				}
			}
			else
			{
				collidedZoom = zoom;
			}
		}
		else
		{
			collidedZoom = 0;
		}
		velo.x = velo.x + (veloXGravi / slowMo);
		velo.y = velo.y + (veloYGravi / slowMo);
		velo.z = velo.z + (veloZGravi / slowMo);
		touching = false;
		ballLastPos.x = pos.x;
		ballLastPos.y = pos.y;
		ballLastPos.z = pos.z;
		if(pauseGamePlay == false)
		{
			CPU();
		}
		touching = false;
		collideAndSlide(velo,gravity);
		if(touchingThis.Alpha == 0.885 && touchingThis.Blue == 1 && touchingThis.Green == 0.85 && touchingThis.Red == 0 && !lightningFrom.equals(touchingThis.mid) && touching)
		{
			Vector dir = new Vector();
			lightningFrom = collisionPackage.intersectionPoint;
			lightningFrom.y = lightningFrom.y - 0.001;
			lightningFrom.x = lightningFrom.x - 0.001;
			dir.x =  pos.x - lightningFrom.x;
			dir.z =  pos.z - lightningFrom.z;
			dir = dir.normalize();
			double dirY = Math.toDegrees(Math.acos(dir.z));
			if(dir.x < 0)
			{
				dirY = dirY * -1;
			}
			dir = new Vector();
			dir.x =  pos.x - lightningFrom.x;
			dir.y =  pos.y - lightningFrom.y;
			dir.z =  pos.z - lightningFrom.z;
			dir = dir.normalize();
			double dirX = Math.toDegrees(Math.asin(dir.y));
			velo.x = velo.x + (Math.cos(Math.toRadians(dirX)) * Math.sin(Math.toRadians(dirY)) * 0.2);
			velo.y = velo.y + (Math.sin(Math.toRadians(dirX)) * 0.2);
			velo.z = velo.z + (Math.cos(Math.toRadians(dirX)) * Math.cos(Math.toRadians(dirY)) * 0.2);
			lightningOn = 150;
			
		}
		
		if(lightningOn * slowMo > 130)
		{
			
			lightningOn --;
			drawLightningAt(lightningFrom,pos);
			drawLightningAt(lightningFrom,pos);
			ballHealth = ballHealth - 1.5;
		}
		else if(lightningOn * slowMo > 0)
		{
			ballHealth = ballHealth - 0.3;
			lightningOn --;
			for(int i = 0; i < (lightningOn / 13); i ++)
			{
				Vector Randoms = new Vector();
				Randoms.x = pos.x + (Math.random() * 2 - 1);
				Randoms.y = pos.y + (Math.random() * 2 - 1);
				Randoms.z = pos.z + (Math.random() * 2 - 1);
				drawLightningAt(pos,Randoms);
			}
		}
		else
		{
			if(!lightningFrom.equals(touchingThis))
			{
				lightningFrom = new Vector();
			}
		}
		Vector gravi = new Vector();
		gravi.x = veloXGravi;
		gravi.y = -veloYGravi;
		gravi.z = veloZGravi; 
		gravi = gravi.normalize();
		gravi = touchingPlaneNormal;
		gravi.y = gravi.y * 1;
		gravi.x = gravi.x * 1;
		gravi.z = gravi.z * 1;
		if(lastCollisionTime <= 40)
		{
			/**
			spinX = (float)(((((velo.y + gravity.y) / 2) / 2.1) / slowMo) * gravi.z);
			spinX = spinX + (float)(((((velo.z + gravity.z) / 2) / 2.1) / slowMo) * gravi.y);
			spinY = (float)(((((velo.z + gravity.z) / 2) / 2.1) / slowMo) * gravi.x);
			spinY = spinY - (float)(((((velo.x + gravity.x) / 2) / 2.1) / slowMo) * gravi.z);
			spinZ = -(float)(((((velo.x + gravity.x) / 2) / 2.1) / slowMo) * gravi.y);
			spinZ = spinZ - (float)(((((velo.y + gravity.y) / 2) / 2.1) / slowMo) * gravi.x);
			*/
			if(Math.abs(spinX * touchingPlaneNormal.x) < Math.abs((-(float)(((((velo.y + gravity.y) / 2) / 2.1) / slowMo) * gravi.z) + (float)(((((velo.z + gravity.z) / 2) / 2.1) / slowMo) * gravi.y)) / touchingPlaneNormal.x))
			{
				spinX = -(float)(((((velo.y + gravity.y) / 2) / 2.1) / slowMo) * gravi.z);
				spinX = spinX + (float)(((((velo.z + gravity.z) / 2) / 2.1) / slowMo) * gravi.y);
			}
			else
			{
				spinX = (float)spinX * (float)0.99;
			}
				if(Math.abs(spinY * touchingPlaneNormal.y) < Math.abs((-(float)(((((velo.z + gravity.z) / 2) / 2.1) / slowMo) * gravi.x) + (float)(((((velo.x + gravity.x) / 2) / 2.1) / slowMo) * gravi.z)) / touchingPlaneNormal.y))
				{
					spinY = -(float)(((((velo.z + gravity.z) / 2) / 2.1) / slowMo) * gravi.x);
					spinY = spinY + (float)(((((velo.x + gravity.x) / 2) / 2.1) / slowMo) * gravi.z);
				}
				else
				{
					spinY = (float)spinY * (float)0.99;
					//spinY = spinY + -(float)(((((velo.z + gravity.z) / 2) / 2.1) / slowMo) * gravi.x);
					//spinY = spinY + (float)(((((velo.x + gravity.x) / 2) / 2.1) / slowMo) * gravi.z);
				}
			
			spinZ = -(float)(((((velo.x + gravity.x) / 2) / 2.1) / slowMo) * gravi.y);
			spinZ = spinZ + (float)(((((velo.y + gravity.y) / 2) / 2.1) / slowMo) * gravi.x);
			//
			//spinY = spinY + (float)(((((velo.z + gravity.z) / 2) / 2.1) / slowMo) * gravi.x);
			//spinY = spinY + (float)(((((velo.x + gravity.x) / 2) / 2.1) / slowMo) * gravi.z);
			if((Math.abs(velo.x) + Math.abs(velo.y) + Math.abs(velo.z)) / 3 > 0.001)
			{
			rotateSphere(0,0,1,spinZ);
			rotateSphere(0,1,0,spinX);
			rotateSphere(1,0,0,spinY);
			}
				
		}
		else
		{
			rotateSphere(0,0,1,spinZ);
			rotateSphere(0,1,0,spinX);
			rotateSphere(1,0,0,spinY);
		}
		veloXGravi = ((sliderXVeloX - 190) / 5700);
		veloYGravi = ((sliderXVeloY - 190) / 5700);
		veloZGravi = ((sliderXVeloZ - 190) / 5700);
		
		//Render
		renderSort();
		if(touchingThis.Alpha == 0.515 && touchingThis.Blue == 0 && touchingThis.Green == 1 && touchingThis.Red == 0 && touching && ballHealth < 1000)
		{
			GL11.glEnable(GL11.GL_LIGHT6);
			GL11.glLight(GL11.GL_LIGHT6, GL11.GL_DIFFUSE, floatBuffer((float)(0),(float)(0.4),(float)(0),1));
		    GL11.glLight(GL11.GL_LIGHT6,GL11.GL_POSITION,floatBuffer((float)pos.x,(float)pos.y + 3,(float)pos.z,1));
		    GL11.glLight(GL11.GL_LIGHT6, GL11.GL_AMBIENT, floatBuffer((float)0,(float)0,(float)0,1));
		    GL11.glLight(GL11.GL_LIGHT6, GL11.GL_SPECULAR, floatBuffer((float)0,(float)1,(float)0,1));
		    if(ballHealth < 1000)
		    {
		    	velo.x = velo.x * 0.5;
		    	velo.z = velo.z * 0.5;
		    	velo.y = velo.y * 0.5;
		    }
		    if(ballHealth == 999)
		    {
		    	GL11.glDisable(GL11.GL_LIGHT6);
		    }
			double plusY = -0.3;
			for(int i = 0; i < 1; i ++)
			{
				healDirY = healDirY + 181;
				Particle p = new Particle();
				p.pos.x = pos.x + (Math.sin(Math.toRadians(healDirY)) * 2);
				p.pos.y = pos.y + plusY;
				p.pos.z = pos.z + (Math.cos(Math.toRadians(healDirY)) * 2);
				p.velo.x = velo.x + (Math.sin(Math.toRadians(healDirY + 90)) * 0.15);
				p.velo.y = velo.y + 0.01;
				p.velo.z = velo.z + (Math.cos(Math.toRadians(healDirY + 90)) * 0.15);
				p.orbitPoint.x = pos.x;
				p.orbitPoint.y = pos.y;
				p.orbitPoint.z = pos.z;
				p.gravity.x = 0;
				p.gravity.y = 0;
				p.gravity.z = 0;
				p.Red = 0;
				p.Green = 1;
				p.Blue = 0;
				p.size = 0.2;
				p.Type = 2;
				p.sizeChange = 0;
				p.airForce = false;
				particles.add(p);
				//plusY = Math.random() * 2 - 0.5;
			}
		}
		else
		{
			GL11.glDisable(GL11.GL_LIGHT6);
		}
		if(touchingThis.Alpha == 0.355 && touchingThis.Blue == 1 && touchingThis.Green == 1 && touchingThis.Red == 1 && lastCollisionTime <= 10)
		{
			respawnPoint = pos;
			Data d = EditorMap.mapData.get(touchingThisSpot);
			Data d2 = new Data();
			boolean foundSpot = false;
			if(touchingThisSpot + 1 != EditorMap.mapData.size())
			{
				d2 = EditorMap.mapData.get(touchingThisSpot + 1);
				if(d2.Alpha == 0.355 && d2.Blue == 1 && d2.Green == 1 && d2.Red == 1)
				{
					foundSpot = true;
				}
			}
			if(foundSpot == false)
			{
				if(touchingThisSpot - 1 >= 0)
				{
					d2 = EditorMap.mapData.get(touchingThisSpot - 1);
					if(d2.Alpha == 0.355 && d2.Blue == 1 && d2.Green == 1 && d2.Red == 1)
					{
						foundSpot = true;
					}
				}
			}
			if(foundSpot == true && riseEffectSpot == -1)
			{
				/**
				GL11.glDisable(GL11.GL_CULL_FACE);
				GL11.glDisable(GL11.GL_LIGHTING);
				Data d3 = new Data();
				Vector v = new Vector();
				d3.v1 = d2.v1.add(v);
				d3.v2 = d2.v1.add(v);
				d3.v2 = d3.v2.add(d.normal);
				d3.v3 = d2.v2.add(v);
				d3.v3 = d3.v3.add(d.normal);
				d3.v4 = d2.v2.add(v);
				d3.Red = 1;
				d3.Green = 1;
				d3.Blue = 1;
				d3.mid = d3.v1.add(d3.v2.add(d3.v3.add(d3.v4)));
				d3.mid = d3.mid.divideNon(4);
				d3.normal = getSurfaceNormal(d3);
				d3.v1Normal = d3.normal;
				d3.v2Normal = d3.normal;
				d3.v3Normal = d3.normal;
				d3.v4Normal = d3.normal;
				GL11.glEnable(GL11.GL_BLEND);
				draw3DQuadWith(d3,1,0,0,1);
				d3 = new Data();
				v = new Vector();
				d3.v1 = d2.v2.add(v);
				d3.v2 = d2.v2.add(v);
				d3.v2 = d3.v2.add(d.normal);
				d3.v3 = d2.v3.add(v);
				d3.v3 = d3.v3.add(d.normal);
				d3.v4 = d2.v3.add(v);
				d3.Red = 1;
				d3.Green = 1;
				d3.Blue = 1;
				d3.mid = d3.v1.add(d3.v2.add(d3.v3.add(d3.v4)));
				d3.mid = d3.mid.divideNon(4);
				d3.normal = getSurfaceNormal(d3);
				d3.v1Normal = d3.normal;
				d3.v2Normal = d3.normal;
				d3.v3Normal = d3.normal;
				d3.v4Normal = d3.normal;
				draw3DQuadWith(d3,1,0,0,1);
				d3 = new Data();
				v = new Vector();
				d3.v1 = d.v2.add(v);
				d3.v2 = d.v2.add(v);
				d3.v2 = d3.v2.add(d.normal);
				d3.v3 = d.v3.add(v);
				d3.v3 = d3.v3.add(d.normal);
				d3.v4 = d.v3.add(v);
				d3.Red = 1;
				d3.Green = 1;
				d3.Blue = 1;
				d3.mid = d3.v1.add(d3.v2.add(d3.v3.add(d3.v4)));
				d3.mid = d3.mid.divideNon(4);
				d3.normal = getSurfaceNormal(d3);
				d3.v1Normal = d3.normal;
				d3.v2Normal = d3.normal;
				d3.v3Normal = d3.normal;
				d3.v4Normal = d3.normal;
				draw3DQuadWith(d3,1,0,0,1);
				d3 = new Data();
				v = new Vector();
				d3.v1 = d.v1.add(v);
				d3.v2 = d.v1.add(v);
				d3.v2 = d3.v2.add(d.normal);
				d3.v3 = d.v2.add(v);
				d3.v3 = d3.v3.add(d.normal);
				d3.v4 = d.v2.add(v);
				d3.Red = 1;
				d3.Green = 1;
				d3.Blue = 1;
				d3.mid = d3.v1.add(d3.v2.add(d3.v3.add(d3.v4)));
				d3.mid = d3.mid.divideNon(4);
				d3.normal = getSurfaceNormal(d3);
				d3.v1Normal = d3.normal;
				d3.v2Normal = d3.normal;
				d3.v3Normal = d3.normal;
				d3.v4Normal = d3.normal;
				draw3DQuadWith(d3,1,0,0,1);
				*/
				riseEffectSpot = touchingThisSpot;
				riseEffect = 0;
				riseEffectSpeed = 0.05;
			}
		}
		if(riseEffectSpot != -1)
		{
			Data d = EditorMap.mapData.get(riseEffectSpot);
			Data d2 = new Data();
			boolean foundSpot = false;
			if(riseEffectSpot + 1 != EditorMap.mapData.size())
			{
				d2 = EditorMap.mapData.get(riseEffectSpot + 1);
				if(d2.Alpha == 0.355 && d2.Blue == 1 && d2.Green == 1 && d2.Red == 1)
				{
					foundSpot = true;
				}
			}
			if(foundSpot == false)
			{
				if(riseEffectSpot - 1 >= 0)
				{
					d2 = EditorMap.mapData.get(riseEffectSpot - 1);
					if(d2.Alpha == 0.355 && d2.Blue == 1 && d2.Green == 1 && d2.Red == 1)
					{
						foundSpot = true;
					}
				}
			}
			if(foundSpot)
			{
				if(riseEffectSpot == touchingThisSpot || riseEffectSpot + 1 == touchingThisSpot || riseEffectSpot - 1 == touchingThisSpot && lastCollisionTime <= 10)
				{
					Vector posV = new Vector();
					posV = d.mid.add(d2.mid);
					posV = posV.divideNon(2);
					posV.y = posV.y + 4;
					GL11.glEnable(GL11.GL_LIGHT5);
					float colorEffect = (float)((riseEffect - 1.5) / 2);
					if(colorEffect < 0)
					{
						colorEffect = 0;
					}
					GL11.glLight(GL11.GL_LIGHT5, GL11.GL_DIFFUSE, floatBuffer((float)(0.5 * (float)colorEffect),(float)(0.5 * (float)colorEffect),(float)(0.5 * (float)colorEffect),1));
				    GL11.glLight(GL11.GL_LIGHT5,GL11.GL_POSITION,floatBuffer((float)posV.x,(float)posV.y,(float)posV.z,1));
				    GL11.glLight(GL11.GL_LIGHT5, GL11.GL_AMBIENT, floatBuffer((float)0,(float)0,(float)0,1));
				    GL11.glLight(GL11.GL_LIGHT5, GL11.GL_SPECULAR, floatBuffer((float)1,(float)1,(float)1,1));
					riseEffectSpeed = riseEffectSpeed - ((riseEffect - 2) / 100);
					riseEffectSpeed = riseEffectSpeed * 0.98;
					/**
					if(riseEffect < 2)
					{
						riseEffectSpeed = riseEffectSpeed + 0.001;
					}
					else
					{
						riseEffectSpeed = riseEffectSpeed - 0.001;
						riseEffectSpeed = riseEffectSpeed * 0.98;
					}
					*/
					riseEffect = riseEffect + riseEffectSpeed;
					/**
					if(riseEffect > 4)
					{
						riseEffectSpeed = riseEffectSpeed - 0.01;
					}
					*/
					//System.out.println(riseEffect);
				}
				else
				{
					float colorEffect = (float)((riseEffect - 1.5) / 2);
					if(colorEffect < 0)
					{
						colorEffect = 0;
					}
					GL11.glLight(GL11.GL_LIGHT5, GL11.GL_DIFFUSE, floatBuffer((float)(0.5 * (float)colorEffect),(float)(0.5 * (float)colorEffect),(float)(0.5 * (float)colorEffect),1));
				    
					if(riseEffect > 0)
					{
						riseEffectSpeed = riseEffectSpeed - 0.005;
					}
					else
					{
						riseEffect = -1;
						foundSpot = false;
						riseEffectSpot = -1;
						riseEffectSpeed = 0;
						GL11.glDisable(GL11.GL_LIGHT5);
					}
					riseEffect = riseEffect + riseEffectSpeed;
				}
			}
			
			if(foundSpot == true && riseEffectSpot != -1)
			{
				GL11.glDisable(GL11.GL_CULL_FACE);
				GL11.glDisable(GL11.GL_LIGHTING);
				Data d3 = new Data();
				Vector v = new Vector();
				Vector normals = new Vector();
				normals.x = d.normal.x;
				normals.y = d.normal.y;
				normals.z = d.normal.z;
				d3.v1 = d2.v1.add(v);
				d3.v2 = d2.v1.add(v);
				d3.v2 = d3.v2.add(normals.multiplyNonVec(riseEffect));
				d3.v3 = d2.v2.add(v);
				d3.v3 = d3.v3.add(normals.multiplyNonVec(riseEffect));
				d3.v4 = d2.v2.add(v);
				d3.Red = 1;
				d3.Green = 1;
				d3.Blue = 1;
				d3.mid = d3.v1.add(d3.v2.add(d3.v3.add(d3.v4)));
				d3.mid = d3.mid.divideNon(4);
				d3.normal = getSurfaceNormal(d3);
				d3.v1Normal = d3.normal;
				d3.v2Normal = d3.normal;
				d3.v3Normal = d3.normal;
				d3.v4Normal = d3.normal;
				GL11.glEnable(GL11.GL_BLEND);
				draw3DQuadWith(d3,1,0,0,1);
				d3 = new Data();
				v = new Vector();
				d3.v1 = d2.v2.add(v);
				d3.v2 = d2.v2.add(v);
				d3.v2 = d3.v2.add(normals.multiplyNonVec(riseEffect));
				d3.v3 = d2.v3.add(v);
				d3.v3 = d3.v3.add(normals.multiplyNonVec(riseEffect));
				d3.v4 = d2.v3.add(v);
				d3.Red = 1;
				d3.Green = 1;
				d3.Blue = 1;
				d3.mid = d3.v1.add(d3.v2.add(d3.v3.add(d3.v4)));
				d3.mid = d3.mid.divideNon(4);
				d3.normal = getSurfaceNormal(d3);
				d3.v1Normal = d3.normal;
				d3.v2Normal = d3.normal;
				d3.v3Normal = d3.normal;
				d3.v4Normal = d3.normal;
				draw3DQuadWith(d3,1,0,0,1);
				d3 = new Data();
				v = new Vector();
				d3.v1 = d.v2.add(v);
				d3.v2 = d.v2.add(v);
				d3.v2 = d3.v2.add(normals.multiplyNonVec(riseEffect));
				d3.v3 = d.v3.add(v);
				d3.v3 = d3.v3.add(normals.multiplyNonVec(riseEffect));
				d3.v4 = d.v3.add(v);
				d3.Red = 1;
				d3.Green = 1;
				d3.Blue = 1;
				d3.mid = d3.v1.add(d3.v2.add(d3.v3.add(d3.v4)));
				d3.mid = d3.mid.divideNon(4);
				d3.normal = getSurfaceNormal(d3);
				d3.v1Normal = d3.normal;
				d3.v2Normal = d3.normal;
				d3.v3Normal = d3.normal;
				d3.v4Normal = d3.normal;
				draw3DQuadWith(d3,1,0,0,1);
				d3 = new Data();
				v = new Vector();
				d3.v1 = d.v1.add(v);
				d3.v2 = d.v1.add(v);
				d3.v2 = d3.v2.add(normals.multiplyNonVec(riseEffect));
				d3.v3 = d.v2.add(v);
				d3.v3 = d3.v3.add(normals.multiplyNonVec(riseEffect));
				d3.v4 = d.v2.add(v);
				d3.Red = 1;
				d3.Green = 1;
				d3.Blue = 1;
				d3.mid = d3.v1.add(d3.v2.add(d3.v3.add(d3.v4)));
				d3.mid = d3.mid.divideNon(4);
				d3.normal = getSurfaceNormal(d3);
				d3.v1Normal = d3.normal;
				d3.v2Normal = d3.normal;
				d3.v3Normal = d3.normal;
				d3.v4Normal = d3.normal;
				draw3DQuadWith(d3,1,0,0,1);
			}
		}
		//Make3D();
		if(pauseGamePlay == false)
		{
			cameraX = (-pos.x);
			cameraY = (-pos.y);
			cameraZ = (-pos.z);
		}
		/**
		if(pauseGamePlay == false)
		{
			if(Keyboard.isKeyDown(Keyboard.KEY_Y))
			{
				if(slowMo < 4)
				{
					slowMo = slowMo + 0.1;
				}
				else
				{
					slowMo = 4;
				}
			}
			else
			{
				if(slowMo > 1)
				{
					slowMo = slowMo - 0.1;
				}
				else
				{
					slowMo = 1;
				}
			}
			}
			*/
		if(Paused)
		{
			Options();
		}
		Make2D();
		//DrawText("" + collected + "/" + totalCollect,50,100,20,0,0,0);
		/**
		if(collected == totalCollect)
		{
			if(Math.round(Math.random() * 90) == 2)
			{
				addFireworkParticle(pos.x + (Math.random() * 100 - 50),pos.y,pos.z + (Math.random() * 100 - 50));
			}
		}
		*/
		
		if(pauseGamePlay == false)
		{
			DrawText("" + collected + "/" + totalCollect + " Golden Orbs",50,720,10,0.9,0.9,0);
		}
		if(Paused == false && pauseGamePlay == false)
		{
			healthBar();
		}
		story();
		//System.out.println(slowMo);
	}
	public void intro()
	{
		
		if(Keyboard.isKeyDown(Keyboard.KEY_SEMICOLON))
		{
			cameraDirZ = cameraDirZ + 1;
		}
		//light0Intensity = 400;
		if(pos.y < -100)
		{
			pos = respawnPoint;
			velo.x = 0;
			velo.y = 0;
			velo.z = 0;
		}
		for(int i = 0; i < EditorMap.mapData.size(); i ++)
		{
			Data d = EditorMap.mapData.get(i);
			d.lastV1.x = d.v1.x;
			d.lastV1.y = d.v1.y;
			d.lastV1.z = d.v1.z;
			
			d.lastV2.x = d.v2.x;
			d.lastV2.y = d.v2.y;
			d.lastV2.z = d.v2.z;
			
			d.lastV3.x = d.v3.x;
			d.lastV3.y = d.v3.y;
			d.lastV3.z = d.v3.z;
			if(d.type == 1)
			{
				d.v1 = d.v1.add(d.velo);
				d.v2 = d.v2.add(d.velo);
				d.v3 = d.v3.add(d.velo);
			}
		}
		light0Dif.x = 0.5;
        light0Dif.y = 0.5;
        light0Dif.z = 0.5;
		light0Amb.x = 0;
        light0Amb.y = 0;
        light0Amb.z = 0;
		light0Pos.x = -10000;
		light0Pos.y = 10000;
		light0Pos.z = 0;
		sunLightDirX = 40;
		particleCollides.clear();
		//drawBackDrop(0.4,0.5,1,0.7,1,1,0.7);
		if(powerUpTime.ifTimeIsGreater(playTime))
		{

		}
		if(Paused == false)
		{
			mouseControls();
		}

		if(Keyboard.isKeyDown(Keyboard.KEY_ESCAPE) && optionsMode == 0)
		{
			if(PauseButton == false)
			{
				PauseButton = true;
				if(Paused == false)
				{
					
					Paused = true;
					Mouse.setGrabbed(false);
				}
				else
				{
					PauseAll = false;
					EditTool = 0;
					Paused = false;
					Mouse.setCursorPosition(screenWidth / 2,screenHeight / 2);
					Mouse.setGrabbed(true);

				}
			}
		}
		else
		{
			PauseButton = false;
		}

		if(touching)
		{
			timeSinceTouched.Second = playTime.Second;
			timeSinceTouched.Minute = playTime.Minute;
			timeSinceTouched.Hour = playTime.Hour;
		}
		if(PauseAll == false)
		{
			//powerUpType = 1;
			keyControl();
			//powerUpType = 0;
		}
		//Make2D();
		//dayAndNight();


		Make3D();
		//Make3D();
		
		//Make2D();
		//rotateSphere(1,0,1,(float)((-velo.y / 2.1) / slowMo));
		Vector gravi = new Vector();
		gravi.x = veloXGravi;
		gravi.y = -veloYGravi;
		gravi.z = veloZGravi; 
		gravi = gravi.normalize();
		gravi = touchingPlaneNormal;
		gravi.y = gravi.y * 1;
		gravi.x = gravi.x * 1;
		gravi.z = gravi.z * 1;
		
		if(lastCollisionTime <= 40)
		{
			/**
			spinX = (float)(((((velo.y + gravity.y) / 2) / 2.1) / slowMo) * gravi.z);
			spinX = spinX + (float)(((((velo.z + gravity.z) / 2) / 2.1) / slowMo) * gravi.y);
			spinY = (float)(((((velo.z + gravity.z) / 2) / 2.1) / slowMo) * gravi.x);
			spinY = spinY - (float)(((((velo.x + gravity.x) / 2) / 2.1) / slowMo) * gravi.z);
			spinZ = -(float)(((((velo.x + gravity.x) / 2) / 2.1) / slowMo) * gravi.y);
			spinZ = spinZ - (float)(((((velo.y + gravity.y) / 2) / 2.1) / slowMo) * gravi.x);
			*/
			if(Math.abs(spinX * touchingPlaneNormal.x) < Math.abs((-(float)(((((velo.y + gravity.y) / 2) / 2.1) / slowMo) * gravi.z) + (float)(((((velo.z + gravity.z) / 2) / 2.1) / slowMo) * gravi.y)) / touchingPlaneNormal.x))
			{
				spinX = -(float)(((((velo.y + gravity.y) / 2) / 2.1) / slowMo) * gravi.z);
				spinX = spinX + (float)(((((velo.z + gravity.z) / 2) / 2.1) / slowMo) * gravi.y);
			}
			else
			{
				spinX = (float)spinX * (float)0.99;
			}
				if(Math.abs(spinY * touchingPlaneNormal.y) < Math.abs((-(float)(((((velo.z + gravity.z) / 2) / 2.1) / slowMo) * gravi.x) + (float)(((((velo.x + gravity.x) / 2) / 2.1) / slowMo) * gravi.z)) / touchingPlaneNormal.y))
				{
					spinY = -(float)(((((velo.z + gravity.z) / 2) / 2.1) / slowMo) * gravi.x);
					spinY = spinY + (float)(((((velo.x + gravity.x) / 2) / 2.1) / slowMo) * gravi.z);
				}
				else
				{
					spinY = (float)spinY * (float)0.99;
					//spinY = spinY + -(float)(((((velo.z + gravity.z) / 2) / 2.1) / slowMo) * gravi.x);
					//spinY = spinY + (float)(((((velo.x + gravity.x) / 2) / 2.1) / slowMo) * gravi.z);
				}
			
			spinZ = -(float)(((((velo.x + gravity.x) / 2) / 2.1) / slowMo) * gravi.y);
			spinZ = spinZ + (float)(((((velo.y + gravity.y) / 2) / 2.1) / slowMo) * gravi.x);
			//
			//spinY = spinY + (float)(((((velo.z + gravity.z) / 2) / 2.1) / slowMo) * gravi.x);
			//spinY = spinY + (float)(((((velo.x + gravity.x) / 2) / 2.1) / slowMo) * gravi.z);
			if((Math.abs(velo.x) + Math.abs(velo.y) + Math.abs(velo.z)) / 3 > 0.001)
			{
			rotateSphere(0,0,1,spinZ);
			rotateSphere(0,1,0,spinX);
			rotateSphere(1,0,0,spinY);
			}
				
		}
		else
		{
			rotateSphere(0,0,1,spinZ);
			rotateSphere(0,1,0,spinX);
			rotateSphere(1,0,0,spinY);
		}
			
			
		
		
		//rotateSphere(0,1,0,(float)((((velo.z + gravity.z) / 2) / 2.1) / slowMo));
		//drawPhysicalObjects(box);
		//rotateSphere(0,1,0,(float)velo.z);
		
		
		data = returnDataList(EditorMap.mapData);
		goThroughTris();
		if(mode == 1)
		{
			if(collideCamera())
			{
				
			}
		}
		else
		{
			collidedZoom = zoom;
		}
		//updateStructures();
		//addOnObjects();
		//draw3DLine(l.light.x,l.light.y,l.light.z,l.light.x,l.light.y + 2,l.light.z,1,1,1);
		velo.x = velo.x + (veloXGravi / slowMo);
		velo.y = velo.y + (veloYGravi / slowMo);
		velo.z = velo.z + (veloZGravi / slowMo);
		//gravity.y = -0.2;

		touching = false;
		//System.out.println(velo.x + "   " + velo.y + "    " + velo.z);
		
		ballLastPos.x = pos.x;
		ballLastPos.y = pos.y;
		ballLastPos.z = pos.z;
		collideAndSlide(velo,gravity);

		if(touchingThis.Alpha == 0.79 && touchingThis.Blue == 0.8066666666666666 && touchingThis.Green == 0.0 && touchingThis.Red == 0.47 && touching)
		{
			veloXGravi = touchingThis.normal.x * -0.0035;
			veloYGravi = touchingThis.normal.y * -0.0035;
			veloZGravi = touchingThis.normal.z * -0.0035;
		}
		/**
		Vector dirTo = new Vector();
		dirTo.x = 0 - pos.x;
		dirTo.z = 0 - pos.z;
		dirTo.y = 0;
		dirTo = dirTo.normalize();
		
		double directionTo =  Math.toDegrees(Math.acos(dirTo.z));
		if(dirTo.x < 0)
		{
			directionTo = directionTo * -1;
		}
		dirTo = new Vector();
		dirTo.x = 0 - pos.x;
		dirTo.y = 0 - pos.y;
		dirTo.z = 0 - pos.z;
		dirTo = dirTo.normalize();
		//cameraDirZ = ((-90 * dirTo.y) + 90) * dirTo.z;
		double dirXTo = Math.toDegrees(Math.asin(dirTo.y));
		//System.out.println("X " + dirTo.x);
		//System.out.println("dirTo " + directionTo);
		veloXGravi = (Math.cos(Math.toRadians(dirXTo)) * Math.sin(Math.toRadians(directionTo))) * 0.003;
		veloYGravi = (Math.sin(Math.toRadians(dirXTo))) * 0.003;
		veloZGravi = (Math.cos(Math.toRadians(dirXTo)) * Math.cos(Math.toRadians(directionTo))) * 0.003;
		*/
		//veloXGravi = ((sliderXVeloX - 190) / 5700);
		//veloYGravi = ((sliderXVeloY - 190) / 5700);
		//veloZGravi = ((sliderXVeloZ - 190) / 5700);
		if(Keyboard.isKeyDown(Keyboard.KEY_U))
		{
			if(switchFrom == false)
			{
				switchFrom = true;
				if(mode == 1)
				{
					mode = 0;
				}
				else
				{
					mode = 1;
				}
			}
		}
		else
		{
			switchFrom = false;
		}

		
		renderSort();
		
		if(touchingThis.Alpha == 0.885 && touchingThis.Blue == 1 && touchingThis.Green == 0.85 && touchingThis.Red == 0 && !lightningFrom.equals(touchingThis.mid) && touching)
		{
			Vector dir = new Vector();
			lightningFrom = collisionPackage.intersectionPoint;
			lightningFrom.y = lightningFrom.y - 0.001;
			lightningFrom.x = lightningFrom.x - 0.001;
			dir.x =  pos.x - lightningFrom.x;
			dir.z =  pos.z - lightningFrom.z;
			dir = dir.normalize();
			double dirY = Math.toDegrees(Math.acos(dir.z));
			if(dir.x < 0)
			{
				dirY = dirY * -1;
			}
			dir = new Vector();
			dir.x =  pos.x - lightningFrom.x;
			dir.y =  pos.y - lightningFrom.y;
			dir.z =  pos.z - lightningFrom.z;
			dir = dir.normalize();
			double dirX = Math.toDegrees(Math.asin(dir.y));
			velo.x = velo.x + (Math.cos(Math.toRadians(dirX)) * Math.sin(Math.toRadians(dirY)) * 0.2);
			velo.y = velo.y + (Math.sin(Math.toRadians(dirX)) * 0.2);
			velo.z = velo.z + (Math.cos(Math.toRadians(dirX)) * Math.cos(Math.toRadians(dirY)) * 0.2);
			lightningOn = 150;
			
		}
		else if(touchingThis.Alpha == 0.355 && touchingThis.Blue == 1 && touchingThis.Green == 1 && touchingThis.Red == 1 && lastCollisionTime <= 10)
		{
			respawnPoint = pos;
			Data d = EditorMap.mapData.get(touchingThisSpot);
			Data d2 = new Data();
			boolean foundSpot = false;
			if(touchingThisSpot + 1 != EditorMap.mapData.size())
			{
				d2 = EditorMap.mapData.get(touchingThisSpot + 1);
				if(d2.Alpha == 0.355 && d2.Blue == 1 && d2.Green == 1 && d2.Red == 1)
				{
					foundSpot = true;
				}
			}
			if(foundSpot == false)
			{
				if(touchingThisSpot - 1 >= 0)
				{
					d2 = EditorMap.mapData.get(touchingThisSpot - 1);
					if(d2.Alpha == 0.355 && d2.Blue == 1 && d2.Green == 1 && d2.Red == 1)
					{
						foundSpot = true;
					}
				}
			}
			if(foundSpot == true && riseEffectSpot == -1)
			{
				/**
				GL11.glDisable(GL11.GL_CULL_FACE);
				GL11.glDisable(GL11.GL_LIGHTING);
				Data d3 = new Data();
				Vector v = new Vector();
				d3.v1 = d2.v1.add(v);
				d3.v2 = d2.v1.add(v);
				d3.v2 = d3.v2.add(d.normal);
				d3.v3 = d2.v2.add(v);
				d3.v3 = d3.v3.add(d.normal);
				d3.v4 = d2.v2.add(v);
				d3.Red = 1;
				d3.Green = 1;
				d3.Blue = 1;
				d3.mid = d3.v1.add(d3.v2.add(d3.v3.add(d3.v4)));
				d3.mid = d3.mid.divideNon(4);
				d3.normal = getSurfaceNormal(d3);
				d3.v1Normal = d3.normal;
				d3.v2Normal = d3.normal;
				d3.v3Normal = d3.normal;
				d3.v4Normal = d3.normal;
				GL11.glEnable(GL11.GL_BLEND);
				draw3DQuadWith(d3,1,0,0,1);
				d3 = new Data();
				v = new Vector();
				d3.v1 = d2.v2.add(v);
				d3.v2 = d2.v2.add(v);
				d3.v2 = d3.v2.add(d.normal);
				d3.v3 = d2.v3.add(v);
				d3.v3 = d3.v3.add(d.normal);
				d3.v4 = d2.v3.add(v);
				d3.Red = 1;
				d3.Green = 1;
				d3.Blue = 1;
				d3.mid = d3.v1.add(d3.v2.add(d3.v3.add(d3.v4)));
				d3.mid = d3.mid.divideNon(4);
				d3.normal = getSurfaceNormal(d3);
				d3.v1Normal = d3.normal;
				d3.v2Normal = d3.normal;
				d3.v3Normal = d3.normal;
				d3.v4Normal = d3.normal;
				draw3DQuadWith(d3,1,0,0,1);
				d3 = new Data();
				v = new Vector();
				d3.v1 = d.v2.add(v);
				d3.v2 = d.v2.add(v);
				d3.v2 = d3.v2.add(d.normal);
				d3.v3 = d.v3.add(v);
				d3.v3 = d3.v3.add(d.normal);
				d3.v4 = d.v3.add(v);
				d3.Red = 1;
				d3.Green = 1;
				d3.Blue = 1;
				d3.mid = d3.v1.add(d3.v2.add(d3.v3.add(d3.v4)));
				d3.mid = d3.mid.divideNon(4);
				d3.normal = getSurfaceNormal(d3);
				d3.v1Normal = d3.normal;
				d3.v2Normal = d3.normal;
				d3.v3Normal = d3.normal;
				d3.v4Normal = d3.normal;
				draw3DQuadWith(d3,1,0,0,1);
				d3 = new Data();
				v = new Vector();
				d3.v1 = d.v1.add(v);
				d3.v2 = d.v1.add(v);
				d3.v2 = d3.v2.add(d.normal);
				d3.v3 = d.v2.add(v);
				d3.v3 = d3.v3.add(d.normal);
				d3.v4 = d.v2.add(v);
				d3.Red = 1;
				d3.Green = 1;
				d3.Blue = 1;
				d3.mid = d3.v1.add(d3.v2.add(d3.v3.add(d3.v4)));
				d3.mid = d3.mid.divideNon(4);
				d3.normal = getSurfaceNormal(d3);
				d3.v1Normal = d3.normal;
				d3.v2Normal = d3.normal;
				d3.v3Normal = d3.normal;
				d3.v4Normal = d3.normal;
				draw3DQuadWith(d3,1,0,0,1);
				*/
				riseEffectSpot = touchingThisSpot;
				riseEffect = 0;
				riseEffectSpeed = 0.05;
			}
		}
		if(riseEffectSpot != -1)
		{
			Data d = EditorMap.mapData.get(riseEffectSpot);
			Data d2 = new Data();
			boolean foundSpot = false;
			if(riseEffectSpot + 1 != EditorMap.mapData.size())
			{
				d2 = EditorMap.mapData.get(riseEffectSpot + 1);
				if(d2.Alpha == 0.355 && d2.Blue == 1 && d2.Green == 1 && d2.Red == 1)
				{
					foundSpot = true;
				}
			}
			if(foundSpot == false)
			{
				if(riseEffectSpot - 1 >= 0)
				{
					d2 = EditorMap.mapData.get(riseEffectSpot - 1);
					if(d2.Alpha == 0.355 && d2.Blue == 1 && d2.Green == 1 && d2.Red == 1)
					{
						foundSpot = true;
					}
				}
			}
			if(foundSpot)
			{
				if(riseEffectSpot == touchingThisSpot || riseEffectSpot + 1 == touchingThisSpot || riseEffectSpot - 1 == touchingThisSpot && lastCollisionTime <= 10)
				{
					Vector posV = new Vector();
					posV = d.mid.add(d2.mid);
					posV = posV.divideNon(2);
					posV.y = posV.y + 4;
					GL11.glEnable(GL11.GL_LIGHT5);
					float colorEffect = (float)((riseEffect - 1.5) / 2);
					if(colorEffect < 0)
					{
						colorEffect = 0;
					}
					GL11.glLight(GL11.GL_LIGHT5, GL11.GL_DIFFUSE, floatBuffer((float)(0.5 * (float)colorEffect),(float)(0.5 * (float)colorEffect),(float)(0.5 * (float)colorEffect),1));
				    GL11.glLight(GL11.GL_LIGHT5,GL11.GL_POSITION,floatBuffer((float)posV.x,(float)posV.y,(float)posV.z,1));
				    GL11.glLight(GL11.GL_LIGHT5, GL11.GL_AMBIENT, floatBuffer((float)0,(float)0,(float)0,1));
				    GL11.glLight(GL11.GL_LIGHT5, GL11.GL_SPECULAR, floatBuffer((float)1,(float)1,(float)1,1));
					riseEffectSpeed = riseEffectSpeed - ((riseEffect - 2) / 100);
					riseEffectSpeed = riseEffectSpeed * 0.98;
					/**
					if(riseEffect < 2)
					{
						riseEffectSpeed = riseEffectSpeed + 0.001;
					}
					else
					{
						riseEffectSpeed = riseEffectSpeed - 0.001;
						riseEffectSpeed = riseEffectSpeed * 0.98;
					}
					*/
					riseEffect = riseEffect + riseEffectSpeed;
					/**
					if(riseEffect > 4)
					{
						riseEffectSpeed = riseEffectSpeed - 0.01;
					}
					*/
					//System.out.println(riseEffect);
				}
				else
				{
					float colorEffect = (float)((riseEffect - 1.5) / 2);
					if(colorEffect < 0)
					{
						colorEffect = 0;
					}
					GL11.glLight(GL11.GL_LIGHT5, GL11.GL_DIFFUSE, floatBuffer((float)(0.5 * (float)colorEffect),(float)(0.5 * (float)colorEffect),(float)(0.5 * (float)colorEffect),1));
				    
					if(riseEffect > 0)
					{
						riseEffectSpeed = riseEffectSpeed - 0.005;
					}
					else
					{
						riseEffect = -1;
						foundSpot = false;
						riseEffectSpot = -1;
						riseEffectSpeed = 0;
						GL11.glDisable(GL11.GL_LIGHT5);
					}
					riseEffect = riseEffect + riseEffectSpeed;
				}
			}
			
			if(foundSpot == true && riseEffectSpot != -1)
			{
				GL11.glDisable(GL11.GL_CULL_FACE);
				GL11.glDisable(GL11.GL_LIGHTING);
				Data d3 = new Data();
				Vector v = new Vector();
				Vector normals = new Vector();
				normals.x = d.normal.x;
				normals.y = d.normal.y;
				normals.z = d.normal.z;
				d3.v1 = d2.v1.add(v);
				d3.v2 = d2.v1.add(v);
				d3.v2 = d3.v2.add(normals.multiplyNonVec(riseEffect));
				d3.v3 = d2.v2.add(v);
				d3.v3 = d3.v3.add(normals.multiplyNonVec(riseEffect));
				d3.v4 = d2.v2.add(v);
				d3.Red = 1;
				d3.Green = 1;
				d3.Blue = 1;
				d3.mid = d3.v1.add(d3.v2.add(d3.v3.add(d3.v4)));
				d3.mid = d3.mid.divideNon(4);
				d3.normal = getSurfaceNormal(d3);
				d3.v1Normal = d3.normal;
				d3.v2Normal = d3.normal;
				d3.v3Normal = d3.normal;
				d3.v4Normal = d3.normal;
				GL11.glEnable(GL11.GL_BLEND);
				draw3DQuadWith(d3,1,0,0,1);
				d3 = new Data();
				v = new Vector();
				d3.v1 = d2.v2.add(v);
				d3.v2 = d2.v2.add(v);
				d3.v2 = d3.v2.add(normals.multiplyNonVec(riseEffect));
				d3.v3 = d2.v3.add(v);
				d3.v3 = d3.v3.add(normals.multiplyNonVec(riseEffect));
				d3.v4 = d2.v3.add(v);
				d3.Red = 1;
				d3.Green = 1;
				d3.Blue = 1;
				d3.mid = d3.v1.add(d3.v2.add(d3.v3.add(d3.v4)));
				d3.mid = d3.mid.divideNon(4);
				d3.normal = getSurfaceNormal(d3);
				d3.v1Normal = d3.normal;
				d3.v2Normal = d3.normal;
				d3.v3Normal = d3.normal;
				d3.v4Normal = d3.normal;
				draw3DQuadWith(d3,1,0,0,1);
				d3 = new Data();
				v = new Vector();
				d3.v1 = d.v2.add(v);
				d3.v2 = d.v2.add(v);
				d3.v2 = d3.v2.add(normals.multiplyNonVec(riseEffect));
				d3.v3 = d.v3.add(v);
				d3.v3 = d3.v3.add(normals.multiplyNonVec(riseEffect));
				d3.v4 = d.v3.add(v);
				d3.Red = 1;
				d3.Green = 1;
				d3.Blue = 1;
				d3.mid = d3.v1.add(d3.v2.add(d3.v3.add(d3.v4)));
				d3.mid = d3.mid.divideNon(4);
				d3.normal = getSurfaceNormal(d3);
				d3.v1Normal = d3.normal;
				d3.v2Normal = d3.normal;
				d3.v3Normal = d3.normal;
				d3.v4Normal = d3.normal;
				draw3DQuadWith(d3,1,0,0,1);
				d3 = new Data();
				v = new Vector();
				d3.v1 = d.v1.add(v);
				d3.v2 = d.v1.add(v);
				d3.v2 = d3.v2.add(normals.multiplyNonVec(riseEffect));
				d3.v3 = d.v2.add(v);
				d3.v3 = d3.v3.add(normals.multiplyNonVec(riseEffect));
				d3.v4 = d.v2.add(v);
				d3.Red = 1;
				d3.Green = 1;
				d3.Blue = 1;
				d3.mid = d3.v1.add(d3.v2.add(d3.v3.add(d3.v4)));
				d3.mid = d3.mid.divideNon(4);
				d3.normal = getSurfaceNormal(d3);
				d3.v1Normal = d3.normal;
				d3.v2Normal = d3.normal;
				d3.v3Normal = d3.normal;
				d3.v4Normal = d3.normal;
				draw3DQuadWith(d3,1,0,0,1);
			}
		}
		//ballHealth = 900;
		if(touchingThis.Alpha == 0.515 && touchingThis.Blue == 0 && touchingThis.Green == 1 && touchingThis.Red == 0 && touching && ballHealth < 1000)
		{
			GL11.glEnable(GL11.GL_LIGHT6);
			GL11.glLight(GL11.GL_LIGHT6, GL11.GL_DIFFUSE, floatBuffer((float)(0),(float)(0.4),(float)(0),1));
		    GL11.glLight(GL11.GL_LIGHT6,GL11.GL_POSITION,floatBuffer((float)pos.x,(float)pos.y + 3,(float)pos.z,1));
		    GL11.glLight(GL11.GL_LIGHT6, GL11.GL_AMBIENT, floatBuffer((float)0,(float)0,(float)0,1));
		    GL11.glLight(GL11.GL_LIGHT6, GL11.GL_SPECULAR, floatBuffer((float)0,(float)1,(float)0,1));
		    if(ballHealth < 1000)
		    {
		    	velo.x = velo.x * 0.5;
		    	velo.z = velo.z * 0.5;
		    	velo.y = velo.y * 0.5;
		    }
		    if(ballHealth == 999)
		    {
		    	GL11.glDisable(GL11.GL_LIGHT6);
		    }
			double plusY = -0.3;
			for(int i = 0; i < 1; i ++)
			{
				healDirY = healDirY + 181;
				Particle p = new Particle();
				p.pos.x = pos.x + (Math.sin(Math.toRadians(healDirY)) * 2);
				p.pos.y = pos.y + plusY;
				p.pos.z = pos.z + (Math.cos(Math.toRadians(healDirY)) * 2);
				p.velo.x = velo.x + (Math.sin(Math.toRadians(healDirY + 90)) * 0.15);
				p.velo.y = velo.y + 0.01;
				p.velo.z = velo.z + (Math.cos(Math.toRadians(healDirY + 90)) * 0.15);
				p.orbitPoint.x = pos.x;
				p.orbitPoint.y = pos.y;
				p.orbitPoint.z = pos.z;
				p.gravity.x = 0;
				p.gravity.y = 0;
				p.gravity.z = 0;
				p.Red = 0;
				p.Green = 1;
				p.Blue = 0;
				p.size = 0.2;
				p.Type = 2;
				p.sizeChange = 0;
				p.airForce = false;
				particles.add(p);
				//plusY = Math.random() * 2 - 0.5;
			}
		}
		else
		{
			GL11.glDisable(GL11.GL_LIGHT6);
		}
		if(lightningOn * slowMo > 130)
		{
			
			lightningOn --;
			drawLightningAt(lightningFrom,pos);
			drawLightningAt(lightningFrom,pos);
			ballHealth = ballHealth - 1;
		}
		else if(lightningOn * slowMo > 0)
		{
			ballHealth = ballHealth - 0.1;
			lightningOn --;
			for(int i = 0; i < (lightningOn / 13); i ++)
			{
				Vector Randoms = new Vector();
				Randoms.x = pos.x + (Math.random() * 2 - 1);
				Randoms.y = pos.y + (Math.random() * 2 - 1);
				Randoms.z = pos.z + (Math.random() * 2 - 1);
				drawLightningAt(pos,Randoms);
			}
		}
		else
		{
			if(!lightningFrom.equals(touchingThis))
			{
				lightningFrom = new Vector();
			}
		}
		
		
		//addParticles(-10, 1, -10,1, 1, 1, 1);
		if(Keyboard.isKeyDown(Keyboard.KEY_H))
		{
			velo.x = 0;
			velo.y = 0;
			velo.z = 0;
			gravity.x = 0;
			gravity.z = 0;
			gravity.y = 0;
			pos = editPos;
		}




		Make3D();
		//drawFullPlayer();
		//lightDir = lightDir + 3;
		/**
			if(lightDir > 100)
			{
				velo.y = 0;
				pos.y = 10;
				pos.z = 0;
				pos.x = 0;
				lights.clear();
				createLightAt(10,10,10,10);
				data.clear();
				draw3DMap();
				intro = 1;
			}
		 */
		//draw3DLine(pos.x,pos.y + 0.5,pos.z,pos.x + (Math.sin(Math.toRadians(characterDir)) * 1),pos.y + 0.5,pos.z + (Math.cos(Math.toRadians(characterDir)) * 1),1,1,1);
		//draw3DLine(pos.x,pos.y,pos.z,pos.x,pos.y + 1,pos.z,1,1,1);
		Lights light = lights.get(0);
		if(changeAndUpdate >= 1 && light.light.y < 3000)
		{
			addParticles(0,0.4,0,1,0.3,0,3,0.006,true,-0.007,2);
			addParticles(0,0.7,0,0.6,0.6,0.6,1,0.0006,true,-0.007,2);
			changeAndUpdate = 0;
		}
		changeAndUpdate = changeAndUpdate + (1 / slowMo);
		
		draw3DLine(editPos.x,editPos.y,editPos.z,editPos.x,editPos.y + 1,editPos.z,1,1,1,1);
		if(mode == 0)
		{

			if(PauseAll == false)
			{
				editor();
				if(Mouse.getY() < 150)
				{
					//OperateAndDrawPopUp();
				}
			}

		}
		else
		{
			if(Mouse.getY() < 150)
			{
				OperateAndDrawPopUpBall();
			}
		}

		if(mode == 1)
		{
			cameraX = (-pos.x);
			cameraY = (-pos.y);
			cameraZ = (-pos.z);


		}
		else
		{
			cameraX = (-editPos.x);
			cameraY = (-editPos.y);
			cameraZ = (-editPos.z);
		}

		
		if(Paused)
		{
			Options();
			
		}
		else
		{
			healthBar();
		}
		Make2D();
		if(Paused)
		{
			
				if(EditTool == 0)
				{
					
					if(draw2DQuadDec(20,700,20, 770,90,770,90,700,0.3,0.5,0.9,0.2,1,1,0.2))
					{
						if(Mouse.isButtonDown(0))
						{
							if(MouseSensedDown == false)
							{
								PauseAll = true;
								EditTool = 1;
								MouseSensedDown = true;
							}
						}
						else
						{
							MouseSensedDown = false;
						}
					}
					if(draw2DQuadDec(110,700,110, 770,180,770,180,700,0,0.8,0.2,0.2,1,1,0.2))
					{
						if(Mouse.isButtonDown(0))
						{
							if(MouseSensedDown == false)
							{
								PauseAll = true;
								EditTool = 2;
								MouseSensedDown = true;
							}
						}
						else
						{
							MouseSensedDown = false;
						}
					}
					
				}
				else if(EditTool == 1)
				{
					if(draw2DQuadDec(20,700,20, 770,90,770,90,700,0.7,0.5,0.1,0.2,1,1,0.2))
					{
						if(Mouse.isButtonDown(0))
						{
							if(MouseSensedDown == false)
							{
								PauseAll = false;
								EditTool = 0;
								MouseSensedDown = true;
								CamY = 0;
							}
						}
						else
						{
							MouseSensedDown = false;
						}
					}
				}
				else if(EditTool == 2)
				{
					if(draw2DQuadDec(20,700,20, 770,90,770,90,700,0,0.2,0.8,0.2,1,1,0.2))
					{
						if(Mouse.isButtonDown(0))
						{
							if(MouseSensedDown == false)
							{
								PauseAll = false;
								EditTool = 0;
								CamY = 0;
								MouseSensedDown = true;
							}
						}
						else
						{
							MouseSensedDown = false;
						}
					}
				}
			}
		
		if(EditTool == 1)
		{
			dropDownSchematics();
		}
		if(EditTool == 2)
		{
			EditPosSpots();
		}
		
		//DrawText("" + collected + "/" + totalCollect,50,100,20,0,0,0);
		
		
		if(selectItem)
		{

			selectItems();
		}
		if(shapesEditor)
		{
			Shapes();
		}
		//healthBar();
		if(Paused == false)
		{
			healthBar();
		}
	}
	public void drawFullPlayer()
	{
		List<Rotators> rotating = new ArrayList<Rotators>();
		for(int i = 0; i < Player.size(); i ++)
		{
			Rotators r = Player.get(i);
			Rotators j = new Rotators();
			j.facing.x = r.facing.x + 0;
			j.facing.y = r.facing.y + 0;
			j.facing.z = r.facing.z + 0;
			j.pos.x = r.pos.x + 0;
			j.pos.y = r.pos.y + 0;
			j.pos.z = r.pos.z + 0;
			j.Rotate.x = r.Rotate.x + 0;
			j.Rotate.y = r.Rotate.y + 0;
			j.Rotate.z = r.Rotate.z + 0;
			j.RotateAround.x = r.RotateAround.x + 0;
			j.RotateAround.y = r.RotateAround.y + 0;
			j.RotateAround.z = r.RotateAround.z + 0;
			j.RotateAngles = r.RotateAngles;
			j.RotateOn = r.RotateOn;
			j.RotateOn2 = r.RotateOn2;
			j.position = pos;
			for(int t = 0; t < r.points.size(); t ++)
			{
				Data d = r.points.get(t);
				Data k = new Data();
				k.v1.x = d.v1.x + 0;
				k.v1.y = d.v1.y + 0;
				k.v1.z = d.v1.z + 0;
				k.v2.x = d.v2.x + 0;
				k.v2.y = d.v2.y + 0;
				k.v2.z = d.v2.z + 0;
				k.v3.x = d.v3.x + 0;
				k.v3.y = d.v3.y + 0;
				k.v3.z = d.v3.z + 0;
				k.normal.x = d.normal.x + 0;
				k.normal.y = d.normal.y + 0;
				k.normal.z = d.normal.z + 0;
				k.v1Normal = k.normal;
				k.v2Normal = k.normal;
				k.v3Normal = k.normal;
				k.Red = d.Red;
				k.Green = d.Green;
				k.Blue = d.Blue;
				j.points.add(k);
			}
			rotating.add(j);
		}
		drawPlayer(1,rotating);
	}
	public void resetPlayer()
	{
		for(int i = 0; i < Player.size(); i ++)
		{
			Rotators r = Player.get(i);
			Quaternion Rotate = new Quaternion();
			
			float RotateX = (float)0;
			float RotateY = (float)0;
			float RotateZ = (float)0;
			
			for(int z = 0; z < 3; z ++)
			{
				if((r.facing.x - RotateX) == 0 && (r.facing.y - RotateY) == 0 && (r.facing.z - RotateZ) == 0)
				{
					Rotate.setFromAxisAngle(new Vector4f(1,1,1,0));
				}
				else
				{
					if(z == 0)
					{
						Rotate.setFromAxisAngle(new Vector4f(1,0,0,(((float)(r.facing.x) - RotateX) / 57)));
					}
					if(z == 1)
					{
						Rotate.setFromAxisAngle(new Vector4f(0,1,0,(((float)r.facing.y - RotateY) / 57)));
					}
					if(z == 2)
					{
						Rotate.setFromAxisAngle(new Vector4f(0,0,1,((float)r.facing.z - RotateZ) / 57));
					}
				}
				for(int t = 0; t < r.points.size(); t ++)
				{
					Data d = r.points.get(t);
					
					
					//r.facing.setFromAxisAngle(new Vector4f((float)RotateX,(float)RotateY,(float)RotateZ,(float)Math.PI *((float)RotateW)));
					Quaternion p = new Quaternion((float)(d.v1.x),(float)(d.v1.y),(float)(d.v1.z),0);
					p = Quaternion.mulInverse(Quaternion.mul(Rotate,p,p),Rotate,p);
					d.v1.x = p.x;
					d.v1.y = p.y;
					d.v1.z = p.z;
	
					p = new Quaternion((float)(d.v2.x),(float)(d.v2.y),(float)(d.v2.z),0);
					p = Quaternion.mulInverse(Quaternion.mul(Rotate,p,p),Rotate,p);
					d.v2.x = p.x;
					d.v2.y = p.y;
					d.v2.z = p.z;
	
					p = new Quaternion((float)(d.v3.x),(float)(d.v3.y),(float)(d.v3.z),0);
					p = Quaternion.mulInverse(Quaternion.mul(Rotate,p,p),Rotate,p);
					d.v3.x = p.x;
					d.v3.y = p.y;
					d.v3.z = p.z;
					d.normal = getSurfaceNormal(d);
					d.v1Normal = d.normal;
					d.v2Normal = d.normal;
					d.v3Normal = d.normal;
					
					
					
				}
			}
			
			r.facing.x = RotateX;
			r.facing.y = RotateY;
			r.facing.z = RotateZ;
		}
	}
	public void drawPlayer(int playerCostume,List<Rotators> RotatePoints)
	{
		
		//System.out.println(PlayerDirY);
		double direction = 0;
		for(int i = 0; i < RotatePoints.size(); i ++)
		{
			Rotators r = RotatePoints.get(i);
			Quaternion Rotate = new Quaternion();
			
			if(i == 0)
			{
				r.Rotate.y = PlayerDirY;
				direction = r.Rotate.y;
			}
			if(i == 1)
			{
				//r.Rotate.x = cameraDirX;
				r.Rotate.y = PlayerDirY;
				
			}
			if(i == 2)
			{
				r.Rotate.y = direction;
				r.pos.x = Math.cos(Math.toRadians(direction)) * 0.15 * 3;
				r.pos.z = Math.sin(Math.toRadians(direction)) * 0.15 * 3;
				
			}
			if(i == 3)
			{
				r.Rotate.y = direction;
				r.pos.x = Math.cos(Math.toRadians(direction)) * -0.15 * 3;
				r.pos.z = Math.sin(Math.toRadians(direction)) * -0.15 * 3;
				
			}
			if(i == 4)
			{
				r.Rotate.y = direction;
				
			}
			if(i == 5)
			{
				r.Rotate.y = direction;
				
			}
			if(i == 6)
			{
				r.Rotate.y = direction;
				r.pos.x = Math.cos(Math.toRadians(direction)) * -0.1 * 3;
				r.pos.z = Math.sin(Math.toRadians(direction)) * -0.1 * 3;
			}
			if(i == 7)
			{
				r.Rotate.y = direction;
				r.pos.x = Math.cos(Math.toRadians(direction)) * 0.1 * 3;
				r.pos.z = Math.sin(Math.toRadians(direction)) * 0.1 * 3;
			}
			if(r.Rotate.y > 180)
			{
				r.Rotate.y = -180 + (r.Rotate.y - 180);
			}
			if(r.Rotate.y < -180)
			{
				r.Rotate.y = 180 + (r.Rotate.y + 180);
			}
			
			
			
			r.RotateOn2 ++;
			if(r.RotateOn2 > movementSpeed)
			{
				r.RotateOn2 = 1;
				r.RotateOn ++;
				if(onThisMovement[0] != switchMovement[0])
				{
					switchMovement[0] = onThisMovement[0];
				}
			}
			if(r.RotateOn >= r.RotateAngles.get(onThisMovement[0]).angles.size())
			{
				r.RotateOn2 = movementSpeed;
				r.RotateOn = 0;
			}
			Vector addRotate = r.RotateAngles.get(onThisMovement[0]).angles.get(r.RotateOn);
			Vector lastRotate = new Vector();
			if(onThisMovement[0] == switchMovement[0])
			{
				switchMovement[1] = r.RotateOn;
				switchMovement[2] = r.RotateOn2;
				if(r.RotateOn == 0)
				{
					lastRotate = r.RotateAngles.get(onThisMovement[0]).angles.get(r.RotateAngles.get(0).angles.size() - 1);
				}
				else
				{
					lastRotate = r.RotateAngles.get(onThisMovement[0]).angles.get(r.RotateOn - 1);
				}
			}
			else
			{
				
					lastRotate = r.RotateAngles.get(switchMovement[0]).angles.get(switchMovement[1]);
					if(switchMovement[1] == 0)
					{
						lastRotate = r.RotateAngles.get(switchMovement[0]).angles.get(r.RotateAngles.get(0).angles.size() - 1);
					}
					else
					{
						lastRotate = r.RotateAngles.get(switchMovement[0]).angles.get(switchMovement[1] - 1);
					}
					Vector switchRotate = new Vector();
					switchRotate = r.RotateAngles.get(switchMovement[0]).angles.get(switchMovement[1]);
					switchRotate = switchRotate.subtract(lastRotate);
					switchRotate = switchRotate.divideNon(movementSpeed);
					switchRotate = switchRotate.multiplyNonVec(switchMovement[2]);
					switchRotate = switchRotate.add(lastRotate);
					lastRotate = switchRotate;
					
			}
			addRotate = addRotate.subtract(lastRotate);
			addRotate = addRotate.divideNon(movementSpeed);
			addRotate = addRotate.multiplyNonVec(r.RotateOn2);
			addRotate = addRotate.add(lastRotate);
			
			float RotateX = (float)(r.Rotate.x + addRotate.x);
			float RotateY = (float)(r.Rotate.y + addRotate.y);
			float RotateZ = (float)(r.Rotate.z + addRotate.z);
			for(int z = 0; z < 3; z ++)
			{
				
				if((r.facing.x - RotateX) == 0 && (r.facing.y - RotateY) == 0 && (r.facing.z - RotateZ) == 0)
				{
					Rotate.setFromAxisAngle(new Vector4f(1,1,1,0));
				}
				else
				{
					if(z == 0)
					{
						//Rotate.setFromAxisAngle(new Vector4f(1,0,0,(((float)((r.facing.x) - RotateX)) / 57)));
						Rotate.setFromAxisAngle(new Vector4f(1,0,0,(((float)((r.facing.x) - RotateX)) / 57)));
					}
					if(z == 2)
					{
						Rotate.setFromAxisAngle(new Vector4f(0,1,0,(((float)(r.facing.y - RotateY)) / 57)));
					}
					if(z == 1)
					{
						Rotate.setFromAxisAngle(new Vector4f(0,0,1,((float)(r.facing.z - RotateZ)) / 57));
					}
				}
				for(int t = 0; t < r.points.size(); t ++)
				{
					Data d = r.points.get(t);
					
					
					//r.facing.setFromAxisAngle(new Vector4f((float)RotateX,(float)RotateY,(float)RotateZ,(float)Math.PI *((float)RotateW)));
					Quaternion p = new Quaternion((float)(d.v1.x),(float)(d.v1.y),(float)(d.v1.z),0);
					p = Quaternion.mulInverse(Quaternion.mul(Rotate,p,p),Rotate,p);
					d.v1.x = p.x;
					d.v1.y = p.y;
					d.v1.z = p.z;
	
					p = new Quaternion((float)(d.v2.x),(float)(d.v2.y),(float)(d.v2.z),0);
					p = Quaternion.mulInverse(Quaternion.mul(Rotate,p,p),Rotate,p);
					d.v2.x = p.x;
					d.v2.y = p.y;
					d.v2.z = p.z;
	
					p = new Quaternion((float)(d.v3.x),(float)(d.v3.y),(float)(d.v3.z),0);
					p = Quaternion.mulInverse(Quaternion.mul(Rotate,p,p),Rotate,p);
					d.v3.x = p.x;
					d.v3.y = p.y;
					d.v3.z = p.z;
					d.normal = getSurfaceNormal(d);
					d.v1Normal = d.normal;
					d.v2Normal = d.normal;
					d.v3Normal = d.normal;
					if(z == 2)
					{
						DrawPosVecMath(d,r.position,r.pos);
					}
					
				}
			}
			r.facing.x = RotateX;
			r.facing.y = RotateY;
			r.facing.z = RotateZ;
		}
		for(int i = 0; i < RotatePoints.size(); i ++)
		{
			Rotators r = RotatePoints.get(i);
			Rotators t = Player.get(i);
			t.Rotate.x = r.Rotate.x;
			t.Rotate.y = r.Rotate.y;
			t.Rotate.z = r.Rotate.z;
			t.RotateOn = r.RotateOn;
			t.RotateOn2 = r.RotateOn2;
			
			
		}
	}
	public void DrawPosVecMath(Data d, Vector Pos,Vector objectPos)
	{
		Data data = new Data();
		data.Red = d.Red;
		data.Green = d.Green;
		data.Blue = d.Blue;
		data.normal = d.normal;
		data.v1Normal = d.v1Normal;
		data.v2Normal = d.v2Normal;
		data.v3Normal = d.v3Normal;
		data.v1 = d.v1.add(Pos.add(objectPos));
		data.v2 = d.v2.add(Pos.add(objectPos));
		data.v3 = d.v3.add(Pos.add(objectPos));
		data.mid = d.v1.add(d.v2.add(d.v3));
		data.mid = data.mid.divideNon(3);
		//VectorMath(data,0,0,0);
		draw3DTriangle(data);
	}
	public void EditPosSpots()
	{
		double MouseDWheel = Mouse.getDWheel();
		CamY = CamY + (MouseDWheel / 100);
		if(CamY > 0)
		{
			CamY = 0;
		}
		if(CamY < SavedPos.size() * -35)
		{
			CamY = SavedPos.size() * -35;
		}
		draw2DQuad(100,200,100,750,820,750,820,200,0.3,0.3,0.3,0.1,0.9,0.9,0.1);
		if(draw2DQuadDec(220,620,220,700,500,700,500,620,0.2,0.6,0.9,0.1,0.9,0.9,0.1))
		{
			if(Mouse.isButtonDown(0))
			{
				if(MouseSensedDown2 == false)
				{
					MouseSensedDown2 = true;
					Vector newPos = new Vector();
					newPos.x = editPos.x;
					newPos.y = editPos.y;
					newPos.z = editPos.z;
					SavedPos.add(newPos);
				}
			}
			else
			{
				MouseSensedDown2 = false;
			}
		}
		DrawText("Save Position",240,660,5,1,1,1);
		int Y = 550;
		for(int i = 0; i < SavedPos.size(); i ++)
		{
			Vector thisPos = SavedPos.get(i);
			double drawY1 = (0 + Y) - CamY;
			double drawY2 = (Y + 35) - CamY;
			if(drawY1 <= 200)
			{
				drawY1 = 200;
				if(drawY2 <= 200)
				{
					drawY2 = 200;
				}
			}
			if(drawY2 >= 600)
			{
				drawY2 = 600;
				if(drawY1 >= 600)
				{
					drawY1 = 600;
				}
			}
			boolean inside = false;
			if(draw2DQuadDec(200,drawY1,200,drawY2,700,drawY2,700,drawY1,0.3,0.7,1,0.2,1,1,0.2))
			{
				if(Mouse.isButtonDown(0))
				{
					if(MouseSensedDown2 == false)
					{
						MouseSensedDown2 = true;
						SelectedPos = thisPos;
					}
				}
				else
				{
					MouseSensedDown2 = false;
				}
				Y = Y - 3;
				inside = true;
			}
			if((int)Math.round(Y + 15) - (int)Math.round(CamY) <= 595 && (int)Math.round(Y + 15) - (int)Math.round(CamY) >= 210)
			{
				DrawText("X: " + Math.round(thisPos.x) + "  Y: " + Math.round(thisPos.y) + "  Z: " + Math.round(thisPos.z),220,(int)Math.round(Y + 15) - (int)Math.round(CamY),5,1,1,1);
			}
			if(inside)
			{
				Y = Y + 3;
			}
			Y = Y - 50;
			if(draw2DQuadDec(700,drawY1,700,drawY2,750,drawY2,750,drawY1,1,0,0,0.2,1,1,0.2))
			{
				if(Mouse.isButtonDown(0))
				{
					if(MouseSensedDown2 == false)
					{
						MouseSensedDown2 = true;
						SavedPos.remove(i);
					}
				}
				else
				{
					MouseSensedDown2 = false;
				}
				
			}
			
		}
		if(draw2DQuadDec(520,620,520,700,600,700,600,620,0.2,0.9,0.9,0.1,0.9,0.9,0.1))
		{
			if(Mouse.isButtonDown(0))
			{
				if(MouseSensedDown2 == false)
				{
					MouseSensedDown2 = true;
					editPos.x = SelectedPos.x;
				}
			}
			else
			{
				MouseSensedDown2 = false;
			}
		}
		DrawText("Set X",530,660,5,1,1,1);
		if(draw2DQuadDec(620,620,620,700,700,700,700,620,0.2,0.9,0.9,0.1,0.9,0.9,0.1))
		{
			if(Mouse.isButtonDown(0))
			{
				if(MouseSensedDown2 == false)
				{
					MouseSensedDown2 = true;
					editPos.y = SelectedPos.y;
					
				}
			}
			else
			{
				MouseSensedDown2 = false;
			}
		}
		DrawText("Set Y",630,660,5,1,1,1);
		if(draw2DQuadDec(720,620,720,700,800,700,800,620,0.2,0.9,0.9,0.1,0.9,0.9,0.1))
		{
			if(Mouse.isButtonDown(0))
			{
				if(MouseSensedDown2 == false)
				{
					MouseSensedDown2 = true;
					editPos.z = SelectedPos.z;
				}
			}
			else
			{
				MouseSensedDown2 = false;
			}
		}
		DrawText("Set Z",730,660,5,1,1,1);
		
	}
	public void dropDownSchematics()
	{
		draw2DQuad(100,200,100,750,800,750,800,200,0.3,0.3,0.3,0.1,0.9,0.9,0.1);
		draw2DQuad(110,100,110,200,790,200,790,100,0.3,0.3,0.3,1.3,0.1,0.1,1.3);
		DrawText(currentSchematicName,130,150,10,1,1,1);
		double MouseDWheel = Mouse.getDWheel();
		CamY = CamY + (MouseDWheel / 100);
		String SchematicName = "";
		if(CamY > 0)
		{
			CamY = 0;
		}
		if(CamY < listSchematics.length * -35)
		{
			CamY = listSchematics.length * -35;
		}
		int Y = 600;
		for(int i = 0; i < listSchematics.length; i ++)
		{
			double drawY1 = (0 + Y) - CamY;
			double drawY2 = (Y + 35) - CamY;
			if(drawY1 <= 200)
			{
				drawY1 = 200;
				if(drawY2 <= 200)
				{
					drawY2 = 200;
				}
			}
			if(drawY2 >= 750)
			{
				drawY2 = 750;
				if(drawY1 >= 750)
				{
					drawY1 = 750;
				}
			}
			
			if(draw2DQuadDec(200,drawY1,200,drawY2,700,drawY2,700,drawY1,0.3,0.7,1,0.2,1,0.8,0))
			{

				SchematicName = listSchematics[i];
				Y = Y - 3;
			}
			String currentName = listSchematics[i];

			DrawText(currentName,220,(int)Math.round(Y + 15) - (int)Math.round(CamY),10,1,1,1);
			Y = Y - 50;
			if(currentName == SchematicName)
			{
				Y = Y + 3;
			}
		}
		if(Mouse.isButtonDown(0) && !SchematicName.equalsIgnoreCase(""))
		{
			if(MouseSensedDown2 == false)
			{
				schematicLoaded = true;
				MouseSensedDown2 = true;
				currentSchematic = Map.returnSchematic(SchematicName);
				currentSchematicName = SchematicName;
			}
		}
		else
		{
			MouseSensedDown2 = false;
		}
	}
	public void selectItems()
	{

		draw2DQuad(0,0,0,1000,1000,1000,1000,0,1,1,1,0.2,1,1,0.2);
		Make2D();
		Paused = true;
		if(Keyboard.isKeyDown(Keyboard.KEY_ESCAPE))
		{
			selectItem = false;
		}
		if(Mouse.isGrabbed())
		{
			Mouse.setGrabbed(false);
		}

		if(draw2DQuadDec(100 - scrollItem,600,100 - scrollItem,700,400 - scrollItem,700,400 - scrollItem,600,1,1,1,0.3,1,1,0.3))
		{
			if(Mouse.isButtonDown(0))
			{
				Items item = items.get(itemNumber);
				if(item.Type == 2)
				{
					totalCollect = totalCollect - 1;
					if(item.NoMore == false)
					{
						item.NoMore = true;
						collected = collected - 1;
					}
				}
				item.Type = 1;
				selectItem = false;
				item.rotate = new Rotators();
				item.rotate.points = setUpSphere(0,0,0,0.3,4,1);
				Paused = false;
				Mouse.setCursorPosition(screenWidth / 2,screenHeight / 2);
				Mouse.setGrabbed(true);

			}
		}
		DrawText("Gravity Pull", (int)Math.round(130 - scrollItem),650,10,1,1,1);
		if(draw2DQuadDec(450 - scrollItem,600,450 - scrollItem,700,750 - scrollItem,700,750 - scrollItem,600,1,1,1,0.3,1,1,0.3))
		{
			if(Mouse.isButtonDown(0))
			{
				Items item = items.get(itemNumber);
				item.Type = 2;
				totalCollect ++;
				selectItem = false;
				item.rotate = new Rotators();
				item.rotate.points = setUpSphere(0,0,0,1,4,1);
				Paused = false;
				Mouse.setCursorPosition(screenWidth / 2,screenHeight / 2);
				Mouse.setGrabbed(true);


			}
		}


		DrawText("Collectable", (int)Math.round(480 - scrollItem),650,10,1,1,1);
		if(draw2DQuadDec(800 - scrollItem,600,800 - scrollItem,700,1200 - scrollItem,700,1200 - scrollItem,600,1,1,1,0.3,1,1,0.3))
		{
			if(Mouse.isButtonDown(0))
			{
				Items item = items.get(itemNumber);
				if(item.Type == 2)
				{
					totalCollect = totalCollect - 1;
					if(item.NoMore == false)
					{
						item.NoMore = true;
						collected = collected - 1;
					}
				}
				item.Type = 3;
				selectItem = false;
				item.rotate = new Rotators();
				item.rotate.points = setUpSphere(0,0,0,0.8,3,1);
				Paused = false;
				Mouse.setCursorPosition(screenWidth / 2,screenHeight / 2);
				Mouse.setGrabbed(true);

			}
		}
		DrawText("Super Speed", (int)Math.round(880 - scrollItem),650,10,1,1,1);
		if(draw2DQuadDec(1250 - scrollItem,600,1250 - scrollItem,700,1550 - scrollItem,700,1550 - scrollItem,600,1,1,1,0.3,1,1,0.3))
		{
			if(Mouse.isButtonDown(0))
			{
				Items item = items.get(itemNumber);
				if(item.Type == 2)
				{
					totalCollect = totalCollect - 1;
					if(item.NoMore == false)
					{
						item.NoMore = true;
						collected = collected - 1;
					}
				}
				item.Type = 4;
				selectItem = false;
				item.rotate = new Rotators();
				item.rotate.points = setUpSphere(0,0,0,1,2,1);
				Paused = false;
				Mouse.setCursorPosition(screenWidth / 2,screenHeight / 2);
				Mouse.setGrabbed(true);

			}
		}
		DrawText("Super Jump", (int)Math.round(1280 - scrollItem),650,10,1,1,1);

		Make3D();
	}
	public void drawRotatable(Rotators r,Vector positions,double Red, double Green, double Blue,int Alpha)
	{
		for(int i = 0; i < r.points.size(); i ++)
		{
			Data d = r.points.get(i);
			
			drawRotated(d.v1,d.v2,d.v3,d.normal,Red,Green,Blue,positions,Alpha);
		}
	}
	public void drawPhysicalObjects(Rotators r)
	{
		
		box.pos = box.pos.add(box.velocity);
		box.velocity.y = box.velocity.y - 0.001;
		box.Rotate.x = box.torque.x;
		for(int i = 0; i < box.points.size(); i ++)
		{
			Data d = box.points.get(i);
			
			//System.out.println(i);
			//System.out.println(d.v1.x + "  " + d.v1.y + " " + d.v1.z);
			
				Quaternion q = new Quaternion();
				//q.setFromAxisAngle(new Vector4f(1,1,100,(float)Math.PI *((float)0)));
				q.setFromAxisAngle(new Vector4f((float)-1,(float)0,(float)0,(float)Math.PI *((float)box.torque.x)));
				
				Quaternion p = new Quaternion((float)d.v1.x,(float)d.v1.y,(float)d.v1.z,0);
				p = Quaternion.mulInverse(Quaternion.mul(q,p,p),q,p);
				d.v1.x = p.x;
				d.v1.y = p.y;
				d.v1.z = p.z;

				p = new Quaternion((float)d.v2.x,(float)d.v2.y,(float)d.v2.z,0);
				p = Quaternion.mulInverse(Quaternion.mul(q,p,p),q,p);
				d.v2.x = p.x;
				d.v2.y = p.y;
				d.v2.z = p.z;

				p = new Quaternion((float)d.v3.x,(float)d.v3.y,(float)d.v3.z,0);
				p = Quaternion.mulInverse(Quaternion.mul(q,p,p),q,p);
				d.v3.x = p.x;
				d.v3.y = p.y;
				d.v3.z = p.z;
				p = new Quaternion((float)d.v4.x,(float)d.v4.y,(float)d.v4.z,0);
				p = Quaternion.mulInverse(Quaternion.mul(q,p,p),q,p);
				d.v4.x = p.x;
				d.v4.y = p.y;
				d.v4.z = p.z;
				d.normal = getSurfaceNormal(d);
				//d.normal.x = d.normal.x * -1;
				d.v1Normal = d.normal;
				d.v2Normal = d.normal;
				d.v3Normal = d.normal;
				//System.out.println(d.normal.x);
				//newPoints.add(d);
				
				 for(int t = 0; t < EditorMap.mapData.size(); t ++)
				 {
					 Data j = EditorMap.mapData.get(t);
					 //double Result = d.v1.dot()
							 if(box.velocity.normalize().dot(j.normal) <= 0)
							 {
									Vector v = new Vector();
									v = (box.pos.add(d.v1)).subtract(j.mid);
									//v = v.normalize();
									double Result = v.dot(j.normal);
									if(Result < 0.15 && Result > -1)
									{
										if(checkPointInTriangle(box.pos.add(d.v1),j.v1,j.v2,j.v3))
										{
											double test = j.normal.dot(d.normal);
											/**
											Data k = new Data();
											Data l = new Data();
											if(i == 0)
											{
												k = box.points.get(box.points.size() - 1);
												l = box.points.get(i + 1);
											}
											else if(i == box.points.size() - 1)
											{
												k = box.points.get(i - 1);
												l = box.points.get(0);
											}
											else
											{
												k = box.points.get(i - 1);
												l = box.points.get(i + 1);
											}
											*/
											//double test2 = k.normal.dot(j.normal);
											box.Rotate.x = box.Rotate.x * test;
											//box.torque.x = box.torque.x * -0.999998;
											box.velocity.y = box.velocity.y * -0.8;
											
										}
									}
									/**
									v = new Vector();
									v = (box.pos.add(d.v2)).subtract(j.mid);
									//v = v.normalize();
									Result = v.dot(j.normal);
									if(Result < 0.15 && Result > -1)
									{
										if(checkPointInTriangle(box.pos.add(d.v2),j.v1,j.v2,j.v3))
										{
											box.Rotate.x = box.Rotate.x * -0.9998;
											//box.torque.x = box.torque.x * -0.999998;
											box.velocity.y = box.velocity.y * -0.8;
											
										}


									}
									v = new Vector();
									v = (box.pos.add(d.v3)).subtract(j.mid);
									//v = v.normalize();
									Result = v.dot(j.normal);
									if(Result < 0.15 && Result > -1)
									{
										if(checkPointInTriangle(box.pos.add(d.v3),j.v1,j.v2,j.v3))
										{
											box.Rotate.x = box.Rotate.x * -0.9998;
											//box.torque.x = box.torque.x * -0.999998;
											box.velocity.y = box.velocity.y * -0.8;
											
										}


									}
									v = new Vector();
									v = (box.pos.add(d.v4)).subtract(j.mid);
									//v = v.normalize();
									Result = v.dot(j.normal);
									if(Result < 0.15 && Result > -1)
									{
										if(checkPointInTriangle(box.pos.add(d.v4),j.v1,j.v2,j.v3))
										{
											
											box.Rotate.x = box.Rotate.x * -0.9998;
											//box.torque.x = box.torque.x * -0.999998;
											box.velocity.y = box.velocity.y * -0.8;
											
										}


									}
									*/
								}
					 
				 }
				 
				drawRotated(d.v1,d.v2,d.v3,d.v4,d.normal,r.pos,d.Red,d.Green,d.Blue);
				
			
		}
		box.torque.x = box.Rotate.x;
	}
	
	public void drawRotated(Vector v1, Vector v2, Vector v3,Vector v4,Vector normal,Vector pos,double Red, double Green, double Blue)
	{
		Data d = new Data();
		d.v1 = v1.add(pos);
		d.v2 = v2.add(pos);
		d.v3 = v3.add(pos);
		d.v4 = v4.add(pos);
		d.mid = v1.add(v2.add(v3.add(v4)));
		d.mid = d.mid.divideNon(4);
		d.Red = Red;
		d.Green = Green;
		d.Blue = Blue;
		d.normal = normal;
		Lights l = lights.get(1);
		Vector t = new Vector();
		t = d.mid.subtract(l.light);
		t.normalize();
		Distance3D(d.mid.x,d.mid.y,d.mid.z,l.light.x,l.light.y,l.light.z);
		double dot = d.normal.dot(t)/ -(d.normal.magnitude() * t.magnitude());
		dot = dot / (Distance / l.intensity);
		/**
		GL11.glBegin(GL11.GL_QUADS);
			GL11.glColor3d(Red * dot, Green * dot, Blue * dot);
			GL11.glVertex3d(d.v1.x, d.v1.y,d.v1.z);
			GL11.glColor3d(Red * dot, Green * dot, Blue * dot);
			// Right & Green
			GL11.glVertex3d(d.v2.x, d.v2.y,d.v2.z);
			GL11.glColor3d(Red * dot, Green * dot, Blue * dot);
			// Left & Blue
			GL11.glVertex3d(d.v3.x + cameraX, d.v3.y + cameraY,d.v3.z + cameraZ);
			GL11.glColor3d(Red * dot, Green * dot, Blue * dot);
			// Left & Blue
			GL11.glVertex3d(d.v4.x + cameraX, d.v4.y + cameraY,d.v4.z + cameraZ);
		GL11.glEnd();
	*/
		
	}
	public List<Data> RotateRotatable(Rotators r,double rotateX,double rotateY,double rotateZ,double rotateSpeed)
	{
		List<Data> newPoints = new ArrayList<Data>();
		for(int i = 0; i < r.points.size(); i ++)
		{
			Data d = r.points.get(i);
			Quaternion q = new Quaternion();
			q.setFromAxisAngle(new Vector4f((float)rotateY,(float)rotateX,(float)rotateZ,(float)Math.PI *((float)rotateSpeed)));
			Quaternion p = new Quaternion((float)d.v1.x,(float)d.v1.y,(float)d.v1.z,0);
			p = Quaternion.mulInverse(Quaternion.mul(q,p,p),q,p);
			d.v1.x = p.x;
			d.v1.y = p.y;
			d.v1.z = p.z;

			p = new Quaternion((float)d.v2.x,(float)d.v2.y,(float)d.v2.z,0);
			p = Quaternion.mulInverse(Quaternion.mul(q,p,p),q,p);
			d.v2.x = p.x;
			d.v2.y = p.y;
			d.v2.z = p.z;

			p = new Quaternion((float)d.v3.x,(float)d.v3.y,(float)d.v3.z,0);
			p = Quaternion.mulInverse(Quaternion.mul(q,p,p),q,p);
			d.v3.x = p.x;
			d.v3.y = p.y;
			d.v3.z = p.z;
			d.normal = getSurfaceNormal(d);
			d.v1Normal = d.normal;
			d.v2Normal = d.normal;
			d.v3Normal = d.normal;
			newPoints.add(d);
		}
		return newPoints;
	}
	public void goThroughTris()
	{
		for(int i = 0; i < data.size(); i ++)
		{
			Data d = data.get(i);
			Distance3D(d.mid.x,d.mid.y,d.mid.z,-cameraX,-cameraY,-cameraZ);
			if(Distance < 50)
			{
				particleCollides.add(d);
			}
		}
	}
	public void draw3DTriangleWithRotation(float x1, float y1, float z1, float x2, float y2, float z2,float x3,float y3,float z3,double Red, double Green,double Blue, double shade, double shade2, double shade3,float rotationX,float rotationY)
	{

		Quaternion q = new Quaternion();
		q.setFromAxisAngle(new Vector4f((float)(Math.sin(rotationY) * 10),(float)rotationX,(float)(Math.cos(Math.toRadians(rotationY)) * 10),(float)Math.PI*.25f));
		Quaternion p = new Quaternion(x1,y1,z1,0);
		p = Quaternion.mulInverse(Quaternion.mul(q,p,p),q,p);
		x1 = p.x;
		y1 = p.y;
		z1 = p.z;

		p = new Quaternion(x2,y2,z2,0);
		p = Quaternion.mulInverse(Quaternion.mul(q,p,p),q,p);
		x2 = p.x;
		y2 = p.y;
		z2 = p.z;

		p = new Quaternion(x3,y3,z3,0);
		p = Quaternion.mulInverse(Quaternion.mul(q,p,p),q,p);
		x3 = p.x;
		y3 = p.y;
		z3 = p.z;


		GL11.glBegin(GL11.GL_TRIANGLES);

		GL11.glColor3d(Red * (shade + gamma), Green * (shade + gamma), Blue * (shade + gamma));
		GL11.glVertex3d(x1 + cameraX, y1 + cameraY,z1 + cameraZ);

		GL11.glColor3d(Red * (shade2 + gamma), Green * (shade2 + gamma), Blue * (shade2 + gamma));
		// Right & Green
		GL11.glVertex3d(x2 + cameraX, y2 + cameraY,z2 + cameraZ);

		GL11.glColor3d(Red * (shade3 + gamma), Green * (shade3 + gamma), Blue * (shade3 + gamma));
		// Left & Blue
		GL11.glVertex3d(x3 + cameraX, y3 + cameraY,z3 + cameraZ);
		GL11.glEnd();



	}
	public List<Data> returnDataList(List<Data> d)
	{
		List<Data> dataa = new ArrayList<Data>();

		if(onlyRenderOne)
		{

			dataa.add(renderOnlyData);



		}
		else
		{
			dataa = d;
		}
		return dataa;
	}
	public void keyControl()
	{
		/**
		if(Keyboard.isKeyDown(Keyboard.KEY_RIGHT))
		{
			GL11.glRotatef(3,0,1,0);
			cameraDirY = cameraDirY - 3;


		}
		else if(Keyboard.isKeyDown(Keyboard.KEY_LEFT))
		{
			GL11.glRotatef(3,0,-1,0);
			cameraDirY = cameraDirY + 3;
		}
		*/
		double MouseDWheel = (Mouse.getDWheel());
		zoom = zoom + (MouseDWheel / 100);
		
		if(zoom > 0)
		{
			zoom = 0;
		}
		else if(zoom < -15)
		{
			zoom = -15;
		}
		/**
		if(Keyboard.isKeyDown(Keyboard.KEY_UP))
		{
			GL11.glRotatef(3,1,0,0);
			cameraDirX = cameraDirX + 3;

		}
		else if(Keyboard.isKeyDown(Keyboard.KEY_DOWN))
		{
			GL11.glRotatef(3,-1,0,0);
			cameraDirX = cameraDirX - 3;
		}
		 */
		/**
			if(Keyboard.isKeyDown(Keyboard.KEY_W))
			{
				lightZ = lightZ + 1;
			}
			else if(Keyboard.isKeyDown(Keyboard.KEY_S))
			{
				lightZ = lightZ - 1;
			}
			if(Keyboard.isKeyDown(Keyboard.KEY_A))
			{
				lightX = lightX + 1;
			}
			else if(Keyboard.isKeyDown(Keyboard.KEY_D))
			{
				lightX = lightX - 1;
			}
		 */

		if(mode == 1 && ((Math.abs(velo.y) + Math.abs(velo.z) + Math.abs(velo.x)) / 3) < 1)
		{
			touchingNoKey = true;
			if(Keyboard.isKeyDown(Keyboard.KEY_W) && !touching)
			{
				touchingNoKey = false;
				if(powerUpType == 1)
				{
					velo.x = velo.x - (Math.cos(Math.toRadians(cameraDirX)) * (Math.sin(Math.toRadians(cameraDirY))) * ((BallSpeed / 4) / slowMo));
					velo.y = velo.y + (Math.sin(Math.toRadians(cameraDirX)) * ((BallSpeed / 4) / slowMo));
					velo.z = velo.z - (Math.cos(Math.toRadians(cameraDirX)) * (Math.cos(Math.toRadians(cameraDirY))) * ((BallSpeed / 4) / slowMo));
				}
				else
				{
					velo.x = velo.x - ((Math.sin(Math.toRadians(cameraDirY))) * ((BallSpeed / 4) / slowMo));
					velo.z = velo.z - ((Math.cos(Math.toRadians(cameraDirY))) * ((BallSpeed / 4) / slowMo));
				}
			}
			if(Keyboard.isKeyDown(Keyboard.KEY_S) && !touching)
			{
				touchingNoKey = false;
				if(powerUpType == 1)
				{
					velo.x = velo.x - (Math.cos(Math.toRadians(cameraDirX)) * (Math.sin(Math.toRadians(cameraDirY))) * ((-BallSpeed / 4.1) / slowMo));
					velo.y = velo.y + (Math.sin(Math.toRadians(cameraDirX)) * ((-BallSpeed / 4.1) / slowMo));
					velo.z = velo.z - (Math.cos(Math.toRadians(cameraDirX)) * (Math.cos(Math.toRadians(cameraDirY))) * ((BallSpeed / 4.1) / slowMo));
				}
				else
				{
					velo.x = velo.x - ((Math.sin(Math.toRadians(cameraDirY))) * ((-BallSpeed / 4.1) / slowMo));
					velo.z = velo.z - ((Math.cos(Math.toRadians(cameraDirY))) * ((-BallSpeed / 4.1) / slowMo));
				}
			}

			if(Keyboard.isKeyDown(Keyboard.KEY_A) && !touching)
			{
				touchingNoKey = false;
				velo.x = velo.x + ((Math.sin(Math.toRadians(cameraDirY - 90))) * ((BallSpeed / 4.1) / slowMo));

				velo.z = velo.z + ((Math.cos(Math.toRadians(cameraDirY - 90))) * ((BallSpeed / 4.1) / slowMo));
			}
			if(Keyboard.isKeyDown(Keyboard.KEY_D) && !touching)
			{
				touchingNoKey = false;
				velo.x = velo.x + ((Math.sin(Math.toRadians(cameraDirY + 90))) * ((BallSpeed / 4.1) / slowMo));
				velo.z = velo.z + ((Math.cos(Math.toRadians(cameraDirY + 90))) * ((BallSpeed / 4.1) / slowMo));
			}
			/**
			if(Keyboard.isKeyDown(Keyboard.KEY_W) && touching)
			{
				touchingNoKey = false;
				if(powerUpType == 1)
				{
					velo.x = velo.x - (Math.cos(Math.toRadians(cameraDirX)) * (Math.sin(Math.toRadians(cameraDirY))) * ((BallSpeed / 1) / slowMo));
					velo.y = velo.y + (Math.sin(Math.toRadians(cameraDirX)) * ((BallSpeed / 1) / slowMo));
					velo.z = velo.z - (Math.cos(Math.toRadians(cameraDirX)) * (Math.cos(Math.toRadians(cameraDirY))) * ((BallSpeed / 1) / slowMo));
				}
				else
				{
					velo.x = velo.x -((Math.sin(Math.toRadians(cameraDirY))) * ((BallSpeed / 1) / slowMo));
					velo.y = velo.y + (Math.sin(Math.toRadians(cameraDirX)) * ((BallSpeed / 1) / slowMo));
					velo.z = velo.z -((Math.cos(Math.toRadians(cameraDirY))) * ((BallSpeed / 1) / slowMo));
				}
			}
			if(Keyboard.isKeyDown(Keyboard.KEY_S) && touching)
			{
				touchingNoKey = false;
				if(powerUpType == 1)
				{
					velo.x = velo.x - (Math.cos(Math.toRadians(cameraDirX)) * (Math.sin(Math.toRadians(cameraDirY))) * ((-BallSpeed / 1.1) / slowMo));
					velo.y = velo.y + (Math.sin(Math.toRadians(cameraDirX)) * ((-BallSpeed / 1.1) / slowMo));
					velo.z = velo.z - (Math.cos(Math.toRadians(cameraDirX)) * (Math.cos(Math.toRadians(cameraDirY))) * ((-BallSpeed / 1.1) / slowMo));
				}
				else
				{
					velo.x = velo.x - ((Math.sin(Math.toRadians(cameraDirY))) * ((-BallSpeed / 1.1) / slowMo));
					velo.y = velo.y + (Math.sin(Math.toRadians(cameraDirX)) * ((-BallSpeed / 1.1) / slowMo));
					velo.z = velo.z - ((Math.cos(Math.toRadians(cameraDirY))) * ((-BallSpeed / 1.1) / slowMo));
				}
			}

			if(Keyboard.isKeyDown(Keyboard.KEY_A) && touching)
			{
				touchingNoKey = false;
				velo.x = velo.x + ((Math.sin(Math.toRadians(cameraDirY - 90))) * ((BallSpeed / 1.1) / slowMo));

				velo.z = velo.z + ((Math.cos(Math.toRadians(cameraDirY - 90))) * ((BallSpeed / 1.1) / slowMo));
			}
			if(Keyboard.isKeyDown(Keyboard.KEY_D) && touching)
			{
				touchingNoKey = false;
				velo.x = velo.x + ((Math.sin(Math.toRadians(cameraDirY + 90))) * ((BallSpeed / 1.1) / slowMo));
				velo.z = velo.z + ((Math.cos(Math.toRadians(cameraDirY + 90))) * ((BallSpeed / 1.1) / slowMo));
			}
			*/
			 Vector gravitys = new Vector();
				gravitys.x = (veloXGravi);
				gravitys.y = -(veloYGravi);
				gravitys.z = (veloZGravi);
				//gravitys = touchingPlaneNormal;
				gravitys = gravitys.normalize();
				
				if(Keyboard.isKeyDown(Keyboard.KEY_W))
				{
					//velo.x = velo.x - (Math.cos(Math.toRadians(cameraDirZ)) * (Math.cos(Math.toRadians(cameraDirX)) * (Math.sin(Math.toRadians(cameraDirY)))) * ((BallSpeed / 1) / slowMo));
					touchingNoKey = false;
					if(gravitys.z > 0)
					{
						velo.y = velo.y + -(gravitys.z * (Math.cos(Math.toRadians(cameraDirX)) * Math.cos(Math.toRadians(cameraRotations.y)) * BallSpeed));
						velo.x = velo.x + (gravitys.z * (Math.cos(Math.toRadians(cameraDirX)) * Math.sin(Math.toRadians(cameraRotations.y)) * BallSpeed));
					}
					else
					{
						velo.y = velo.y + (gravitys.z * (Math.cos(Math.toRadians(cameraDirX)) * Math.cos(Math.toRadians(cameraRotations.y)) * BallSpeed));
						velo.x = velo.x + (gravitys.z * (Math.cos(Math.toRadians(cameraDirX)) * Math.sin(Math.toRadians(cameraRotations.y)) * BallSpeed));
					}
						velo.x = velo.x + (-gravitys.y * (Math.cos(Math.toRadians(cameraRotations.x)) * Math.sin(Math.toRadians(-cameraRotations.y)) * BallSpeed));
						velo.z = velo.z + (-gravitys.y * (Math.cos(Math.toRadians(cameraRotations.x)) * Math.cos(Math.toRadians(cameraRotations.y)) * BallSpeed));
						if(gravitys.x > 0)
						{
							velo.y = velo.y + (gravitys.x * (Math.cos(Math.toRadians(cameraRotations.x)) * Math.sin(Math.toRadians(cameraRotations.y)) * BallSpeed));
							velo.z = velo.z + (-gravitys.x * (Math.cos(Math.toRadians(cameraRotations.x)) * Math.cos(Math.toRadians(cameraRotations.y)) * BallSpeed));
						}
						else
						{
							velo.y = velo.y + (gravitys.x * (Math.cos(Math.toRadians(cameraRotations.x)) * Math.sin(Math.toRadians(cameraRotations.y)) * BallSpeed));
							velo.z = velo.z + (gravitys.x * (Math.cos(Math.toRadians(cameraRotations.x)) * Math.cos(Math.toRadians(cameraRotations.y)) * BallSpeed));
						}
						//velo.x = velo.x - (Math.cos(Math.toRadians(cameraDirX)) * (Math.sin(Math.toRadians(cameraDirY))) * ((BallSpeed / 1) / slowMo));
						//velo.y = velo.y + (Math.sin(Math.toRadians(cameraDirX)) * ((BallSpeed / 1) / slowMo));
						//velo.z = velo.z - (Math.cos(Math.toRadians(cameraDirX)) * (Math.cos(Math.toRadians(cameraDirY))) * ((BallSpeed / 1) / slowMo));
					
				}
				if(Keyboard.isKeyDown(Keyboard.KEY_S))
				{
					//velo.x = velo.x - (Math.cos(Math.toRadians(cameraDirZ)) * (Math.cos(Math.toRadians(cameraDirX)) * (Math.sin(Math.toRadians(cameraDirY)))) * ((BallSpeed / 1) / slowMo));
					touchingNoKey = false;
					if(gravitys.z > 0)
					{
						velo.y = velo.y + (gravitys.z * (Math.cos(Math.toRadians(cameraDirX)) * Math.cos(Math.toRadians(cameraRotations.y)) * BallSpeed));
						velo.x = velo.x + (-gravitys.z * (Math.cos(Math.toRadians(cameraDirX)) * Math.sin(Math.toRadians(cameraRotations.y)) * BallSpeed));
					}
					else
					{
						velo.y = velo.y + (-gravitys.z * (Math.cos(Math.toRadians(cameraDirX)) * Math.cos(Math.toRadians(cameraRotations.y)) * BallSpeed));
						velo.x = velo.x + (-gravitys.z * (Math.cos(Math.toRadians(cameraDirX)) * Math.sin(Math.toRadians(cameraRotations.y)) * BallSpeed));
					}
						velo.x = velo.x + (gravitys.y * (Math.cos(Math.toRadians(cameraRotations.x)) * Math.sin(Math.toRadians(-cameraRotations.y)) * BallSpeed));
						velo.z = velo.z + (gravitys.y * (Math.cos(Math.toRadians(cameraRotations.x)) * Math.cos(Math.toRadians(cameraRotations.y)) * BallSpeed));
						if(gravitys.x > 0)
						{
							velo.y = velo.y + (-gravitys.x * (Math.cos(Math.toRadians(cameraRotations.x)) * Math.sin(Math.toRadians(cameraRotations.y)) * BallSpeed));
							velo.z = velo.z + (gravitys.x * (Math.cos(Math.toRadians(cameraRotations.x)) * Math.cos(Math.toRadians(cameraRotations.y)) * BallSpeed));
						}
						else
						{
							velo.y = velo.y + (-gravitys.x * (Math.cos(Math.toRadians(cameraRotations.x)) * Math.sin(Math.toRadians(cameraRotations.y)) * BallSpeed));
							velo.z = velo.z + (-gravitys.x * (Math.cos(Math.toRadians(cameraRotations.x)) * Math.cos(Math.toRadians(cameraRotations.y)) * BallSpeed));
						}
							//velo.x = velo.x - (Math.cos(Math.toRadians(cameraDirX)) * (Math.sin(Math.toRadians(cameraDirY))) * ((BallSpeed / 1) / slowMo));
						//velo.y = velo.y + (Math.sin(Math.toRadians(cameraDirX)) * ((BallSpeed / 1) / slowMo));
						//velo.z = velo.z - (Math.cos(Math.toRadians(cameraDirX)) * (Math.cos(Math.toRadians(cameraDirY))) * ((BallSpeed / 1) / slowMo));
					
				}
				if(Keyboard.isKeyDown(Keyboard.KEY_A))
				{
					//velo.x = velo.x - (Math.cos(Math.toRadians(cameraDirZ)) * (Math.cos(Math.toRadians(cameraDirX)) * (Math.sin(Math.toRadians(cameraDirY)))) * ((BallSpeed / 1) / slowMo));
					touchingNoKey = false;
					if(gravitys.z > 0)
					{
						velo.y = velo.y + -(gravitys.z * (Math.cos(Math.toRadians(cameraDirX)) * Math.cos(Math.toRadians(cameraRotations.y - 90)) * BallSpeed));
						velo.x = velo.x + (gravitys.z * (Math.cos(Math.toRadians(cameraDirX)) * Math.sin(Math.toRadians(cameraRotations.y - 90)) * BallSpeed));
					}
					else
					{
						velo.y = velo.y + (gravitys.z * (Math.cos(Math.toRadians(cameraDirX)) * Math.cos(Math.toRadians(cameraRotations.y - 90)) * BallSpeed));
						velo.x = velo.x + (gravitys.z * (Math.cos(Math.toRadians(cameraDirX)) * Math.sin(Math.toRadians(cameraRotations.y - 90)) * BallSpeed));
					}
						velo.x = velo.x + (gravitys.y * (Math.cos(Math.toRadians(cameraRotations.x)) * Math.sin(Math.toRadians(cameraRotations.y - 90)) * BallSpeed));
						velo.z = velo.z + (-gravitys.y * (Math.cos(Math.toRadians(cameraRotations.x)) * Math.cos(Math.toRadians(cameraRotations.y - 90)) * BallSpeed));
						if(gravitys.x > 0)
						{
							velo.y = velo.y + (gravitys.x * (Math.cos(Math.toRadians(cameraRotations.x)) * Math.sin(Math.toRadians(cameraRotations.y - 90)) * BallSpeed));
							velo.z = velo.z + (-gravitys.x * (Math.cos(Math.toRadians(cameraRotations.x)) * Math.cos(Math.toRadians(cameraRotations.y - 90)) * BallSpeed));
						}
						else
						{
							velo.y = velo.y + (gravitys.x * (Math.cos(Math.toRadians(cameraRotations.x)) * Math.sin(Math.toRadians(cameraRotations.y - 90)) * BallSpeed));
							velo.z = velo.z + (gravitys.x * (Math.cos(Math.toRadians(cameraRotations.x)) * Math.cos(Math.toRadians(cameraRotations.y - 90)) * BallSpeed));
						}
							//velo.x = velo.x - (Math.cos(Math.toRadians(cameraDirX)) * (Math.sin(Math.toRadians(cameraDirY))) * ((BallSpeed / 1) / slowMo));
						//velo.y = velo.y + (Math.sin(Math.toRadians(cameraDirX)) * ((BallSpeed / 1) / slowMo));
						//velo.z = velo.z - (Math.cos(Math.toRadians(cameraDirX)) * (Math.cos(Math.toRadians(cameraDirY))) * ((BallSpeed / 1) / slowMo));
					
				}
				if(Keyboard.isKeyDown(Keyboard.KEY_D))
				{
					//velo.x = velo.x - (Math.cos(Math.toRadians(cameraDirZ)) * (Math.cos(Math.toRadians(cameraDirX)) * (Math.sin(Math.toRadians(cameraDirY)))) * ((BallSpeed / 1) / slowMo));
					touchingNoKey = false;
					if(gravitys.z > 0)
					{
						velo.y = velo.y + (gravitys.z * (Math.cos(Math.toRadians(cameraDirX)) * Math.cos(Math.toRadians(cameraRotations.y - 90)) * BallSpeed));
						velo.x = velo.x + (-gravitys.z * (Math.cos(Math.toRadians(cameraDirX)) * Math.sin(Math.toRadians(cameraRotations.y - 90)) * BallSpeed));
					}
					else
					{
						velo.y = velo.y + (-gravitys.z * (Math.cos(Math.toRadians(cameraDirX)) * Math.cos(Math.toRadians(cameraRotations.y - 90)) * BallSpeed));
						velo.x = velo.x + (-gravitys.z * (Math.cos(Math.toRadians(cameraDirX)) * Math.sin(Math.toRadians(cameraRotations.y - 90)) * BallSpeed));
					}
						velo.x = velo.x + (-gravitys.y * (Math.cos(Math.toRadians(cameraRotations.x)) * Math.sin(Math.toRadians(cameraRotations.y - 90)) * BallSpeed));
						velo.z = velo.z + (gravitys.y * (Math.cos(Math.toRadians(cameraRotations.x)) * Math.cos(Math.toRadians(cameraRotations.y - 90)) * BallSpeed));
						if(gravitys.x > 0)
						{
							velo.y = velo.y + (-gravitys.x * (Math.cos(Math.toRadians(cameraRotations.x)) * Math.sin(Math.toRadians(cameraRotations.y - 90)) * BallSpeed));
							velo.z = velo.z + (gravitys.x * (Math.cos(Math.toRadians(cameraRotations.x)) * Math.cos(Math.toRadians(cameraRotations.y - 90)) * BallSpeed));
						}
						else
						{
							velo.y = velo.y + (-gravitys.x * (Math.cos(Math.toRadians(cameraRotations.x)) * Math.sin(Math.toRadians(cameraRotations.y - 90)) * BallSpeed));
							velo.z = velo.z + (-gravitys.x * (Math.cos(Math.toRadians(cameraRotations.x)) * Math.cos(Math.toRadians(cameraRotations.y - 90)) * BallSpeed));
						}
							//velo.x = velo.x - (Math.cos(Math.toRadians(cameraDirX)) * (Math.sin(Math.toRadians(cameraDirY))) * ((BallSpeed / 1) / slowMo));
						//velo.y = velo.y + (Math.sin(Math.toRadians(cameraDirX)) * ((BallSpeed / 1) / slowMo));
						//velo.z = velo.z - (Math.cos(Math.toRadians(cameraDirX)) * (Math.cos(Math.toRadians(cameraDirY))) * ((BallSpeed / 1) / slowMo));
					
				}
			
			if(Keyboard.isKeyDown(Keyboard.KEY_SPACE))
			{
				if(touching == true)
				{
					velo.x = velo.x + (touchingPlaneNormal.x * 0.12);
					velo.y = velo.y + (touchingPlaneNormal.y * 0.12);
					velo.z = velo.z + (touchingPlaneNormal.z * 0.12);
					
				}
			}
			if(touchingNoKey == false)
			{
				//switchMovement(0,0,0);
				/**
					Vector q = new Vector();
					q.x = velo.x;
					q.z = velo.z;
					q = q.normalize();
					PlayerDirY = Math.toDegrees(Math.acos(-q.z));
					if(q.x < 0)
					{
						PlayerDirY = PlayerDirY * -1;
					}
					
				*/
			}
			else
			{
				if(touching == true)
				{
					//velo.x = velo.x * 0.9;
					//velo.z = velo.z * 0.9;
				}
				//switchMovement(1,0,0);
			}
		}

	}
	public void drawBackDrop(double Red, double Green,double Blue,double shade, double shade2, double shade3, double shade4)
	{

		Make2D();
		GL11.glBegin(GL11.GL_QUADS);
		GL11.glColor3d(Red * shade,Green * shade,Blue * shade);
		GL11.glVertex2f(0,0);
		GL11.glColor3d(Red * shade2,Green * shade2,Blue * shade2);

		GL11.glVertex2f(0,(1000 / 1000) * screenHeight);
		GL11.glColor3d(Red * shade3,Green * shade3,Blue * shade3);

		GL11.glVertex2f((1000 / 1000) * screenWidth,(1000 / 1000) * screenHeight);
		GL11.glColor3d(Red * shade4,Green * shade4,Blue * shade4);

		GL11.glVertex2f((1000 / 1000) * screenWidth,0);
		GL11.glEnd();


	}
	public void draw()
	{	

		//drawBackDrop(0.5,0.8,1,1,1,0.8,0.8);

		keyControl();
		RotateReferenceAxis(HorizontalSpeed,VerticalSpeed,RollingSpeed);

		gravity.y = -0.01;
		gravity.x = velo.x;
		gravity.z = velo.z;
		velo.y = velo.y + gravity.y;


		renderSort();

		//draw3DObject(lightX,lightY,lightZ,lightX + 1,lightY,lightZ,lightX + 1, lightY, lightZ + 1, lightX, lightY, lightZ + 1,1,1,1,1,1,1,1);
		draw3DLine(cameraX + FlashLightLeft.x,cameraY + 1, cameraZ + FlashLightLeft.z,cameraX,cameraY + 1,cameraZ,1,0,0,1);
		draw3DLine(cameraX + FlashLightRight.x,cameraY + 1, cameraZ + FlashLightRight.z,cameraX,cameraY + 1,cameraZ,1,0,0,1);





		/**
			Vector p1 = new Vector();
			p1.x = 0;
			p1.y = 0;
			p1.z = 10;
			Vector p2 = new Vector();
			p2.x = 10;
			p2.y = 0;
			p2.z = -10;
			Vector p3 = new Vector();
			p2.x = -10;
			p2.y = 0;
			p2.z = -10;
			collisionPacket.basePoint.x = 0;
			collisionPacket.basePoint.y = 0.4;
			collisionPacket.basePoint.z = 0;
			collisionPacket.velocity.x = 0;
			collisionPacket.velocity.y = 0;
			collisionPacket.velocity.y = 0;
			collisionCheck(p1,p2,p3);
		 */


		//draw3DLine(pos.x,pos.y, pos.z, pos.x, pos.y + 1, pos.z,1,1,1);
		//draw3DLine(pos.x,pos.y,pos.z,collisionPacket.intersectionPoint.x,collisionPacket.intersectionPoint.y,collisionPacket.intersectionPoint.z,1,1,1);

	}


	public void RotateReferenceAxis(double horiSpeed, double vertSpeed,double rollSpeed)
	{
		double cosHoriz = Math.cos(Math.toRadians(horiSpeed));
		double sinHoriz = Math.sin(Math.toRadians(horiSpeed));
		double cosVert = Math.cos(Math.toRadians(vertSpeed));
		double sinVert = Math.sin(Math.toRadians(vertSpeed));
		double cosRoll = Math.cos(Math.toRadians(rollSpeed));
		double sinRoll = Math.sin(Math.toRadians(rollSpeed));
		tmpx = (cosRoll * XarX) + (sinRoll * XarY);
		tmpy = (cosRoll * XarY) - (sinRoll * XarX);
		XarY = (cosVert * tmpy) + (sinVert * tmpy);
		tmpz = (cosVert * XarZ) - (sinVert * tmpy);
		XarX = (cosHoriz * tmpx) + (sinHoriz * tmpz);
		XarZ = (cosHoriz * tmpz) - (sinHoriz * tmpx);
		tmpx = (cosRoll * YarX) + (sinRoll * YarY);
		tmpy = (cosRoll * YarY) - (sinRoll * YarX);
		YarY = (cosVert * tmpy) + (sinVert * YarZ);
		tmpz = (cosVert * YarZ) + (sinVert * tmpy);
		YarX = (cosHoriz * tmpx) + (sinHoriz * tmpz);
		YarZ = (cosHoriz * tmpz) - (sinHoriz * tmpx);
		tmpx = (cosRoll * ZarX) + (sinRoll * ZarY);
		tmpy = (cosRoll * ZarY) - (sinRoll * ZarX);
		ZarY = (cosVert * tmpy) + (sinVert * ZarZ);
		tmpz = (cosVert * ZarZ) - (sinVert * tmpy);
		ZarX = (cosHoriz * tmpx) + (sinHoriz * tmpz);
		ZarZ = (cosHoriz * tmpz) - (sinHoriz * tmpx);
	}
	public void tmp(double X, double Y, double Z)
	{
		double offsetX = X - cameraX;
		double offsetY = Y - cameraY;
		double offsetZ = Z - cameraZ;
		tmpx = (XarX * offsetX) + (YarX * offsetY) + (ZarX * offsetZ);
		tmpy = (XarY * offsetX) + (YarY * offsetY) + (ZarY * offsetZ);
		tmpz = (XarZ * offsetX) + (YarZ * offsetY) + (ZarZ * offsetZ);

		if(tmpz >= 0)
		{
			if(tmpz < 0)
			{
				tmpz = 1;
			}
			tmpx = (tmpx * viewFactor) / (tmpz);
			tmpy = (tmpy * viewFactor) / (tmpz);
		}
		else
		{
			if(Math.abs(tmpz) < 1)
			{
				tmpz = -1;
			}
			tmpx = (tmpx * (viewFactor * 1)) * Math.abs(tmpz);
			tmpy = (tmpy * (viewFactor * 1)) * Math.abs(tmpz);
		}
		tmpx = tmpx + 500;
		tmpy = tmpy + 400;

	}
	public void renderSort()
	{
		Make3D();
		
		if(Math.abs(collidedZoom) > 2 || mode == 0)
		{
			drawRotatedSphere();
		}
		
		List<Data> translucent = new ArrayList<Data>();
		for(int i = 0; i < data.size(); i ++)
		{
			Data d = data.get(i);
			//Distance(cameraX, cameraY, cameraZ, d.mid.x, d.mid.y, d.mid.z);
			//d.Shine = 120;
			if(d.Alpha == 1)
			{
				draw3DTriangle(d);
			}
			else
			{
				translucent.add(d);
			}

		}
		particles();
		ItemTime();
		
		if(translucent.size() > 0)
		{
			GL11.glEnable(GL11.GL_BLEND);
			//GL11.glDisable(GL11.GL_CULL_FACE);
			//GL11.glDisable(GL11.GL_DEPTH_TEST);
			
			for(int i = 0; i < translucent.size(); i ++)
			{
				Data d = translucent.get(i);
				
				draw3DTriangle(d);
				if(d.Alpha == 0.885 && d.Blue == 1 && d.Green == 0.85 && d.Red == 0)
				{
					if(Math.round(Math.random() * lightningAmount) == 100 && d.lightning == 0)
					{
						Vector random = new Vector();
						random.x = d.mid.x + ((Math.random() * 5) - 2.5);
						random.y = d.mid.y + ((Math.random() * 5) - 2.5);
						random.z = d.mid.z + ((Math.random() * 5) - 2.5);
						drawLightningAt(d.mid,random);
						d.random = random;
						d.lightning = 20;
						GL11.glEnable(GL11.GL_BLEND);
					}
					if(d.lightning > 0)
					{
						d.lightning --;
						drawLightningAt(d.mid,d.random);
						GL11.glEnable(GL11.GL_BLEND);
					}
				}
				
			}
			GL11.glDisable(GL11.GL_BLEND);
			//GL11.glDisable(GL11.GL_CULL_FACE);
			
		}
		
		



	}
	public double getSmallZ(Data d)
	{
		tmp(d.v1.x,d.v1.y,d.v1.z);
		double tmpz1 = tmpz;
		tmp(d.v2.x,d.v2.y,d.v2.z);
		double tmpz2 = tmpz;
		tmp(d.v3.x,d.v3.y,d.v3.z);
		double tmpz3 = tmpz;
		if(tmpz1 < tmpz2)
		{
			if(tmpz1 < tmpz3)
			{
				tmpz = tmpz1;
			}
			else
			{
				tmpz = tmpz3;
			}
		}
		else
		{
			if(tmpz2 < tmpz3)
			{
				tmpz = tmpz2;
			}
			else
			{
				tmpz = tmpz3;
			}
		}
		return tmpz;
	}
	public void draw3DMap()
	{


		/**
			for(int t = 0; t < 20; t ++)
			{
				x = 0;
				z = z + 5;
				for(int i = 0; i < 20; i ++)
				{
					x = x + 5;
					setUpWall(x,-0.5,z,x + 5,-0.5,z,x + 5,-0.5,z + 5,x,-0.5,z + 5,1,1,1,1.2,0);
				}
			}
		 */
		//createLightAt(0,10,0,10);
		//createWallTypeAt(5,0,20,0);

		//Create lights

		currentMap = currentMap.returnMapNum(2);
		data = currentMap.mapData;



	}
	public List<Data> setUpSphere(double x, double y, double z,double size, double detail,int type)
	{
		
		List<Data> outCome = new ArrayList<Data>();
		double dir = 0;
		double dirY = 0;
		if(type == 0)
		{
			size = collisionPackage.eRadius.x;
		}
		double x1 = x + Math.sin(Math.toRadians(dirY)) * (Math.sin(Math.toRadians(dir)) * size);
		if(type == 0)
		{
			size = collisionPackage.eRadius.y;
		}
		double y1 = y + Math.cos(Math.toRadians(dirY)) * size;
		if(type == 0)
		{
			size = collisionPackage.eRadius.z;
		}
		double z1 = z + Math.sin(Math.toRadians(dirY)) * (Math.cos(Math.toRadians(dir)) * size);
		
		if(type == 0)
		{
			size = collisionPackage.eRadius.x;
		}
		double x2 = x + Math.sin(Math.toRadians(dirY)) * (Math.sin(Math.toRadians(dir)) * size);
		if(type == 0)
		{
			size = collisionPackage.eRadius.y;
		}
		double y2 = y + Math.cos(Math.toRadians(dirY)) * size;
		if(type == 0)
		{
			size = collisionPackage.eRadius.z;
		}
		double z2 = z + Math.sin(Math.toRadians(dirY)) * (Math.cos(Math.toRadians(dir)) * size);

		if(type == 0)
		{
			size = collisionPackage.eRadius.x;
		}
		double x3 = x + Math.sin(Math.toRadians(dirY)) * (Math.sin(Math.toRadians(dir)) * size);
		if(type == 0)
		{
			size = collisionPackage.eRadius.y;
		}
		double y3 = z + Math.cos(Math.toRadians(dirY)) * size;
		if(type == 0)
		{
			size = collisionPackage.eRadius.z;
		}
		double z3 = z + Math.sin(Math.toRadians(dirY)) * (Math.cos(Math.toRadians(dir)) * size);
		if(type == 0)
		{
			size = collisionPackage.eRadius.x;
		}
		double x4 = x + Math.sin(Math.toRadians(dirY)) * (Math.sin(Math.toRadians(dir)) * size);
		if(type == 0)
		{
			size = collisionPackage.eRadius.y;
		}
		double y4 = y + Math.cos(Math.toRadians(dirY)) * size;
		if(type == 0)
		{
			size = collisionPackage.eRadius.z;
		}
		
		double z4 = z + Math.sin(Math.toRadians(dirY)) * (Math.cos(Math.toRadians(dir)) * size);
		double texCord1 = 0;
		double texCord2 = 0;
		//dirY = dirY + ((360 / detail) / 2);
		if(type == 2)
		{
			detail = detail - 1;
		}
		for(int i = 0; i < (detail); i ++)
		{
			//System.out.println(( texCord2 + (1 / detail)));
			
			texCord1 = 0;
			
			for(int t = 0; t < (detail); t ++)
			{
				if(type == 0)
				{
					size = collisionPackage.eRadius.x;
				}
				x1 = x +  Math.sin(Math.toRadians(dirY)) * (Math.sin(Math.toRadians(dir)) * size);
				if(type == 0)
				{
					size = collisionPackage.eRadius.y;
				}
				y1 = y +  Math.cos(Math.toRadians(dirY)) * size;
				if(type == 0)
				{
					size = collisionPackage.eRadius.z;
				}
				z1 = z + Math.sin(Math.toRadians(dirY)) * (Math.cos(Math.toRadians(dir)) * size);
				dirY = dirY + ((360 / detail) / 2);
				if(type == 0)
				{
					size = collisionPackage.eRadius.x;
				}
				x2 = x + Math.sin(Math.toRadians(dirY)) * (Math.sin(Math.toRadians(dir)) * size);
				if(type == 0)
				{
					size = collisionPackage.eRadius.y;
				}
				y2 = y + Math.cos(Math.toRadians(dirY)) * size;
				if(type == 0)
				{
					size = collisionPackage.eRadius.z;
				}
				z2 = z + Math.sin(Math.toRadians(dirY)) * (Math.cos(Math.toRadians(dir)) * size);
				dir = dir + (360 / detail);
				if(type == 0)
				{
					size = collisionPackage.eRadius.x;
				}
				x3 = x + Math.sin(Math.toRadians(dirY)) * (Math.sin(Math.toRadians(dir)) * size);
				if(type == 0)
				{
					size = collisionPackage.eRadius.y;
				}
				y3 = y + Math.cos(Math.toRadians(dirY)) * size;
				if(type == 0)
				{
					size = collisionPackage.eRadius.z;
				}
				z3 = z + Math.sin(Math.toRadians(dirY)) * (Math.cos(Math.toRadians(dir)) * size);
				dirY = dirY - ((360 / detail) / 2);
				if(type == 0)
				{
					size = collisionPackage.eRadius.x;
				}
				x4 = x + Math.sin(Math.toRadians(dirY)) * (Math.sin(Math.toRadians(dir)) * size);
				if(type == 0)
				{
					size = collisionPackage.eRadius.y;
				}
				y4 = y + Math.cos(Math.toRadians(dirY)) * size;
				if(type == 0)
				{
					size = collisionPackage.eRadius.z;
				}
				z4 = z + Math.sin(Math.toRadians(dirY)) * (Math.cos(Math.toRadians(dir)) * size);
				Data j = new Data();
				//Data j = returnDataTri(x1,y1,z1,x2,y2,z2,x3,y3,z3,Math.random() * 0.1 + 0.2,Math.random() * 0.2 + 0.5,Math.random() * 0.5 + 0.5);
				if(type == 0)
				{
				
					j.v1.x = x1;
					j.v1.y = y1;
					j.v1.z = z1;
					j.v2.x = x2;
					j.v2.y = y2;
					j.v2.z = z2;
					j.v3.x = x3;
					j.v3.y = y3;
					j.v3.z = z3;
					j.v4.x = x4;
					j.v4.y = y4;
					j.v4.z = z4;
				
				j.normal = getSurfaceNormal(j);
				j.v1Normal = j.normal;
				j.v2Normal = j.normal;
				j.v3Normal = j.normal;
				j.v4Normal = j.normal;
				j.Red = 1;//Math.random() * 0.1 + 0.2;
				j.Green = 1;//Math.random() * 0.2 + 0.5;
				j.Blue = 1;//Math.random() * 0.5 + 0.5;
				j.tex1.x = texCord1;
				j.tex1.y = texCord2;
				if(texCord1 + (1 / detail) > 1)
				{
					j.tex4.x = 1;
				}
				else
				{
					j.tex4.x = texCord1 + (1 / detail);
				}
				j.tex4.y = texCord2;
				if(texCord1 + (1 / detail) > 1)
				{
					j.tex3.x = 1;
				}
				else
				{
					j.tex3.x = texCord1 + (1 / detail);
				}
				if(texCord2  + (1 / detail) > 1)
				{
					j.tex3.y = 1;
				}
				else
				{
					j.tex3.y = texCord2 + (1 / detail);
				}
				j.tex2.x = texCord1;
				if(texCord2 + (1 / detail) > 1)
				{
					texCord2 = 0;
					j.tex2.y = 1;
				}
				else
				{
					j.tex2.y = texCord2 + (1 / detail);
				}
				
				if(detail - 1 == i)
				{
					//System.out.println(j.normal.x + " " + j.normal.y + " " + j.normal.z);
				}
				
				
					outCome.add(j);
				}
				else
				{
					if(type == 2)
					{
						x1 = Math.round(x1);
						y1 = Math.round(y1);
						z1 = Math.round(z1);
						x2 = Math.round(x2);
						y2 = Math.round(y2);
						z2 = Math.round(z2);
						x3 = Math.round(x3);
						y3 = Math.round(y3);
						z3 = Math.round(z3);
						x4 = Math.round(x4);
						y4 = Math.round(y4);
						z4 = Math.round(z4);
						
					}
					j.v1.x = x1;
					j.v1.y = y1;
					j.v1.z = z1;
					j.v2.x = x2;
					j.v2.y = y2;
					j.v2.z = z2;
					j.v3.x = x3;
					j.v3.y = y3;
					j.v3.z = z3;
					Data d = new Data();
					d.v1.x = x4;
					d.v1.y = y4;
					d.v1.z = z4;
					d.v2.x = x1;
					d.v2.y = y1;
					d.v2.z = z1;
					d.v3.x = x3;
					d.v3.y = y3;
					d.v3.z = z3;
				
				j.normal = getSurfaceNormal(j);
				j.v1Normal = j.normal;
				j.v2Normal = j.normal;
				j.v3Normal = j.normal;
				j.v4Normal = j.normal;
				d.v1Normal = j.normal;
				d.v2Normal = j.normal;
				d.v3Normal = j.normal;
				
				d.normal = j.normal;
				d.Red = 1;
				d.Green = 1;
				d.Blue = 1;
				j.Red = 1;//Math.random() * 0.1 + 0.2;
				j.Green = 1;//Math.random() * 0.2 + 0.5;
				j.Blue = 1;//Math.random() * 0.5 + 0.5;
				outCome.add(j);
				outCome.add(d);
				//outCome.add(d);
				}
				//Data k = returnDataTri(x3,y3,z3,x4,y4,z4,x1,y1,z1,j.Red,j.Green,j.Blue);
				//outCome.add(k);
				texCord1 = texCord1 + (1 / detail);

			}
			dirY = dirY + ((360 / detail) / 2);
			texCord2 = texCord2 + (1 / (detail));
		}
		if(type == 0)
		{
			for(int i = 0; i < outCome.size(); i ++)
			{
				Data d = outCome.get(i);
				for(int t = 0; t < outCome.size(); t ++)
				{
					Data j = outCome.get(t);
					//Distance(j.mid.x,j.mid.y,j.mid.z,d.mid.x,d.mid.y,d.mid.z);
					if(i != t)
					{
					if(d.v1.equals(j.v1))
					{
						d.v1Normal = j.v1Normal.add(d.v1Normal);
						d.v1Normal = d.v1Normal.normalize();
						j.v1Normal = d.v1Normal;
					}
					if(d.v1.equals(j.v2))
					{
						d.v1Normal = j.v2Normal.add(d.v1Normal);
						d.v1Normal = d.v1Normal.normalize();
						j.v2Normal = d.v1Normal;
					}
					if(d.v1.equals(j.v3))
					{
						d.v1Normal = j.v3Normal.add(d.v1Normal);
						d.v1Normal = d.v1Normal.normalize();
						j.v3Normal = d.v1Normal;
					}
					if(d.v1.equals(j.v4))
					{
						d.v1Normal = j.v4Normal.add(d.v1Normal);
						d.v1Normal = d.v1Normal.normalize();
						j.v4Normal = d.v1Normal;
					}
					if(d.v2.equals(j.v1))
					{
						d.v2Normal = j.v1Normal.add(d.v2Normal);
						d.v2Normal = d.v2Normal.normalize();
						j.v1Normal = d.v2Normal;
					}
					if(d.v2.equals(j.v2))
					{
						d.v2Normal = j.v2Normal.add(d.v2Normal);
						d.v2Normal = d.v2Normal.normalize();
						j.v2Normal = d.v2Normal;
					}
					if(d.v2.equals(j.v3))
					{
						d.v2Normal = j.v3Normal.add(d.v2Normal);
						d.v2Normal = d.v2Normal.normalize();
						j.v3Normal = d.v2Normal;
					}
					if(d.v2.equals(j.v4))
					{
						d.v2Normal = j.v4Normal.add(d.v2Normal);
						d.v2Normal = d.v2Normal.normalize();
						j.v4Normal = d.v2Normal;
					}
					if(d.v3.equals(j.v1))
					{
						d.v3Normal = j.v1Normal.add(d.v3Normal);
						d.v3Normal = d.v3Normal.normalize();
						j.v1Normal = d.v3Normal;
					}
					if(d.v3.equals(j.v2))
					{
						d.v3Normal = j.v2Normal.add(d.v3Normal);
						d.v3Normal = d.v3Normal.normalize();
						j.v2Normal = d.v3Normal;
					}
					if(d.v3.equals(j.v3))
					{
						d.v3Normal = j.v3Normal.add(d.v3Normal);
						d.v3Normal = d.v3Normal.normalize();
						j.v3Normal = d.v3Normal;
					}
					if(d.v3.equals(j.v4))
					{
						d.v3Normal = j.v4Normal.add(d.v3Normal);
						d.v3Normal = d.v3Normal.normalize();
						j.v4Normal = d.v3Normal;
					}
					if(d.v4.equals(j.v1))
					{
						d.v4Normal = j.v1Normal.add(d.v4Normal);
						d.v4Normal = d.v4Normal.normalize();
						j.v1Normal = d.v4Normal;
					}
					if(d.v4.equals(j.v2))
					{
						d.v4Normal = j.v2Normal.add(d.v4Normal);
						d.v4Normal = d.v4Normal.normalize();
						j.v2Normal = d.v4Normal;
					}
					if(d.v4.equals(j.v3))
					{
						d.v4Normal = j.v3Normal.add(d.v4Normal);
						d.v4Normal = d.v4Normal.normalize();
						j.v3Normal = d.v4Normal;
						
					}
					if(d.v4.equals(j.v4))
					{
						d.v4Normal = j.v4Normal.add(d.v4Normal);
						d.v4Normal = d.v4Normal.normalize();
						j.v4Normal = d.v4Normal;
					}
					}
					
				}
				
			}
		}
		return outCome;
	}
	
	public Data returnDataTri(double x, double y, double z,double x2, double y2, double z2, double x3, double y3, double z3,double Red, double Green, double Blue)
	{
		Data d = new Data();
		d.v1.x = x;
		d.v1.y = y;
		d.v1.z = z;
		d.v2.x = x2;
		d.v2.y = y2;
		d.v2.z = z2;
		d.v3.x = x3;
		d.v3.y = y3;
		d.v3.z = z3;
		d.mid.x = (d.v1.x + d.v2.x + d.v3.x) / 3;
		d.mid.y = (d.v1.y + d.v2.y + d.v3.y) / 3;
		d.mid.z = (d.v1.z + d.v2.z + d.v3.z) / 3;
		d.Red = Red;
		d.Green = Green;
		d.Blue = Blue;
		d.normal = getSurfaceNormal(d);
		d.v1Normal = d.normal;
		d.v2Normal = d.normal;
		d.v3Normal = d.normal;
		d.Collide = false;
		return d;
	}
	public void rotateSphere(double rotateX,double rotateY,double rotateZ,float rotateSpeed)
	{
		
		for(int i = 0; i < sphere.points.size(); i ++)
		{
			Data d = sphere.points.get(i);
			Quaternion q = new Quaternion();
			q.setFromAxisAngle(new Vector4f((float)rotateY,(float)rotateX,(float)rotateZ,(float)Math.PI*rotateSpeed));
			d.v1 = d.v1.multiplyNonVec(times);
			d.v1.x = Math.round(d.v1.x);
			d.v1.y = Math.round(d.v1.y);
			d.v1.z = Math.round(d.v1.z);
			Quaternion p = new Quaternion((float)d.v1.x,(float)d.v1.y,(float)d.v1.z,0);
			p = Quaternion.mulInverse(Quaternion.mul(q,p,p),q,p);
			d.v1.x = Math.round(p.x);
			d.v1.y = Math.round(p.y);
			d.v1.z = Math.round(p.z);
			d.v2 = d.v2.multiplyNonVec(times);
			d.v2.x = Math.round(d.v2.x);
			d.v2.y = Math.round(d.v2.y);
			d.v2.z = Math.round(d.v2.z);
			p = new Quaternion((float)d.v2.x,(float)d.v2.y,(float)d.v2.z,0);
			p = Quaternion.mulInverse(Quaternion.mul(q,p,p),q,p);
			d.v2.x = Math.round(p.x);
			d.v2.y = Math.round(p.y);
			d.v2.z = Math.round(p.z);
			d.v3 = d.v3.multiplyNonVec(times);
			d.v3.x = Math.round(d.v3.x);
			d.v3.y = Math.round(d.v3.y);
			d.v3.z = Math.round(d.v3.z);
			p = new Quaternion((float)d.v3.x,(float)d.v3.y,(float)d.v3.z,0);
			p = Quaternion.mulInverse(Quaternion.mul(q,p,p),q,p);
			d.v3.x = Math.round(p.x);
			d.v3.y = Math.round(p.y);
			d.v3.z = Math.round(p.z);
			d.v4 = d.v4.multiplyNonVec(times);
			d.v4.x = Math.round(d.v4.x);
			d.v4.y = Math.round(d.v4.y);
			d.v4.z = Math.round(d.v4.z);
			p = new Quaternion((float)d.v4.x,(float)d.v4.y,(float)d.v4.z,0);
			p = Quaternion.mulInverse(Quaternion.mul(q,p,p),q,p);
			d.v4.x = Math.round(p.x);
			d.v4.y = Math.round(p.y);
			d.v4.z = Math.round(p.z);
			d.mid = d.v1.add(d.v2.add(d.v3.add(d.v4)));
			d.mid = d.mid.divideNon(4);
			d.normal = getSurfaceNormal(d);
			d.v1Normal = d.normal;
			d.v2Normal = d.normal;
			d.v3Normal = d.normal;
			d.v4Normal = d.normal;
			d.v1 = d.v1.divideNon(times);
			d.v2 = d.v2.divideNon(times);
			d.v3 = d.v3.divideNon(times);
			d.v4 = d.v4.divideNon(times);
			
		}
		
		
		
	}
	public void drawRotatedSphere()
	{
		
		for(int i = 0; i < sphere.points.size(); i ++)
		{
			Data d = sphere.points.get(i);
			for(int t = 0; t < sphere.points.size(); t ++)
			{
				Data j = sphere.points.get(t);
				//Distance(j.mid.x,j.mid.y,j.mid.z,d.mid.x,d.mid.y,d.mid.z);
				if(i != t)
				{
					
				if(d.v1.equals(j.v1))
				{
					
					d.v1Normal = j.v1Normal.add(d.v1Normal);
					d.v1Normal = d.v1Normal.normalize();
					j.v1Normal = d.v1Normal;
				}
				if(d.v1.equals(j.v2))
				{
					d.v1Normal = j.v2Normal.add(d.v1Normal);
					d.v1Normal = d.v1Normal.normalize();
					j.v2Normal = d.v1Normal;
				}
				if(d.v1.equals(j.v3))
				{
					d.v1Normal = j.v3Normal.add(d.v1Normal);
					d.v1Normal = d.v1Normal.normalize();
					j.v3Normal = d.v1Normal;
				}
				if(d.v1.equals(j.v4))
				{
					d.v1Normal = j.v4Normal.add(d.v1Normal);
					d.v1Normal = d.v1Normal.normalize();
					j.v4Normal = d.v1Normal;
				}
				if(d.v2.equals(j.v1))
				{
					d.v2Normal = j.v1Normal.add(d.v2Normal);
					d.v2Normal = d.v2Normal.normalize();
					j.v1Normal = d.v2Normal;
				}
				if(d.v2.equals(j.v2))
				{
					d.v2Normal = j.v2Normal.add(d.v2Normal);
					d.v2Normal = d.v2Normal.normalize();
					j.v2Normal = d.v2Normal;
				}
				if(d.v2.equals(j.v3))
				{
					d.v2Normal = j.v3Normal.add(d.v2Normal);
					d.v2Normal = d.v2Normal.normalize();
					j.v3Normal = d.v2Normal;
				}
				if(d.v2.equals(j.v4))
				{
					d.v2Normal = j.v4Normal.add(d.v2Normal);
					d.v2Normal = d.v2Normal.normalize();
					j.v4Normal = d.v2Normal;
				}
				if(d.v3.equals(j.v1))
				{
					d.v3Normal = j.v1Normal.add(d.v3Normal);
					d.v3Normal = d.v3Normal.normalize();
					j.v1Normal = d.v3Normal;
				}
				if(d.v3.equals(j.v2))
				{
					d.v3Normal = j.v2Normal.add(d.v3Normal);
					d.v3Normal = d.v3Normal.normalize();
					j.v2Normal = d.v3Normal;
				}
				if(d.v3.equals(j.v3))
				{
					d.v3Normal = j.v3Normal.add(d.v3Normal);
					d.v3Normal = d.v3Normal.normalize();
					j.v3Normal = d.v3Normal;
				}
				if(d.v3.equals(j.v4))
				{
					d.v3Normal = j.v4Normal.add(d.v3Normal);
					d.v3Normal = d.v3Normal.normalize();
					j.v4Normal = d.v3Normal;
				}
				if(d.v4.equals(j.v1))
				{
					d.v4Normal = j.v1Normal.add(d.v4Normal);
					d.v4Normal = d.v4Normal.normalize();
					j.v1Normal = d.v4Normal;
				}
				if(d.v4.equals(j.v2))
				{
					d.v4Normal = j.v2Normal.add(d.v4Normal);
					d.v4Normal = d.v4Normal.normalize();
					j.v2Normal = d.v4Normal;
				}
				if(d.v4.equals(j.v3))
				{
					d.v4Normal = j.v3Normal.add(d.v4Normal);
					d.v4Normal = d.v4Normal.normalize();
					j.v3Normal = d.v4Normal;
					
				}
				if(d.v4.equals(j.v4))
				{
					d.v4Normal = j.v4Normal.add(d.v4Normal);
					d.v4Normal = d.v4Normal.normalize();
					j.v4Normal = d.v4Normal;
				}
				}
				
			}
			
		}
		
		for(int i = 0; i < sphere.points.size(); i ++)
		{
			Data dj = sphere.points.get(i);
			Data d = new Data();
			d.v1.x = dj.v1.x + pos.x;
			d.v1.y = dj.v1.y + pos.y;
			d.v1.z = dj.v1.z + pos.z;
			d.v2.x = dj.v2.x + pos.x;
			d.v2.y = dj.v2.y + pos.y;
			d.v2.z = dj.v2.z + pos.z;
			d.v3.x = dj.v3.x + pos.x;
			d.v3.y = dj.v3.y + pos.y;
			d.v3.z = dj.v3.z + pos.z;
			d.v4.x = dj.v4.x + pos.x;
			d.v4.y = dj.v4.y + pos.y;
			d.v4.z = dj.v4.z + pos.z;
			d.normal = dj.normal;
			d.v1Normal = dj.v1Normal;
			d.v2Normal = dj.v2Normal;
			d.v3Normal = dj.v3Normal;
			d.v4Normal = dj.v4Normal;
			d.Collide = false;
			d.Red = dj.Red;
			d.Blue = dj.Blue;
			d.Green = dj.Green;
			d.tex1.x = dj.tex1.x * ball.getWidth();
			d.tex1.y = dj.tex1.y * ball.getHeight();
			d.tex2.y = dj.tex2.y * ball.getHeight();
			d.tex2.x = dj.tex2.x * ball.getWidth();
			d.tex3.x = dj.tex3.x * ball.getWidth();
			d.tex3.y = dj.tex3.y * ball.getHeight();
			d.tex4.x = dj.tex4.x * ball.getWidth();
			d.tex4.y = dj.tex4.y * ball.getHeight();
			draw3DQuad(d,0);
			
		}
	}
	public void drawRotated(Vector v, Vector v2, Vector v3, Vector normal,double Red, double Green, double Blue,Vector position,int alpha)
	{
		Data d = new Data();
		d.v1.x = v.x + position.x;
		d.v1.y = v.y + position.y;
		d.v1.z = v.z + position.z;
		d.v2.x = v2.x + position.x;
		d.v2.y = v2.y + position.y;
		d.v2.z = v2.z + position.z;
		d.v3.x = v3.x + position.x;
		d.v3.y = v3.y + position.y;
		d.v3.z = v3.z + position.z;
		
		d.normal = normal;
		d.v1Normal = normal;
		d.v2Normal = normal;
		d.v3Normal = normal;
		d.Collide = false;
		d.Red = Red;
		d.Blue = Blue;
		d.Green = Green;
		d.mid = d.v1.add(d.v2.add(d.v3));
		d.mid = d.mid.divideNon(3);
		d.Shine = alpha;
		draw3DTriangle(d);
		//VectorMath(d,0,0,0);
	}
	public void setUpSquareTri(double x, double y, double z, double x2, double y2, double z2, double x3, double y3, double z3, double x4, double y4, double z4,double Red, double Green, double Blue)
	{
		setUpTriangle(x3,y3,z3,x2,y2,z2,x,y,z,Red,Green,Blue,true);
		setUpTriangle(x,y,z,x4,y4,z4,x3,y3,z3,Red,Green,Blue,true);
	}
	public void setUpRamp(int x, int y, int z)
	{
		setUpTriangle(x - 3,y,z - 3,x -3, y,z + 3,x + 3,y + 2, z + 3,1,1,1,true);
		setUpTriangle(x + 3,y + 2,z - 3,x -3, y,z - 3,x + 3,y + 2, z + 3,1,1,1,true);
	}
	public void setUpOtherRamp(int x, int y, int z)
	{
		setUpTriangle(x - 3,y,z + 3,x -3, y + 3,z - 3,x + 3,y, z + 3,1,1,1,true);

	}
	public void setUpTriangle(double x, double y, double z,double x2, double y2, double z2, double x3, double y3, double z3,double Red, double Green, double Blue,boolean collide)
	{
		Data d = new Data();
		d.v1.x = x;
		d.v1.y = y;
		d.v1.z = z;
		d.v2.x = x2;
		d.v2.y = y2;
		d.v2.z = z2;
		d.v3.x = x3;
		d.v3.y = y3;
		d.v3.z = z3;
		d.mid.x = (d.v1.x + d.v2.x + d.v3.x) / 3;
		d.mid.y = (d.v1.y + d.v2.y + d.v3.y) / 3;
		d.mid.z = (d.v1.z + d.v2.z + d.v3.z) / 3;
		d.Red = Red;
		d.Green = Green;
		d.Blue = Blue;
		d.normal = getSurfaceNormal(d);
		d.v1Normal = d.normal;
		d.v2Normal = d.normal;
		d.v3Normal = d.normal;
		d.Collide = collide;
		data.add(d);
	}
	public void createLightAt(double x, double y, double z,double intensity,double Red, double Green, double Blue)
	{
		Lights light = new Lights();
		light.light.x = x;
		light.light.y = y;
		light.light.z = z;
		light.intensity = intensity;
		light.Red = Red;
		light.Green = Green;
		light.Blue = Blue;
		lights.add(light);
	}



	public Vector getSurfaceNormal(Data d)
	{
		Vector v1 = d.v2.subtract(d.v1);
		Vector v2 = d.v3.subtract(d.v1);
		Vector normal = v1.crossProduct(v2);
		normal = normal.normalize();
		return normal;
	}
	



	public Vector getCross(double x1, double y1, double z1, double x2, double y2, double z2, double x3, double y3, double z3)
	{
		Vector d1 = new Vector();
		d1.x = Math.round(x2 - x1);
		d1.y = Math.round(y2 - y1);
		d1.z = Math.round(z2 - z1);
		Vector d2 = new Vector();
		d2.x = Math.round(x3 - x1);
		d2.y = Math.round(y3 - y1);
		d2.z = Math.round(z3 - z1);
		Vector cross = new Vector();
		cross = d1.crossProduct( d2);
		Vector norm = new Vector();
		norm = cross;




		norm = norm.normalize();
		return norm;
	}
	public Vector getTheShade(double x1, double y1, double z1, double x2, double y2, double z2, double x3, double y3, double z3)
	{
		light.x = Math.round(x1 - lightX);
		light.y = Math.round(y1 - lightY);
		light.z = Math.round(z1 - lightZ);
		Vector v1 = new Vector();
		v1.x = x2 - x1;
		v1.y = y2 - y1;
		v1.z = z2 - z1;
		Vector v2 = new Vector();
		v2.x = x3 - x2;
		v2.y = y3 - y2;
		v2.z = z3 - z2;
		Vector cross = new Vector();

		Vector norm = new Vector();
		cross.x = v1.y * v2.z - v1.z * v2.y;
		cross.y = v1.z * v2.x - v1.x * v2.z;
		cross.z = v1.x * v2.y - v1.y * v2.x;

		norm = cross.normalize();


		light = light.normalize();




		double dot = norm.dot(light) / -(norm.magnitude() * light.magnitude());
		dot = Math.max(dot, 0.05);

		return norm;
	}
	public void draw3DQuadWith(Data d, double Alpha1, double Alpha2, double Alpha3, double Alpha4)
	{
		GL11.glBegin(GL11.GL_QUADS);
			GL11.glColor4d(d.Red, d.Green,d.Blue,Alpha1);
			GL11.glNormal3d(d.v1Normal.x,d.v1Normal.y,d.v1Normal.z); 
			GL11.glVertex3d(d.v1.x, d.v1.y,d.v1.z);
			GL11.glColor4d(d.Red, d.Green,d.Blue,Alpha2);
			GL11.glNormal3d(d.v2Normal.x,d.v2Normal.y,d.v2Normal.z); 
			GL11.glVertex3d(d.v2.x, d.v2.y,d.v2.z);
			GL11.glColor4d(d.Red, d.Green,d.Blue,Alpha3);
			GL11.glNormal3d(d.v3Normal.x,d.v3Normal.y,d.v3Normal.z); 
			GL11.glVertex3d(d.v3.x, d.v3.y,d.v3.z);
			GL11.glColor4d(d.Red, d.Green,d.Blue,Alpha4);
			GL11.glNormal3d(d.v4Normal.x,d.v4Normal.y,d.v4Normal.z); 
			GL11.glVertex3d(d.v4.x, d.v4.y,d.v4.z);
		GL11.glEnd();
	}
	public void draw3DQuad(Data d,int type)
	{
		GL11.glEnable(GL11.GL_COLOR_MATERIAL);
		GL11.glCullFace(GL11.GL_BACK);
		//set material properties which will be assigned by glColor
				GL11.glColorMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE);
				GL11.glMaterial(GL11.GL_FRONT, GL11.GL_SPECULAR, floatBuffer(0.5f, 0.5f, 0.5f, 1.0f));
				GL11.glMateriali(GL11.GL_FRONT, GL11.GL_SHININESS, 128);
				if(type == 0 && obtainNail == 1)
				{
					draw3DLine(d.v4.x,d.v4.y,d.v4.z,d.v4.x + d.v4Normal.x,d.v4.y + d.v4Normal.y,d.v4.z + d.v4Normal.z,1,1,1,1);
				}
				//draw3DLine(d.v2.x,d.v2.y,d.v2.z,d.v2.x + d.v2Normal.x,d.v2.y + d.v2Normal.y,d.v2.z + d.v2Normal.z,1,1,1);
				//draw3DLine(d.v1.x,d.v1.y,d.v1.z,d.v1.x + d.v1Normal.x,d.v1.y + d.v1Normal.y,d.v1.z + d.v1Normal.z,1,1,1);
				if(d.tex3.x != 0)
				{
					//System.out.println("hi");
					
					GL11.glEnable(GL11.GL_TEXTURE_2D);
					if(pauseGamePlay == false)
					{
						if(type == 0)
						{
							if(eyeCloseTime <= 300)
							{
								ball.bind();
							}
							else
							{
								//System.out.println("blink");
								SleepBall.bind();
								if(eyeCloseTime >= 308)
								{
									eyeCloseTime = 0;
								}
							}
						}
						else if(type == 1)
						{
							DM.bind();
						}
					}
					else if(storyLine == 0 && type != 3)
					{
						if(sideStory <= 4)
						{
							SleepBall.bind();
						}
						else
						{
							ball.bind();
						}
					}
					
					
				}
				if(type == 3)
				{
					Ransom.bind();
				}
				if(type == 5)
				{
					BallEnemy.bind();
				}
				if(type == 8)
				{
					VividEye.bind();
				}
				double divideBy = 1;
				GL11.glBegin(GL11.GL_QUADS);
					if(torchLight)
					{
						Distance(light0Pos.x,light0Pos.y,light0Pos.z,d.v1.x,d.v1.y,d.v1.z);
						divideBy = (Distance / light0Intensity);
					}
					if(divideBy < 1)
					{
						divideBy = 1;
					}
					GL11.glColor3d(d.Red / divideBy, d.Green / divideBy,d.Blue / divideBy);
					if(d.tex3.x != 0)
					{
						GL11.glTexCoord2d(d.tex1.x,d.tex1.y);
					}
					GL11.glNormal3d(d.v1Normal.x,d.v1Normal.y,d.v1Normal.z); 
					GL11.glVertex3d(d.v1.x, d.v1.y,d.v1.z);
					if(d.tex3.x != 0)
					{
						GL11.glTexCoord2d(d.tex2.x,d.tex2.y);
					}
					if(torchLight)
					{
						Distance(light0Pos.x,light0Pos.y,light0Pos.z,d.v2.x,d.v2.y,d.v2.z);
						divideBy = (Distance / light0Intensity);
					}
					if(divideBy < 1)
					{
						divideBy = 1;
					}
					GL11.glColor3d(d.Red / divideBy, d.Green / divideBy,d.Blue / divideBy);
					GL11.glNormal3d(d.v2Normal.x,d.v2Normal.y,d.v2Normal.z); 
					GL11.glVertex3d(d.v2.x, d.v2.y,d.v2.z);
					if(d.tex3.x != 0)
					{
						GL11.glTexCoord2d(d.tex3.x,d.tex3.y);
					}
					if(torchLight)
					{
						Distance(light0Pos.x,light0Pos.y,light0Pos.z,d.v3.x,d.v3.y,d.v3.z);
						divideBy = (Distance / light0Intensity);
					}
					if(divideBy < 1)
					{
						divideBy = 1;
					}
					GL11.glColor3d(d.Red / divideBy, d.Green / divideBy, d.Blue / divideBy);
					GL11.glNormal3d(d.v3Normal.x,d.v3Normal.y,d.v3Normal.z); 
					GL11.glVertex3d(d.v3.x, d.v3.y,d.v3.z);
					if(d.tex3.x != 0)
					{
						GL11.glTexCoord2d(d.tex4.x,d.tex4.y);
					}
					if(torchLight)
					{
						Distance(light0Pos.x,light0Pos.y,light0Pos.z,d.v4.x,d.v4.y,d.v4.z);
						divideBy = (Distance / light0Intensity);
					}
					if(divideBy < 1)
					{
						divideBy = 1;
					}
					GL11.glColor3d(d.Red / divideBy, d.Green / divideBy,d.Blue / divideBy);
					GL11.glNormal3d(d.v4Normal.x,d.v4Normal.y,d.v4Normal.z); 
					GL11.glVertex3d(d.v4.x, d.v4.y,d.v4.z);
				GL11.glEnd();
				//ball.release();
				text.bind();
				GL11.glDisable(GL11.GL_TEXTURE_2D);
				//ball.release();
				
	}
	public void draw3DTriangle(Data d)
	{
		/**
			int drawX4 = 0;
			int drawY4 = 0;
			tmp(x1,y1,z1);
			int drawX1 = (int)Math.round(tmpx);
			int drawY1 = (int)Math.round(tmpy);
			double drawZ1 = tmpz;

			tmp(x2,y2,z2);

			int drawX2 = (int)Math.round(tmpx);
			int drawY2 = (int)Math.round(tmpy);
			double drawZ2 = tmpz;


			tmp(x3,y3,z3);

			int drawX3 = (int)Math.round(tmpx);
			int drawY3 = (int)Math.round(tmpy);
			if(tmpz < 0)
			{
				drawX3 = drawX3 - drawX2;
				drawY3 = drawY3 - drawX2;


			}
			double drawZ3 = tmpz;
		 **/
		/**
			if(drawZ3 > 0 || drawZ2 > 0 || drawZ1 > 0)
			{
				GL11.glBegin(GL11.GL_QUADS);
	            GL11.glColor3d(Red * (shade + gamma), Green * (shade + gamma), Blue * (shade + gamma));
	            GL11.glVertex2d(drawX1, drawY1);

	            // Right & Green
	            GL11.glColor3d(Red * (shade2 + gamma), Green * (shade2 + gamma), Blue * (shade2 + gamma));
	            GL11.glVertex2f(drawX2, drawY2);

	            // Left & Blue
	            GL11.glColor3d(Red * (shade3 + gamma), Green * (shade3 + gamma), Blue * (shade3 + gamma));
	            GL11.glVertex2f(drawX3, drawY3);

	            GL11.glColor3d(Red * (shade3 + gamma), Green * (shade3 + gamma), Blue * (shade3 + gamma));
	            GL11.glVertex2f(drawX4, drawY4);
	            GL11.glEnd();
			}
		 */
/**
		double ColorRed1 = color1.Red * (shade + gamma);
		double ColorGreen1 = color1.Green * (shade + gamma);
		double ColorBlue1 = color1.Blue * (shade + gamma);
		double ColorRed2 = color2.Red * (shade2 + gamma);
		double ColorGreen2 = color2.Green * (shade2 + gamma);
		double ColorBlue2 = color3.Blue * (shade2 + gamma);
		double ColorRed3 = color3.Red * (shade3 + gamma);
		double ColorGreen3 = color2.Green * (shade3 + gamma);
		double ColorBlue3 = color3.Blue * (shade3 + gamma);
		if(ColorRed1 > color1.Red) ColorRed1 = color1.Red;
		if(ColorGreen1 > color1.Green) ColorGreen1 = color1.Green;
		if(ColorBlue1 > color1.Blue) ColorBlue1 = color1.Blue;
		if(ColorRed2 > color2.Red) ColorRed2 = color2.Red;
		if(ColorGreen2 > color2.Green) ColorGreen2 = color2.Green;
		if(ColorBlue2 > color2.Blue) ColorBlue2 = color2.Blue;
		if(ColorRed3 > color3.Red) ColorRed3 = color3.Red;
		if(ColorGreen3 > color3.Green) ColorGreen3 = color3.Green;
		if(ColorBlue3 > color3.Blue) ColorBlue3 = color3.Blue;
*/
		/**
		GL11.glBegin(GL11.GL_TRIANGLES);
		GL11.glNormal3d(d.normal.x,d.normal.y,d.normal.z); 
		GL11.glColor3d(d.Red, d.Green,d.Blue);
		GL11.glVertex3d(x1 + cameraX, y1 + cameraY,z1 + cameraZ);
		GL11.glColor3d(d.Red, d.Green,d.Blue);
		// Right & Green
		GL11.glVertex3d(x2 + cameraX, y2 + cameraY,z2 + cameraZ);
		GL11.glColor3d(d.Red, d.Green,d.Blue);
		// Left & Blue
		GL11.glVertex3d(x3 + cameraX, y3 + cameraY,z3 + cameraZ);
		GL11.glEnd();
*/		//GL11.glDisable(GL11.GL_COLOR_MATERIAL);
//set material properties which will be assigned by glColor
		GL11.glColorMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE);
		if(d.Shine == 0)
		{
			GL11.glMaterial(GL11.GL_FRONT, GL11.GL_SPECULAR, floatBuffer(0f, 0f, 0f, 1.0f));
		}
		else
		{
			GL11.glMaterial(GL11.GL_FRONT, GL11.GL_SPECULAR, floatBuffer(0.1f, 0.1f, 0.1f, 1.0f));
		}
		//GL11.glMaterial(GL11.GL_FRONT, GL11.GL_SPECULAR, floatBuffer(0.4f, 0.4f, 0.4f, 1.0f));
		GL11.glMateriali(GL11.GL_FRONT, GL11.GL_SHININESS, d.Shine);
		double divideBy = 1;
		
		if(torchLight)
		{
			Distance(light0Pos.x,light0Pos.y,light0Pos.z,d.mid.x,d.mid.y,d.mid.z);
			divideBy = (Distance / light0Intensity);
		}
		if(divideBy < 1)
		{
			divideBy = 1;
		}
		if(maxDetail == 0)
		{
			renderType = 0;
		}
		else
		{
			renderType = 1;
		}
		if(renderType == 1)
		{
			Distance(d.mid.x,d.mid.y,d.mid.z,-cameraX,-cameraY,-cameraZ);
			int detail = (int)Math.round((7 - (Distance / 5)));
			if(noDetail)
			{
				detail = 1;
			}
			if(detail <= 0)
			{
				
				detail = 1;
			}
			if(detail >= maxDetail)
			{
				detail = (int)Math.round(maxDetail);
			}
			if(detail > 1)
			{
				surfacesRendered ++;
			}
			if(surfacesRendered >= 1)
			{
				double renderDown = ((surfacesRendered / 25));
				if(renderDown <= 1)
				{
					renderDown = 1;
				}
				detail = (int)Math.round(detail / renderDown);
			}
			if(detail <= 0)
			{
				
				detail = 1;
			}
			//System.out.println(detail);
			Vector toPointV3 = new Vector();
			toPointV3 = d.v3.subtract(d.v1);
			Vector toPointV2 = new Vector();
			toPointV2 = d.v2.subtract(d.v1);
			toPointV3 = toPointV3.divideNon(detail);
			toPointV2 = toPointV2.divideNon(detail);
			Data j = new Data();
			Vector noVal = new Vector();
			j.v2 = d.v1.add(noVal);
			j.v3 = d.v1.add(noVal);
			//GL11.glDisable(GL11.GL_CULL_FACE);
			for(int i = 0; i < detail; i ++)
			{
				
				
				
				j.v2 = j.v2.add(toPointV2);
				j.v3 = j.v3.add(toPointV3);
				for(int t = 0; t < detail; t ++)
				{
					Vector toOtherPoint = j.v3.subtract(j.v2);
					toOtherPoint = toOtherPoint.divideNon(detail);
					Vector toOtherPoint2 = (j.v3.subtract(toPointV3)).subtract(j.v2.subtract(toPointV2));
					toOtherPoint2 = toOtherPoint2.divideNon(detail);
					Data k = new Data();
					//Distance(j.v2.x,j.v2.y,j.v2.z,j.v3.x,j.v3.y,j.v3.z);
					//Distance = Distance / 3;
					k.v1 = j.v2.add(toOtherPoint.multiplyNonVec(t));
					k.v2 = (j.v2.subtract(toPointV2)).add(toOtherPoint2.multiplyNonVec(t));
					k.v4 = j.v2.add(toOtherPoint.multiplyNonVec(t + 1));
					k.v3 = (j.v2.subtract(toPointV2)).add(toOtherPoint2.multiplyNonVec(t + 1));
					
					
					k.Red = d.Red;
					k.Green = d.Green;
					k.Blue = d.Blue;
					
					Vector norms = new Vector();
					norms.x = d.normal.x;
					norms.y = d.normal.y;
					norms.z = d.normal.z;
					k.normal = norms;
					k.v1Normal = norms;
					k.v2Normal = norms;
					k.v3Normal = norms;
					k.v4Normal = norms;
					draw3DQuadWith(k,d.Alpha,d.Alpha,d.Alpha,d.Alpha);
				}
			}
		}
		else
		{
			 GL11.glCullFace(GL11.GL_BACK);
		GL11.glBegin(GL11.GL_TRIANGLES);
			
			GL11.glColor4d(d.Red / divideBy, d.Green / divideBy,d.Blue / divideBy,d.Alpha);
			//GL11.glColor4d(d.Red / divideBy, d.Green / divideBy,d.Blue / divideBy,d.Alpha);
			GL11.glNormal3d(d.v1Normal.x,d.v1Normal.y,d.v1Normal.z); 
			GL11.glVertex3d(d.v1.x, d.v1.y,d.v1.z);
			//GL11.glColor3d(d.Red, d.Green,d.Blue);
			// Right & Green
			if(torchLight)
			{
				Distance(light0Pos.x,light0Pos.y,light0Pos.z,d.v2.x,d.v2.y,d.v2.z);
				divideBy = (Distance / light0Intensity);
			}
			if(divideBy < 1)
			{
				divideBy = 1;
			}
			//GL11.glColor4d(d.Red / divideBy, d.Green / divideBy,d.Blue / divideBy,d.Alpha);
			GL11.glNormal3d(d.v2Normal.x,d.v2Normal.y,d.v2Normal.z); 
			GL11.glVertex3d(d.v2.x, d.v2.y,d.v2.z);
		//	GL11.glColor3d(d.Red, d.Green,d.Blue);
			// Left & Blue
			if(torchLight)
			{
				Distance(light0Pos.x,light0Pos.y,light0Pos.z,d.v3.x,d.v3.y,d.v3.z);
				divideBy = (Distance / light0Intensity);
			}
			if(divideBy < 1)
			{
				divideBy = 1;
			}
			//GL11.glColor4d(d.Red / divideBy, d.Green / divideBy,d.Blue / divideBy,d.Alpha);
			GL11.glNormal3d(d.v3Normal.x,d.v3Normal.y,d.v3Normal.z); 
			GL11.glVertex3d(d.v3.x, d.v3.y,d.v3.z);
		GL11.glEnd();
		}

	}
	public void drawTri(Data d)
	{
		GL11.glBegin(GL11.GL_TRIANGLES);
			GL11.glColor4d(d.Red, d.Green,d.Blue,d.Alpha);
			GL11.glNormal3d(d.v1Normal.x,d.v1Normal.y,d.v1Normal.z); 
			GL11.glVertex3d(d.v1.x, d.v1.y,d.v1.z);
			GL11.glNormal3d(d.v2Normal.x,d.v2Normal.y,d.v2Normal.z); 
			GL11.glVertex3d(d.v2.x, d.v2.y,d.v2.z);
			GL11.glNormal3d(d.v3Normal.x,d.v3Normal.y,d.v3Normal.z); 
			GL11.glVertex3d(d.v3.x, d.v3.y,d.v3.z);
		GL11.glEnd();
	}
	public void draw3DObject(double x1, double y1, double z1, double x2, double y2, double z2, double x3, double y3, double z3, double x4, double y4, double z4,double Red, double Green, double Blue, double shade,double shade2,double shade3, double shade4)
	{
		tmp(x1,y1,z1);
		int drawX1 = (int)Math.round(tmpx);
		int drawY1 = (int)Math.round(tmpy);
		double drawZ1 = tmpz;
		if(tmpz < 0)
		{



			drawY1 = drawY1 * -1;
			drawX1 = drawX1 * -1;



		}
		tmp(x2,y2,z2);

		int drawX2 = (int)Math.round(tmpx);
		int drawY2 = (int)Math.round(tmpy);
		double drawZ2 = tmpz;
		if(tmpz < 0)
		{

			drawX2 = drawX2 * -1;
			drawY2 = drawY2 * -1;

		}
		/**
			int tempDrawX1 = drawX1;
			int tempDrawY1 = drawY1;
			if(drawX1 > 1000)
			{
				tempDrawY1 = drawY1 - (drawY1 - drawY2) * ((drawX1 - 500) / (drawX1 - drawX2));
				tempDrawX1 = 1000;
			}
			if(drawX1 < 0)
			{
				tempDrawY1 = drawY1 - (drawY1 - drawY2) * ((drawX1 + 500) / (drawX1 - drawX2));
				tempDrawX1 = 0;
			}
			if(drawX2 > 1000)
			{
				drawY2 = drawY2 - (drawY2 - drawY1) * ((drawX2 - 500) / (drawX2 - drawX1));
				drawX2 = 1000;
			}
			if(drawX2 < 0)
			{
				drawY2 = drawY2 - (drawY2 - drawY1) * ((drawX2 + 500) / (drawX2 - drawX1));
				drawX2 = 0;
			}
			drawX1 = tempDrawX1;
			drawY1 = tempDrawY1;
		 */
		tmp(x3,y3,z3);

		int drawX3 = (int)Math.round(tmpx);
		int drawY3 = (int)Math.round(tmpy);
		double drawZ3 = tmpz;
		if(tmpz < 0)
		{

			drawX3 = drawX3 * -1;
			drawY3 = drawY3 * -1;

		}
		tmp(x4,y4,z4);

		int drawX4 = (int)Math.round(tmpx);
		int drawY4 = (int)Math.round(tmpy);
		double drawZ4 = tmpz;
		if(tmpz < 0)
		{
			drawX4 = drawX4 * -1;
			drawY4 = drawY4 * -1;

		}
		/**
			int tempDrawX3 = drawX3;
			int tempDrawY3 = drawY3;
			if(drawX3 > 1000)
			{
				tempDrawY3 = drawY3 - (drawY3 - drawY4) * ((drawX3 - 500) / (drawX3 - drawX4));
				tempDrawX3 = 1000;
			}
			if(drawX3 < 0)
			{
				tempDrawY3 = drawY3 - (drawY3 - drawY4) * ((drawX3 + 500) / (drawX3 - drawX4));
				tempDrawX3 = 0;
			}
			if(drawX4 > 1000)
			{
				drawY4 = drawY4 - (drawY4 - drawY3) * ((drawX4 - 500) / (drawX4 - drawX3));
				drawX4 = 1000;
			}
			if(drawX4 < 0)
			{
				drawY4 = drawY4 - (drawY4 - drawY3) * ((drawX4 + 500) / (drawX4 - drawX3));
				drawX4 = 0;
			}
			drawX3 = tempDrawX3;
			drawY3 = tempDrawY3;
		 */
		/**
			if(drawX1 > 600|| drawX1 < 200)
			{
				shade = 0;
			}
			if(drawX2 > 600 || drawX2 < 200)
			{
				shade2 = 0;
			}
			if(drawX3 > 600 || drawX3 < 200)
			{
				shade3 = 0;
			}
			if(drawX4 > 600 || drawX4 < 200)
			{
				shade4 = 0;
			}
		 */
		if(drawX3 > 0 || drawX4 > 0 || drawX2 > 0 || drawX1 > 0 || drawX1 < 1000 || drawX2 < 1000 || drawX3 < 1000 || drawX4 < 1000)
		{
			if(drawZ1 > -1 || drawZ2 > -1 || drawZ3 > -1 || drawZ4 > -1)
			{
				GL11.glColor3d(Red * shade,Green * shade,Blue * shade);
				GL11.glBegin(GL11.GL_QUADS);
				GL11.glNormal3d(0,0,1);
				GL11.glTexCoord2f((float)0,(float)0);
				GL11.glVertex2f(drawX1,drawY1);
				GL11.glColor3d(Red * shade2,Green * shade2,Blue * shade2);
				GL11.glTexCoord2f((float)1,(float)0);
				GL11.glVertex2f(drawX2,drawY2);
				GL11.glColor3d(Red * shade3,Green * shade3,Blue * shade3);
				GL11.glTexCoord2f((float)1,(float)1);
				GL11.glVertex2f(drawX3,drawY3);
				GL11.glColor3d(Red * shade4,Green * shade4,Blue * shade4);
				GL11.glTexCoord2f((float)0,(float)1);
				GL11.glVertex2f(drawX4,drawY4);
				GL11.glEnd();
			}
		}
	}
	public void Distance(double x, double y, double z, double x2, double y2, double z2)
	{
		Distance = Math.sqrt(((x - x2) * (x - x2)) + ((y - y2) * (y-y2)) + ((z - z2) * (z - z2)));
	}
	public void draw3DLine(double x1, double y1, double z1, double x2, double y2, double z2,double Red, double Green,double Blue,double Alpha)
	{
		GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glColor4d(Red, Green, Blue,Alpha);
		GL11.glBegin(GL11.GL_LINE_STRIP);
		GL11.glVertex3d(x1, y1,z1);
		GL11.glVertex3d(x2, y2,z2);
		GL11.glEnd();
		GL11.glEnable(GL11.GL_LIGHTING);
	}
	public void checkDrawing(double drawX, double drawY,double opoX, double opoY)
	{
		checkReX = drawX;
		checkReY = drawY;
		if(checkReX > 1000)
		{
			checkReY = drawY - (checkReY - opoY) * ((checkReX - 500) / (checkReX - opoX));
			checkReX = 1000;
		}
		else if(checkReX < 0)
		{
			checkReY = drawY - (checkReY - opoY) * ((checkReX + 500) / (checkReX - opoX));
			checkReX = 0;
		}
	}
}