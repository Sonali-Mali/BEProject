package material.tracking;

import app.blockchain.smartcontract.Context;
import app.blockchain.smartcontract.SmartContract;
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
public class MaterialTrackingSmartContract implements SmartContract
{

    private String superAdmin;
//    private String Admin;
//    private String Manufacturer;
//    private String Site;
//    private String SiteUnit;
//    private String Seller;
//    private String Builder;
//    private String Material;

    /**
     * City -> Admin
     */
    private Map<String, List<String>> adminCityMap = new HashMap<>();

    /**
     * City-> Manufacturer
     */
    private Map<String, List<Manufacturer>> manufacturerCityMap = new HashMap<>();

    /**
     * City -> Seller
     */
    private Map<String, List<Seller>> sellerCityMap = new HashMap<>();

    /**
     * City -> Builder
     */
    private Map<String, List<Builder>> builderCityMap = new HashMap<>();

    /**
     * City -> Site
     */
    private Map<String, List<Site>> SiteCityMap = new HashMap<>();

    /**
     * SiteID -> Site
     */
    private Map<String, Site> siteMap = new HashMap<>();

    /**
     * BuilderID -> Builder
     */
    private Map<String, Builder> builderMap = new HashMap<>();

    private Map<String, String> materialMap = new HashMap<>();

    private Map<String, Person> userMap = new HashMap<>();

    @Override
    public void create(Context context)
    {
        this.superAdmin = context.msgSender;
    }

    @Override
    public void update(Context context, String command, Object... params)
    {
        if (command.equalsIgnoreCase("ADD_ADMIN"))
        {
            addAdmin(context, params);
        } else if (command.equalsIgnoreCase("ADD_MANUFACTURER"))
        {
            addManufacturer(context, params);
        } else if (command.equalsIgnoreCase("ADD_SELLER"))
        {
            addSeller(context, params);
        } else if (command.equalsIgnoreCase("ADD_BUILDER"))
        {
            addBuilder(context, params);
        } else if (command.equalsIgnoreCase("ADD_SITE"))
        {
            addSite(context, params);
        } else if (command.equalsIgnoreCase("ADD_SITEUNIT"))
        {
            addSiteUnit(context, params);
        } else if (command.equalsIgnoreCase("ADD_MATERIAL"))
        {
            addMaterial(context, params);
        } else if (command.equalsIgnoreCase("SET_PERSON_DETAILS"))
        {
            addPerson(context, params);
        } else
        {
            throw new RuntimeException("update command \"" + command + "\" not found");
        }
    }

    @Override
    public Object query(Context context, String command, Object... params)
    {
        if (command.equalsIgnoreCase("GET_PERSON"))
        {
            return getPerson(context, params);
        } else if (command.equalsIgnoreCase("GET_ADMIN"))
        {
            return getAdmin(context, params);
        } else if (command.equalsIgnoreCase("GET_MANUFACTURER"))
        {
            return getManufacturer(context, params);
        } else if (command.equalsIgnoreCase("GET_SELLER"))
        {
            return getSeller(context, params);
        } else if (command.equalsIgnoreCase("GET_BUILDER"))
        {
            return getBuilder(context, params);
        }else if (command.equalsIgnoreCase("GET_PERSON"))
        {
            return getPerson(context, params);
        }
        else
        {
            throw new RuntimeException("query command \"" + command + "\" not found");
        }

//        return null;
    }

    private void addAdmin(Context context, Object[] params)
    {
        System.out.println("superAdmin = " + superAdmin);
        System.out.println("context.msgSender = " + context.msgSender);

        if (!context.msgSender.equalsIgnoreCase(superAdmin))
        {
            throw new RuntimeException("Must be superadmin to add new admin");
        }

        String cityname = (String) params[0];
        String adminAddress = (String) params[1];

        List<String> list = adminCityMap.get(cityname);
        if (list == null)
        {
            list = new ArrayList<>();
            adminCityMap.put(cityname, list);
        }
        list.add(adminAddress);
    }

    private void addManufacturer(Context context, Object[] params)
    {

        Manufacturer manufacturer = new Manufacturer();
        String manufacturerID = (String) params[0];
        manufacturer.address = (String) params[1];
        manufacturer.contact = (String) params[2];
        manufacturer.name = (String) params[3];
        manufacturer.city = (String) params[4];

        List<String> admins = adminCityMap.get(manufacturer.city);
        System.out.println("Admin = " + admins);
        System.out.println("context.msgSender = " + context.msgSender);

        if (admins == null || !admins.contains(context.msgSender))
        {
            throw new RuntimeException("Must be admin of city \"" + manufacturer.city + "\" to add new manufacturer");
        }

        List<Manufacturer> list1 = manufacturerCityMap.get(manufacturerID);
        if (list1 == null)
        {
            list1 = new ArrayList<>();
            manufacturerCityMap.put(manufacturerID, list1);
        }
        list1.add(manufacturer);
    }

    private void addSeller(Context context, Object[] params)
    {
        Seller seller = new Seller();
        String sellerID = (String) params[0];
        seller.address = (String) params[1];
        seller.contact = (String) params[2];
        seller.name = (String) params[3];
        seller.city = (String) params[4];
        List<String> admins = adminCityMap.get(seller.city);
        if (admins == null || !admins.contains(context.msgSender))
        {
            throw new RuntimeException("Must be admin of city \"" + seller.city + "\" to add new seller");
        }
        System.out.println("Admin = " + admins);
        System.out.println("context.msgSender = " + context.msgSender);
        List<Seller> list2 = sellerCityMap.get(sellerID);

        if (list2 == null)
        {
            list2 = new ArrayList<>();
            sellerCityMap.put(sellerID, list2);
        }
        list2.add(seller);
    }

