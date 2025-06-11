package main.models.services;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.json.JSONArray;

import com.google.gson.Gson;

import main.models.dao.MunicipiosIbge;
import main.models.entities.LocalizacaoUser;

public class UserServices {
	//aqui estamos usando a api do ip.com
	//aq está pegando o ip do usuário e obtendo seu dados geográficos 
	public static LocalizacaoUser acharPeloIP() {
		try {
			//aq se cria a classe url pra conectar a api
			URL url = new URL("http://ip-api.com/json/");
			
			//conex]ão propriamente dita do site, o http se conecta ao url do site
			HttpURLConnection http = (HttpURLConnection) url.openConnection();
			
			//aqui ta declarado q so queremos pegar dados.
		    http.setRequestMethod("GET");
		    
		    //aq o java ta lendo os dados dos sites, de bites pra texto o site manda e meio q isso lê e transforma em json
            BufferedReader in = new BufferedReader(new InputStreamReader(http.getInputStream()));
            StringBuilder resposta = new StringBuilder();
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                resposta.append(inputLine);
            }
            in.close();
            //transforma o json em onjeto java
            Gson gson = new Gson();
            return gson.fromJson(resposta.toString(), LocalizacaoUser.class);


			} catch (Exception e) {
				e.printStackTrace();
    		}
		return null;
	}
	
	public static Integer codigoIbgeDaCidade() {
	    String cidade = acharPeloIP().getCity().toLowerCase().trim();

	    try {
	        URL url = new URL("https://servicodados.ibge.gov.br/api/v1/localidades/municipios");
	        HttpURLConnection http = (HttpURLConnection) url.openConnection();
	        http.setRequestMethod("GET");

	        BufferedReader in = new BufferedReader(new InputStreamReader(http.getInputStream()));
	        StringBuilder resposta = new StringBuilder();

	        String inputLine;
	        while ((inputLine = in.readLine()) != null) {
	            resposta.append(inputLine);
	        }
	        in.close();

	        JSONArray jsonMunicipios = new JSONArray(resposta.toString());
	        Gson gson = new Gson();
	        MunicipiosIbge[] municipios = gson.fromJson(resposta.toString(), MunicipiosIbge[].class);
	        
	        for (MunicipiosIbge municipio : municipios) {
	        	if(municipio.nome.toLowerCase().trim().equals(cidade)) {
	        		String idFormatador = String.valueOf(municipio.id);
	        		if (idFormatador.length()>6) {
	        			String seisDigitos = idFormatador.substring(0, 6);
	        			Integer numeroFormatado = Integer.parseInt(seisDigitos);
	        			return numeroFormatado;
	        		}else {
	        			Integer numeroFormatado = Integer.parseInt(idFormatador);
	        			return numeroFormatado;
	        		}
	        	}
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return null;
	}
	
}
