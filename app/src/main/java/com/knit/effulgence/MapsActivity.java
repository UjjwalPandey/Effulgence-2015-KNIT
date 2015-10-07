package com.knit.effulgence;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends Activity {
    static final LatLng Academics = new LatLng(26.28862014, 82.08262546);
    static final LatLng Main_Gate = new LatLng(26.28905761, 82.0798713);
    static final LatLng Ramanujam = new LatLng(26.28503672, 82.08074033);
    static final LatLng Maitrayee = new LatLng(26.28619106, 82.08269298);
    static final LatLng Ground = new LatLng(26.28872093, 82.08180249);
    static final LatLng Khosla = new LatLng(26.28548884, 82.07983911);
    static final LatLng VS = new LatLng(26.28480586, 82.07915246);
    static final LatLng CSA = new LatLng(26.28817264,82.08268225);
    static final LatLng Aryabhatt = new LatLng(26.28696061,82.07921684);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyConnection conn = new MyConnection(this);
        setContentView(R.layout.activity_maps);
        ImageView imgMap = (ImageView)findViewById(R.id.ivMap);
        Fragment frag = getFragmentManager().findFragmentById(R.id.fvmap);
        if(conn.isConnectingToInternet()){
            if(!frag.isVisible())
            frag.setUserVisibleHint(true);
            imgMap.setVisibility(View.GONE);
            initializeMap();
        }else{
            if(frag.isVisible())
            frag.setUserVisibleHint(false);
            imgMap.setVisibility(View.VISIBLE);
            errorToast();
        }
        imgMap.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                errorToast();
            }
        });
    }

    private void errorToast(){
        Toast.makeText(getApplicationContext(), "Sorry! No Internet Connection", Toast.LENGTH_SHORT).show();
    }

    private void initializeMap() {

        GoogleMap map = ((MapFragment) getFragmentManager().findFragmentById(R.id.fvmap))
                .getMap();
        map.getUiSettings().setZoomControlsEnabled(true);
        map.getUiSettings().setCompassEnabled(true);
        map.getUiSettings().setMyLocationButtonEnabled(true);
        map.getUiSettings().setRotateGesturesEnabled(true);

        if (map != null) {

            Marker main_gate = map.addMarker(new MarkerOptions().position(Main_Gate)
                            .title("KNIT Main Gate")
            );
            main_gate.showInfoWindow();

            Marker ramanujam = map.addMarker(new MarkerOptions().position(Ramanujam)
                            .title("Ramanujam")
                            .snippet("Boy's Hostel")
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE))
            );
            ramanujam.showInfoWindow();

            Marker ground = map.addMarker(new MarkerOptions().position(Ground)
                            .title("KNIT Ground")
            );
            ground.showInfoWindow();

            Marker khosla = map.addMarker(new MarkerOptions().position(Khosla)
                            .title("Khosla")
                            .snippet("Boy's Hostel")
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE))
            );
            khosla.showInfoWindow();

            Marker vs = map.addMarker(new MarkerOptions().position(VS)
                            .title("Old V.S.")
                            .snippet("Boy's Hostel")
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE))
            );
            vs.showInfoWindow();

            Marker maitrayee = map.addMarker(new MarkerOptions().position(Maitrayee)
                            .title("Maitrayee")
                            .snippet("Girl's Hostel")
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE))
            );
            maitrayee.showInfoWindow();

            Marker csa = map.addMarker(new MarkerOptions().position(CSA)
                            .title("C.S.A.")
                            .snippet("Council for Student Activity")
            );

            csa.showInfoWindow();

            Marker aryabhatt = map.addMarker(new MarkerOptions().position(Aryabhatt)
                            .title("Aryabhatt")
                            .snippet("Boy's Hostel")
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE))
            );
            aryabhatt.showInfoWindow();

            Marker academics = map.addMarker(new MarkerOptions().position(Academics)
                            .title("KNIT")
                            .snippet("Academics")
            );
            academics.showInfoWindow();

            // Move the camera instantly to KNIT with a zoom of 15.
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(Ground, 10));
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(Main_Gate, 10));
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(CSA, 10));
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(Maitrayee, 10));
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(Ramanujam, 10));
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(Khosla, 10));
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(VS, 10));
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(Academics, 10));

            // Zoom in, animating the camera.
            map.animateCamera(CameraUpdateFactory.zoomTo(15.75f), 2000, null);


        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        initializeMap();
    }

}