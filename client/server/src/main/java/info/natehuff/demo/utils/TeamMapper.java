package info.natehuff.demo.utils;

import java.util.HashMap;
import java.util.Map;

public class TeamMapper {
    public enum NflTeams {
        ATL,PHI,BUF,BAL,PIT,CLE,CIN,IND,
        TEN,MIA,SF,MIN,HOU,NE,TB,NO,
        JAX,NYG,KC,LAC,WAS,ARI,DAL,CAR,
        SEA,DEN,CHI,GB,NYJ,DET,LA,OAK
    }

    public enum NflTeamsFull {
        BALTIMORE,
        CINCINNATI,
        INDIANAPOLIS,
        WASHINGTON,
        CAROLINA,
        ATLANTA,
        MINNESOTA,
        GREEN_BAY,
        LA_CHARGERS,
        BUFFALO,
        HOUSTON,
        TENNESSEE,
        KANSAS_CITY,
        PITTSBURGH,
        MIAMI,
        NY_JETS,
        PHILADELPHIA,
        TAMPA_BAY,
        CLEVELAND,
        NEW_ORLEANS,
        ARIZONA,
        LA_RAMS,
        DETROIT,
        SAN_FRANCISCO,
        NEW_ENGLAND,
        JACKSONVILLE,
        OAKLAND,
        DENVER,
        NY_GIANTS,
        DALLAS,
        SEATTLE,
        CHICAGO
    }

    private static Map<String, String> nflTeamMap = new HashMap<>();

    static {
        nflTeamMap.put(NflTeamsFull.CHICAGO.toString(), NflTeams.CHI.toString());
        nflTeamMap.put(NflTeamsFull.SEATTLE.toString(), NflTeams.SEA.toString());
        nflTeamMap.put(NflTeamsFull.DALLAS.toString(), NflTeams.DAL.toString());
        nflTeamMap.put(NflTeamsFull.NY_GIANTS.toString(), NflTeams.NYG.toString());
        nflTeamMap.put("NY GIANTS".toUpperCase(), NflTeams.NYG.toString());
        nflTeamMap.put(NflTeamsFull.DENVER.toString(), NflTeams.DEN.toString());
        nflTeamMap.put(NflTeamsFull.OAKLAND.toString(), NflTeams.OAK.toString());
        nflTeamMap.put(NflTeamsFull.JACKSONVILLE.toString(), NflTeams.JAX.toString());
        nflTeamMap.put(NflTeamsFull.NEW_ENGLAND.toString(), NflTeams.NE.toString());
        nflTeamMap.put("NEW ENGLAND".toUpperCase(), NflTeams.NE.toString());
        nflTeamMap.put(NflTeamsFull.SAN_FRANCISCO.toString(), NflTeams.SF.toString());
        nflTeamMap.put("SAN FRANCISCO".toUpperCase(), NflTeams.SF.toString());
        nflTeamMap.put(NflTeamsFull.LA_RAMS.toString(), NflTeams.LA.toString());
        nflTeamMap.put("LA Rams".toUpperCase(), NflTeams.LA.toString());
        nflTeamMap.put(NflTeamsFull.ARIZONA.toString(), NflTeams.ARI.toString());
        nflTeamMap.put(NflTeamsFull.NEW_ORLEANS.toString(), NflTeams.NO.toString());
        nflTeamMap.put(NflTeamsFull.CLEVELAND.toString(), NflTeams.CLE.toString());
        nflTeamMap.put(NflTeamsFull.TAMPA_BAY.toString(), NflTeams.TB.toString());
        nflTeamMap.put(NflTeamsFull.PHILADELPHIA.toString(), NflTeams.PHI.toString());
        nflTeamMap.put(NflTeamsFull.NY_JETS.toString(), NflTeams.NYJ.toString());
        nflTeamMap.put("NY Jets".toUpperCase(), NflTeams.NYJ.toString());
        nflTeamMap.put(NflTeamsFull.MIAMI.toString(), NflTeams.MIA.toString());
        nflTeamMap.put(NflTeamsFull.PITTSBURGH.toString(), NflTeams.PIT.toString());
        nflTeamMap.put(NflTeamsFull.KANSAS_CITY.toString(), NflTeams.KC.toString());
        nflTeamMap.put("KANSAS CITY".toUpperCase(), NflTeams.KC.toString());
        nflTeamMap.put(NflTeamsFull.TENNESSEE.toString(), NflTeams.TEN.toString());
        nflTeamMap.put(NflTeamsFull.HOUSTON.toString(), NflTeams.HOU.toString());
        nflTeamMap.put(NflTeamsFull.BUFFALO.toString(), NflTeams.BUF.toString());
        nflTeamMap.put(NflTeamsFull.LA_CHARGERS.toString(), NflTeams.LAC.toString());
        nflTeamMap.put("LA Chargers".toUpperCase(), NflTeams.LAC.toString());
        nflTeamMap.put(NflTeamsFull.GREEN_BAY.toString(), NflTeams.GB.toString());
        nflTeamMap.put(NflTeamsFull.MINNESOTA.toString(), NflTeams.MIN.toString());
        nflTeamMap.put(NflTeamsFull.ATLANTA.toString(), NflTeams.ATL.toString());
        nflTeamMap.put(NflTeamsFull.CAROLINA.toString(), NflTeams.CAR.toString());
        nflTeamMap.put(NflTeamsFull.WASHINGTON.toString(), NflTeams.WAS.toString());
        nflTeamMap.put(NflTeamsFull.INDIANAPOLIS.toString(), NflTeams.IND.toString());
        nflTeamMap.put(NflTeamsFull.CINCINNATI.toString(), NflTeams.CIN.toString());
        nflTeamMap.put(NflTeamsFull.BALTIMORE.toString(), NflTeams.BAL.toString());
        nflTeamMap.put(NflTeamsFull.DETROIT.toString(), NflTeams.DET.toString());

    }

    public static String convert(String city) {
        return nflTeamMap.get(city.toUpperCase());
    }
}
