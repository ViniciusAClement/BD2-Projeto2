package main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

import main.models.entities.LocalizacaoUser;
import main.models.services.Programa;
import main.models.services.UserServices;

public class Main {
	public static void main(String[] args) throws Exception {
        Programa.iniciarPrograma();
    }
}
