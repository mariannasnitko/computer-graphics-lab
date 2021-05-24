package application;

import com.sun.j3d.utils.geometry.*;
import com.sun.j3d.utils.image.TextureLoader;

import javax.media.j3d.Appearance;
import javax.media.j3d.Material;
import javax.media.j3d.Texture;
import javax.media.j3d.TextureAttributes;
import javax.vecmath.Color3f;
import javax.vecmath.Color4f;
import java.awt.*;

public class PCBuilder {
        public static Box getPart(float x, float y, float z) {
            int primitive_flags = Primitive.GENERATE_NORMALS + Primitive.GENERATE_TEXTURE_COORDS;
            return new Box(x, y, z, primitive_flags, getTableAppearance());
        }
        public static Box getPCBox(float x, float y, float z) {
                int primitive_flags = Primitive.GENERATE_NORMALS + Primitive.GENERATE_TEXTURE_COORDS;
                return new Box(x, y, z, primitive_flags, get_PC_box_Appearance());
        }
        public static Box getPCBack(float x, float y, float z) {
                int primitive_flags = Primitive.GENERATE_NORMALS + Primitive.GENERATE_TEXTURE_COORDS;
                return new Box(x, y, z, primitive_flags, get_PC_box_back_Appearance());
        }

        public static Box getMonitor(float x, float y, float z) {
                int primitive_flags = Primitive.GENERATE_NORMALS + Primitive.GENERATE_TEXTURE_COORDS;
                return new Box(x, y, z, primitive_flags, get_Monitor_Appearance());
        }

        public static Cylinder getMonitor(float radius, float height) {
                int primitive_flags = Primitive.GENERATE_NORMALS + Primitive.GENERATE_TEXTURE_COORDS;
                return new Cylinder(radius, height, primitive_flags, get_Monitor_Appearance());
        }
        public static Cylinder getPush(float radius, float height) {
                int primitive_flags = Primitive.GENERATE_NORMALS + Primitive.GENERATE_TEXTURE_COORDS;
                return new Cylinder(radius, height, primitive_flags, get_Push_Appearance());
        }
        public static Box getScreen(float x, float y, float z) {
                int primitive_flags = Primitive.GENERATE_NORMALS + Primitive.GENERATE_TEXTURE_COORDS;
                return new Box(x,y,z, primitive_flags, get_Screen_Appearance());
        }
        public static Box getButton(float x, float y, float z) {
                int primitive_flags = Primitive.GENERATE_NORMALS + Primitive.GENERATE_TEXTURE_COORDS;
                return new Box(x,y,z, primitive_flags, get_Button_Appearance());
        }

        public static Cylinder getButton(float radius, float height) {
                int primitive_flags = Primitive.GENERATE_NORMALS + Primitive.GENERATE_TEXTURE_COORDS;
                return new Cylinder(radius,height, primitive_flags, get_Button_Appearance());
        }
        public static Box getCD(float x, float y, float z) {
                int primitive_flags = Primitive.GENERATE_NORMALS + Primitive.GENERATE_TEXTURE_COORDS;
                return new Box(x,y,z, primitive_flags, get_CD_Appearance());
        }

        private static Appearance getTableAppearance() {
                TextureLoader loader = new TextureLoader("src\\textures\\wood.jpg", "LUMINANCE", new Container());
                Appearance ap = new Appearance();

                Texture texture = loader.getTexture();
                texture.setBoundaryModeS(Texture.WRAP);
                texture.setBoundaryModeT(Texture.WRAP);
                texture.setBoundaryColor(new Color4f(0.0f, 1.0f, 1.0f, 0.0f));

                TextureAttributes texAttr = new TextureAttributes();
                texAttr.setTextureMode(TextureAttributes.MODULATE);

                ap.setTexture(texture);
                ap.setTextureAttributes(texAttr);

                Color3f emissive = new Color3f(new Color(69, 29, 0));
                Color3f ambient = new Color3f(new Color(119, 41, 0));
                Color3f diffuse = new Color3f();
                Color3f specular = new Color3f(new Color(0, 0, 0));
                ap.setMaterial(new Material(ambient, emissive, diffuse, specular, 1.0f));
                return ap;
    }
        private static Appearance get_PC_box_Appearance() {
                TextureLoader loader = new TextureLoader("src\\textures\\plastic_for_pc.jpg", "LUMINANCE", new Container());
                Appearance ap = new Appearance();

                Texture texture = loader.getTexture();
                texture.setBoundaryModeS(Texture.WRAP);
                texture.setBoundaryModeT(Texture.WRAP);
                texture.setBoundaryColor(new Color4f(0.0f, 1.0f, 1.0f, 0.0f));

                TextureAttributes texAttr = new TextureAttributes();
                texAttr.setTextureMode(TextureAttributes.MODULATE);

                ap.setTexture(texture);
                ap.setTextureAttributes(texAttr);

                Color3f emissive = new Color3f(new Color(99, 99, 101));
                Color3f ambient = new Color3f(new Color(0, 0, 0, 210));
                Color3f diffuse = new Color3f();
                Color3f specular = new Color3f(new Color(0, 0, 0));
                ap.setMaterial(new Material(ambient, emissive, diffuse, specular, 1.0f));
                return ap;
        }

