package main.models.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.Gson;

import main.models.dao.UbsDao;
import main.models.entities.LocalizacaoUser;
import main.models.entities.Ubs;
import main.models.entities.UbsDistancia;

public class UserServices {
	
	//Api q automaticamente pega teu ip´e retorna um moi de coisa, ela salva na classe Ubs
	public static LocalizacaoUser acharPeloIP() {
		try {
			URL url = new URL("http://ip-api.com/json/");
			
			HttpURLConnection http = (HttpURLConnection) url.openConnection();
		    http.setRequestMethod("GET");
		    
		    int resposta = http.getResponseCode();
		    
		    if (resposta == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(http.getInputStream()));
                StringBuilder response = new StringBuilder();
                String inputLine;

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                
                Gson gson = new Gson();
                return gson.fromJson(response.toString(), LocalizacaoUser.class);
                
                
		    }else {
		    	System.out.println("Deu Erro Dog");
        	}

			} catch (Exception e) {
				e.printStackTrace();
    		}
		return null;
	}
	
	//pega o nome da cidade e transforma em codigo do IBGE
	public static Integer codigoIbgeDaCidade() {
	    String cidade = acharPeloIP().getCity().toLowerCase().trim();

	    try {
	        URL url = new URL("https://servicodados.ibge.gov.br/api/v1/localidades/municipios");
	        HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
	        conexao.setRequestMethod("GET");

	        BufferedReader in = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
	        StringBuilder conteudo = new StringBuilder();

	        String inputLine;
	        while ((inputLine = in.readLine()) != null) {
	            conteudo.append(inputLine);
	        }
	        in.close();
	        conexao.disconnect();

	        JSONArray municipios = new JSONArray(conteudo.toString());

	        for (int i = 0; i < municipios.length(); i++) {
	            JSONObject municipio = municipios.getJSONObject(i);
	            String nome = municipio.getString("nome").toLowerCase();

	            if (nome.equals(cidade)) {
	                int codigo = municipio.getInt("id");
	                String codStr = String.valueOf(codigo);
	                if (codStr.length() > 6) {
	                    String codiguin = codStr.substring(0, codStr.length() - 1);
	                    return Integer.parseInt(codiguin);
	                }
	                return codigo;
	            }
	        }
	        System.out.println("Cidade não encontrada.");
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return null;
	}
	
	//metodoq  calcula a distancia,(N ta funfando)
	public static double distancia(double latUser, double lonUser, double latUbs, double lonUbs) {
	    final int raio = 6371000;

	    double lat1Rad = Math.toRadians(latUser);
	    double lat2Rad = Math.toRadians(latUbs);
	    double deltaLat = Math.toRadians(latUbs - latUser);
	    double deltaLon = Math.toRadians(lonUbs - lonUser);

	    double a = Math.sin(deltaLat / 2) * Math.sin(deltaLat / 2) +
	               Math.cos(lat1Rad) * Math.cos(lat2Rad) *
	               Math.sin(deltaLon / 2) * Math.sin(deltaLon / 2);

	    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

	    return raio * c;
	}

	public static UbsDistancia ubsMaisProxima(){
	    Integer codigoIbge = codigoIbgeDaCidade();
	    List<Ubs> s = UbsDao.ubsPorCidade(codigoIbge);

	    UbsDistancia ubsProxima = new UbsDistancia();
	    ubsProxima.setDistancia(Double.MAX_VALUE);

	    Double latUser = Double.parseDouble( acharPeloIP().getLat());
	    Double lonUser = Double.parseDouble( acharPeloIP().getLon());
	    if (latUser == null || lonUser == null) {
	        System.out.println("Latitude ou longitude do usuário não disponíveis.");
	        return null;
	    }

	    for (Ubs ubs : s) {
	        double distancia = distancia(latUser, lonUser, ubs.getLatitude(), ubs.getLongitude());
	        if (distancia < ubsProxima.getDistancia()) {
	            ubsProxima.setDistancia(distancia);
	            ubsProxima.setUbs(ubs);
	        }
	    }
	    return ubsProxima;
	}
}