    private void addBuilder(Context context, Object[] params)
    {
        Builder builder = new Builder();
        builder.ID = (String) params[0];
        builder.publickey = (String) params[1];
        builder.address = (String) params[2];
        builder.contact = (String) params[3];
        builder.name = (String) params[4];
        builder.city = (String) params[5];
        List<String> admins = adminCityMap.get(builder.city);
        System.out.println("admins:" + admins);
        if (admins == null || !admins.contains(context.msgSender))
        {
            throw new RuntimeException("Must be admin of city \"" + builder.city + "\" to add new builder");
        }
        builderMap.put(builder.ID, builder);

        List<Builder> list = builderCityMap.get(builder.city);
        if (list == null)
        {
            list = new ArrayList<>();
            builderCityMap.put(builder.city, list);
        }
        list.add(builder);
    }

    private void addSite(Context context, Object[] params)
    {
        Site site = new Site();
        site.ownerAddress = context.msgSender;
        site.ID = (String) params[0];
        site.address = (String) params[1];
        site.city = (String) params[2];
        site.builderid = (String) params[3];
        siteMap.put(site.ID, site);
        List<String> admins = adminCityMap.get(site.city);
        System.out.println("Admin = " + admins);
        System.out.println("context.msgSender = " + context.msgSender);
        if (admins == null || !admins.contains(context.msgSender))
        {
            throw new RuntimeException("Must be admin of city \"" + site.city + "\" to add new site");
        }

        List<Site> list4 = SiteCityMap.get(site.ID);
        if (list4 == null)
        {
            list4 = new ArrayList<>();
            SiteCityMap.put(site.ID, list4);
        }
        list4.add(site);
    }

    private void addSiteUnit(Context context, Object[] params)
    {

        SiteUnit siteunit = new SiteUnit();
        siteunit.ID = (String) params[0];
        siteunit.address = (String) params[1];
        siteunit.name = (String) params[2];
        String siteid = (String) params[3];
        siteunit.BuilderID = (String) params[4];
        Site site = siteMap.get(siteid);
        System.out.println("sitemap" + siteMap);
        Builder builder = builderMap.get(site.builderid);
        if (!context.msgSender.equalsIgnoreCase(builder.publickey))
        {
            throw new RuntimeException("Must be builder of ID \"" + builder.ID + "\" to add new siteunit");
        }
        System.out.println("Builder = " + builder);
        System.out.println("context.msgSender = " + context.msgSender);
        site.siteUnitMap.put(siteunit.ID, siteunit);
    }

    private void addMaterial(Context context, Object[] params)
    {
        Material m = new Material();
        m.ID = (String) params[0];
        m.qrcode = (String) params[1];  //QR CODE
        String siteid = (String) params[2];
        String siteunitid = (String) params[3];
        m.name = (String) params[4];
        m.manufacturerID = (String) params[5];
        m.sellerID = (String) params[6];

        Site site = siteMap.get(siteid);
        Builder builder = builderMap.get(site.builderid);

        if (!context.msgSender.equalsIgnoreCase(builder.publickey))
        {
            throw new RuntimeException("Must be builder of site to add new material");
        }

        SiteUnit su = site.siteUnitMap.get(siteunitid);
        if (su == null)
        {
            throw new RuntimeException("Site Unit " + siteunitid + " does not exist");
        }
        su.materialList.add(m);
    }

    private Object getAdmin(Context context, Object[] params)
    {
        String cityname = (String) params[0];
        List<String> admins = adminCityMap.get(cityname);
        return admins;
    }

    private Object getManufacturer(Context context, Object[] params)
    {
        String manufacturerID = (String) params[0];
        List<Manufacturer> manufacturers = manufacturerCityMap.get(manufacturerID);
        return manufacturers;
    }

    private Object getSeller(Context context, Object[] params)
    {
        String sellerID = (String) params[0];
        List<Seller> sellers = sellerCityMap.get(sellerID);
        return sellers;
    }

    private Object getBuilder(Context context, Object[] params)
    {
        String builderID = (String) params[0];
        Builder builder = builderMap.get(builderID);
        return builder;
    }

    private Object getMaterial(Context context, Object[] params)
    {
        String materialID = (String) params[0];
        String materials = materialMap.get(materialID);
        return materials;
    }

    private Object getSite(Context context, Object[] params)
    {
        String siteID = (String) params[0];
        return siteMap.get(siteID);
    }

    private Object getSiteUnit(Context context, Object[] params)
    {
        String siteid = (String) params[0];
        String siteunitid = (String) params[1];
        return siteMap.get(siteid).siteUnitMap.get(siteunitid);
    }

    private void addPerson(Context context, Object[] params)
    {
        Person ps = new Person();
        ps.ID = (String) params[0];
        ps.name = (String) params[1];
        ps.city = (String) params[2];
        ps.publicKey = context.msgSender;
        userMap.put(ps.publicKey, ps);
    }

    private Object getPerson(Context context, Object[] params)
    {
        Map<String,Person> map=new HashMap<>();
        for(Object o : params)
        {
            map.put((String)o,userMap.get((String)o));
        }
        return map;
    }
}
