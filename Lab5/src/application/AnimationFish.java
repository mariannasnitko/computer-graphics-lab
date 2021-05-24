package application;

import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.swing.*;
import javax.vecmath.Vector3d;
import javax.vecmath.Vector3f;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class AnimationFish implements ActionListener, KeyListener {

    private TransformGroup fish;
    private Transform3D translateTransform;
    private Transform3D rotateTransformX;
    private Transform3D rotateTransformY;
    private Transform3D rotateTransformZ;

    private float zoom = 0.5f;
    private float xloc = 0.3f;
    private float yloc = 0.3f;
    private float zloc = 0.2f;
    private float delta = 0.03f;

    private boolean pressedW = false;
    private boolean pressedS = false;
    private boolean pressedA = false;
    private boolean pressedD = false;

    public AnimationFish(TransformGroup fish, Transform3D trans){
        this.fish = fish;
        this.translateTransform = trans;

        rotateTransformX= new Transform3D();
        rotateTransformY= new Transform3D();
        rotateTransformZ= new Transform3D();

        Main.canvas.addKeyListener(this);
        Timer timer = new Timer(20, this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Move();
    }

    private void Move(){
        if(pressedA){
            if (xloc*2 >= -3) {
                xloc -= delta;
            }
        } else if(pressedS){
            if(yloc*2 >= -4){
                yloc -= delta;
            }
        } else if(pressedW){
            if(yloc <= 0.03){
                yloc += delta;
            }
        } else if(pressedD){
            if(xloc <= 1.5){
                xloc += delta;
            }
        }
        translateTransform.setScale(new Vector3d(zoom,zoom,zoom));
        translateTransform.setTranslation(new Vector3f(xloc,yloc,zloc));
        fish.setTransform(translateTransform);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //Invoked when a key has been typed.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case 87: // W
                pressedW = true;
                if(pressedA){
                    rotateTransformZ.rotZ(-Math.PI/2);
                    rotateTransformY.rotY(Math.PI/2);
                    translateTransform.mul(rotateTransformZ);
                    translateTransform.mul(rotateTransformY);
                    pressedA = false;
                } else if(pressedD){
                    rotateTransformZ.rotZ(Math.PI/2);
                    rotateTransformY.rotY(Math.PI/2);
                    translateTransform.mul(rotateTransformZ);
                    translateTransform.mul(rotateTransformY);
                    pressedD = false;
                } else if(pressedS){
                    rotateTransformZ.rotZ(Math.PI);
                    translateTransform.mul(rotateTransformZ);
                    pressedS = false;
                }
                break;
            case 83: // S
                pressedS = true;
                if(pressedA){
                    rotateTransformZ.rotZ(Math.PI/2);
                    rotateTransformY.rotY(-Math.PI/2);
                    translateTransform.mul(rotateTransformZ);
                    translateTransform.mul(rotateTransformY);
                    pressedA = false;
                } else if(pressedW){
                    rotateTransformZ.rotZ(Math.PI);
                    translateTransform.mul(rotateTransformZ);
                    pressedW = false;
                } else if(pressedD){
                    rotateTransformZ.rotZ(-Math.PI/2);
                    rotateTransformY.rotY(-Math.PI/2);
                    translateTransform.mul(rotateTransformZ);
                    translateTransform.mul(rotateTransformY);
                    pressedD = false;
                }
                break;
            case 65: // A
                pressedA = true;
                if(pressedW){
                    rotateTransformX.rotX(-Math.PI/2);
                    rotateTransformY.rotY(-Math.PI/2);
                    translateTransform.mul(rotateTransformX);
                    translateTransform.mul(rotateTransformY);
                    pressedW = false;
                } else if(pressedD){
                    rotateTransformZ.rotZ(Math.PI);
                    translateTransform.mul(rotateTransformZ);
                    pressedD = false;
                } else if(pressedS){
                    rotateTransformX.rotX(-Math.PI/2);
                    rotateTransformY.rotY(Math.PI/2);
                    translateTransform.mul(rotateTransformX);
                    translateTransform.mul(rotateTransformY);
                    pressedS = false;
                }
                break;
            case 68: // D
                pressedD = true;
                if(pressedW){
                    rotateTransformZ.rotZ(-Math.PI/2);
                    rotateTransformX.rotX(Math.PI/2);
                    translateTransform.mul(rotateTransformZ);
                    translateTransform.mul(rotateTransformX);
                    pressedW = false;
                } else if(pressedA){
                    rotateTransformZ.rotZ(Math.PI);
                    translateTransform.mul(rotateTransformZ);
                    pressedA = false;
                } else if(pressedS){
                    rotateTransformZ.rotZ(Math.PI/2);
                    rotateTransformX.rotX(Math.PI/2);
                    translateTransform.mul(rotateTransformZ);
                    translateTransform.mul(rotateTransformX);
                    pressedS = false;
                }
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}