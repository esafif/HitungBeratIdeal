package com.example.esafi.hitungberatideal;

import android.app.Application;

/**
 * Created by esafi on 02/05/2017.
 */

import io.realm.DynamicRealm;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmMigration;
import io.realm.RealmSchema;

public class BaseApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        //kode konfigurasi Realm
        RealmConfiguration config = new RealmConfiguration.Builder(this)
                //versi database
                .schemaVersion(0)
                .migration(new DataMigration())
                .build();

        Realm.setDefaultConfiguration(config);

    }

    private class DataMigration implements RealmMigration {
        @Override
        public void migrate(DynamicRealm realm, long oldVersion, long newVersion) {

            //Mengambil schema
            RealmSchema schema = realm.getSchema();

            //membuat schema baru jika versi 0
            if (oldVersion == 0) {
                schema.create("DataBerat")
                        .addField("id", int.class)
                        .addField("nama", String.class)
                        .addField("jenisKelamin", String.class)
                        .addField("tinggi", int.class)
                        .addField("berat", int.class)
                        .addField("beratIdeal", double.class)
                        .addField("bmi", double.class)
                        .addField("kesimpulan", String.class);
                oldVersion++;
            }

        }
    }
}