        private static Appearance get_PC_box_back_Appearance() {
                TextureLoader loader = new TextureLoader("src\\textures\\metal.jpg", "LUMINANCE", new Container());
                Appearance ap = new Appearance();

                Texture texture = loader.getTexture();
                texture.setBoundaryModeS(Texture.WRAP);
                texture.setBoundaryModeT(Texture.WRAP);
                texture.setBoundaryColor(new Color4f(0.0f, 1.0f, 1.0f, 0.0f));

                TextureAttributes texAttr = new TextureAttributes();
                texAttr.setTextureMode(TextureAttributes.MODULATE);

                ap.setTexture(texture);
                ap.setTextureAttributes(texAttr);

                Color3f emissive = new Color3f(new Color(71, 71, 73));
                Color3f ambient = new Color3f(new Color(179, 179, 179, 210));
                Color3f diffuse = new Color3f();
                Color3f specular = new Color3f(new Color(0, 0, 0));
                ap.setMaterial(new Material(ambient, emissive, diffuse, specular, 1.0f));
                return ap;
        }

        private static Appearance get_Monitor_Appearance() {
                TextureLoader loader = new TextureLoader("src\\textures\\plastic.jpg", "LUMINANCE", new Container());
                Appearance ap = new Appearance();

                Texture texture = loader.getTexture();
                texture.setBoundaryModeS(Texture.WRAP);
                texture.setBoundaryModeT(Texture.WRAP);
                texture.setBoundaryColor(new Color4f(0.0f, 1.0f, 1.0f, 0.0f));

                TextureAttributes texAttr = new TextureAttributes();
                texAttr.setTextureMode(TextureAttributes.MODULATE);

                ap.setTexture(texture);
                ap.setTextureAttributes(texAttr);

                Color3f emissive = new Color3f(new Color(71, 71, 73));
                Color3f ambient = new Color3f(new Color(6, 6, 6, 210));
                Color3f diffuse = new Color3f();
                Color3f specular = new Color3f(new Color(0, 0, 0));
                ap.setMaterial(new Material(ambient, emissive, diffuse, specular, 1.0f));
                return ap;
        }
        private static Appearance get_Push_Appearance() {
                TextureLoader loader = new TextureLoader("src\\textures\\push.jpg", "LUMINANCE", new Container());
                return getAppearance(loader);
        }

        private static Appearance getAppearance(TextureLoader loader) {
                Appearance ap = new Appearance();

                Texture texture = loader.getTexture();
                texture.setBoundaryModeS(Texture.WRAP);
                texture.setBoundaryModeT(Texture.WRAP);
                texture.setBoundaryColor(new Color4f(0.0f, 1.0f, 1.0f, 0.0f));

                TextureAttributes texAttr = new TextureAttributes();
                texAttr.setTextureMode(TextureAttributes.MODULATE);

                ap.setTexture(texture);
                ap.setTextureAttributes(texAttr);

                Color3f emissive = new Color3f(new Color(3, 3, 4));
                Color3f ambient = new Color3f(new Color(255, 0, 0, 255));
                Color3f diffuse = new Color3f();
                Color3f specular = new Color3f(new Color(0, 0, 0));
                ap.setMaterial(new Material(ambient, emissive, diffuse, specular, 1.0f));
                return ap;
        }

        private static Appearance get_CD_Appearance() {
                TextureLoader loader = new TextureLoader("src\\textures\\cd.jpg", "LUMINANCE", new Container());
                return getAppearance(loader);
        }

        private static Appearance get_Button_Appearance() {
                TextureLoader loader = new TextureLoader("src\\textures\\buttons.jpg", "LUMINANCE", new Container());
                Appearance ap = new Appearance();

                Texture texture = loader.getTexture();
                texture.setBoundaryModeS(Texture.WRAP);
                texture.setBoundaryModeT(Texture.WRAP);
                texture.setBoundaryColor(new Color4f(0.0f, 1.0f, 1.0f, 0.0f));

                TextureAttributes texAttr = new TextureAttributes();
                texAttr.setTextureMode(TextureAttributes.MODULATE);

                ap.setTexture(texture);
                ap.setTextureAttributes(texAttr);

                Color3f emissive = new Color3f(new Color(87, 87, 87));
                Color3f ambient = new Color3f(new Color(140, 0, 0, 246));
                Color3f diffuse = new Color3f();
                Color3f specular = new Color3f(new Color(0, 0, 0));
                ap.setMaterial(new Material(ambient, emissive, diffuse, specular, 1.0f));
                return ap;
        }
        private static Appearance get_Screen_Appearance() {
                TextureLoader loader = new TextureLoader("src\\textures\\screen.png", "LUMINANCE", new Container());
                Appearance ap = new Appearance();

                Texture texture = loader.getTexture();
                texture.setBoundaryModeS(Texture.WRAP);
                texture.setBoundaryModeT(Texture.WRAP);
                texture.setBoundaryColor(new Color4f(0.0f, 1.0f, 1.0f, 0.0f));

                TextureAttributes texAttr = new TextureAttributes();
                texAttr.setTextureMode(TextureAttributes.MODULATE);

                ap.setTexture(texture);
                ap.setTextureAttributes(texAttr);

                Color3f emissive = new Color3f(new Color(0, 3, 119));
                Color3f ambient = new Color3f(new Color(0, 3, 50, 238));
                Color3f diffuse = new Color3f();
                Color3f specular = new Color3f(new Color(0, 0, 0));
                ap.setMaterial(new Material(ambient, emissive, diffuse, specular, 1.0f));
                return ap;
        }
}