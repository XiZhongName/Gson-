package com.example.gsondemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.gsondemo.bean.ShopBean;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_json_ToJavaObject,btn_jsonArray_ToJavaList,btn_Java_To_Json,btn_javaList_To_jsonArray;
    private TextView tv_native_original,tv_native_last;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initListener();
    }

    private void initListener() {
        btn_json_ToJavaObject.setOnClickListener(this);
        btn_jsonArray_ToJavaList.setOnClickListener(this);
        btn_Java_To_Json.setOnClickListener(this);
        btn_javaList_To_jsonArray.setOnClickListener(this);
    }

    private void initView() {
        btn_json_ToJavaObject = findViewById(R.id.btn_json_ToJavaObject);
        btn_jsonArray_ToJavaList = findViewById(R.id.btn_jsonArray_ToJavaList);
        btn_Java_To_Json = findViewById(R.id.btn_Java_To_Json);
        btn_javaList_To_jsonArray = findViewById(R.id.btn_javaList_To_jsonArray);
        tv_native_original = findViewById(R.id.tv_native_original);
        tv_native_last = findViewById(R.id.tv_native_last);
    }
/**
 * (1)将json格式的字符串转换为java对象
 * （2）将json格式的字符串转换为java对象的List
 * (3)将java对象转换为json字符串
 * （4）将java对象的List转换为json字符串
 * */
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_json_ToJavaObject:
                jsonToJavaObjectByGson();//将json格式的字符串转换为java对象
                break;
            case R.id.btn_jsonArray_ToJavaList:
                jsonToJavaListByGson();//将json格式的字符串转换为java对象的List
                break;
            case R.id.btn_Java_To_Json:
                javaToJsonObjectByGson();//将java对象转换为json字符串
                break;
            case R.id.btn_javaList_To_jsonArray:
                javaToJsonArrayByGson();//将java对象的List转换为json字符串
                break;
        }
    }
    //将java对象的List转换为json字符串
    private void javaToJsonArrayByGson() {
        //获取或创建java对象
        List<ShopBean> shops = new ArrayList<>();
        ShopBean baoyu = new ShopBean(7,"鲍鱼",99.9,"192.123.114/yu.jpg");
        ShopBean haishen = new ShopBean(3,"海参",89.9,"192.123.114/shen.jpg");
        shops.add(baoyu);
        shops.add(haishen);
        //生成JSON数据
        Gson gson = new Gson();
        String json = gson.toJson(shops);
        //展示数据
        tv_native_original.setText(shops.toString());
        tv_native_last.setText(json);
    }

    //将java对象转换为json字符串
    private void javaToJsonObjectByGson() {
        //获取或创建java对象
        ShopBean shopBean = new ShopBean(3,"海参",89.9,"192.123.114/shen.jpg");
        //生成JSON数据
        Gson gson = new Gson();
        String json = gson.toJson(shopBean);
        //展示数据
        tv_native_original.setText(shopBean.toString());
        tv_native_last.setText(json);
    }

    //将json格式的字符串转换为java对象的List
    private void jsonToJavaListByGson() {
        //获取或创建JSON数据
        String json = "[\n" +
                "    {\n" +
                "        \"id\":1,\n" +
                "        \"name\":\"小虾米1\",\n" +
                "        \"price\":21.9,\n" +
                "        \"imagePath\":\"http://192.168.10.165:8080/server/images/xia.jpg\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":2,\n" +
                "        \"name\":\"小虾米2\",\n" +
                "        \"price\":22.9,\n" +
                "        \"imagePath\":\"http://192.168.10.165:8080/server/images/xia.jpg\"\n" +
                "    } \n" +
                "]";
        //解析JSON数据
        Gson gson = new Gson();
        List<ShopBean> shops = gson.fromJson(json, new TypeToken<List<ShopBean>>() {
        }.getType());
        //展示数据
        tv_native_original.setText(json);
        tv_native_last.setText(shops.toString());
    }

    //将json格式的字符串转换为java对象
    private void jsonToJavaObjectByGson() {
        //获取或创建JSON数据
        String json = "{\n" +
                "    \"id\":2,\n" +
                "    \"name\":\"小虾米\",\n" +
                "    \"price\":21.9,\n" +
                "    \"imagePath\":\"http://192.168.10.165:8080/server/images/xia.jpg\"\n" +
                "}";
        //解析JSON数据
        Gson gson = new Gson();
        ShopBean shopBean = gson.fromJson(json, ShopBean.class);//shopBean为解析后的数据
        //展示数据
        tv_native_original.setText(json);
        tv_native_last.setText(shopBean.toString());

    }
}




















