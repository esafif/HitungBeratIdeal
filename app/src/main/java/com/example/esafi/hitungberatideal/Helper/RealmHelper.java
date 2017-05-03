package com.example.esafi.hitungberatideal.Helper;

import android.content.Context;
import android.provider.ContactsContract;
import android.util.Log;
import android.widget.Toast;

import com.example.esafi.hitungberatideal.Model.DataBeratModel;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.Sort;


/**
 * Created by esafi on 02/05/2017.
 */

public class RealmHelper {

    private static final String TAG = "RealmHelper";

    private Realm realm;
    private RealmResults<DataBerat> realmResult;
    public Context context;

    public RealmHelper(Context context) {
        realm = Realm.getInstance(context);
        this.context = context;
    }

    public void addDataBerat(String nama, String jenisKelamin, int tinggi, int berat, double beratIdeal, double bmi, String kesimpulan) {
        DataBerat dataBerat = new DataBerat();
        dataBerat.setId((int) (System.currentTimeMillis() / 1000));
        dataBerat.setNama(nama);
        dataBerat.setJenisKelamin(jenisKelamin);
        dataBerat.setTinggi(tinggi);
        dataBerat.setBerat(berat);
        dataBerat.setBeratIdeal(beratIdeal);
        dataBerat.setBmi(bmi);
        dataBerat.setKesimpulan(kesimpulan);


        realm.beginTransaction();
        realm.copyToRealm(dataBerat);
        realm.commitTransaction();


        showLog("Added ; " + nama);
        showToast("Data " +nama + " berhasil disimpan.");
    }

    public ArrayList<DataBeratModel> findAllArticle() {
        ArrayList<DataBeratModel> data = new ArrayList<>();


        realmResult = realm.where(DataBerat.class).findAll();
        realmResult.sort("id", Sort.DESCENDING);
        if (realmResult.size() > 0) {
            showLog("Size : " + realmResult.size());


            for (int i = 0; i < realmResult.size(); i++) {

                String nama;
                String jenisKelamin;
                int tinggi;
                int berat;
                double beratIdeal;
                double bmi;
                String kesimpulan;

                int id = realmResult.get(i).getId();
                nama = realmResult.get(i).getNama();
                jenisKelamin = realmResult.get(i).getJenisKelamin();
                tinggi = realmResult.get(i).getTinggi();
                berat = realmResult.get(i).getBerat();
                beratIdeal = realmResult.get(i).getBeratIdeal();
                bmi = realmResult.get(i).getBmi();
                kesimpulan = realmResult.get(i).getKesimpulan();
                data.add(new DataBeratModel(id, nama, jenisKelamin, tinggi, berat, beratIdeal, bmi, kesimpulan));
            }

        } else {
            showLog("Size : 0");
            showToast("Database Kosong!");
        }
        return data;
    }

    public void deleteData(int id) {
        RealmResults<DataBerat> dataDesults = realm.where(DataBerat.class).equalTo("id", id).findAll();
        realm.beginTransaction();
        dataDesults.remove(0);
        dataDesults.removeLast();
        dataDesults.clear();
        realm.commitTransaction();

        showToast("Hapus data berhasil.");
    }

    private void showLog(String s) {
        Log.d(TAG, s);

    }

    /**
     * Membuat Toast Informasi
     */
    private void showToast(String s) {
        Toast.makeText(context, s, Toast.LENGTH_LONG).show();
    }
}
