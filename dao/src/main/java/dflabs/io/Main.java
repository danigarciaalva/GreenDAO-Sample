package dflabs.io;

import java.io.IOException;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

public class Main {

    public static void main(String[] args) throws Exception {
        Schema schema = new Schema(1, "dflabs.io.dao");
        schema.enableKeepSectionsByDefault();
        createSchema(schema);
        DaoGenerator generator = new DaoGenerator();
        generator.generateAll(schema, args[0]);
    }

    private static void createSchema(Schema schema) {
        Entity post = schema.addEntity("Post");
        post.addIdProperty();
        post.addStringProperty("title");
        post.addStringProperty("body");
        post.addStringProperty("image");
    }
}
