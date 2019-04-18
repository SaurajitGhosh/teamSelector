package com.sunny.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by Saurajit on 4/18/19.
 */
@RestController
@RequestMapping(path = "/test")
public class Initiator {

    @RequestMapping("/testing")
    public String test(){
        return "Hello World";
    }

    @RequestMapping("/test2")
    public String makeTeams(@RequestParam("players") String players, @RequestParam("teams") int numberOfTeams){

        System.out.println("players :: "+players);
        System.out.println("teams :: "+numberOfTeams);


        String response = "";
        String[] arr = players.split(",");

        List<String> playerList  = new ArrayList<>(Arrays.asList(arr));
        List<String> origList = new ArrayList<>(Arrays.asList(arr));

        List<String> team1 = new ArrayList<String>();
        List<String> team2 = new ArrayList<String>();

       /* for(String name : origList){
            int index = 0;
            if(name.equalsIgnoreCase("saurajit") || name.equalsIgnoreCase("sandesh") || name.equalsIgnoreCase("siva")){
                index = origList.indexOf(name);
            }
            playerList.remove(index);
        }*/


        int totalsize = origList.size();
        System.out.println("playerList size = "+totalsize);
        System.out.println("numberOfTeams = "+numberOfTeams);
        int teamSize = totalsize/numberOfTeams;
        System.out.println("teamSize = " + teamSize);

        StringBuilder stringBuilder = new StringBuilder();

for(int j = 1 ; j <= numberOfTeams ; j++ ){
        stringBuilder.append("\n Team "+j+": ");
        for(int i = 0 ; i < teamSize; i++){
            int tempsize = playerList.size();
            Random random = new Random();
            int randomIndex = random.nextInt(tempsize);
            System.out.println("randomIndex = " + randomIndex);
            String randomEle = playerList.get(randomIndex);
            System.out.println("randomEle = " + randomEle);
            String p = playerList.remove(randomIndex);
            stringBuilder.append(p);
            if(i != teamSize-1){
                stringBuilder.append(",");
            }
        }
}
        String finalString = stringBuilder.toString();

        System.out.println("finalString = "+finalString);

        System.out.println("PalyerList :: "+playerList.toString());

        System.out.println("Orig list  :: "+origList.toString());

        response = finalString;

        return response;

    }
}
