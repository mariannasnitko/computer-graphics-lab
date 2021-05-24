package application;

import com.sun.j3d.loaders.Scene;
import com.sun.j3d.loaders.objectfile.ObjectFile;
import com.sun.j3d.utils.image.TextureLoader;
import com.sun.j3d.utils.universe.SimpleUniverse;
import com.sun.j3d.utils.universe.ViewingPlatform;

import javax.media.j3d.Appearance;
import javax.media.j3d.Background;
import javax.media.j3d.BoundingSphere;
import javax.media.j3d.Bounds;
import javax.media.j3d.BranchGroup;
import javax.media.j3d.Canvas3D;
import javax.media.j3d.DirectionalLight;
import javax.media.j3d.Shape3D;
import javax.media.j3d.Texture;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.swing.*;
import javax.vecmath.Color3f;
import javax.vecmath.Color4f;
import javax.vecmath.Point3d;
import javax.vecmath.Vector3f;
import java.awt.*;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class Main extends JFrame {
    static SimpleUniverse universe;
    static Scene scene;
    static Map<String, Shape3D> nameMap;
    static BranchGroup root;
    static Canvas3D canvas;

    static TransformGroup fish;
    static Transform3D transform3D;

    public Main() throws IOException {
        configureWindow();
        configureCanvas();
        configureUniverse();
        addModelToUniverse();
        setFishElementsList();
        addAppearance();
        addImageBackground();
        addLightToUniverse();
        changeViewAngle();
        root.compile();
        universe.addBranchGraph(root);
    }

    private void configureWindow()  {
        setTitle("Fish animation");
        setSize(760,640);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void configureCanvas(){
        canvas = new Canvas3D(SimpleUniverse.getPreferredConfiguration());
        canvas.setDoubleBufferEnable(true);
        getContentPane().add(canvas, BorderLayout.CENTER);
    }

    private void configureUniverse(){
        root = new BranchGroup();
        universe = new SimpleUniverse(canvas);
        universe.getViewingPlatform().setNominalViewingTransform();
    }

    private void addModelToUniverse() throws IOException{
        scene = getSceneFromFile("source_folder/12265_Fish_v1_L2.obj");
        root = scene.getSceneGroup();
    }

    public static Scene getSceneFromFile(String location) throws IOException {
        ObjectFile file = new ObjectFile(ObjectFile.RESIZE);
        file.setFlags (ObjectFile.RESIZE | ObjectFile.TRIANGULATE | ObjectFile.STRIPIFY);
        return file.load(new FileReader(location));
    }

    private void addLightToUniverse(){
        Bounds bounds = new BoundingSphere();
        Color3f color = new Color3f(65/255f, 30/255f, 25/255f);
        Vector3f lightdirection = new Vector3f(-1f,-1f,-1f);
        DirectionalLight dirlight = new DirectionalLight(color,lightdirection);
        dirlight.setInfluencingBounds(bounds);
        root.addChild(dirlight);
    }

    private void changeViewAngle(){
        ViewingPlatform vp = universe.getViewingPlatform();
        TransformGroup vpGroup = vp.getMultiTransformGroup().getTransformGroup(0);
        Transform3D vpTranslation = new Transform3D();
        Vector3f translationVector = new Vector3f(0.0F, -1.2F, 6F);
        vpTranslation.setTranslation(translationVector);
        vpGroup.setTransform(vpTranslation);
    }

    private void printModelElementsList(Map<String,Shape3D> nameMap){
        for (String name : nameMap.keySet()) {
            System.out.printf("Name: %s\n", name);}
    }

    private void setFishElementsList() {
        nameMap = scene.getNamedObjects();
        //Print elements of your model:
        printModelElementsList(nameMap);

        fish = new TransformGroup();
        transform3D = new Transform3D();
        transform3D.rotX(-Math.PI/2);
        fish.setTransform(transform3D);
        root.removeChild(nameMap.get("12265_fish"));
        fish.addChild(nameMap.get("12265_fish"));
        fish.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        root.addChild(fish);
    }

    private Texture getTexture(String path) {
        TextureLoader textureLoader = new TextureLoader(path,"RGP", new Container());
        Texture texture = textureLoader.getTexture();
        texture.setBoundaryModeS(Texture.WRAP);
        texture.setBoundaryModeT(Texture.WRAP);
        texture.setBoundaryColor( new Color4f( Color.BLUE ) );
        return texture;
    }

    private void addAppearance(){
        Appearance fishAppearance = new Appearance();
        fishAppearance.setTexture(getTexture("source_folder/fish.jpg"));
        Shape3D fish = nameMap.get("12265_fish");
        fish.setAppearance(fishAppearance);
    }

    private void addImageBackground(){
        TextureLoader t = new TextureLoader("source_folder/water.jpg", canvas);
        Background background = new Background(t.getImage());
        background.setImageScaleMode(Background.SCALE_FIT_ALL);
        BoundingSphere bounds = new BoundingSphere(new Point3d(0.0, 0.0, 0.0),100.0);
        background.setApplicationBounds(bounds);
        root.addChild(background);
    }

    public static void main(String[]args){
        try {
            Main window = new Main();
            AnimationFish fishMovement = new AnimationFish(fish, transform3D);
            window.addKeyListener(fishMovement);
            window.setVisible(true);
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}