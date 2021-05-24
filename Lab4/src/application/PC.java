package application;

import com.sun.j3d.utils.geometry.*;
import com.sun.j3d.utils.geometry.Box;
import com.sun.j3d.utils.universe.SimpleUniverse;
import javax.media.j3d.*;
import javax.swing.*;
import javax.vecmath.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PC implements ActionListener {
    private TransformGroup carTransformGroup = new TransformGroup();
    private Transform3D carTransform3D = new Transform3D();
    private Timer timer;
    private float angle= 0;
    public static void main(String[] args) {
        new PC();

    }

    private PC() {
        timer = new Timer(50, this);
        timer.start();
        BranchGroup scene = createSceneGraph();
        SimpleUniverse u = new SimpleUniverse();
        u.getViewingPlatform().setNominalViewingTransform();
        u.addBranchGraph(scene);

    }

    private BranchGroup createSceneGraph() {
        BranchGroup objRoot = new BranchGroup();
        carTransformGroup = new TransformGroup();
        carTransformGroup.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        MakePC();

        objRoot.addChild(carTransformGroup);

        Background background = new Background(new Color3f(1.0f, 1.0f, 1.0f));
        BoundingSphere sphere = new BoundingSphere(new Point3d(0,0,0), 100000);
        background.setApplicationBounds(sphere);
        objRoot.addChild(background);

        BoundingSphere bounds = new BoundingSphere(new Point3d(0.0, 0.0, 0.0),100.0);
        Color3f light1Color = new Color3f(1.0f, 0.5f, 0.4f);
        Vector3f light1Direction = new Vector3f(.8f, .8f, .0f);
        DirectionalLight light1 = new DirectionalLight(light1Color, light1Direction);
        light1.setInfluencingBounds(bounds);
        objRoot.addChild(light1);

        Color3f ambientColor = new Color3f(1.0f, 1.0f, 1.0f);
        AmbientLight ambientLightNode = new AmbientLight(ambientColor);
        ambientLightNode.setInfluencingBounds(bounds);
        objRoot.addChild(ambientLightNode);
        return objRoot;
    }

    private void MakePC() {
        Box leg1 = PCBuilder.getPart(.02f,.3f,.3f);
        Transform3D body1T = new Transform3D();
        body1T.setTranslation(new Vector3f(.4f, .0f, .0f));
        TransformGroup body1TG = new TransformGroup();
        body1TG.setTransform(body1T);
        body1TG.addChild(leg1);
        carTransformGroup.addChild(body1TG);


        Box leg2 = PCBuilder.getPart(.02f,.3f,.3f);
        Transform3D body2T = new Transform3D();
        body2T.setTranslation(new Vector3f(-.4f, .0f, .0f));
        TransformGroup body2TG = new TransformGroup();
        body2TG.setTransform(body2T);
        body2TG.addChild(leg2);
        carTransformGroup.addChild(body2TG);


        Box table = PCBuilder.getPart(.6f,.01f,.34f);
        Transform3D body3T = new Transform3D();
        body3T.setTranslation(new Vector3f(.0f, .3f, .0f));
        TransformGroup body3TG = new TransformGroup();
        body3TG.setTransform(body3T);
        body3TG.addChild(table);
        carTransformGroup.addChild(body3TG);


        Box PC_Box = PCBuilder.getPCBox(.08f,.2f,.28f);
        Transform3D body4T = new Transform3D();
        body4T.setTranslation(new Vector3f(.2f, -.1f, .025f));
        TransformGroup body4TG = new TransformGroup();
        body4TG.setTransform(body4T);
        body4TG.addChild(PC_Box);
        carTransformGroup.addChild(body4TG);

        Box PC_Box_back = PCBuilder.getPCBack(.078f,.168f,.005f);
        Transform3D body5T = new Transform3D();
        body5T.setTranslation(new Vector3f(.2f, -.07f, -.26f));
        TransformGroup body5TG = new TransformGroup();
        body5TG.setTransform(body5T);
        body5TG.addChild(PC_Box_back);
        carTransformGroup.addChild(body5TG);

        Cylinder PC_Monitor_bottom = PCBuilder.getMonitor(.1f,.03f);
        Transform3D body6T = new Transform3D();
        body6T.setTranslation(new Vector3f(.0f, .32f, .0f));
        TransformGroup body6TG = new TransformGroup();
        body6TG.setTransform(body6T);
        body6TG.addChild(PC_Monitor_bottom);
        carTransformGroup.addChild(body6TG);

        Cylinder PC_Monitor_leg = PCBuilder.getMonitor(.013f,.08f);
        Transform3D body7T = new Transform3D();
        body7T.setTranslation(new Vector3f(.0f, .37f, .0f));
        TransformGroup body7TG = new TransformGroup();
        body7TG.setTransform(body7T);
        body7TG.addChild(PC_Monitor_leg);
        carTransformGroup.addChild(body7TG);

        Box PC_Monitor = PCBuilder.getMonitor(.3f,.18f,0.015f);
        Transform3D body8T = new Transform3D();
        body8T.setTranslation(new Vector3f(.0f, .59f, .0f));
        TransformGroup body8TG = new TransformGroup();
        body8TG.setTransform(body8T);
        body8TG.addChild(PC_Monitor);
        carTransformGroup.addChild(body8TG);

        Box PC_Screen = PCBuilder.getScreen(.29f,.165f,0.001f);
        Transform3D body9T = new Transform3D();
        body9T.setTranslation(new Vector3f(.0f, .59f, .015f));
        TransformGroup body9TG = new TransformGroup();
        body9TG.setTransform(body9T);
        body9TG.addChild(PC_Screen);
        carTransformGroup.addChild(body9TG);

        Cylinder PC_Push = PCBuilder.getPush(.05f,0.001f);
        Transform3D body10T = new Transform3D();
        body10T.rotX(Math.PI/2);
        body10T.setTranslation(new Vector3f(.2f, -.19f, .305f));
        TransformGroup body10TG = new TransformGroup();
        body10TG.setTransform(body10T);
        body10TG.addChild(PC_Push);
        carTransformGroup.addChild(body10TG);

        Box PC_CD1 = PCBuilder.getCD(.06f,.008f,0.001f);
        Transform3D body11T = new Transform3D();
        body11T.setTranslation(new Vector3f(.2f, -0.f, .305f));
        TransformGroup body11TG = new TransformGroup();
        body11TG.setTransform(body11T);
        body11TG.addChild(PC_CD1);
        carTransformGroup.addChild(body11TG);


        Box PC_CD2 = PCBuilder.getCD(.06f,.008f,0.001f);
        Transform3D body12T = new Transform3D();
        body12T.setTranslation(new Vector3f(.2f, 0.02f, .305f));
        TransformGroup body12TG = new TransformGroup();
        body12TG.setTransform(body12T);
        body12TG.addChild(PC_CD2);
        carTransformGroup.addChild(body12TG);

        Box PC_CD3 = PCBuilder.getCD(.06f,.008f,0.001f);
        Transform3D body13T = new Transform3D();
        body13T.setTranslation(new Vector3f(.2f, 0.04f, .305f));
        TransformGroup body13TG = new TransformGroup();
        body13TG.setTransform(body13T);
        body13TG.addChild(PC_CD3);
        carTransformGroup.addChild(body13TG);


        Box PC_USB1 = PCBuilder.getButton(.013f,.005f,0.001f);
        Transform3D body14T = new Transform3D();
        body14T.setTranslation(new Vector3f(.22f, -.02f, .305f));
        TransformGroup body14TG = new TransformGroup();
        body14TG.setTransform(body14T);
        body14TG.addChild(PC_USB1);
        carTransformGroup.addChild(body14TG);

        Box PC_USB2 = PCBuilder.getButton(.013f,.005f,0.001f);
        Transform3D body15T = new Transform3D();
        body15T.setTranslation(new Vector3f(.18f, -.02f, .305f));
        TransformGroup body15TG = new TransformGroup();
        body15TG.setTransform(body15T);
        body15TG.addChild(PC_USB2);
        carTransformGroup.addChild(body15TG);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        carTransform3D.rotY(angle);
        carTransform3D.setScale(0.6);
        carTransformGroup.setTransform(carTransform3D);
        angle += 0.03;
    }
}