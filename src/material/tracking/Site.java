package material.tracking;


import app.blockchain.smartcontract.DataItem;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sonali
 */
public class Site implements DataItem
{
     public String ID;
     public String name;
     public String address;
     public String ownerAddress;
     public String city;
     public String builderid;
     
     public Map<String,SiteUnit> siteUnitMap= new HashMap<>();
    
}
