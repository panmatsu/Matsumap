package com.example.matsu.matsumap;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity  {

    private GoogleMap mMap = null;
    //タッチした時に座標を保存
    LatLng lat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);


        mMap = ( (SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.map) ).getMap();

        if(mMap!=null){
            //タッチ時のイベント
            mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
                @Override
                public void onMapClick(LatLng latLng) {

                    //タッチした座標をトーストで表示
                    Toast.makeText(getApplicationContext(), "タップ位置\n緯度：" + latLng.latitude + "\n経度:" + latLng.longitude, Toast.LENGTH_LONG).show();
                    //タッチした座標を引数のlatLngから取得
                    lat = latLng;
                    //代入された座標へマーカーを設置
                    mMap.addMarker(new MarkerOptions().position(lat));
                    //最新の場所へカメラが寄る
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(lat));
                }
            });
        }
    }
}
