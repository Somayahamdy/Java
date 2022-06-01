//package gov.iti.day6.lab.dao;

import gov.iti.day6.lab.service.City;
import gov.iti.day6.lab.service.Country;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;


public class InMemoryWorldDao implements WorldDao {
    private static InMemoryWorldDao instance;
    private Map<String, Country> countries;
    private Map<Integer, City> cities;
    private Set<String> continents;

    private InMemoryWorldDao() {
        countries = new ConcurrentHashMap<> ();
        cities = new ConcurrentHashMap<> ();
        createCountries ();
        createCities1 ();
        createCities1000 ();
        createCities2000 ();
        createCities2500 ();
        createCities3000 ();
        createCities3600 ();
        for (City city : cities.values ()) {
            Country country = countries.get (city.getCountryCode ());
            if (country == null) {
                System.out.println ("No such countryCode: "
                        + city.getCountryCode ());
                continue;
            }
            country.getCities ().add (city);
        }

        continents = new HashSet<> ();
        for (Country country : countries.values ())
            continents.add (country.getContinent ());
    }

    public static void main(String args[]) {
        InMemoryWorldDao worldDao = InMemoryWorldDao.getInstance ();
        Set<String> allContinents = worldDao.getContinents ();
        //System.out.println(allContinents);
        Map<String, Country> allCountries = worldDao.getCountries ();
        //System.out.println(allCountries);
        Map<Integer, City> allCities = worldDao.getCities ();
        //System.out.println(allCities);
        worldDao.writeCountriesToFile (allCountries, "Countries.txt");
        worldDao.writeCitiesToFile (allCities, "Cities.txt");
    }
    ///////////////////////////////////////////////////////////////////////////////

    public static InMemoryWorldDao getInstance() {
        synchronized (InMemoryWorldDao.class) {
            if (instance == null)
                instance = new InMemoryWorldDao ();
        }
        return instance;
    }

    public void writeCountriesToFile(Map<String, Country> map, String path) {

        //new file object
        File file = new File (path);
        BufferedWriter bf = null;
        ;
        try {
            //create new BufferedWriter for the output file
            bf = new BufferedWriter (new FileWriter (file));
            //iterate map entries
            for (Map.Entry<String, Country> entry : map.entrySet ()) {
                //put key and value separated by a colon
                bf.write (entry.getKey () + ", " + entry.getValue ());
                //new line
                bf.newLine ();
            }
            bf.flush ();
        } catch (IOException e) {
            e.printStackTrace ();
        } finally {
            try {
                //always close the writer
                bf.close ();
            } catch (Exception e) {
            }
        }
    }

    ///////////////////////////////////////////////////////////////////////////////
    public void writeCitiesToFile(Map<Integer, City> map, String path) {

        //new file object
        File file = new File (path);
        BufferedWriter bf = null;
        ;
        try {
            //create new BufferedWriter for the output file
            bf = new BufferedWriter (new FileWriter (file));
            //iterate map entries
            for (Map.Entry<Integer, City> entry : map.entrySet ()) {
                //put key and value separated by a colon
                bf.write (entry.getKey () + ", " + entry.getValue ());
                //new line
                bf.newLine ();
            }
            bf.flush ();
        } catch (IOException e) {
            e.printStackTrace ();
        } finally {
            try {
                //always close the writer
                bf.close ();
            } catch (Exception e) {
            }
        }
    }

    public Map<String, Country> getCountries() {
        return countries;
    }

    public void setCountries(Map<String, Country> countries) {
        this.countries = countries;
    }

    public Map<Integer, City> getCities() {
        return cities;
    }

    public void setCities(Map<Integer, City> cities) {
        this.cities = cities;
    }

    public Set<String> getContinents() {
        return continents;
    }

    public void setContinents(Set<String> continents) {
        this.continents = continents;
    }

    public void createCities1() {
        cities.put (1, new City (1, "Kabul", "AFG", 1780000));
        cities.put (2, new City (2, "Qandahar", "AFG", 237500));
        cities.put (3, new City (3, "Herat", "AFG", 186800));
        cities.put (4, new City (4, "Mazar-e-Sharif", "AFG", 127800));
        cities.put (5, new City (5, "Amsterdam", "NLD", 731200));
        cities.put (6, new City (6, "Rotterdam", "NLD", 593321));
        cities.put (7, new City (7, "Haag", "NLD", 440900));
        cities.put (8, new City (8, "Utrecht", "NLD", 234323));
        cities.put (9, new City (9, "Eindhoven", "NLD", 201843));
        cities.put (10, new City (10, "Tilburg", "NLD", 193238));
        cities.put (11, new City (11, "Groningen", "NLD", 172701));
        cities.put (12, new City (12, "Breda", "NLD", 160398));
        cities.put (13, new City (13, "Apeldoorn", "NLD", 153491));
        cities.put (14, new City (14, "Nijmegen", "NLD", 152463));
        cities.put (15, new City (15, "Enschede", "NLD", 149544));
        cities.put (16, new City (16, "Haarlem", "NLD", 148772));
        cities.put (17, new City (17, "Almere", "NLD", 142465));
        cities.put (18, new City (18, "Arnhem", "NLD", 138020));
        cities.put (19, new City (19, "Zaanstad", "NLD", 135621));
        cities.put (20, new City (20, "Ã¯s-Hertogenbosch", "NLD", 129170));
        cities.put (21, new City (21, "Amersfoort", "NLD", 126270));
        cities.put (22, new City (22, "Maastricht", "NLD", 122087));
        cities.put (23, new City (23, "Dordrecht", "NLD", 119811));
        cities.put (24, new City (24, "Leiden", "NLD", 117196));
        cities.put (25, new City (25, "Haarlemmermeer", "NLD", 110722));
        cities.put (26, new City (26, "Zoetermeer", "NLD", 110214));
        cities.put (27, new City (27, "Emmen", "NLD", 105853));
        cities.put (28, new City (28, "Zwolle", "NLD", 105819));
        cities.put (29, new City (29, "Ede", "NLD", 101574));
        cities.put (30, new City (30, "Delft", "NLD", 95268));
        cities.put (31, new City (31, "Heerlen", "NLD", 95052));
        cities.put (32, new City (32, "Alkmaar", "NLD", 92713));
        cities.put (33, new City (33, "Willemstad", "ANT", 2345));
        cities.put (34, new City (34, "Tirana", "ALB", 270000));
        cities.put (35, new City (35, "Alger", "DZA", 2168000));
        cities.put (36, new City (36, "Oran", "DZA", 609823));
        cities.put (37, new City (37, "Constantine", "DZA", 443727));
        cities.put (38, new City (38, "Annaba", "DZA", 222518));
        cities.put (39, new City (39, "Batna", "DZA", 183377));
        cities.put (40, new City (40, "Sâ€štif", "DZA", 179055));
        cities.put (41, new City (41, "Sidi Bel AbbÅ s", "DZA", 153106));
        cities.put (42, new City (42, "Skikda", "DZA", 128747));
        cities.put (43, new City (43, "Biskra", "DZA", 128281));
        cities.put (44, new City (44, "Blida (el-Boulaida)", "DZA", 127284));
        cities.put (45, new City (45, "Bâ€šjaâ€¹a", "DZA", 117162));
        cities.put (46, new City (46, "Mostaganem", "DZA", 115212));
        cities.put (47, new City (47, "Tâ€šbessa", "DZA", 112007));
        cities.put (48, new City (48, "Tlemcen (Tilimsen)", "DZA", 110242));
        cities.put (49, new City (49, "Bâ€šchar", "DZA", 107311));
        cities.put (50, new City (50, "Tiaret", "DZA", 100118));
        cities.put (51, new City (51, "Ech-Chleff (el-Asnam)", "DZA", 96794));
        cities.put (52, new City (52, "Ghardaâ€¹a", "DZA", 89415));
        cities.put (53, new City (53, "Tafuna", "ASM", 5200));
        cities.put (54, new City (54, "Fagatogo", "ASM", 2323));
        cities.put (55, new City (55, "Andorra la Vella", "AND", 21189));
        cities.put (56, new City (56, "Luanda", "AGO", 2022000));
        cities.put (57, new City (57, "Huambo", "AGO", 163100));
        cities.put (58, new City (58, "Lobito", "AGO", 130000));
        cities.put (59, new City (59, "Benguela", "AGO", 128300));
        cities.put (60, new City (60, "Namibe", "AGO", 118200));
        cities.put (61, new City (61, "South Hill", "AIA", 961));
        cities.put (62, new City (62, "The Valley", "AIA", 595));
        cities.put (63, new City (63, "Saint JohnÃ¯s", "ATG", 24000));
        cities.put (64, new City (64, "Dubai", "ARE", 669181));
        cities.put (65, new City (65, "Abu Dhabi", "ARE", 398695));
        cities.put (66, new City (66, "Sharja", "ARE", 320095));
        cities.put (67, new City (67, "al-Ayn", "ARE", 225970));
        cities.put (68, new City (68, "Ajman", "ARE", 114395));
        cities.put (69, new City (69, "Buenos Aires", "ARG", 2982146));
        cities.put (70, new City (70, "La Matanza", "ARG", 1266461));
        cities.put (71, new City (71, "CÂ¢rdoba", "ARG", 1157507));
        cities.put (72, new City (72, "Rosario", "ARG", 907718));
        cities.put (73, new City (73, "Lomas de Zamora", "ARG", 622013));
        cities.put (74, new City (74, "Quilmes", "ARG", 559249));
        cities.put (75, new City (75, "Almirante Brown", "ARG", 538918));
        cities.put (76, new City (76, "La Plata", "ARG", 521936));
        cities.put (77, new City (77, "Mar del Plata", "ARG", 512880));
        cities.put (78, new City (78, "San Miguel de TucumÂ n", "ARG", 470809));
        cities.put (79, new City (79, "LanÂ£s", "ARG", 469735));
        cities.put (80, new City (80, "Merlo", "ARG", 463846));
        cities.put (81, new City (81, "General San MartÂ¡n", "ARG", 422542));
        cities.put (82, new City (82, "Salta", "ARG", 367550));
        cities.put (83, new City (83, "Moreno", "ARG", 356993));
        cities.put (84, new City (84, "Santa Fâ€š", "ARG", 353063));
        cities.put (85, new City (85, "Avellaneda", "ARG", 353046));
        cities.put (86, new City (86, "Tres de Febrero", "ARG", 352311));
        cities.put (87, new City (87, "MorÂ¢n", "ARG", 349246));
        cities.put (88, new City (88, "Florencio Varela", "ARG", 315432));
        cities.put (89, new City (89, "San Isidro", "ARG", 306341));
        cities.put (90, new City (90, "Tigre", "ARG", 296226));
        cities.put (91, new City (91, "Malvinas Argentinas", "ARG", 290335));
        cities.put (92, new City (92, "Vicente LÂ¢pez", "ARG", 288341));
        cities.put (93, new City (93, "Berazategui", "ARG", 276916));
        cities.put (94, new City (94, "Corrientes", "ARG", 258103));
        cities.put (95, new City (95, "San Miguel", "ARG", 248700));
        cities.put (96, new City (96, "BahÂ¡a Blanca", "ARG", 239810));
        cities.put (97, new City (97, "Esteban EcheverrÂ¡a", "ARG", 235760));
        cities.put (98, new City (98, "Resistencia", "ARG", 229212));
        cities.put (99, new City (99, "Josâ€š C. Paz", "ARG", 221754));
        cities.put (100, new City (100, "ParanÂ ", "ARG", 207041));
        cities.put (101, new City (101, "Godoy Cruz", "ARG", 206998));
        cities.put (102, new City (102, "Posadas", "ARG", 201273));
        cities.put (103, new City (103, "Guaymallâ€šn", "ARG", 200595));
        cities.put (104, new City (104, "Santiago del Estero", "ARG", 189947));
        cities.put (105, new City (105, "San Salvador de Jujuy", "ARG", 178748));
        cities.put (106, new City (106, "Hurlingham", "ARG", 170028));
        cities.put (107, new City (107, "Neuquâ€šn", "ARG", 167296));
        cities.put (108, new City (108, "ItuzaingÂ¢", "ARG", 158197));
        cities.put (109, new City (109, "San Fernando", "ARG", 153036));
        cities.put (110, new City (110, "Formosa", "ARG", 147636));
        cities.put (111, new City (111, "Las Heras", "ARG", 145823));
        cities.put (112, new City (112, "La Rioja", "ARG", 138117));
        cities.put (113, new City (113, "San Fernando del Valle de Cata", "ARG",
                134935));
        cities.put (114, new City (114, "RÂ¡o Cuarto", "ARG", 134355));
        cities.put (115, new City (115, "Comodoro Rivadavia", "ARG", 124104));
        cities.put (116, new City (116, "Mendoza", "ARG", 123027));
        cities.put (117, new City (117, "San NicolÂ s de los Arroyos", "ARG",
                119302));
        cities.put (118, new City (118, "San Juan", "ARG", 119152));
        cities.put (119, new City (119, "Escobar", "ARG", 116675));
        cities.put (120, new City (120, "Concordia", "ARG", 116485));
        cities.put (121, new City (121, "Pilar", "ARG", 113428));
        cities.put (122, new City (122, "San Luis", "ARG", 110136));
        cities.put (123, new City (123, "Ezeiza", "ARG", 99578));
        cities.put (124, new City (124, "San Rafael", "ARG", 94651));
        cities.put (125, new City (125, "Tandil", "ARG", 91101));
        cities.put (126, new City (126, "Yerevan", "ARM", 1248700));
        cities.put (127, new City (127, "Gjumri", "ARM", 211700));
        cities.put (128, new City (128, "Vanadzor", "ARM", 172700));
        cities.put (129, new City (129, "Oranjestad", "ABW", 29034));
        cities.put (130, new City (130, "Sydney", "AUS", 3276207));
        cities.put (131, new City (131, "Melbourne", "AUS", 2865329));
        cities.put (132, new City (132, "Brisbane", "AUS", 1291117));
        cities.put (133, new City (133, "Perth", "AUS", 1096829));
        cities.put (134, new City (134, "Adelaide", "AUS", 978100));
        cities.put (135, new City (135, "Canberra", "AUS", 322723));
        cities.put (136, new City (136, "Gold Coast", "AUS", 311932));
        cities.put (137, new City (137, "Newcastle", "AUS", 270324));
        cities.put (138, new City (138, "Central Coast", "AUS", 227657));
        cities.put (139, new City (139, "Wollongong", "AUS", 219761));
        cities.put (140, new City (140, "Hobart", "AUS", 126118));
        cities.put (141, new City (141, "Geelong", "AUS", 125382));
        cities.put (142, new City (142, "Townsville", "AUS", 109914));
        cities.put (143, new City (143, "Cairns", "AUS", 92273));
        cities.put (144, new City (144, "Baku", "AZE", 1787800));
        cities.put (145, new City (145, "Gâ€žncâ€ž", "AZE", 299300));
        cities.put (146, new City (146, "Sumqayit", "AZE", 283000));
        cities.put (147, new City (147, "Mingâ€žâ€¡evir", "AZE", 93900));
        cities.put (148, new City (148, "Nassau", "BHS", 172000));
        cities.put (149, new City (149, "al-Manama", "BHR", 148000));
        cities.put (150, new City (150, "Dhaka", "BGD", 3612850));
        cities.put (151, new City (151, "Chittagong", "BGD", 1392860));
        cities.put (152, new City (152, "Khulna", "BGD", 663340));
        cities.put (153, new City (153, "Rajshahi", "BGD", 294056));
        cities.put (154, new City (154, "Narayanganj", "BGD", 202134));
        cities.put (155, new City (155, "Rangpur", "BGD", 191398));
        cities.put (156, new City (156, "Mymensingh", "BGD", 188713));
        cities.put (157, new City (157, "Barisal", "BGD", 170232));
        cities.put (158, new City (158, "Tungi", "BGD", 168702));
        cities.put (159, new City (159, "Jessore", "BGD", 139710));
        cities.put (160, new City (160, "Comilla", "BGD", 135313));
        cities.put (161, new City (161, "Nawabganj", "BGD", 130577));
        cities.put (162, new City (162, "Dinajpur", "BGD", 127815));
        cities.put (163, new City (163, "Bogra", "BGD", 120170));
        cities.put (164, new City (164, "Sylhet", "BGD", 117396));
        cities.put (165, new City (165, "Brahmanbaria", "BGD", 109032));
        cities.put (166, new City (166, "Tangail", "BGD", 106004));
        cities.put (167, new City (167, "Jamalpur", "BGD", 103556));
        cities.put (168, new City (168, "Pabna", "BGD", 103277));
        cities.put (169, new City (169, "Naogaon", "BGD", 101266));
        cities.put (170, new City (170, "Sirajganj", "BGD", 99669));
        cities.put (171, new City (171, "Narsinghdi", "BGD", 98342));
        cities.put (172, new City (172, "Saidpur", "BGD", 96777));
        cities.put (173, new City (173, "Gazipur", "BGD", 96717));
        cities.put (174, new City (174, "Bridgetown", "BRB", 6070));
        cities.put (175, new City (175, "Antwerpen", "BEL", 446525));
        cities.put (176, new City (176, "Gent", "BEL", 224180));
        cities.put (177, new City (177, "Charleroi", "BEL", 200827));
        cities.put (178, new City (178, "LiÅ ge", "BEL", 185639));
        cities.put (179, new City (179, "Bruxelles [Brussel]", "BEL", 133859));
        cities.put (180, new City (180, "Brugge", "BEL", 116246));
        cities.put (181, new City (181, "Schaerbeek", "BEL", 105692));
        cities.put (182, new City (182, "Namur", "BEL", 105419));
        cities.put (183, new City (183, "Mons", "BEL", 90935));
        cities.put (184, new City (184, "Belize City", "BLZ", 55810));
        cities.put (185, new City (185, "Belmopan", "BLZ", 7105));
        cities.put (186, new City (186, "Cotonou", "BEN", 536827));
        cities.put (187, new City (187, "Porto-Novo", "BEN", 194000));
        cities.put (188, new City (188, "Djougou", "BEN", 134099));
        cities.put (189, new City (189, "Parakou", "BEN", 103577));
        cities.put (190, new City (190, "Saint George", "BMU", 1800));
        cities.put (191, new City (191, "Hamilton", "BMU", 1200));
        cities.put (192, new City (192, "Thimphu", "BTN", 22000));
        cities.put (193, new City (193, "Santa Cruz de la Sierra", "BOL", 935361));
        cities.put (194, new City (194, "La Paz", "BOL", 758141));
        cities.put (195, new City (195, "El Alto", "BOL", 534466));
        cities.put (196, new City (196, "Cochabamba", "BOL", 482800));
        cities.put (197, new City (197, "Oruro", "BOL", 223553));
        cities.put (198, new City (198, "Sucre", "BOL", 178426));
        cities.put (199, new City (199, "PotosÂ¡", "BOL", 140642));
        cities.put (200, new City (200, "Tarija", "BOL", 125255));
        cities.put (201, new City (201, "Sarajevo", "BIH", 360000));
        cities.put (202, new City (202, "Banja Luka", "BIH", 143079));
        cities.put (203, new City (203, "Zenica", "BIH", 96027));
        cities.put (204, new City (204, "Gaborone", "BWA", 213017));
        cities.put (205, new City (205, "Francistown", "BWA", 101805));
        cities.put (206, new City (206, "SÃ†o Paulo", "BRA", 9968485));
        cities.put (207, new City (207, "Rio de Janeiro", "BRA", 5598953));
        cities.put (208, new City (208, "Salvador", "BRA", 2302832));
        cities.put (209, new City (209, "Belo Horizonte", "BRA", 2139125));
        cities.put (210, new City (210, "Fortaleza", "BRA", 2097757));
        cities.put (211, new City (211, "BrasÂ¡lia", "BRA", 1969868));
        cities.put (212, new City (212, "Curitiba", "BRA", 1584232));
        cities.put (213, new City (213, "Recife", "BRA", 1378087));
        cities.put (214, new City (214, "Porto Alegre", "BRA", 1314032));
        cities.put (215, new City (215, "Manaus", "BRA", 1255049));
        cities.put (216, new City (216, "Belâ€šm", "BRA", 1186926));
        cities.put (217, new City (217, "Guarulhos", "BRA", 1095874));
        cities.put (218, new City (218, "GoiÆ’nia", "BRA", 1056330));
        cities.put (219, new City (219, "Campinas", "BRA", 950043));
        cities.put (220, new City (220, "SÃ†o Gonâ€¡alo", "BRA", 869254));
        cities.put (221, new City (221, "Nova Iguaâ€¡u", "BRA", 862225));
        cities.put (222, new City (222, "SÃ†o LuÂ¡s", "BRA", 837588));
        cities.put (223, new City (223, "MaceiÂ¢", "BRA", 786288));
        cities.put (224, new City (224, "Duque de Caxias", "BRA", 746758));
        cities.put (225, new City (225, "SÃ†o Bernardo do Campo", "BRA",
                723132));
        cities.put (226, new City (226, "Teresina", "BRA", 691942));
        cities.put (227, new City (227, "Natal", "BRA", 688955));
        cities.put (228, new City (228, "Osasco", "BRA", 659604));
        cities.put (229, new City (229, "Campo Grande", "BRA", 649593));
        cities.put (230, new City (230, "Santo Andrâ€š", "BRA", 630073));
        cities.put (231, new City (231, "JoÃ†o Pessoa", "BRA", 584029));
        cities.put (232, new City (232, "JaboatÃ†o dos Guararapes", "BRA",
                558680));
        cities.put (233, new City (233, "Contagem", "BRA", 520801));
        cities.put (234, new City (234, "SÃ†o Josâ€š dos Campos", "BRA",
                515553));
        cities.put (235, new City (235, "UberlÆ’ndia", "BRA", 487222));
        cities.put (236, new City (236, "Feira de Santana", "BRA", 479992));
        cities.put (237, new City (237, "RibeirÃ†o Preto", "BRA", 473276));
        cities.put (238, new City (238, "Sorocaba", "BRA", 466823));
        cities.put (239, new City (239, "NiterÂ¢i", "BRA", 459884));
        cities.put (240, new City (240, "CuiabÂ ", "BRA", 453813));
        cities.put (241, new City (241, "Juiz de Fora", "BRA", 450288));
        cities.put (242, new City (242, "Aracaju", "BRA", 445555));
        cities.put (243, new City (243, "SÃ†o JoÃ†o de Meriti", "BRA",
                440052));
        cities.put (244, new City (244, "Londrina", "BRA", 432257));
        cities.put (245, new City (245, "Joinville", "BRA", 428011));
        cities.put (246, new City (246, "Belford Roxo", "BRA", 425194));
        cities.put (247, new City (247, "Santos", "BRA", 408748));
        cities.put (248, new City (248, "Ananindeua", "BRA", 400940));
        cities.put (249, new City (249, "Campos dos Goytacazes", "BRA", 398418));
        cities.put (250, new City (250, "MauÂ ", "BRA", 375055));
        cities.put (251, new City (251, "CarapicuÂ¡ba", "BRA", 357552));
        cities.put (252, new City (252, "Olinda", "BRA", 354732));
        cities.put (253, new City (253, "Campina Grande", "BRA", 352497));
        cities.put (254, new City (254, "SÃ†o Josâ€š do Rio Preto", "BRA",
                351944));
        cities.put (255, new City (255, "Caxias do Sul", "BRA", 349581));
        cities.put (256, new City (256, "Moji das Cruzes", "BRA", 339194));
        cities.put (257, new City (257, "Diadema", "BRA", 335078));
        cities.put (258,
                new City (258, "Aparecida de GoiÆ’nia", "BRA", 324662));
        cities.put (259, new City (259, "Piracicaba", "BRA", 319104));
        cities.put (260, new City (260, "Cariacica", "BRA", 319033));
        cities.put (261, new City (261, "Vila Velha", "BRA", 318758));
        cities.put (262, new City (262, "Pelotas", "BRA", 315415));
        cities.put (263, new City (263, "Bauru", "BRA", 313670));
        cities.put (264, new City (264, "Porto Velho", "BRA", 309750));
        cities.put (265, new City (265, "Serra", "BRA", 302666));
        cities.put (266, new City (266, "Betim", "BRA", 302108));
        cities.put (267, new City (267, "JundÂ¡aÂ¡", "BRA", 296127));
        cities.put (268, new City (268, "Canoas", "BRA", 294125));
        cities.put (269, new City (269, "Franca", "BRA", 290139));
        cities.put (270, new City (270, "SÃ†o Vicente", "BRA", 286848));
        cities.put (271, new City (271, "MaringÂ ", "BRA", 286461));
        cities.put (272, new City (272, "Montes Claros", "BRA", 286058));
        cities.put (273, new City (273, "AnÂ polis", "BRA", 282197));
        cities.put (274, new City (274, "FlorianÂ¢polis", "BRA", 281928));
        cities.put (275, new City (275, "PetrÂ¢polis", "BRA", 279183));
        cities.put (276, new City (276, "Itaquaquecetuba", "BRA", 270874));
        cities.put (277, new City (277, "VitÂ¢ria", "BRA", 270626));
        cities.put (278, new City (278, "Ponta Grossa", "BRA", 268013));
        cities.put (279, new City (279, "Rio Branco", "BRA", 259537));
        cities.put (280, new City (280, "Foz do Iguaâ€¡u", "BRA", 259425));
        cities.put (281, new City (281, "MacapÂ ", "BRA", 256033));
        cities.put (282, new City (282, "Ilhâ€šus", "BRA", 254970));
        cities.put (283, new City (283, "VitÂ¢ria da Conquista", "BRA", 253587));
        cities.put (284, new City (284, "Uberaba", "BRA", 249225));
        cities.put (285, new City (285, "Paulista", "BRA", 248473));
        cities.put (286, new City (286, "Limeira", "BRA", 245497));
        cities.put (287, new City (287, "Blumenau", "BRA", 244379));
        cities.put (288, new City (288, "Caruaru", "BRA", 244247));
        cities.put (289, new City (289, "Santarâ€šm", "BRA", 241771));
        cities.put (290, new City (290, "Volta Redonda", "BRA", 240315));
        cities.put (291, new City (291, "Novo Hamburgo", "BRA", 239940));
        cities.put (292, new City (292, "Caucaia", "BRA", 238738));
        cities.put (293, new City (293, "Santa Maria", "BRA", 238473));
        cities.put (294, new City (294, "Cascavel", "BRA", 237510));
        cities.put (295, new City (295, "GuarujÂ ", "BRA", 237206));
        cities.put (296, new City (296, "RibeirÃ†o das Neves", "BRA", 232685));
        cities.put (297, new City (297, "Governador Valadares", "BRA", 231724));
        cities.put (298, new City (298, "Taubatâ€š", "BRA", 229130));
        cities.put (299, new City (299, "Imperatriz", "BRA", 224564));
        cities.put (300, new City (300, "GravataÂ¡", "BRA", 223011));
        cities.put (301, new City (301, "Embu", "BRA", 222223));
        cities.put (302, new City (302, "MossorÂ¢", "BRA", 214901));
        cities.put (303, new City (303, "VÂ rzea Grande", "BRA", 214435));
        cities.put (304, new City (304, "Petrolina", "BRA", 210540));
        cities.put (305, new City (305, "Barueri", "BRA", 208426));
        cities.put (306, new City (306, "ViamÃ†o", "BRA", 207557));
        cities.put (307, new City (307, "Ipatinga", "BRA", 206338));
        cities.put (308, new City (308, "Juazeiro", "BRA", 201073));
        cities.put (309, new City (309, "Juazeiro do Norte", "BRA", 199636));
        cities.put (310, new City (310, "TaboÃ†o da Serra", "BRA", 197550));
        cities.put (311, new City (311, "SÃ†o Josâ€š dos Pinhais", "BRA",
                196884));
        cities.put (312, new City (312, "Magâ€š", "BRA", 196147));
        cities.put (313, new City (313, "Suzano", "BRA", 195434));
        cities.put (314, new City (314, "SÃ†o Leopoldo", "BRA", 189258));
        cities.put (315, new City (315, "MarÂ¡lia", "BRA", 188691));
        cities.put (316, new City (316, "SÃ†o Carlos", "BRA", 187122));
        cities.put (317, new City (317, "Sumarâ€š", "BRA", 186205));
        cities.put (318, new City (318, "Presidente Prudente", "BRA", 185340));
        cities.put (319, new City (319, "DivinÂ¢polis", "BRA", 185047));
        cities.put (320, new City (320, "Sete Lagoas", "BRA", 182984));
        cities.put (321, new City (321, "Rio Grande", "BRA", 182222));
        cities.put (322, new City (322, "Itabuna", "BRA", 182148));
        cities.put (323, new City (323, "Jequiâ€š", "BRA", 179128));
        cities.put (324, new City (324, "Arapiraca", "BRA", 178988));
        cities.put (325, new City (325, "Colombo", "BRA", 177764));
        cities.put (326, new City (326, "Americana", "BRA", 177409));
        cities.put (327, new City (327, "Alvorada", "BRA", 175574));
        cities.put (328, new City (328, "Araraquara", "BRA", 174381));
        cities.put (329, new City (329, "ItaboraÂ¡", "BRA", 173977));
        cities.put (330, new City (330, "Santa BÂ rbara dÃ¯Oeste", "BRA",
                171657));
        cities.put (331, new City (331, "Nova Friburgo", "BRA", 170697));
        cities.put (332, new City (332, "JacareÂ¡", "BRA", 170356));
        cities.put (333, new City (333, "Araâ€¡atuba", "BRA", 169303));
        cities.put (334, new City (334, "Barra Mansa", "BRA", 168953));
        cities.put (335, new City (335, "Praia Grande", "BRA", 168434));
        cities.put (336, new City (336, "MarabÂ ", "BRA", 167795));
        cities.put (337, new City (337, "CriciÂ£ma", "BRA", 167661));
        cities.put (338, new City (338, "Boa Vista", "BRA", 167185));
        cities.put (339, new City (339, "Passo Fundo", "BRA", 166343));
        cities.put (340, new City (340, "Dourados", "BRA", 164716));
        cities.put (341, new City (341, "Santa Luzia", "BRA", 164704));
        cities.put (342, new City (342, "Rio Claro", "BRA", 163551));
        cities.put (343, new City (343, "MaracanaÂ£", "BRA", 162022));
        cities.put (344, new City (344, "Guarapuava", "BRA", 160510));
        cities.put (345, new City (345, "RondonÂ¢polis", "BRA", 155115));
        cities.put (346, new City (346, "SÃ†o Josâ€š", "BRA", 155105));
        cities.put (347, new City (347, "Cachoeiro de Itapemirim", "BRA", 155024));
        cities.put (348, new City (348, "NilÂ¢polis", "BRA", 153383));
        cities.put (349, new City (349, "Itapevi", "BRA", 150664));
        cities.put (350, new City (350, "Cabo de Santo Agostinho", "BRA", 149964));
        cities.put (351, new City (351, "Camaâ€¡ari", "BRA", 149146));
        cities.put (352, new City (352, "Sobral", "BRA", 146005));
        cities.put (353, new City (353, "ItajaÂ¡", "BRA", 145197));
        cities.put (354, new City (354, "ChapecÂ¢", "BRA", 144158));
        cities.put (355, new City (355, "Cotia", "BRA", 140042));
        cities.put (356, new City (356, "Lages", "BRA", 139570));
        cities.put (357, new City (357, "Ferraz de Vasconcelos", "BRA", 139283));
        cities.put (358, new City (358, "Indaiatuba", "BRA", 135968));
        cities.put (359, new City (359, "HortolÆ’ndia", "BRA", 135755));
        cities.put (360, new City (360, "Caxias", "BRA", 133980));
        cities.put (361, new City (361, "SÃ†o Caetano do Sul", "BRA", 133321));
        cities.put (362, new City (362, "Itu", "BRA", 132736));
        cities.put (363,
                new City (363, "Nossa Senhora do Socorro", "BRA", 131351));
        cities.put (364, new City (364, "ParnaÂ¡ba", "BRA", 129756));
        cities.put (365, new City (365, "Poâ€¡os de Caldas", "BRA", 129683));
        cities.put (366, new City (366, "TeresÂ¢polis", "BRA", 128079));
        cities.put (367, new City (367, "Barreiras", "BRA", 127801));
        cities.put (368, new City (368, "Castanhal", "BRA", 127634));
        cities.put (369, new City (369, "Alagoinhas", "BRA", 126820));
        cities.put (370, new City (370, "Itapecerica da Serra", "BRA", 126672));
        cities.put (371, new City (371, "Uruguaiana", "BRA", 126305));
        cities.put (372, new City (372, "ParanaguÂ ", "BRA", 126076));
        cities.put (373, new City (373, "Ibiritâ€š", "BRA", 125982));
        cities.put (374, new City (374, "Timon", "BRA", 125812));
        cities.put (375, new City (375, "LuziÆ’nia", "BRA", 125597));
        cities.put (376, new City (376, "Macaâ€š", "BRA", 125597));
        cities.put (377, new City (377, "TeÂ¢filo Otoni", "BRA", 124489));
        cities.put (378, new City (378, "Moji-Guaâ€¡u", "BRA", 123782));
        cities.put (379, new City (379, "Palmas", "BRA", 121919));
        cities.put (380, new City (380, "Pindamonhangaba", "BRA", 121904));
        cities.put (381, new City (381, "Francisco Morato", "BRA", 121197));
        cities.put (382, new City (382, "Bagâ€š", "BRA", 120793));
        cities.put (383, new City (383, "Sapucaia do Sul", "BRA", 120217));
        cities.put (384, new City (384, "Cabo Frio", "BRA", 119503));
        cities.put (385, new City (385, "Itapetininga", "BRA", 119391));
        cities.put (386, new City (386, "Patos de Minas", "BRA", 119262));
        cities.put (387, new City (387, "Camaragibe", "BRA", 118968));
        cities.put (388, new City (388, "Braganâ€¡a Paulista", "BRA", 116929));
        cities.put (389, new City (389, "Queimados", "BRA", 115020));
        cities.put (390, new City (390, "AraguaÂ¡na", "BRA", 114948));
        cities.put (391, new City (391, "Garanhuns", "BRA", 114603));
        cities.put (392, new City (392, "VitÂ¢ria de Santo AntÃ†o", "BRA",
                113595));
        cities.put (393, new City (393, "Santa Rita", "BRA", 113135));
        cities.put (394, new City (394, "Barbacena", "BRA", 113079));
        cities.put (395, new City (395, "Abaetetuba", "BRA", 111258));
        cities.put (396, new City (396, "JaÂ£", "BRA", 109965));
        cities.put (397, new City (397, "Lauro de Freitas", "BRA", 109236));
        cities.put (398, new City (398, "Franco da Rocha", "BRA", 108964));
        cities.put (399, new City (399, "Teixeira de Freitas", "BRA", 108441));
        cities.put (400, new City (400, "Varginha", "BRA", 108314));
        cities.put (401, new City (401, "RibeirÃ†o Pires", "BRA", 108121));
        cities.put (402, new City (402, "SabarÂ ", "BRA", 107781));
        cities.put (403, new City (403, "Catanduva", "BRA", 107761));
        cities.put (404, new City (404, "Rio Verde", "BRA", 107755));
        cities.put (405, new City (405, "Botucatu", "BRA", 107663));
        cities.put (406, new City (406, "Colatina", "BRA", 107354));
        cities.put (407, new City (407, "Santa Cruz do Sul", "BRA", 106734));
        cities.put (408, new City (408, "Linhares", "BRA", 106278));
        cities.put (409, new City (409, "Apucarana", "BRA", 105114));
        cities.put (410, new City (410, "Barretos", "BRA", 104156));
        cities.put (411, new City (411, "GuaratinguetÂ ", "BRA", 103433));
        cities.put (412, new City (412, "Cachoeirinha", "BRA", 103240));
        cities.put (413, new City (413, "CodÂ¢", "BRA", 103153));
        cities.put (414, new City (414, "JaraguÂ  do Sul", "BRA", 102580));
        cities.put (415, new City (415, "CubatÃ†o", "BRA", 102372));
        cities.put (416, new City (416, "Itabira", "BRA", 102217));
        cities.put (417, new City (417, "Itaituba", "BRA", 101320));
        cities.put (418, new City (418, "Araras", "BRA", 101046));
        cities.put (419, new City (419, "Resende", "BRA", 100627));
        cities.put (420, new City (420, "Atibaia", "BRA", 100356));
        cities.put (421, new City (421, "Pouso Alegre", "BRA", 100028));
        cities.put (422, new City (422, "Toledo", "BRA", 99387));
        cities.put (423, new City (423, "Crato", "BRA", 98965));
        cities.put (424, new City (424, "Passos", "BRA", 98570));
        cities.put (425, new City (425, "Araguari", "BRA", 98399));
        cities.put (426, new City (426, "SÃ†o Josâ€š de Ribamar", "BRA",
                98318));
        cities.put (427, new City (427, "Pinhais", "BRA", 98198));
        cities.put (428, new City (428, "SertÃ†ozinho", "BRA", 98140));
        cities.put (429, new City (429, "Conselheiro Lafaiete", "BRA", 97507));
        cities.put (430, new City (430, "Paulo Afonso", "BRA", 97291));
        cities.put (431, new City (431, "Angra dos Reis", "BRA", 96864));
        cities.put (432, new City (432, "EunÂ polis", "BRA", 96610));
        cities.put (433, new City (433, "Salto", "BRA", 96348));
        cities.put (434, new City (434, "Ourinhos", "BRA", 96291));
        cities.put (435, new City (435, "Parnamirim", "BRA", 96210));
        cities.put (436, new City (436, "Jacobina", "BRA", 96131));
        cities.put (437, new City (437, "Coronel Fabriciano", "BRA", 95933));
        cities.put (438, new City (438, "Birigui", "BRA", 94685));
        cities.put (439, new City (439, "TatuÂ¡", "BRA", 93897));
        cities.put (440, new City (440, "Ji-ParanÂ ", "BRA", 93346));
        cities.put (441, new City (441, "Bacabal", "BRA", 93121));
        cities.put (442, new City (442, "CametÂ ", "BRA", 92779));
        cities.put (443, new City (443, "GuaÂ¡ba", "BRA", 92224));
        cities.put (444, new City (444, "SÃ†o Lourenâ€¡o da Mata", "BRA",
                91999));
        cities.put (445, new City (445, "Santana do Livramento", "BRA", 91779));
        cities.put (446, new City (446, "Votorantim", "BRA", 91777));
        cities.put (447, new City (447, "Campo Largo", "BRA", 91203));
        cities.put (448, new City (448, "Patos", "BRA", 90519));
        cities.put (449, new City (449, "Ituiutaba", "BRA", 90507));
        cities.put (450, new City (450, "CorumbÂ ", "BRA", 90111));
        cities.put (451, new City (451, "Palhoâ€¡a", "BRA", 89465));
        cities.put (452, new City (452, "Barra do PiraÂ¡", "BRA", 89388));
        cities.put (453, new City (453, "Bento Gonâ€¡alves", "BRA", 89254));
        cities.put (454, new City (454, "PoÂ ", "BRA", 89236));
        cities.put (455, new City (455, "Âµguas Lindas de GoiÂ s", "BRA",
                89200));
        cities.put (456, new City (456, "London", "GBR", 7285000));
        cities.put (457, new City (457, "Birmingham", "GBR", 1013000));
        cities.put (458, new City (458, "Glasgow", "GBR", 619680));
        cities.put (459, new City (459, "Liverpool", "GBR", 461000));
        cities.put (460, new City (460, "Edinburgh", "GBR", 450180));
        cities.put (461, new City (461, "Sheffield", "GBR", 431607));
        cities.put (462, new City (462, "Manchester", "GBR", 430000));
        cities.put (463, new City (463, "Leeds", "GBR", 424194));
        cities.put (464, new City (464, "Bristol", "GBR", 402000));
        cities.put (465, new City (465, "Cardiff", "GBR", 321000));
        cities.put (466, new City (466, "Coventry", "GBR", 304000));
        cities.put (467, new City (467, "Leicester", "GBR", 294000));
        cities.put (468, new City (468, "Bradford", "GBR", 289376));
        cities.put (469, new City (469, "Belfast", "GBR", 287500));
        cities.put (470, new City (470, "Nottingham", "GBR", 287000));
        cities.put (471, new City (471, "Kingston upon Hull", "GBR", 262000));
        cities.put (472, new City (472, "Plymouth", "GBR", 253000));
        cities.put (473, new City (473, "Stoke-on-Trent", "GBR", 252000));
        cities.put (474, new City (474, "Wolverhampton", "GBR", 242000));
        cities.put (475, new City (475, "Derby", "GBR", 236000));
        cities.put (476, new City (476, "Swansea", "GBR", 230000));
        cities.put (477, new City (477, "Southampton", "GBR", 216000));
        cities.put (478, new City (478, "Aberdeen", "GBR", 213070));
        cities.put (479, new City (479, "Northampton", "GBR", 196000));
        cities.put (480, new City (480, "Dudley", "GBR", 192171));
        cities.put (481, new City (481, "Portsmouth", "GBR", 190000));
        cities.put (482, new City (482, "Newcastle upon Tyne", "GBR", 189150));
        cities.put (483, new City (483, "Sunderland", "GBR", 183310));
        cities.put (484, new City (484, "Luton", "GBR", 183000));
        cities.put (485, new City (485, "Swindon", "GBR", 180000));
        cities.put (486, new City (486, "Southend-on-Sea", "GBR", 176000));
        cities.put (487, new City (487, "Walsall", "GBR", 174739));
        cities.put (488, new City (488, "Bournemouth", "GBR", 162000));
        cities.put (489, new City (489, "Peterborough", "GBR", 156000));
        cities.put (490, new City (490, "Brighton", "GBR", 156124));
        cities.put (491, new City (491, "Blackpool", "GBR", 151000));
        cities.put (492, new City (492, "Dundee", "GBR", 146690));
        cities.put (493, new City (493, "West Bromwich", "GBR", 146386));
        cities.put (494, new City (494, "Reading", "GBR", 148000));
        cities.put (495, new City (495, "Oldbury/Smethwick (Warley)", "GBR",
                145542));
        cities.put (496, new City (496, "Middlesbrough", "GBR", 145000));
        cities.put (497, new City (497, "Huddersfield", "GBR", 143726));
        cities.put (498, new City (498, "Oxford", "GBR", 144000));
        cities.put (499, new City (499, "Poole", "GBR", 141000));
        cities.put (500, new City (500, "Bolton", "GBR", 139020));
        cities.put (501, new City (501, "Blackburn", "GBR", 140000));
        cities.put (502, new City (502, "Newport", "GBR", 139000));
        cities.put (503, new City (503, "Preston", "GBR", 135000));
        cities.put (504, new City (504, "Stockport", "GBR", 132813));
        cities.put (505, new City (505, "Norwich", "GBR", 124000));
        cities.put (506, new City (506, "Rotherham", "GBR", 121380));
        cities.put (507, new City (507, "Cambridge", "GBR", 121000));
        cities.put (508, new City (508, "Watford", "GBR", 113080));
        cities.put (509, new City (509, "Ipswich", "GBR", 114000));
        cities.put (510, new City (510, "Slough", "GBR", 112000));
        cities.put (511, new City (511, "Exeter", "GBR", 111000));
        cities.put (512, new City (512, "Cheltenham", "GBR", 106000));
        cities.put (513, new City (513, "Gloucester", "GBR", 107000));
        cities.put (514, new City (514, "Saint Helens", "GBR", 106293));
        cities.put (515, new City (515, "Sutton Coldfield", "GBR", 106001));
        cities.put (516, new City (516, "York", "GBR", 104425));
        cities.put (517, new City (517, "Oldham", "GBR", 103931));
        cities.put (518, new City (518, "Basildon", "GBR", 100924));
        cities.put (519, new City (519, "Worthing", "GBR", 100000));
        cities.put (520, new City (520, "Chelmsford", "GBR", 97451));
        cities.put (521, new City (521, "Colchester", "GBR", 96063));
        cities.put (522, new City (522, "Crawley", "GBR", 97000));
        cities.put (523, new City (523, "Gillingham", "GBR", 92000));
        cities.put (524, new City (524, "Solihull", "GBR", 94531));
        cities.put (525, new City (525, "Rochdale", "GBR", 94313));
        cities.put (526, new City (526, "Birkenhead", "GBR", 93087));
        cities.put (527, new City (527, "Worcester", "GBR", 95000));
        cities.put (528, new City (528, "Hartlepool", "GBR", 92000));
        cities.put (529, new City (529, "Halifax", "GBR", 91069));
        cities.put (530, new City (530, "Woking/Byfleet", "GBR", 92000));
        cities.put (531, new City (531, "Southport", "GBR", 90959));
        cities.put (532, new City (532, "Maidstone", "GBR", 90878));
        cities.put (533, new City (533, "Eastbourne", "GBR", 90000));
        cities.put (534, new City (534, "Grimsby", "GBR", 89000));
        cities.put (535, new City (535, "Saint Helier", "GBR", 27523));
        cities.put (536, new City (536, "Douglas", "GBR", 23487));
        cities.put (537, new City (537, "Road Town", "VGB", 8000));
        cities.put (538, new City (538, "Bandar Seri Begawan", "BRN", 21484));
        cities.put (539, new City (539, "Sofija", "BGR", 1122302));
        cities.put (540, new City (540, "Plovdiv", "BGR", 342584));
        cities.put (541, new City (541, "Varna", "BGR", 299801));
        cities.put (542, new City (542, "Burgas", "BGR", 195255));
        cities.put (543, new City (543, "Ruse", "BGR", 166467));
        cities.put (544, new City (544, "Stara Zagora", "BGR", 147939));
        cities.put (545, new City (545, "Pleven", "BGR", 121952));
        cities.put (546, new City (546, "Sliven", "BGR", 105530));
        cities.put (547, new City (547, "Dobric", "BGR", 100399));
        cities.put (548, new City (548, "?umen", "BGR", 94686));
        cities.put (549, new City (549, "Ouagadougou", "BFA", 824000));
        cities.put (550, new City (550, "Bobo-Dioulasso", "BFA", 300000));
        cities.put (551, new City (551, "Koudougou", "BFA", 105000));
        cities.put (552, new City (552, "Bujumbura", "BDI", 300000));
        cities.put (553, new City (553, "George Town", "CYM", 19600));
        cities.put (554, new City (554, "Santiago de Chile", "CHL", 4703954));
        cities.put (555, new City (555, "Puente Alto", "CHL", 386236));
        cities.put (556, new City (556, "ViÂ¤a del Mar", "CHL", 312493));
        cities.put (557, new City (557, "ValparaÂ¡so", "CHL", 293800));
        cities.put (558, new City (558, "Talcahuano", "CHL", 277752));
        cities.put (559, new City (559, "Antofagasta", "CHL", 251429));
        cities.put (560, new City (560, "San Bernardo", "CHL", 241910));
        cities.put (561, new City (561, "Temuco", "CHL", 233041));
        cities.put (562, new City (562, "ConcepciÂ¢n", "CHL", 217664));
        cities.put (563, new City (563, "Rancagua", "CHL", 212977));
        cities.put (564, new City (564, "Arica", "CHL", 189036));
        cities.put (565, new City (565, "Talca", "CHL", 187557));
        cities.put (566, new City (566, "ChillÂ n", "CHL", 178182));
        cities.put (567, new City (567, "Iquique", "CHL", 177892));
        cities.put (568, new City (568, "Los Angeles", "CHL", 158215));
        cities.put (569, new City (569, "Puerto Montt", "CHL", 152194));
        cities.put (570, new City (570, "Coquimbo", "CHL", 143353));
        cities.put (571, new City (571, "Osorno", "CHL", 141468));
        cities.put (572, new City (572, "La Serena", "CHL", 137409));
        cities.put (573, new City (573, "Calama", "CHL", 137265));
        cities.put (574, new City (574, "Valdivia", "CHL", 133106));
        cities.put (575, new City (575, "Punta Arenas", "CHL", 125631));
        cities.put (576, new City (576, "CopiapÂ¢", "CHL", 120128));
        cities.put (577, new City (577, "Quilpuâ€š", "CHL", 118857));
        cities.put (578, new City (578, "CuricÂ¢", "CHL", 115766));
        cities.put (579, new City (579, "Ovalle", "CHL", 94854));
        cities.put (580, new City (580, "Coronel", "CHL", 93061));
        cities.put (581, new City (581, "San Pedro de la Paz", "CHL", 91684));
        cities.put (582, new City (582, "Melipilla", "CHL", 91056));
        cities.put (583, new City (583, "Avarua", "COK", 11900));
        cities.put (584, new City (584, "San Josâ€š", "CRI", 339131));
        cities.put (585, new City (585, "Djibouti", "DJI", 383000));
        cities.put (586, new City (586, "Roseau", "DMA", 16243));
        cities.put (587, new City (587, "Santo Domingo de GuzmÂ n", "DOM",
                1609966));
        cities.put (588, new City (588, "Santiago de los Caballeros", "DOM",
                365463));
        cities.put (589, new City (589, "La Romana", "DOM", 140204));
        cities.put (590, new City (590, "San Pedro de MacorÂ¡s", "DOM", 124735));
        cities.put (591, new City (591, "San Francisco de MacorÂ¡s", "DOM",
                108485));
        cities.put (592, new City (592, "San Felipe de Puerto Plata", "DOM",
                89423));
        cities.put (593, new City (593, "Guayaquil", "ECU", 2070040));
        cities.put (594, new City (594, "Quito", "ECU", 1573458));
        cities.put (595, new City (595, "Cuenca", "ECU", 270353));
        cities.put (596, new City (596, "Machala", "ECU", 210368));
        cities.put (597, new City (597, "Santo Domingo de los Colorados", "ECU",
                202111));
        cities.put (598, new City (598, "Portoviejo", "ECU", 176413));
        cities.put (599, new City (599, "Ambato", "ECU", 169612));
        cities.put (600, new City (600, "Manta", "ECU", 164739));
        cities.put (601, new City (601, "Duran [Eloy Alfaro]", "ECU", 152514));
        cities.put (602, new City (602, "Ibarra", "ECU", 130643));
        cities.put (603, new City (603, "Quevedo", "ECU", 129631));
        cities.put (604, new City (604, "Milagro", "ECU", 124177));
        cities.put (605, new City (605, "Loja", "ECU", 123875));
        cities.put (606, new City (606, "RÂ¡obamba", "ECU", 123163));
        cities.put (607, new City (607, "Esmeraldas", "ECU", 123045));
        cities.put (608, new City (608, "Cairo", "EGY", 6789479));
        cities.put (609, new City (609, "Alexandria", "EGY", 3328196));
        cities.put (610, new City (610, "Giza", "EGY", 2221868));
        cities.put (611, new City (611, "Shubra al-Khayma", "EGY", 870716));
        cities.put (612, new City (612, "Port Said", "EGY", 469533));
        cities.put (613, new City (613, "Suez", "EGY", 417610));
        cities.put (614, new City (614, "al-Mahallat al-Kubra", "EGY", 395402));
        cities.put (615, new City (615, "Tanta", "EGY", 371010));
        cities.put (616, new City (616, "al-Mansura", "EGY", 369621));
        cities.put (617, new City (617, "Luxor", "EGY", 360503));
        cities.put (618, new City (618, "Asyut", "EGY", 343498));
        cities.put (619, new City (619, "Bahtim", "EGY", 275807));
        cities.put (620, new City (620, "Zagazig", "EGY", 267351));
        cities.put (621, new City (621, "al-Faiyum", "EGY", 260964));
        cities.put (622, new City (622, "Ismailia", "EGY", 254477));
        cities.put (623, new City (623, "Kafr al-Dawwar", "EGY", 231978));
        cities.put (624, new City (624, "Assuan", "EGY", 219017));
        cities.put (625, new City (625, "Damanhur", "EGY", 212203));
        cities.put (626, new City (626, "al-Minya", "EGY", 201360));
        cities.put (627, new City (627, "Bani Suwayf", "EGY", 172032));
        cities.put (628, new City (628, "Qina", "EGY", 171275));
        cities.put (629, new City (629, "Sawhaj", "EGY", 170125));
        cities.put (630, new City (630, "Shibin al-Kawm", "EGY", 159909));
        cities.put (631, new City (631, "Bulaq al-Dakrur", "EGY", 148787));
        cities.put (632, new City (632, "Banha", "EGY", 145792));
        cities.put (633, new City (633, "Warraq al-Arab", "EGY", 127108));
        cities.put (634, new City (634, "Kafr al-Shaykh", "EGY", 124819));
        cities.put (635, new City (635, "Mallawi", "EGY", 119283));
        cities.put (636, new City (636, "Bilbays", "EGY", 113608));
        cities.put (637, new City (637, "Mit Ghamr", "EGY", 101801));
        cities.put (638, new City (638, "al-Arish", "EGY", 100447));
        cities.put (639, new City (639, "Talkha", "EGY", 97700));
        cities.put (640, new City (640, "Qalyub", "EGY", 97200));
        cities.put (641, new City (641, "Jirja", "EGY", 95400));
        cities.put (642, new City (642, "Idfu", "EGY", 94200));
        cities.put (643, new City (643, "al-Hawamidiya", "EGY", 91700));
        cities.put (644, new City (644, "Disuq", "EGY", 91300));
        cities.put (645, new City (645, "San Salvador", "SLV", 415346));
        cities.put (646, new City (646, "Santa Ana", "SLV", 139389));
        cities.put (647, new City (647, "Mejicanos", "SLV", 138800));
        cities.put (648, new City (648, "Soyapango", "SLV", 129800));
        cities.put (649, new City (649, "San Miguel", "SLV", 127696));
        cities.put (650, new City (650, "Nueva San Salvador", "SLV", 98400));
        cities.put (651, new City (651, "Apopa", "SLV", 88800));
        cities.put (652, new City (652, "Asmara", "ERI", 431000));
        cities.put (653, new City (653, "Madrid", "ESP", 2879052));
        cities.put (654, new City (654, "Barcelona", "ESP", 1503451));
        cities.put (655, new City (655, "Valencia", "ESP", 739412));
        cities.put (656, new City (656, "Sevilla", "ESP", 701927));
        cities.put (657, new City (657, "Zaragoza", "ESP", 603367));
        cities.put (658, new City (658, "MÂ laga", "ESP", 530553));
        cities.put (659, new City (659, "Bilbao", "ESP", 357589));
        cities.put (660, new City (660, "Las Palmas de Gran Canaria", "ESP",
                354757));
        cities.put (661, new City (661, "Murcia", "ESP", 353504));
        cities.put (662, new City (662, "Palma de Mallorca", "ESP", 326993));
        cities.put (663, new City (663, "Valladolid", "ESP", 319998));
        cities.put (664, new City (664, "CÂ¢rdoba", "ESP", 311708));
        cities.put (665, new City (665, "Vigo", "ESP", 283670));
        cities.put (666, new City (666, "Alicante [Alacant]", "ESP", 272432));
        cities.put (667, new City (667, "GijÂ¢n", "ESP", 267980));
        cities.put (668, new City (668, "LÃ¯Hospitalet de Llobregat", "ESP",
                247986));
        cities.put (669, new City (669, "Granada", "ESP", 244767));
        cities.put (670, new City (670, "A CoruÂ¤a (La CoruÂ¤a)", "ESP",
                243402));
        cities.put (671, new City (671, "Vitoria-Gasteiz", "ESP", 217154));
        cities.put (672, new City (672, "Santa Cruz de Tenerife", "ESP", 213050));
        cities.put (673, new City (673, "Badalona", "ESP", 209635));
        cities.put (674, new City (674, "Oviedo", "ESP", 200453));
        cities.put (675, new City (675, "MÂ¢stoles", "ESP", 195351));
        cities.put (676, new City (676, "Elche [Elx]", "ESP", 193174));
        cities.put (677, new City (677, "Sabadell", "ESP", 184859));
        cities.put (678, new City (678, "Santander", "ESP", 184165));
        cities.put (679, new City (679, "Jerez de la Frontera", "ESP", 182660));
        cities.put (680, new City (680, "Pamplona [IruÂ¤a]", "ESP", 180483));
        cities.put (681, new City (681, "Donostia-San SebastiÂ n", "ESP",
                179208));
        cities.put (682, new City (682, "Cartagena", "ESP", 177709));
        cities.put (683, new City (683, "Leganâ€šs", "ESP", 173163));
        cities.put (684, new City (684, "Fuenlabrada", "ESP", 171173));
        cities.put (685, new City (685, "AlmerÂ¡a", "ESP", 169027));
        cities.put (686, new City (686, "Terrassa", "ESP", 168695));
        cities.put (687, new City (687, "AlcalÂ  de Henares", "ESP", 164463));
        cities.put (688, new City (688, "Burgos", "ESP", 162802));
        cities.put (689, new City (689, "Salamanca", "ESP", 158720));
        cities.put (690, new City (690, "Albacete", "ESP", 147527));
        cities.put (691, new City (691, "Getafe", "ESP", 145371));
        cities.put (692, new City (692, "CÂ diz", "ESP", 142449));
        cities.put (693, new City (693, "AlcorcÂ¢n", "ESP", 142048));
        cities.put (694, new City (694, "Huelva", "ESP", 140583));
        cities.put (695, new City (695, "LeÂ¢n", "ESP", 139809));
        cities.put (696, new City (696, "CastellÂ¢n de la Plana [Castell",
                "ESP", 139712));
        cities.put (697, new City (697, "Badajoz", "ESP", 136613));
        cities.put (698, new City (698, "[San CristÂ¢bal de] la Laguna", "ESP",
                127945));
        cities.put (699, new City (699, "LogroÂ¤o", "ESP", 127093));
        cities.put (700,
                new City (700, "Santa Coloma de Gramenet", "ESP", 120802));
        cities.put (701, new City (701, "Tarragona", "ESP", 113016));
        cities.put (702, new City (702, "Lleida (Lâ€šrida)", "ESP", 112207));
        cities.put (703, new City (703, "Jaâ€šn", "ESP", 109247));
        cities.put (704, new City (704, "Ourense (Orense)", "ESP", 109120));
        cities.put (705, new City (705, "MatarÂ¢", "ESP", 104095));
        cities.put (706, new City (706, "Algeciras", "ESP", 103106));
        cities.put (707, new City (707, "Marbella", "ESP", 101144));
        cities.put (708, new City (708, "Barakaldo", "ESP", 98212));
        cities.put (709, new City (709, "Dos Hermanas", "ESP", 94591));
        cities.put (710, new City (710, "Santiago de Compostela", "ESP", 93745));
        cities.put (711, new City (711, "TorrejÂ¢n de Ardoz", "ESP", 92262));
        cities.put (712, new City (712, "Cape Town", "ZAF", 2352121));
        cities.put (713, new City (713, "Soweto", "ZAF", 904165));
        cities.put (714, new City (714, "Johannesburg", "ZAF", 756653));
        cities.put (715, new City (715, "Port Elizabeth", "ZAF", 752319));
        cities.put (716, new City (716, "Pretoria", "ZAF", 658630));
        cities.put (717, new City (717, "Inanda", "ZAF", 634065));
        cities.put (718, new City (718, "Durban", "ZAF", 566120));
        cities.put (719, new City (719, "Vanderbijlpark", "ZAF", 468931));
        cities.put (720, new City (720, "Kempton Park", "ZAF", 442633));
        cities.put (721, new City (721, "Alberton", "ZAF", 410102));
        cities.put (722, new City (722, "Pinetown", "ZAF", 378810));
        cities.put (723, new City (723, "Pietermaritzburg", "ZAF", 370190));
        cities.put (724, new City (724, "Benoni", "ZAF", 365467));
        cities.put (725, new City (725, "Randburg", "ZAF", 341288));
        cities.put (726, new City (726, "Umlazi", "ZAF", 339233));
        cities.put (727, new City (727, "Bloemfontein", "ZAF", 334341));
        cities.put (728, new City (728, "Vereeniging", "ZAF", 328535));
        cities.put (729, new City (729, "Wonderboom", "ZAF", 283289));
        cities.put (730, new City (730, "Roodepoort", "ZAF", 279340));
        cities.put (731, new City (731, "Boksburg", "ZAF", 262648));
        cities.put (732, new City (732, "Klerksdorp", "ZAF", 261911));
        cities.put (733, new City (733, "Soshanguve", "ZAF", 242727));
        cities.put (734, new City (734, "Newcastle", "ZAF", 222993));
        cities.put (735, new City (735, "East London", "ZAF", 221047));
        cities.put (736, new City (736, "Welkom", "ZAF", 203296));
        cities.put (737, new City (737, "Kimberley", "ZAF", 197254));
        cities.put (738, new City (738, "Uitenhage", "ZAF", 192120));
        cities.put (739, new City (739, "Chatsworth", "ZAF", 189885));
        cities.put (740, new City (740, "Mdantsane", "ZAF", 182639));
        cities.put (741, new City (741, "Krugersdorp", "ZAF", 181503));
        cities.put (742, new City (742, "Botshabelo", "ZAF", 177971));
        cities.put (743, new City (743, "Brakpan", "ZAF", 171363));
        cities.put (744, new City (744, "Witbank", "ZAF", 167183));
        cities.put (745, new City (745, "Oberholzer", "ZAF", 164367));
        cities.put (746, new City (746, "Germiston", "ZAF", 164252));
        cities.put (747, new City (747, "Springs", "ZAF", 162072));
        cities.put (748, new City (748, "Westonaria", "ZAF", 159632));
        cities.put (749, new City (749, "Randfontein", "ZAF", 120838));
        cities.put (750, new City (750, "Paarl", "ZAF", 105768));
        cities.put (751, new City (751, "Potchefstroom", "ZAF", 101817));
        cities.put (752, new City (752, "Rustenburg", "ZAF", 97008));
        cities.put (753, new City (753, "Nigel", "ZAF", 96734));
        cities.put (754, new City (754, "George", "ZAF", 93818));
        cities.put (755, new City (755, "Ladysmith", "ZAF", 89292));
        cities.put (756, new City (756, "Addis Abeba", "ETH", 2495000));
        cities.put (757, new City (757, "Dire Dawa", "ETH", 164851));
        cities.put (758, new City (758, "Nazret", "ETH", 127842));
        cities.put (759, new City (759, "Gonder", "ETH", 112249));
        cities.put (760, new City (760, "Dese", "ETH", 97314));
        cities.put (761, new City (761, "Mekele", "ETH", 96938));
        cities.put (762, new City (762, "Bahir Dar", "ETH", 96140));
        cities.put (763, new City (763, "Stanley", "FLK", 1636));
        cities.put (764, new City (764, "Suva", "FJI", 77366));
        cities.put (765, new City (765, "Quezon", "PHL", 2173831));
        cities.put (766, new City (766, "Manila", "PHL", 1581082));
        cities.put (767, new City (767, "Kalookan", "PHL", 1177604));
        cities.put (768, new City (768, "Davao", "PHL", 1147116));
        cities.put (769, new City (769, "Cebu", "PHL", 718821));
        cities.put (770, new City (770, "Zamboanga", "PHL", 601794));
        cities.put (771, new City (771, "Pasig", "PHL", 505058));
        cities.put (772, new City (772, "Valenzuela", "PHL", 485433));
        cities.put (773, new City (773, "Las PiÂ¤as", "PHL", 472780));
        cities.put (774, new City (774, "Antipolo", "PHL", 470866));
        cities.put (775, new City (775, "Taguig", "PHL", 467375));
        cities.put (776, new City (776, "Cagayan de Oro", "PHL", 461877));
        cities.put (777, new City (777, "ParaÂ¤aque", "PHL", 449811));
        cities.put (778, new City (778, "Makati", "PHL", 444867));
        cities.put (779, new City (779, "Bacolod", "PHL", 429076));
        cities.put (780, new City (780, "General Santos", "PHL", 411822));
        cities.put (781, new City (781, "Marikina", "PHL", 391170));
        cities.put (782, new City (782, "DasmariÂ¤as", "PHL", 379520));
        cities.put (783, new City (783, "Muntinlupa", "PHL", 379310));
        cities.put (784, new City (784, "Iloilo", "PHL", 365820));
        cities.put (785, new City (785, "Pasay", "PHL", 354908));
        cities.put (786, new City (786, "Malabon", "PHL", 338855));
        cities.put (787,
                new City (787, "San Josâ€š del Monte", "PHL", 315807));
        cities.put (788, new City (788, "Bacoor", "PHL", 305699));
        cities.put (789, new City (789, "Iligan", "PHL", 285061));
        cities.put (790, new City (790, "Calamba", "PHL", 281146));
        cities.put (791, new City (791, "Mandaluyong", "PHL", 278474));
        cities.put (792, new City (792, "Butuan", "PHL", 267279));
        cities.put (793, new City (793, "Angeles", "PHL", 263971));
        cities.put (794, new City (794, "Tarlac", "PHL", 262481));
        cities.put (795, new City (795, "Mandaue", "PHL", 259728));
        cities.put (796, new City (796, "Baguio", "PHL", 252386));
        cities.put (797, new City (797, "Batangas", "PHL", 247588));
        cities.put (798, new City (798, "Cainta", "PHL", 242511));
        cities.put (799, new City (799, "San Pedro", "PHL", 231403));
        cities.put (800, new City (800, "Navotas", "PHL", 230403));
        cities.put (801, new City (801, "Cabanatuan", "PHL", 222859));
        cities.put (802, new City (802, "San Fernando", "PHL", 221857));
        cities.put (803, new City (803, "Lipa", "PHL", 218447));
        cities.put (804, new City (804, "Lapu-Lapu", "PHL", 217019));
        cities.put (805, new City (805, "San Pablo", "PHL", 207927));
        cities.put (806, new City (806, "BiÂ¤an", "PHL", 201186));
        cities.put (807, new City (807, "Taytay", "PHL", 198183));
        cities.put (808, new City (808, "Lucena", "PHL", 196075));
        cities.put (809, new City (809, "Imus", "PHL", 195482));
        cities.put (810, new City (810, "Olongapo", "PHL", 194260));
        cities.put (811, new City (811, "Binangonan", "PHL", 187691));
        cities.put (812, new City (812, "Santa Rosa", "PHL", 185633));
        cities.put (813, new City (813, "Tagum", "PHL", 179531));
        cities.put (814, new City (814, "Tacloban", "PHL", 178639));
        cities.put (815, new City (815, "Malolos", "PHL", 175291));
        cities.put (816, new City (816, "Mabalacat", "PHL", 171045));
        cities.put (817, new City (817, "Cotabato", "PHL", 163849));
        cities.put (818, new City (818, "Meycauayan", "PHL", 163037));
        cities.put (819, new City (819, "Puerto Princesa", "PHL", 161912));
        cities.put (820, new City (820, "Legazpi", "PHL", 157010));
        cities.put (821, new City (821, "Silang", "PHL", 156137));
        cities.put (822, new City (822, "Ormoc", "PHL", 154297));
        cities.put (823, new City (823, "San Carlos", "PHL", 154264));
        cities.put (824, new City (824, "Kabankalan", "PHL", 149769));
        cities.put (825, new City (825, "Talisay", "PHL", 148110));
        cities.put (826, new City (826, "Valencia", "PHL", 147924));
        cities.put (827, new City (827, "Calbayog", "PHL", 147187));
        cities.put (828, new City (828, "Santa Maria", "PHL", 144282));
        cities.put (829, new City (829, "Pagadian", "PHL", 142515));
        cities.put (830, new City (830, "Cadiz", "PHL", 141954));
        cities.put (831, new City (831, "Bago", "PHL", 141721));
        cities.put (832, new City (832, "Toledo", "PHL", 141174));
        cities.put (833, new City (833, "Naga", "PHL", 137810));
        cities.put (834, new City (834, "San Mateo", "PHL", 135603));
        cities.put (835, new City (835, "Panabo", "PHL", 133950));
        cities.put (836, new City (836, "Koronadal", "PHL", 133786));
        cities.put (837, new City (837, "Marawi", "PHL", 131090));
        cities.put (838, new City (838, "Dagupan", "PHL", 130328));
        cities.put (839, new City (839, "Sagay", "PHL", 129765));
        cities.put (840, new City (840, "Roxas", "PHL", 126352));
        cities.put (841, new City (841, "Lubao", "PHL", 125699));
        cities.put (842, new City (842, "Digos", "PHL", 125171));
        cities.put (843, new City (843, "San Miguel", "PHL", 123824));
        cities.put (844, new City (844, "Malaybalay", "PHL", 123672));
        cities.put (845, new City (845, "Tuguegarao", "PHL", 120645));
        cities.put (846, new City (846, "Ilagan", "PHL", 119990));
        cities.put (847, new City (847, "Baliuag", "PHL", 119675));
        cities.put (848, new City (848, "Surigao", "PHL", 118534));
        cities.put (849, new City (849, "San Carlos", "PHL", 118259));
        cities.put (850, new City (850, "San Juan del Monte", "PHL", 117680));
        cities.put (851, new City (851, "Tanauan", "PHL", 117539));
        cities.put (852, new City (852, "Concepcion", "PHL", 115171));
        cities.put (853, new City (853, "Rodriguez (Montalban)", "PHL", 115167));
        cities.put (854, new City (854, "Sariaya", "PHL", 114568));
        cities.put (855, new City (855, "Malasiqui", "PHL", 113190));
        cities.put (856, new City (856, "General Mariano Alvarez", "PHL", 112446));
        cities.put (857, new City (857, "Urdaneta", "PHL", 111582));
        cities.put (858, new City (858, "Hagonoy", "PHL", 111425));
        cities.put (859, new City (859, "San Jose", "PHL", 111009));
        cities.put (860, new City (860, "Polomolok", "PHL", 110709));
        cities.put (861, new City (861, "Santiago", "PHL", 110531));
        cities.put (862, new City (862, "Tanza", "PHL", 110517));
        cities.put (863, new City (863, "Ozamis", "PHL", 110420));
        cities.put (864, new City (864, "Mexico", "PHL", 109481));
        cities.put (865, new City (865, "San Jose", "PHL", 108254));
        cities.put (866, new City (866, "Silay", "PHL", 107722));
        cities.put (867, new City (867, "General Trias", "PHL", 107691));
        cities.put (868, new City (868, "Tabaco", "PHL", 107166));
        cities.put (869, new City (869, "Cabuyao", "PHL", 106630));
        cities.put (870, new City (870, "Calapan", "PHL", 105910));
        cities.put (871, new City (871, "Mati", "PHL", 105908));
        cities.put (872, new City (872, "Midsayap", "PHL", 105760));
        cities.put (873, new City (873, "Cauayan", "PHL", 103952));
        cities.put (874, new City (874, "Gingoog", "PHL", 102379));
        cities.put (875, new City (875, "Dumaguete", "PHL", 102265));
        cities.put (876, new City (876, "San Fernando", "PHL", 102082));
        cities.put (877, new City (877, "Arayat", "PHL", 101792));
        cities.put (878, new City (878, "Bayawan (Tulong)", "PHL", 101391));
        cities.put (879, new City (879, "Kidapawan", "PHL", 101205));
        cities.put (880, new City (880, "Daraga (Locsin)", "PHL", 101031));
        cities.put (881, new City (881, "Marilao", "PHL", 101017));
        cities.put (882, new City (882, "Malita", "PHL", 100000));
        cities.put (883, new City (883, "Dipolog", "PHL", 99862));
        cities.put (884, new City (884, "Cavite", "PHL", 99367));
        cities.put (885, new City (885, "Danao", "PHL", 98781));
        cities.put (886, new City (886, "Bislig", "PHL", 97860));
        cities.put (887, new City (887, "Talavera", "PHL", 97329));
        cities.put (888, new City (888, "Guagua", "PHL", 96858));
        cities.put (889, new City (889, "Bayambang", "PHL", 96609));
        cities.put (890, new City (890, "Nasugbu", "PHL", 96113));
        cities.put (891, new City (891, "Baybay", "PHL", 95630));
        cities.put (892, new City (892, "Capas", "PHL", 95219));
        cities.put (893, new City (893, "Sultan Kudarat", "PHL", 94861));
        cities.put (894, new City (894, "Laoag", "PHL", 94466));
        cities.put (895, new City (895, "Bayugan", "PHL", 93623));
        cities.put (896, new City (896, "Malungon", "PHL", 93232));
        cities.put (897, new City (897, "Santa Cruz", "PHL", 92694));
        cities.put (898, new City (898, "Sorsogon", "PHL", 92512));
        cities.put (899, new City (899, "Candelaria", "PHL", 92429));
        cities.put (900, new City (900, "Ligao", "PHL", 90603));
        cities.put (901, new City (901, "TÂ¢rshavn", "FRO", 14542));
        cities.put (902, new City (902, "Libreville", "GAB", 419000));
        cities.put (903, new City (903, "Serekunda", "GMB", 102600));
        cities.put (904, new City (904, "Banjul", "GMB", 42326));
        cities.put (905, new City (905, "Tbilisi", "GEO", 1235200));
        cities.put (906, new City (906, "Kutaisi", "GEO", 240900));
        cities.put (907, new City (907, "Rustavi", "GEO", 155400));
        cities.put (908, new City (908, "Batumi", "GEO", 137700));
        cities.put (909, new City (909, "Sohumi", "GEO", 111700));
        cities.put (910, new City (910, "Accra", "GHA", 1070000));
        cities.put (911, new City (911, "Kumasi", "GHA", 385192));
        cities.put (912, new City (912, "Tamale", "GHA", 151069));
        cities.put (913, new City (913, "Tema", "GHA", 109975));
        cities.put (914, new City (914, "Sekondi-Takoradi", "GHA", 103653));
        cities.put (915, new City (915, "Gibraltar", "GIB", 27025));
        cities.put (916, new City (916, "Saint GeorgeÃ¯s", "GRD", 4621));
        cities.put (917, new City (917, "Nuuk", "GRL", 13445));
        cities.put (918, new City (918, "Les Abymes", "GLP", 62947));
        cities.put (919, new City (919, "Basse-Terre", "GLP", 12433));
        cities.put (920, new City (920, "Tamuning", "GUM", 9500));
        cities.put (921, new City (921, "AgaÂ¤a", "GUM", 1139));
        cities.put (922, new City (922, "Ciudad de Guatemala", "GTM", 823301));
        cities.put (923, new City (923, "Mixco", "GTM", 209791));
        cities.put (924, new City (924, "Villa Nueva", "GTM", 101295));
        cities.put (925, new City (925, "Quetzaltenango", "GTM", 90801));
        cities.put (926, new City (926, "Conakry", "GIN", 1090610));
        cities.put (927, new City (927, "Bissau", "GNB", 241000));
        cities.put (928, new City (928, "Georgetown", "GUY", 254000));
        cities.put (929, new City (929, "Port-au-Prince", "HTI", 884472));
        cities.put (930, new City (930, "Carrefour", "HTI", 290204));
        cities.put (931, new City (931, "Delmas", "HTI", 240429));
        cities.put (932, new City (932, "Le-Cap-Haâ€¹tien", "HTI", 102233));
        cities.put (933, new City (933, "Tegucigalpa", "HND", 813900));
        cities.put (934, new City (934, "San Pedro Sula", "HND", 383900));
        cities.put (935, new City (935, "La Ceiba", "HND", 89200));
        cities.put (936,
                new City (936, "Kowloon and New Kowloon", "HKG", 1987996));
        cities.put (937, new City (937, "Victoria", "HKG", 1312637));
        cities.put (938, new City (938, "Longyearbyen", "SJM", 1438));
        cities.put (939, new City (939, "Jakarta", "IDN", 9604900));
        cities.put (940, new City (940, "Surabaya", "IDN", 2663820));
        cities.put (941, new City (941, "Bandung", "IDN", 2429000));
        cities.put (942, new City (942, "Medan", "IDN", 1843919));
        cities.put (943, new City (943, "Palembang", "IDN", 1222764));
        cities.put (944, new City (944, "Tangerang", "IDN", 1198300));
        cities.put (945, new City (945, "Semarang", "IDN", 1104405));
        cities.put (946, new City (946, "Ujung Pandang", "IDN", 1060257));
        cities.put (947, new City (947, "Malang", "IDN", 716862));
        cities.put (948, new City (948, "Bandar Lampung", "IDN", 680332));
        cities.put (949, new City (949, "Bekasi", "IDN", 644300));
        cities.put (950, new City (950, "Padang", "IDN", 534474));
        cities.put (951, new City (951, "Surakarta", "IDN", 518600));
        cities.put (952, new City (952, "Banjarmasin", "IDN", 482931));
        cities.put (953, new City (953, "Pekan Baru", "IDN", 438638));
        cities.put (954, new City (954, "Denpasar", "IDN", 435000));
        cities.put (955, new City (955, "Yogyakarta", "IDN", 418944));
        cities.put (956, new City (956, "Pontianak", "IDN", 409632));
        cities.put (957, new City (957, "Samarinda", "IDN", 399175));
        cities.put (958, new City (958, "Jambi", "IDN", 385201));
        cities.put (959, new City (959, "Depok", "IDN", 365200));
        cities.put (960, new City (960, "Cimahi", "IDN", 344600));
        cities.put (961, new City (961, "Balikpapan", "IDN", 338752));
        cities.put (962, new City (962, "Manado", "IDN", 332288));
        cities.put (963, new City (963, "Mataram", "IDN", 306600));
        cities.put (964, new City (964, "Pekalongan", "IDN", 301504));
        cities.put (965, new City (965, "Tegal", "IDN", 289744));
        cities.put (966, new City (966, "Bogor", "IDN", 285114));
        cities.put (967, new City (967, "Ciputat", "IDN", 270800));
        cities.put (968, new City (968, "Pondokgede", "IDN", 263200));
        cities.put (969, new City (969, "Cirebon", "IDN", 254406));
        cities.put (970, new City (970, "Kediri", "IDN", 253760));
        cities.put (971, new City (971, "Ambon", "IDN", 249312));
        cities.put (972, new City (972, "Jember", "IDN", 218500));
        cities.put (973, new City (973, "Cilacap", "IDN", 206900));
        cities.put (974, new City (974, "Cimanggis", "IDN", 205100));
        cities.put (975, new City (975, "Pematang Siantar", "IDN", 203056));
        cities.put (976, new City (976, "Purwokerto", "IDN", 202500));
        cities.put (977, new City (977, "Ciomas", "IDN", 187400));
        cities.put (978, new City (978, "Tasikmalaya", "IDN", 179800));
        cities.put (979, new City (979, "Madiun", "IDN", 171532));
        cities.put (980, new City (980, "Bengkulu", "IDN", 146439));
        cities.put (981, new City (981, "Karawang", "IDN", 145000));
        cities.put (982, new City (982, "Banda Aceh", "IDN", 143409));
        cities.put (983, new City (983, "Palu", "IDN", 142800));
        cities.put (984, new City (984, "Pasuruan", "IDN", 134019));
        cities.put (985, new City (985, "Kupang", "IDN", 129300));
        cities.put (986, new City (986, "Tebing Tinggi", "IDN", 129300));
        cities.put (987, new City (987, "Percut Sei Tuan", "IDN", 129000));
        cities.put (988, new City (988, "Binjai", "IDN", 127222));
        cities.put (989, new City (989, "Sukabumi", "IDN", 125766));
        cities.put (990, new City (990, "Waru", "IDN", 124300));
        cities.put (991, new City (991, "Pangkal Pinang", "IDN", 124000));
        cities.put (992, new City (992, "Magelang", "IDN", 123800));
        cities.put (993, new City (993, "Blitar", "IDN", 122600));
        cities.put (994, new City (994, "Serang", "IDN", 122400));
        cities.put (995, new City (995, "Probolinggo", "IDN", 120770));
        cities.put (996, new City (996, "Cilegon", "IDN", 117000));
        cities.put (997, new City (997, "Cianjur", "IDN", 114300));
        cities.put (998, new City (998, "Ciparay", "IDN", 111500));
        cities.put (999, new City (999, "Lhokseumawe", "IDN", 109600));
    }

    public void createCities1000() {
        cities.put (1000, new City (1000, "Taman", "IDN", 107000));
        cities.put (1001, new City (1001, "Depok", "IDN", 106800));
        cities.put (1002, new City (1002, "Citeureup", "IDN", 105100));
        cities.put (1003, new City (1003, "Pemalang", "IDN", 103500));
        cities.put (1004, new City (1004, "Klaten", "IDN", 103300));
        cities.put (1005, new City (1005, "Salatiga", "IDN", 103000));
        cities.put (1006, new City (1006, "Cibinong", "IDN", 101300));
        cities.put (1007, new City (1007, "Palangka Raya", "IDN", 99693));
        cities.put (1008, new City (1008, "Mojokerto", "IDN", 96626));
        cities.put (1009, new City (1009, "Purwakarta", "IDN", 95900));
        cities.put (1010, new City (1010, "Garut", "IDN", 95800));
        cities.put (1011, new City (1011, "Kudus", "IDN", 95300));
        cities.put (1012, new City (1012, "Kendari", "IDN", 94800));
        cities.put (1013, new City (1013, "Jaya Pura", "IDN", 94700));
        cities.put (1014, new City (1014, "Gorontalo", "IDN", 94058));
        cities.put (1015, new City (1015, "Majalaya", "IDN", 93200));
        cities.put (1016, new City (1016, "Pondok Aren", "IDN", 92700));
        cities.put (1017, new City (1017, "Jombang", "IDN", 92600));
        cities.put (1018, new City (1018, "Sunggal", "IDN", 92300));
        cities.put (1019, new City (1019, "Batam", "IDN", 91871));
        cities.put (1020, new City (1020, "Padang Sidempuan", "IDN", 91200));
        cities.put (1021, new City (1021, "Sawangan", "IDN", 91100));
        cities.put (1022, new City (1022, "Banyuwangi", "IDN", 89900));
        cities.put (1023, new City (1023, "Tanjung Pinang", "IDN", 89900));
        cities.put (1024, new City (1024, "Mumbai (Bombay)", "IND", 10500000));
        cities.put (1025, new City (1025, "Delhi", "IND", 7206704));
        cities.put (1026, new City (1026, "Calcutta [Kolkata]", "IND", 4399819));
        cities.put (1027, new City (1027, "Chennai (Madras)", "IND", 3841396));
        cities.put (1028, new City (1028, "Hyderabad", "IND", 2964638));
        cities.put (1029, new City (1029, "Ahmedabad", "IND", 2876710));
        cities.put (1030, new City (1030, "Bangalore", "IND", 2660088));
        cities.put (1031, new City (1031, "Kanpur", "IND", 1874409));
        cities.put (1032, new City (1032, "Nagpur", "IND", 1624752));
        cities.put (1033, new City (1033, "Lucknow", "IND", 1619115));
        cities.put (1034, new City (1034, "Pune", "IND", 1566651));
        cities.put (1035, new City (1035, "Surat", "IND", 1498817));
        cities.put (1036, new City (1036, "Jaipur", "IND", 1458483));
        cities.put (1037, new City (1037, "Indore", "IND", 1091674));
        cities.put (1038, new City (1038, "Bhopal", "IND", 1062771));
        cities.put (1039, new City (1039, "Ludhiana", "IND", 1042740));
        cities.put (1040, new City (1040, "Vadodara (Baroda)", "IND", 1031346));
        cities.put (1041, new City (1041, "Kalyan", "IND", 1014557));
        cities.put (1042, new City (1042, "Madurai", "IND", 977856));
        cities.put (1043, new City (1043, "Haora (Howrah)", "IND", 950435));
        cities.put (1044, new City (1044, "Varanasi (Benares)", "IND", 929270));
        cities.put (1045, new City (1045, "Patna", "IND", 917243));
        cities.put (1046, new City (1046, "Srinagar", "IND", 892506));
        cities.put (1047, new City (1047, "Agra", "IND", 891790));
        cities.put (1048, new City (1048, "Coimbatore", "IND", 816321));
        cities.put (1049, new City (1049, "Thane (Thana)", "IND", 803389));
        cities.put (1050, new City (1050, "Allahabad", "IND", 792858));
        cities.put (1051, new City (1051, "Meerut", "IND", 753778));
        cities.put (1052, new City (1052, "Vishakhapatnam", "IND", 752037));
        cities.put (1053, new City (1053, "Jabalpur", "IND", 741927));
        cities.put (1054, new City (1054, "Amritsar", "IND", 708835));
        cities.put (1055, new City (1055, "Faridabad", "IND", 703592));
        cities.put (1056, new City (1056, "Vijayawada", "IND", 701827));
        cities.put (1057, new City (1057, "Gwalior", "IND", 690765));
        cities.put (1058, new City (1058, "Jodhpur", "IND", 666279));
        cities.put (1059, new City (1059, "Nashik (Nasik)", "IND", 656925));
        cities.put (1060, new City (1060, "Hubli-Dharwad", "IND", 648298));
        cities.put (1061, new City (1061, "Solapur (Sholapur)", "IND", 604215));
        cities.put (1062, new City (1062, "Ranchi", "IND", 599306));
        cities.put (1063, new City (1063, "Bareilly", "IND", 587211));
        cities.put (1064, new City (1064, "Guwahati (Gauhati)", "IND", 584342));
        cities.put (1065, new City (1065, "Shambajinagar (Aurangabad)", "IND",
                573272));
        cities.put (1066, new City (1066, "Cochin (Kochi)", "IND", 564589));
        cities.put (1067, new City (1067, "Rajkot", "IND", 559407));
        cities.put (1068, new City (1068, "Kota", "IND", 537371));
        cities.put (1069, new City (1069, "Thiruvananthapuram (Trivandrum",
                "IND", 524006));
        cities.put (1070, new City (1070, "Pimpri-Chinchwad", "IND", 517083));
        cities.put (1071, new City (1071, "Jalandhar (Jullundur)", "IND", 509510));
        cities.put (1072, new City (1072, "Gorakhpur", "IND", 505566));
        cities.put (1073, new City (1073, "Chandigarh", "IND", 504094));
        cities.put (1074, new City (1074, "Mysore", "IND", 480692));
        cities.put (1075, new City (1075, "Aligarh", "IND", 480520));
        cities.put (1076, new City (1076, "Guntur", "IND", 471051));
        cities.put (1077, new City (1077, "Jamshedpur", "IND", 460577));
        cities.put (1078, new City (1078, "Ghaziabad", "IND", 454156));
        cities.put (1079, new City (1079, "Warangal", "IND", 447657));
        cities.put (1080, new City (1080, "Raipur", "IND", 438639));
        cities.put (1081, new City (1081, "Moradabad", "IND", 429214));
        cities.put (1082, new City (1082, "Durgapur", "IND", 425836));
        cities.put (1083, new City (1083, "Amravati", "IND", 421576));
        cities.put (1084, new City (1084, "Calicut (Kozhikode)", "IND", 419831));
        cities.put (1085, new City (1085, "Bikaner", "IND", 416289));
        cities.put (1086, new City (1086, "Bhubaneswar", "IND", 411542));
        cities.put (1087, new City (1087, "Kolhapur", "IND", 406370));
        cities.put (1088, new City (1088, "Kataka (Cuttack)", "IND", 403418));
        cities.put (1089, new City (1089, "Ajmer", "IND", 402700));
        cities.put (1090, new City (1090, "Bhavnagar", "IND", 402338));
        cities.put (1091, new City (1091, "Tiruchirapalli", "IND", 387223));
        cities.put (1092, new City (1092, "Bhilai", "IND", 386159));
        cities.put (1093, new City (1093, "Bhiwandi", "IND", 379070));
        cities.put (1094, new City (1094, "Saharanpur", "IND", 374945));
        cities.put (1095, new City (1095, "Ulhasnagar", "IND", 369077));
        cities.put (1096, new City (1096, "Salem", "IND", 366712));
        cities.put (1097, new City (1097, "Ujjain", "IND", 362266));
        cities.put (1098, new City (1098, "Malegaon", "IND", 342595));
        cities.put (1099, new City (1099, "Jamnagar", "IND", 341637));
        cities.put (1100, new City (1100, "Bokaro Steel City", "IND", 333683));
        cities.put (1101, new City (1101, "Akola", "IND", 328034));
        cities.put (1102, new City (1102, "Belgaum", "IND", 326399));
        cities.put (1103, new City (1103, "Rajahmundry", "IND", 324851));
        cities.put (1104, new City (1104, "Nellore", "IND", 316606));
        cities.put (1105, new City (1105, "Udaipur", "IND", 308571));
        cities.put (1106, new City (1106, "New Bombay", "IND", 307297));
        cities.put (1107, new City (1107, "Bhatpara", "IND", 304952));
        cities.put (1108, new City (1108, "Gulbarga", "IND", 304099));
        cities.put (1109, new City (1109, "New Delhi", "IND", 301297));
        cities.put (1110, new City (1110, "Jhansi", "IND", 300850));
        cities.put (1111, new City (1111, "Gaya", "IND", 291675));
        cities.put (1112, new City (1112, "Kakinada", "IND", 279980));
        cities.put (1113, new City (1113, "Dhule (Dhulia)", "IND", 278317));
        cities.put (1114, new City (1114, "Panihati", "IND", 275990));
        cities.put (1115, new City (1115, "Nanded (Nander)", "IND", 275083));
        cities.put (1116, new City (1116, "Mangalore", "IND", 273304));
        cities.put (1117, new City (1117, "Dehra Dun", "IND", 270159));
        cities.put (1118, new City (1118, "Kamarhati", "IND", 266889));
        cities.put (1119, new City (1119, "Davangere", "IND", 266082));
        cities.put (1120, new City (1120, "Asansol", "IND", 262188));
        cities.put (1121, new City (1121, "Bhagalpur", "IND", 253225));
        cities.put (1122, new City (1122, "Bellary", "IND", 245391));
        cities.put (1123, new City (1123, "Barddhaman (Burdwan)", "IND", 245079));
        cities.put (1124, new City (1124, "Rampur", "IND", 243742));
        cities.put (1125, new City (1125, "Jalgaon", "IND", 242193));
        cities.put (1126, new City (1126, "Muzaffarpur", "IND", 241107));
        cities.put (1127, new City (1127, "Nizamabad", "IND", 241034));
        cities.put (1128, new City (1128, "Muzaffarnagar", "IND", 240609));
        cities.put (1129, new City (1129, "Patiala", "IND", 238368));
        cities.put (1130, new City (1130, "Shahjahanpur", "IND", 237713));
        cities.put (1131, new City (1131, "Kurnool", "IND", 236800));
        cities.put (1132, new City (1132, "Tiruppur (Tirupper)", "IND", 235661));
        cities.put (1133, new City (1133, "Rohtak", "IND", 233400));
        cities.put (1134, new City (1134, "South Dum Dum", "IND", 232811));
        cities.put (1135, new City (1135, "Mathura", "IND", 226691));
        cities.put (1136, new City (1136, "Chandrapur", "IND", 226105));
        cities.put (1137, new City (1137, "Barahanagar (Baranagar)", "IND",
                224821));
        cities.put (1138, new City (1138, "Darbhanga", "IND", 218391));
        cities.put (1139, new City (1139, "Siliguri (Shiliguri)", "IND", 216950));
        cities.put (1140, new City (1140, "Raurkela", "IND", 215489));
        cities.put (1141, new City (1141, "Ambattur", "IND", 215424));
        cities.put (1142, new City (1142, "Panipat", "IND", 215218));
        cities.put (1143, new City (1143, "Firozabad", "IND", 215128));
        cities.put (1144, new City (1144, "Ichalkaranji", "IND", 214950));
        cities.put (1145, new City (1145, "Jammu", "IND", 214737));
        cities.put (1146, new City (1146, "Ramagundam", "IND", 214384));
        cities.put (1147, new City (1147, "Eluru", "IND", 212866));
        cities.put (1148, new City (1148, "Brahmapur", "IND", 210418));
        cities.put (1149, new City (1149, "Alwar", "IND", 205086));
        cities.put (1150, new City (1150, "Pondicherry", "IND", 203065));
        cities.put (1151, new City (1151, "Thanjavur", "IND", 202013));
        cities.put (1152, new City (1152, "Bihar Sharif", "IND", 201323));
        cities.put (1153, new City (1153, "Tuticorin", "IND", 199854));
        cities.put (1154, new City (1154, "Imphal", "IND", 198535));
        cities.put (1155, new City (1155, "Latur", "IND", 197408));
        cities.put (1156, new City (1156, "Sagar", "IND", 195346));
        cities.put (1157, new City (1157, "Farrukhabad-cum-Fatehgarh", "IND",
                194567));
        cities.put (1158, new City (1158, "Sangli", "IND", 193197));
        cities.put (1159, new City (1159, "Parbhani", "IND", 190255));
        cities.put (1160, new City (1160, "Nagar Coil", "IND", 190084));
        cities.put (1161, new City (1161, "Bijapur", "IND", 186939));
        cities.put (1162, new City (1162, "Kukatpalle", "IND", 185378));
        cities.put (1163, new City (1163, "Bally", "IND", 184474));
        cities.put (1164, new City (1164, "Bhilwara", "IND", 183965));
        cities.put (1165, new City (1165, "Ratlam", "IND", 183375));
        cities.put (1166, new City (1166, "Avadi", "IND", 183215));
        cities.put (1167, new City (1167, "Dindigul", "IND", 182477));
        cities.put (1168, new City (1168, "Ahmadnagar", "IND", 181339));
        cities.put (1169, new City (1169, "Bilaspur", "IND", 179833));
        cities.put (1170, new City (1170, "Shimoga", "IND", 179258));
        cities.put (1171, new City (1171, "Kharagpur", "IND", 177989));
        cities.put (1172, new City (1172, "Mira Bhayandar", "IND", 175372));
        cities.put (1173, new City (1173, "Vellore", "IND", 175061));
        cities.put (1174, new City (1174, "Jalna", "IND", 174985));
        cities.put (1175, new City (1175, "Burnpur", "IND", 174933));
        cities.put (1176, new City (1176, "Anantapur", "IND", 174924));
        cities.put (1177, new City (1177, "Allappuzha (Alleppey)", "IND", 174666));
        cities.put (1178, new City (1178, "Tirupati", "IND", 174369));
        cities.put (1179, new City (1179, "Karnal", "IND", 173751));
        cities.put (1180, new City (1180, "Burhanpur", "IND", 172710));
        cities.put (1181, new City (1181, "Hisar (Hissar)", "IND", 172677));
        cities.put (1182, new City (1182, "Tiruvottiyur", "IND", 172562));
        cities.put (1183, new City (1183, "Mirzapur-cum-Vindhyachal", "IND",
                169336));
        cities.put (1184, new City (1184, "Secunderabad", "IND", 167461));
        cities.put (1185, new City (1185, "Nadiad", "IND", 167051));
        cities.put (1186, new City (1186, "Dewas", "IND", 164364));
        cities.put (1187, new City (1187, "Murwara (Katni)", "IND", 163431));
        cities.put (1188, new City (1188, "Ganganagar", "IND", 161482));
        cities.put (1189, new City (1189, "Vizianagaram", "IND", 160359));
        cities.put (1190, new City (1190, "Erode", "IND", 159232));
        cities.put (1191, new City (1191, "Machilipatnam (Masulipatam)", "IND",
                159110));
        cities.put (1192, new City (1192, "Bhatinda (Bathinda)", "IND", 159042));
        cities.put (1193, new City (1193, "Raichur", "IND", 157551));
        cities.put (1194, new City (1194, "Agartala", "IND", 157358));
        cities.put (1195, new City (1195, "Arrah (Ara)", "IND", 157082));
        cities.put (1196, new City (1196, "Satna", "IND", 156630));
        cities.put (1197, new City (1197, "Lalbahadur Nagar", "IND", 155500));
        cities.put (1198, new City (1198, "Aizawl", "IND", 155240));
        cities.put (1199, new City (1199, "Uluberia", "IND", 155172));
        cities.put (1200, new City (1200, "Katihar", "IND", 154367));
        cities.put (1201, new City (1201, "Cuddalore", "IND", 153086));
        cities.put (1202, new City (1202, "Hugli-Chinsurah", "IND", 151806));
        cities.put (1203, new City (1203, "Dhanbad", "IND", 151789));
        cities.put (1204, new City (1204, "Raiganj", "IND", 151045));
        cities.put (1205, new City (1205, "Sambhal", "IND", 150869));
        cities.put (1206, new City (1206, "Durg", "IND", 150645));
        cities.put (1207, new City (1207, "Munger (Monghyr)", "IND", 150112));
        cities.put (1208, new City (1208, "Kanchipuram", "IND", 150100));
        cities.put (1209, new City (1209, "North Dum Dum", "IND", 149965));
        cities.put (1210, new City (1210, "Karimnagar", "IND", 148583));
        cities.put (1211, new City (1211, "Bharatpur", "IND", 148519));
        cities.put (1212, new City (1212, "Sikar", "IND", 148272));
        cities.put (1213, new City (1213, "Hardwar (Haridwar)", "IND", 147305));
        cities.put (1214, new City (1214, "Dabgram", "IND", 147217));
        cities.put (1215, new City (1215, "Morena", "IND", 147124));
        cities.put (1216, new City (1216, "Noida", "IND", 146514));
        cities.put (1217, new City (1217, "Hapur", "IND", 146262));
        cities.put (1218, new City (1218, "Bhusawal", "IND", 145143));
        cities.put (1219, new City (1219, "Khandwa", "IND", 145133));
        cities.put (1220, new City (1220, "Yamuna Nagar", "IND", 144346));
        cities.put (1221, new City (1221, "Sonipat (Sonepat)", "IND", 143922));
        cities.put (1222, new City (1222, "Tenali", "IND", 143726));
        cities.put (1223, new City (1223, "Raurkela Civil Township", "IND",
                140408));
        cities.put (1224, new City (1224, "Kollam (Quilon)", "IND", 139852));
        cities.put (1225, new City (1225, "Kumbakonam", "IND", 139483));
        cities.put (1226, new City (1226, "Ingraj Bazar (English Bazar)", "IND",
                139204));
        cities.put (1227, new City (1227, "Timkur", "IND", 138903));
        cities.put (1228, new City (1228, "Amroha", "IND", 137061));
        cities.put (1229, new City (1229, "Serampore", "IND", 137028));
        cities.put (1230, new City (1230, "Chapra", "IND", 136877));
        cities.put (1231, new City (1231, "Pali", "IND", 136842));
        cities.put (1232, new City (1232, "Maunath Bhanjan", "IND", 136697));
        cities.put (1233, new City (1233, "Adoni", "IND", 136182));
        cities.put (1234, new City (1234, "Jaunpur", "IND", 136062));
        cities.put (1235, new City (1235, "Tirunelveli", "IND", 135825));
        cities.put (1236, new City (1236, "Bahraich", "IND", 135400));
        cities.put (1237, new City (1237, "Gadag Betigeri", "IND", 134051));
        cities.put (1238, new City (1238, "Proddatur", "IND", 133914));
        cities.put (1239, new City (1239, "Chittoor", "IND", 133462));
        cities.put (1240, new City (1240, "Barrackpur", "IND", 133265));
        cities.put (1241, new City (1241, "Bharuch (Broach)", "IND", 133102));
        cities.put (1242, new City (1242, "Naihati", "IND", 132701));
        cities.put (1243, new City (1243, "Shillong", "IND", 131719));
        cities.put (1244, new City (1244, "Sambalpur", "IND", 131138));
        cities.put (1245, new City (1245, "Junagadh", "IND", 130484));
        cities.put (1246, new City (1246, "Rae Bareli", "IND", 129904));
        cities.put (1247, new City (1247, "Rewa", "IND", 128981));
        cities.put (1248, new City (1248, "Gurgaon", "IND", 128608));
        cities.put (1249, new City (1249, "Khammam", "IND", 127992));
        cities.put (1250, new City (1250, "Bulandshahr", "IND", 127201));
        cities.put (1251, new City (1251, "Navsari", "IND", 126089));
        cities.put (1252, new City (1252, "Malkajgiri", "IND", 126066));
        cities.put (1253, new City (1253, "Midnapore (Medinipur)", "IND", 125498));
        cities.put (1254, new City (1254, "Miraj", "IND", 125407));
        cities.put (1255, new City (1255, "Raj Nandgaon", "IND", 125371));
        cities.put (1256, new City (1256, "Alandur", "IND", 125244));
        cities.put (1257, new City (1257, "Puri", "IND", 125199));
        cities.put (1258, new City (1258, "Navadwip", "IND", 125037));
        cities.put (1259, new City (1259, "Sirsa", "IND", 125000));
        cities.put (1260, new City (1260, "Korba", "IND", 124501));
        cities.put (1261, new City (1261, "Faizabad", "IND", 124437));
        cities.put (1262, new City (1262, "Etawah", "IND", 124072));
        cities.put (1263, new City (1263, "Pathankot", "IND", 123930));
        cities.put (1264, new City (1264, "Gandhinagar", "IND", 123359));
        cities.put (1265, new City (1265, "Palghat (Palakkad)", "IND", 123289));
        cities.put (1266, new City (1266, "Veraval", "IND", 123000));
        cities.put (1267, new City (1267, "Hoshiarpur", "IND", 122705));
        cities.put (1268, new City (1268, "Ambala", "IND", 122596));
        cities.put (1269, new City (1269, "Sitapur", "IND", 121842));
        cities.put (1270, new City (1270, "Bhiwani", "IND", 121629));
        cities.put (1271, new City (1271, "Cuddapah", "IND", 121463));
        cities.put (1272, new City (1272, "Bhimavaram", "IND", 121314));
        cities.put (1273, new City (1273, "Krishnanagar", "IND", 121110));
        cities.put (1274, new City (1274, "Chandannagar", "IND", 120378));
        cities.put (1275, new City (1275, "Mandya", "IND", 120265));
        cities.put (1276, new City (1276, "Dibrugarh", "IND", 120127));
        cities.put (1277, new City (1277, "Nandyal", "IND", 119813));
        cities.put (1278, new City (1278, "Balurghat", "IND", 119796));
        cities.put (1279, new City (1279, "Neyveli", "IND", 118080));
        cities.put (1280, new City (1280, "Fatehpur", "IND", 117675));
        cities.put (1281, new City (1281, "Mahbubnagar", "IND", 116833));
        cities.put (1282, new City (1282, "Budaun", "IND", 116695));
        cities.put (1283, new City (1283, "Porbandar", "IND", 116671));
        cities.put (1284, new City (1284, "Silchar", "IND", 115483));
        cities.put (1285, new City (1285, "Berhampore (Baharampur)", "IND",
                115144));
        cities.put (1286, new City (1286, "Purnea (Purnia)", "IND", 114912));
        cities.put (1287, new City (1287, "Bankura", "IND", 114876));
        cities.put (1288, new City (1288, "Rajapalaiyam", "IND", 114202));
        cities.put (1289, new City (1289, "Titagarh", "IND", 114085));
        cities.put (1290, new City (1290, "Halisahar", "IND", 114028));
        cities.put (1291, new City (1291, "Hathras", "IND", 113285));
        cities.put (1292, new City (1292, "Bhir (Bid)", "IND", 112434));
        cities.put (1293, new City (1293, "Pallavaram", "IND", 111866));
        cities.put (1294, new City (1294, "Anand", "IND", 110266));
        cities.put (1295, new City (1295, "Mango", "IND", 110024));
        cities.put (1296, new City (1296, "Santipur", "IND", 109956));
        cities.put (1297, new City (1297, "Bhind", "IND", 109755));
        cities.put (1298, new City (1298, "Gondiya", "IND", 109470));
        cities.put (1299, new City (1299, "Tiruvannamalai", "IND", 109196));
        cities.put (1300, new City (1300, "Yeotmal (Yavatmal)", "IND", 108578));
        cities.put (1301, new City (1301, "Kulti-Barakar", "IND", 108518));
        cities.put (1302, new City (1302, "Moga", "IND", 108304));
        cities.put (1303, new City (1303, "Shivapuri", "IND", 108277));
        cities.put (1304, new City (1304, "Bidar", "IND", 108016));
        cities.put (1305, new City (1305, "Guntakal", "IND", 107592));
        cities.put (1306, new City (1306, "Unnao", "IND", 107425));
        cities.put (1307, new City (1307, "Barasat", "IND", 107365));
        cities.put (1308, new City (1308, "Tambaram", "IND", 107187));
        cities.put (1309, new City (1309, "Abohar", "IND", 107163));
        cities.put (1310, new City (1310, "Pilibhit", "IND", 106605));
        cities.put (1311, new City (1311, "Valparai", "IND", 106523));
        cities.put (1312, new City (1312, "Gonda", "IND", 106078));
        cities.put (1313, new City (1313, "Surendranagar", "IND", 105973));
        cities.put (1314, new City (1314, "Qutubullapur", "IND", 105380));
        cities.put (1315, new City (1315, "Beawar", "IND", 105363));
        cities.put (1316, new City (1316, "Hindupur", "IND", 104651));
        cities.put (1317, new City (1317, "Gandhidham", "IND", 104585));
        cities.put (1318,
                new City (1318, "Haldwani-cum-Kathgodam", "IND", 104195));
        cities.put (1319, new City (1319, "Tellicherry (Thalassery)", "IND",
                103579));
        cities.put (1320, new City (1320, "Wardha", "IND", 102985));
        cities.put (1321, new City (1321, "Rishra", "IND", 102649));
        cities.put (1322, new City (1322, "Bhuj", "IND", 102176));
        cities.put (1323, new City (1323, "Modinagar", "IND", 101660));
        cities.put (1324, new City (1324, "Gudivada", "IND", 101656));
        cities.put (1325, new City (1325, "Basirhat", "IND", 101409));
        cities.put (1326, new City (1326, "Uttarpara-Kotrung", "IND", 100867));
        cities.put (1327, new City (1327, "Ongole", "IND", 100836));
        cities.put (1328, new City (1328, "North Barrackpur", "IND", 100513));
        cities.put (1329, new City (1329, "Guna", "IND", 100490));
        cities.put (1330, new City (1330, "Haldia", "IND", 100347));
        cities.put (1331, new City (1331, "Habra", "IND", 100223));
        cities.put (1332, new City (1332, "Kanchrapara", "IND", 100194));
        cities.put (1333, new City (1333, "Tonk", "IND", 100079));
        cities.put (1334, new City (1334, "Champdani", "IND", 98818));
        cities.put (1335, new City (1335, "Orai", "IND", 98640));
        cities.put (1336, new City (1336, "Pudukkottai", "IND", 98619));
        cities.put (1337, new City (1337, "Sasaram", "IND", 98220));
        cities.put (1338, new City (1338, "Hazaribag", "IND", 97712));
        cities.put (1339, new City (1339, "Palayankottai", "IND", 97662));
        cities.put (1340, new City (1340, "Banda", "IND", 97227));
        cities.put (1341, new City (1341, "Godhra", "IND", 96813));
        cities.put (1342, new City (1342, "Hospet", "IND", 96322));
        cities.put (1343, new City (1343, "Ashoknagar-Kalyangarh", "IND", 96315));
        cities.put (1344, new City (1344, "Achalpur", "IND", 96216));
        cities.put (1345, new City (1345, "Patan", "IND", 96109));
        cities.put (1346, new City (1346, "Mandasor", "IND", 95758));
        cities.put (1347, new City (1347, "Damoh", "IND", 95661));
        cities.put (1348, new City (1348, "Satara", "IND", 95133));
        cities.put (1349, new City (1349, "Meerut Cantonment", "IND", 94876));
        cities.put (1350, new City (1350, "Dehri", "IND", 94526));
        cities.put (1351, new City (1351, "Delhi Cantonment", "IND", 94326));
        cities.put (1352, new City (1352, "Chhindwara", "IND", 93731));
        cities.put (1353, new City (1353, "Bansberia", "IND", 93447));
        cities.put (1354, new City (1354, "Nagaon", "IND", 93350));
        cities.put (1355, new City (1355, "Kanpur Cantonment", "IND", 93109));
        cities.put (1356, new City (1356, "Vidisha", "IND", 92917));
        cities.put (1357, new City (1357, "Bettiah", "IND", 92583));
        cities.put (1358, new City (1358, "Purulia", "IND", 92574));
        cities.put (1359, new City (1359, "Hassan", "IND", 90803));
        cities.put (1360, new City (1360, "Ambala Sadar", "IND", 90712));
        cities.put (1361, new City (1361, "Baidyabati", "IND", 90601));
        cities.put (1362, new City (1362, "Morvi", "IND", 90357));
        cities.put (1363, new City (1363, "Raigarh", "IND", 89166));
        cities.put (1364, new City (1364, "Vejalpur", "IND", 89053));
        cities.put (1365, new City (1365, "Baghdad", "IRQ", 4336000));
        cities.put (1366, new City (1366, "Mosul", "IRQ", 879000));
        cities.put (1367, new City (1367, "Irbil", "IRQ", 485968));
        cities.put (1368, new City (1368, "Kirkuk", "IRQ", 418624));
        cities.put (1369, new City (1369, "Basra", "IRQ", 406296));
        cities.put (1370, new City (1370, "al-Sulaymaniya", "IRQ", 364096));
        cities.put (1371, new City (1371, "al-Najaf", "IRQ", 309010));
        cities.put (1372, new City (1372, "Karbala", "IRQ", 296705));
        cities.put (1373, new City (1373, "al-Hilla", "IRQ", 268834));
        cities.put (1374, new City (1374, "al-Nasiriya", "IRQ", 265937));
        cities.put (1375, new City (1375, "al-Amara", "IRQ", 208797));
        cities.put (1376, new City (1376, "al-Diwaniya", "IRQ", 196519));
        cities.put (1377, new City (1377, "al-Ramadi", "IRQ", 192556));
        cities.put (1378, new City (1378, "al-Kut", "IRQ", 183183));
        cities.put (1379, new City (1379, "Baquba", "IRQ", 114516));
        cities.put (1380, new City (1380, "Teheran", "IRN", 6758845));
        cities.put (1381, new City (1381, "Mashhad", "IRN", 1887405));
        cities.put (1382, new City (1382, "Esfahan", "IRN", 1266072));
        cities.put (1383, new City (1383, "Tabriz", "IRN", 1191043));
        cities.put (1384, new City (1384, "Shiraz", "IRN", 1053025));
        cities.put (1385, new City (1385, "Karaj", "IRN", 940968));
        cities.put (1386, new City (1386, "Ahvaz", "IRN", 804980));
        cities.put (1387, new City (1387, "Qom", "IRN", 777677));
        cities.put (1388, new City (1388, "Kermanshah", "IRN", 692986));
        cities.put (1389, new City (1389, "Urmia", "IRN", 435200));
        cities.put (1390, new City (1390, "Zahedan", "IRN", 419518));
        cities.put (1391, new City (1391, "Rasht", "IRN", 417748));
        cities.put (1392, new City (1392, "Hamadan", "IRN", 401281));
        cities.put (1393, new City (1393, "Kerman", "IRN", 384991));
        cities.put (1394, new City (1394, "Arak", "IRN", 380755));
        cities.put (1395, new City (1395, "Ardebil", "IRN", 340386));
        cities.put (1396, new City (1396, "Yazd", "IRN", 326776));
        cities.put (1397, new City (1397, "Qazvin", "IRN", 291117));
        cities.put (1398, new City (1398, "Zanjan", "IRN", 286295));
        cities.put (1399, new City (1399, "Sanandaj", "IRN", 277808));
        cities.put (1400, new City (1400, "Bandar-e-Abbas", "IRN", 273578));
        cities.put (1401, new City (1401, "Khorramabad", "IRN", 272815));
        cities.put (1402, new City (1402, "Eslamshahr", "IRN", 265450));
        cities.put (1403, new City (1403, "Borujerd", "IRN", 217804));
        cities.put (1404, new City (1404, "Abadan", "IRN", 206073));
        cities.put (1405, new City (1405, "Dezful", "IRN", 202639));
        cities.put (1406, new City (1406, "Kashan", "IRN", 201372));
        cities.put (1407, new City (1407, "Sari", "IRN", 195882));
        cities.put (1408, new City (1408, "Gorgan", "IRN", 188710));
        cities.put (1409, new City (1409, "Najafabad", "IRN", 178498));
        cities.put (1410, new City (1410, "Sabzevar", "IRN", 170738));
        cities.put (1411, new City (1411, "Khomeynishahr", "IRN", 165888));
        cities.put (1412, new City (1412, "Amol", "IRN", 159092));
        cities.put (1413, new City (1413, "Neyshabur", "IRN", 158847));
        cities.put (1414, new City (1414, "Babol", "IRN", 158346));
        cities.put (1415, new City (1415, "Khoy", "IRN", 148944));
        cities.put (1416, new City (1416, "Malayer", "IRN", 144373));
        cities.put (1417, new City (1417, "Bushehr", "IRN", 143641));
        cities.put (1418, new City (1418, "Qaemshahr", "IRN", 143286));
        cities.put (1419, new City (1419, "Qarchak", "IRN", 142690));
        cities.put (1420, new City (1420, "Qods", "IRN", 138278));
        cities.put (1421, new City (1421, "Sirjan", "IRN", 135024));
        cities.put (1422, new City (1422, "Bojnurd", "IRN", 134835));
        cities.put (1423, new City (1423, "Maragheh", "IRN", 132318));
        cities.put (1424, new City (1424, "Birjand", "IRN", 127608));
        cities.put (1425, new City (1425, "Ilam", "IRN", 126346));
        cities.put (1426, new City (1426, "Bukan", "IRN", 120020));
        cities.put (1427, new City (1427, "Masjed-e-Soleyman", "IRN", 116883));
        cities.put (1428, new City (1428, "Saqqez", "IRN", 115394));
        cities.put (1429, new City (1429, "Gonbad-e Qabus", "IRN", 111253));
        cities.put (1430, new City (1430, "Saveh", "IRN", 111245));
        cities.put (1431, new City (1431, "Mahabad", "IRN", 107799));
        cities.put (1432, new City (1432, "Varamin", "IRN", 107233));
        cities.put (1433, new City (1433, "Andimeshk", "IRN", 106923));
        cities.put (1434, new City (1434, "Khorramshahr", "IRN", 105636));
        cities.put (1435, new City (1435, "Shahrud", "IRN", 104765));
        cities.put (1436, new City (1436, "Marv Dasht", "IRN", 103579));
        cities.put (1437, new City (1437, "Zabol", "IRN", 100887));
        cities.put (1438, new City (1438, "Shahr-e Kord", "IRN", 100477));
        cities.put (1439, new City (1439, "Bandar-e Anzali", "IRN", 98500));
        cities.put (1440, new City (1440, "Rafsanjan", "IRN", 98300));
        cities.put (1441, new City (1441, "Marand", "IRN", 96400));
        cities.put (1442, new City (1442, "Torbat-e Heydariyeh", "IRN", 94600));
        cities.put (1443, new City (1443, "Jahrom", "IRN", 94200));
        cities.put (1444, new City (1444, "Semnan", "IRN", 91045));
        cities.put (1445, new City (1445, "Miandoab", "IRN", 90100));
        cities.put (1446, new City (1446, "Qomsheh", "IRN", 89800));
        cities.put (1447, new City (1447, "Dublin", "IRL", 481854));
        cities.put (1448, new City (1448, "Cork", "IRL", 127187));
        cities.put (1449, new City (1449, "ReykjavÂ¡k", "ISL", 109184));
        cities.put (1450, new City (1450, "Jerusalem", "ISR", 633700));
        cities.put (1451, new City (1451, "Tel Aviv-Jaffa", "ISR", 348100));
        cities.put (1452, new City (1452, "Haifa", "ISR", 265700));
        cities.put (1453, new City (1453, "Rishon Le Ziyyon", "ISR", 188200));
        cities.put (1454, new City (1454, "Beerseba", "ISR", 163700));
        cities.put (1455, new City (1455, "Holon", "ISR", 163100));
        cities.put (1456, new City (1456, "Petah Tiqwa", "ISR", 159400));
        cities.put (1457, new City (1457, "Ashdod", "ISR", 155800));
        cities.put (1458, new City (1458, "Netanya", "ISR", 154900));
        cities.put (1459, new City (1459, "Bat Yam", "ISR", 137000));
        cities.put (1460, new City (1460, "Bene Beraq", "ISR", 133900));
        cities.put (1461, new City (1461, "Ramat Gan", "ISR", 126900));
        cities.put (1462, new City (1462, "Ashqelon", "ISR", 92300));
        cities.put (1463, new City (1463, "Rehovot", "ISR", 90300));
        cities.put (1464, new City (1464, "Roma", "ITA", 2643581));
        cities.put (1465, new City (1465, "Milano", "ITA", 1300977));
        cities.put (1466, new City (1466, "Napoli", "ITA", 1002619));
        cities.put (1467, new City (1467, "Torino", "ITA", 903705));
        cities.put (1468, new City (1468, "Palermo", "ITA", 683794));
        cities.put (1469, new City (1469, "Genova", "ITA", 636104));
        cities.put (1470, new City (1470, "Bologna", "ITA", 381161));
        cities.put (1471, new City (1471, "Firenze", "ITA", 376662));
        cities.put (1472, new City (1472, "Catania", "ITA", 337862));
        cities.put (1473, new City (1473, "Bari", "ITA", 331848));
        cities.put (1474, new City (1474, "Venezia", "ITA", 277305));
        cities.put (1475, new City (1475, "Messina", "ITA", 259156));
        cities.put (1476, new City (1476, "Verona", "ITA", 255268));
        cities.put (1477, new City (1477, "Trieste", "ITA", 216459));
        cities.put (1478, new City (1478, "Padova", "ITA", 211391));
        cities.put (1479, new City (1479, "Taranto", "ITA", 208214));
        cities.put (1480, new City (1480, "Brescia", "ITA", 191317));
        cities.put (1481, new City (1481, "Reggio di Calabria", "ITA", 179617));
        cities.put (1482, new City (1482, "Modena", "ITA", 176022));
        cities.put (1483, new City (1483, "Prato", "ITA", 172473));
        cities.put (1484, new City (1484, "Parma", "ITA", 168717));
        cities.put (1485, new City (1485, "Cagliari", "ITA", 165926));
        cities.put (1486, new City (1486, "Livorno", "ITA", 161673));
        cities.put (1487, new City (1487, "Perugia", "ITA", 156673));
        cities.put (1488, new City (1488, "Foggia", "ITA", 154891));
        cities.put (1489,
                new City (1489, "Reggio nellÃ¯ Emilia", "ITA", 143664));
        cities.put (1490, new City (1490, "Salerno", "ITA", 142055));
        cities.put (1491, new City (1491, "Ravenna", "ITA", 138418));
        cities.put (1492, new City (1492, "Ferrara", "ITA", 132127));
        cities.put (1493, new City (1493, "Rimini", "ITA", 131062));
        cities.put (1494, new City (1494, "Syrakusa", "ITA", 126282));
        cities.put (1495, new City (1495, "Sassari", "ITA", 120803));
        cities.put (1496, new City (1496, "Monza", "ITA", 119516));
        cities.put (1497, new City (1497, "Bergamo", "ITA", 117837));
        cities.put (1498, new City (1498, "Pescara", "ITA", 115698));
        cities.put (1499, new City (1499, "Latina", "ITA", 114099));
        cities.put (1500, new City (1500, "Vicenza", "ITA", 109738));
        cities.put (1501, new City (1501, "Terni", "ITA", 107770));
        cities.put (1502, new City (1502, "ForlÂ�", "ITA", 107475));
        cities.put (1503, new City (1503, "Trento", "ITA", 104906));
        cities.put (1504, new City (1504, "Novara", "ITA", 102037));
        cities.put (1505, new City (1505, "Piacenza", "ITA", 98384));
        cities.put (1506, new City (1506, "Ancona", "ITA", 98329));
        cities.put (1507, new City (1507, "Lecce", "ITA", 98208));
        cities.put (1508, new City (1508, "Bolzano", "ITA", 97232));
        cities.put (1509, new City (1509, "Catanzaro", "ITA", 96700));
        cities.put (1510, new City (1510, "La Spezia", "ITA", 95504));
        cities.put (1511, new City (1511, "Udine", "ITA", 94932));
        cities.put (1512, new City (1512, "Torre del Greco", "ITA", 94505));
        cities.put (1513, new City (1513, "Andria", "ITA", 94443));
        cities.put (1514, new City (1514, "Brindisi", "ITA", 93454));
        cities.put (1515, new City (1515, "Giugliano in Campania", "ITA", 93286));
        cities.put (1516, new City (1516, "Pisa", "ITA", 92379));
        cities.put (1517, new City (1517, "Barletta", "ITA", 91904));
        cities.put (1518, new City (1518, "Arezzo", "ITA", 91729));
        cities.put (1519, new City (1519, "Alessandria", "ITA", 90289));
        cities.put (1520, new City (1520, "Cesena", "ITA", 89852));
        cities.put (1521, new City (1521, "Pesaro", "ITA", 88987));
        cities.put (1522, new City (1522, "Dili", "TMP", 47900));
        cities.put (1523, new City (1523, "Wien", "AUT", 1608144));
        cities.put (1524, new City (1524, "Graz", "AUT", 240967));
        cities.put (1525, new City (1525, "Linz", "AUT", 188022));
        cities.put (1526, new City (1526, "Salzburg", "AUT", 144247));
        cities.put (1527, new City (1527, "Innsbruck", "AUT", 111752));
        cities.put (1528, new City (1528, "Klagenfurt", "AUT", 91141));
        cities.put (1529, new City (1529, "Spanish Town", "JAM", 110379));
        cities.put (1530, new City (1530, "Kingston", "JAM", 103962));
        cities.put (1531, new City (1531, "Portmore", "JAM", 99799));
        cities.put (1532, new City (1532, "Tokyo", "JPN", 7980230));
        cities.put (1533, new City (1533, "Jokohama [Yokohama]", "JPN", 3339594));
        cities.put (1534, new City (1534, "Osaka", "JPN", 2595674));
        cities.put (1535, new City (1535, "Nagoya", "JPN", 2154376));
        cities.put (1536, new City (1536, "Sapporo", "JPN", 1790886));
        cities.put (1537, new City (1537, "Kioto", "JPN", 1461974));
        cities.put (1538, new City (1538, "Kobe", "JPN", 1425139));
        cities.put (1539, new City (1539, "Fukuoka", "JPN", 1308379));
        cities.put (1540, new City (1540, "Kawasaki", "JPN", 1217359));
        cities.put (1541, new City (1541, "Hiroshima", "JPN", 1119117));
        cities.put (1542, new City (1542, "Kitakyushu", "JPN", 1016264));
        cities.put (1543, new City (1543, "Sendai", "JPN", 989975));
        cities.put (1544, new City (1544, "Chiba", "JPN", 863930));
        cities.put (1545, new City (1545, "Sakai", "JPN", 797735));
        cities.put (1546, new City (1546, "Kumamoto", "JPN", 656734));
        cities.put (1547, new City (1547, "Okayama", "JPN", 624269));
        cities.put (1548, new City (1548, "Sagamihara", "JPN", 586300));
        cities.put (1549, new City (1549, "Hamamatsu", "JPN", 568796));
        cities.put (1550, new City (1550, "Kagoshima", "JPN", 549977));
        cities.put (1551, new City (1551, "Funabashi", "JPN", 545299));
        cities.put (1552, new City (1552, "Higashiosaka", "JPN", 517785));
        cities.put (1553, new City (1553, "Hachioji", "JPN", 513451));
        cities.put (1554, new City (1554, "Niigata", "JPN", 497464));
        cities.put (1555, new City (1555, "Amagasaki", "JPN", 481434));
        cities.put (1556, new City (1556, "Himeji", "JPN", 475167));
        cities.put (1557, new City (1557, "Shizuoka", "JPN", 473854));
        cities.put (1558, new City (1558, "Urawa", "JPN", 469675));
        cities.put (1559, new City (1559, "Matsuyama", "JPN", 466133));
        cities.put (1560, new City (1560, "Matsudo", "JPN", 461126));
        cities.put (1561, new City (1561, "Kanazawa", "JPN", 455386));
        cities.put (1562, new City (1562, "Kawaguchi", "JPN", 452155));
        cities.put (1563, new City (1563, "Ichikawa", "JPN", 441893));
        cities.put (1564, new City (1564, "Omiya", "JPN", 441649));
        cities.put (1565, new City (1565, "Utsunomiya", "JPN", 440353));
        cities.put (1566, new City (1566, "Oita", "JPN", 433401));
        cities.put (1567, new City (1567, "Nagasaki", "JPN", 432759));
        cities.put (1568, new City (1568, "Yokosuka", "JPN", 430200));
        cities.put (1569, new City (1569, "Kurashiki", "JPN", 425103));
        cities.put (1570, new City (1570, "Gifu", "JPN", 408007));
        cities.put (1571, new City (1571, "Hirakata", "JPN", 403151));
        cities.put (1572, new City (1572, "Nishinomiya", "JPN", 397618));
        cities.put (1573, new City (1573, "Toyonaka", "JPN", 396689));
        cities.put (1574, new City (1574, "Wakayama", "JPN", 391233));
        cities.put (1575, new City (1575, "Fukuyama", "JPN", 376921));
        cities.put (1576, new City (1576, "Fujisawa", "JPN", 372840));
        cities.put (1577, new City (1577, "Asahikawa", "JPN", 364813));
        cities.put (1578, new City (1578, "Machida", "JPN", 364197));
        cities.put (1579, new City (1579, "Nara", "JPN", 362812));
        cities.put (1580, new City (1580, "Takatsuki", "JPN", 361747));
        cities.put (1581, new City (1581, "Iwaki", "JPN", 361737));
        cities.put (1582, new City (1582, "Nagano", "JPN", 361391));
        cities.put (1583, new City (1583, "Toyohashi", "JPN", 360066));
        cities.put (1584, new City (1584, "Toyota", "JPN", 346090));
        cities.put (1585, new City (1585, "Suita", "JPN", 345750));
        cities.put (1586, new City (1586, "Takamatsu", "JPN", 332471));
        cities.put (1587, new City (1587, "Koriyama", "JPN", 330335));
        cities.put (1588, new City (1588, "Okazaki", "JPN", 328711));
        cities.put (1589, new City (1589, "Kawagoe", "JPN", 327211));
        cities.put (1590, new City (1590, "Tokorozawa", "JPN", 325809));
        cities.put (1591, new City (1591, "Toyama", "JPN", 325790));
        cities.put (1592, new City (1592, "Kochi", "JPN", 324710));
        cities.put (1593, new City (1593, "Kashiwa", "JPN", 320296));
        cities.put (1594, new City (1594, "Akita", "JPN", 314440));
        cities.put (1595, new City (1595, "Miyazaki", "JPN", 303784));
        cities.put (1596, new City (1596, "Koshigaya", "JPN", 301446));
        cities.put (1597, new City (1597, "Naha", "JPN", 299851));
        cities.put (1598, new City (1598, "Aomori", "JPN", 295969));
        cities.put (1599, new City (1599, "Hakodate", "JPN", 294788));
        cities.put (1600, new City (1600, "Akashi", "JPN", 292253));
        cities.put (1601, new City (1601, "Yokkaichi", "JPN", 288173));
        cities.put (1602, new City (1602, "Fukushima", "JPN", 287525));
        cities.put (1603, new City (1603, "Morioka", "JPN", 287353));
        cities.put (1604, new City (1604, "Maebashi", "JPN", 284473));
        cities.put (1605, new City (1605, "Kasugai", "JPN", 282348));
        cities.put (1606, new City (1606, "Otsu", "JPN", 282070));
        cities.put (1607, new City (1607, "Ichihara", "JPN", 279280));
        cities.put (1608, new City (1608, "Yao", "JPN", 276421));
        cities.put (1609, new City (1609, "Ichinomiya", "JPN", 270828));
        cities.put (1610, new City (1610, "Tokushima", "JPN", 269649));
        cities.put (1611, new City (1611, "Kakogawa", "JPN", 266281));
        cities.put (1612, new City (1612, "Ibaraki", "JPN", 261020));
        cities.put (1613, new City (1613, "Neyagawa", "JPN", 257315));
        cities.put (1614, new City (1614, "Shimonoseki", "JPN", 257263));
        cities.put (1615, new City (1615, "Yamagata", "JPN", 255617));
        cities.put (1616, new City (1616, "Fukui", "JPN", 254818));
        cities.put (1617, new City (1617, "Hiratsuka", "JPN", 254207));
        cities.put (1618, new City (1618, "Mito", "JPN", 246559));
        cities.put (1619, new City (1619, "Sasebo", "JPN", 244240));
        cities.put (1620, new City (1620, "Hachinohe", "JPN", 242979));
        cities.put (1621, new City (1621, "Takasaki", "JPN", 239124));
        cities.put (1622, new City (1622, "Shimizu", "JPN", 239123));
        cities.put (1623, new City (1623, "Kurume", "JPN", 235611));
        cities.put (1624, new City (1624, "Fuji", "JPN", 231527));
        cities.put (1625, new City (1625, "Soka", "JPN", 222768));
        cities.put (1626, new City (1626, "Fuchu", "JPN", 220576));
        cities.put (1627, new City (1627, "Chigasaki", "JPN", 216015));
        cities.put (1628, new City (1628, "Atsugi", "JPN", 212407));
        cities.put (1629, new City (1629, "Numazu", "JPN", 211382));
        cities.put (1630, new City (1630, "Ageo", "JPN", 209442));
        cities.put (1631, new City (1631, "Yamato", "JPN", 208234));
        cities.put (1632, new City (1632, "Matsumoto", "JPN", 206801));
        cities.put (1633, new City (1633, "Kure", "JPN", 206504));
        cities.put (1634, new City (1634, "Takarazuka", "JPN", 205993));
        cities.put (1635, new City (1635, "Kasukabe", "JPN", 201838));
        cities.put (1636, new City (1636, "Chofu", "JPN", 201585));
        cities.put (1637, new City (1637, "Odawara", "JPN", 200171));
        cities.put (1638, new City (1638, "Kofu", "JPN", 199753));
        cities.put (1639, new City (1639, "Kushiro", "JPN", 197608));
        cities.put (1640, new City (1640, "Kishiwada", "JPN", 197276));
        cities.put (1641, new City (1641, "Hitachi", "JPN", 196622));
        cities.put (1642, new City (1642, "Nagaoka", "JPN", 192407));
        cities.put (1643, new City (1643, "Itami", "JPN", 190886));
        cities.put (1644, new City (1644, "Uji", "JPN", 188735));
        cities.put (1645, new City (1645, "Suzuka", "JPN", 184061));
        cities.put (1646, new City (1646, "Hirosaki", "JPN", 177522));
        cities.put (1647, new City (1647, "Ube", "JPN", 175206));
        cities.put (1648, new City (1648, "Kodaira", "JPN", 174984));
        cities.put (1649, new City (1649, "Takaoka", "JPN", 174380));
        cities.put (1650, new City (1650, "Obihiro", "JPN", 173685));
        cities.put (1651, new City (1651, "Tomakomai", "JPN", 171958));
        cities.put (1652, new City (1652, "Saga", "JPN", 170034));
        cities.put (1653, new City (1653, "Sakura", "JPN", 168072));
        cities.put (1654, new City (1654, "Kamakura", "JPN", 167661));
        cities.put (1655, new City (1655, "Mitaka", "JPN", 167268));
        cities.put (1656, new City (1656, "Izumi", "JPN", 166979));
        cities.put (1657, new City (1657, "Hino", "JPN", 166770));
        cities.put (1658, new City (1658, "Hadano", "JPN", 166512));
        cities.put (1659, new City (1659, "Ashikaga", "JPN", 165243));
        cities.put (1660, new City (1660, "Tsu", "JPN", 164543));
        cities.put (1661, new City (1661, "Sayama", "JPN", 162472));
        cities.put (1662, new City (1662, "Yachiyo", "JPN", 161222));
        cities.put (1663, new City (1663, "Tsukuba", "JPN", 160768));
        cities.put (1664, new City (1664, "Tachikawa", "JPN", 159430));
        cities.put (1665, new City (1665, "Kumagaya", "JPN", 157171));
        cities.put (1666, new City (1666, "Moriguchi", "JPN", 155941));
        cities.put (1667, new City (1667, "Otaru", "JPN", 155784));
        cities.put (1668, new City (1668, "Anjo", "JPN", 153823));
        cities.put (1669, new City (1669, "Narashino", "JPN", 152849));
        cities.put (1670, new City (1670, "Oyama", "JPN", 152820));
        cities.put (1671, new City (1671, "Ogaki", "JPN", 151758));
        cities.put (1672, new City (1672, "Matsue", "JPN", 149821));
        cities.put (1673, new City (1673, "Kawanishi", "JPN", 149794));
        cities.put (1674, new City (1674, "Hitachinaka", "JPN", 148006));
        cities.put (1675, new City (1675, "Niiza", "JPN", 147744));
        cities.put (1676, new City (1676, "Nagareyama", "JPN", 147738));
        cities.put (1677, new City (1677, "Tottori", "JPN", 147523));
        cities.put (1678, new City (1678, "Tama", "JPN", 146712));
        cities.put (1679, new City (1679, "Iruma", "JPN", 145922));
        cities.put (1680, new City (1680, "Ota", "JPN", 145317));
        cities.put (1681, new City (1681, "Omuta", "JPN", 142889));
        cities.put (1682, new City (1682, "Komaki", "JPN", 139827));
        cities.put (1683, new City (1683, "Ome", "JPN", 139216));
        cities.put (1684, new City (1684, "Kadoma", "JPN", 138953));
        cities.put (1685, new City (1685, "Yamaguchi", "JPN", 138210));
        cities.put (1686, new City (1686, "Higashimurayama", "JPN", 136970));
        cities.put (1687, new City (1687, "Yonago", "JPN", 136461));
        cities.put (1688, new City (1688, "Matsubara", "JPN", 135010));
        cities.put (1689, new City (1689, "Musashino", "JPN", 134426));
        cities.put (1690, new City (1690, "Tsuchiura", "JPN", 134072));
        cities.put (1691, new City (1691, "Joetsu", "JPN", 133505));
        cities.put (1692, new City (1692, "Miyakonojo", "JPN", 133183));
        cities.put (1693, new City (1693, "Misato", "JPN", 132957));
        cities.put (1694, new City (1694, "Kakamigahara", "JPN", 131831));
        cities.put (1695, new City (1695, "Daito", "JPN", 130594));
        cities.put (1696, new City (1696, "Seto", "JPN", 130470));
        cities.put (1697, new City (1697, "Kariya", "JPN", 127969));
        cities.put (1698, new City (1698, "Urayasu", "JPN", 127550));
        cities.put (1699, new City (1699, "Beppu", "JPN", 127486));
        cities.put (1700, new City (1700, "Niihama", "JPN", 127207));
        cities.put (1701, new City (1701, "Minoo", "JPN", 127026));
        cities.put (1702, new City (1702, "Fujieda", "JPN", 126897));
        cities.put (1703, new City (1703, "Abiko", "JPN", 126670));
        cities.put (1704, new City (1704, "Nobeoka", "JPN", 125547));
        cities.put (1705, new City (1705, "Tondabayashi", "JPN", 125094));
        cities.put (1706, new City (1706, "Ueda", "JPN", 124217));
        cities.put (1707, new City (1707, "Kashihara", "JPN", 124013));
        cities.put (1708, new City (1708, "Matsusaka", "JPN", 123582));
        cities.put (1709, new City (1709, "Isesaki", "JPN", 123285));
        cities.put (1710, new City (1710, "Zama", "JPN", 122046));
        cities.put (1711, new City (1711, "Kisarazu", "JPN", 121967));
        cities.put (1712, new City (1712, "Noda", "JPN", 121030));
        cities.put (1713, new City (1713, "Ishinomaki", "JPN", 120963));
        cities.put (1714, new City (1714, "Fujinomiya", "JPN", 119714));
        cities.put (1715, new City (1715, "Kawachinagano", "JPN", 119666));
        cities.put (1716, new City (1716, "Imabari", "JPN", 119357));
        cities.put (1717, new City (1717, "Aizuwakamatsu", "JPN", 119287));
        cities.put (1718, new City (1718, "Higashihiroshima", "JPN", 119166));
        cities.put (1719, new City (1719, "Habikino", "JPN", 118968));
        cities.put (1720, new City (1720, "Ebetsu", "JPN", 118805));
        cities.put (1721, new City (1721, "Hofu", "JPN", 118751));
        cities.put (1722, new City (1722, "Kiryu", "JPN", 118326));
        cities.put (1723, new City (1723, "Okinawa", "JPN", 117748));
        cities.put (1724, new City (1724, "Yaizu", "JPN", 117258));
        cities.put (1725, new City (1725, "Toyokawa", "JPN", 115781));
        cities.put (1726, new City (1726, "Ebina", "JPN", 115571));
        cities.put (1727, new City (1727, "Asaka", "JPN", 114815));
        cities.put (1728, new City (1728, "Higashikurume", "JPN", 111666));
        cities.put (1729, new City (1729, "Ikoma", "JPN", 111645));
        cities.put (1730, new City (1730, "Kitami", "JPN", 111295));
        cities.put (1731, new City (1731, "Koganei", "JPN", 110969));
        cities.put (1732, new City (1732, "Iwatsuki", "JPN", 110034));
        cities.put (1733, new City (1733, "Mishima", "JPN", 109699));
        cities.put (1734, new City (1734, "Handa", "JPN", 108600));
        cities.put (1735, new City (1735, "Muroran", "JPN", 108275));
        cities.put (1736, new City (1736, "Komatsu", "JPN", 107937));
        cities.put (1737, new City (1737, "Yatsushiro", "JPN", 107661));
        cities.put (1738, new City (1738, "Iida", "JPN", 107583));
        cities.put (1739, new City (1739, "Tokuyama", "JPN", 107078));
        cities.put (1740, new City (1740, "Kokubunji", "JPN", 106996));
        cities.put (1741, new City (1741, "Akishima", "JPN", 106914));
        cities.put (1742, new City (1742, "Iwakuni", "JPN", 106647));
        cities.put (1743, new City (1743, "Kusatsu", "JPN", 106232));
        cities.put (1744, new City (1744, "Kuwana", "JPN", 106121));
        cities.put (1745, new City (1745, "Sanda", "JPN", 105643));
        cities.put (1746, new City (1746, "Hikone", "JPN", 105508));
        cities.put (1747, new City (1747, "Toda", "JPN", 103969));
        cities.put (1748, new City (1748, "Tajimi", "JPN", 103171));
        cities.put (1749, new City (1749, "Ikeda", "JPN", 102710));
        cities.put (1750, new City (1750, "Fukaya", "JPN", 102156));
        cities.put (1751, new City (1751, "Ise", "JPN", 101732));
        cities.put (1752, new City (1752, "Sakata", "JPN", 101651));
        cities.put (1753, new City (1753, "Kasuga", "JPN", 101344));
        cities.put (1754, new City (1754, "Kamagaya", "JPN", 100821));
        cities.put (1755, new City (1755, "Tsuruoka", "JPN", 100713));
        cities.put (1756, new City (1756, "Hoya", "JPN", 100313));
        cities.put (1757, new City (1757, "Nishio", "JPN", 100032));
        cities.put (1758, new City (1758, "Tokai", "JPN", 99738));
        cities.put (1759, new City (1759, "Inazawa", "JPN", 98746));
        cities.put (1760, new City (1760, "Sakado", "JPN", 98221));
        cities.put (1761, new City (1761, "Isehara", "JPN", 98123));
        cities.put (1762, new City (1762, "Takasago", "JPN", 97632));
        cities.put (1763, new City (1763, "Fujimi", "JPN", 96972));
        cities.put (1764, new City (1764, "Urasoe", "JPN", 96002));
        cities.put (1765, new City (1765, "Yonezawa", "JPN", 95592));
        cities.put (1766, new City (1766, "Konan", "JPN", 95521));
        cities.put (1767, new City (1767, "Yamatokoriyama", "JPN", 95165));
        cities.put (1768, new City (1768, "Maizuru", "JPN", 94784));
        cities.put (1769, new City (1769, "Onomichi", "JPN", 93756));
        cities.put (1770, new City (1770, "Higashimatsuyama", "JPN", 93342));
        cities.put (1771, new City (1771, "Kimitsu", "JPN", 93216));
        cities.put (1772, new City (1772, "Isahaya", "JPN", 93058));
        cities.put (1773, new City (1773, "Kanuma", "JPN", 93053));
        cities.put (1774, new City (1774, "Izumisano", "JPN", 92583));
        cities.put (1775, new City (1775, "Kameoka", "JPN", 92398));
        cities.put (1776, new City (1776, "Mobara", "JPN", 91664));
        cities.put (1777, new City (1777, "Narita", "JPN", 91470));
        cities.put (1778, new City (1778, "Kashiwazaki", "JPN", 91229));
        cities.put (1779, new City (1779, "Tsuyama", "JPN", 91170));
        cities.put (1780, new City (1780, "Sanaa", "YEM", 503600));
        cities.put (1781, new City (1781, "Aden", "YEM", 398300));
        cities.put (1782, new City (1782, "Taizz", "YEM", 317600));
        cities.put (1783, new City (1783, "Hodeida", "YEM", 298500));
        cities.put (1784, new City (1784, "al-Mukalla", "YEM", 122400));
        cities.put (1785, new City (1785, "Ibb", "YEM", 103300));
        cities.put (1786, new City (1786, "Amman", "JOR", 1000000));
        cities.put (1787, new City (1787, "al-Zarqa", "JOR", 389815));
        cities.put (1788, new City (1788, "Irbid", "JOR", 231511));
        cities.put (1789, new City (1789, "al-Rusayfa", "JOR", 137247));
        cities.put (1790, new City (1790, "Wadi al-Sir", "JOR", 89104));
        cities.put (1791, new City (1791, "Flying Fish Cove", "CXR", 700));
        cities.put (1792, new City (1792, "Beograd", "YUG", 1204000));
        cities.put (1793, new City (1793, "Novi Sad", "YUG", 179626));
        cities.put (1794, new City (1794, "Ni?", "YUG", 175391));
        cities.put (1795, new City (1795, "Pri?tina", "YUG", 155496));
        cities.put (1796, new City (1796, "Kragujevac", "YUG", 147305));
        cities.put (1797, new City (1797, "Podgorica", "YUG", 135000));
        cities.put (1798, new City (1798, "Subotica", "YUG", 100386));
        cities.put (1799, new City (1799, "Prizren", "YUG", 92303));
        cities.put (1800, new City (1800, "Phnom Penh", "KHM", 570155));
        cities.put (1801, new City (1801, "Battambang", "KHM", 129800));
        cities.put (1802, new City (1802, "Siem Reap", "KHM", 105100));
        cities.put (1803, new City (1803, "Douala", "CMR", 1448300));
        cities.put (1804, new City (1804, "Yaoundâ€š", "CMR", 1372800));
        cities.put (1805, new City (1805, "Garoua", "CMR", 177000));
        cities.put (1806, new City (1806, "Maroua", "CMR", 143000));
        cities.put (1807, new City (1807, "Bamenda", "CMR", 138000));
        cities.put (1808, new City (1808, "Bafoussam", "CMR", 131000));
        cities.put (1809, new City (1809, "Nkongsamba", "CMR", 112454));
        cities.put (1810, new City (1810, "Montrâ€šal", "CAN", 1016376));
        cities.put (1811, new City (1811, "Calgary", "CAN", 768082));
        cities.put (1812, new City (1812, "Toronto", "CAN", 688275));
        cities.put (1813, new City (1813, "North York", "CAN", 622632));
        cities.put (1814, new City (1814, "Winnipeg", "CAN", 618477));
        cities.put (1815, new City (1815, "Edmonton", "CAN", 616306));
        cities.put (1816, new City (1816, "Mississauga", "CAN", 608072));
        cities.put (1817, new City (1817, "Scarborough", "CAN", 594501));
        cities.put (1818, new City (1818, "Vancouver", "CAN", 514008));
        cities.put (1819, new City (1819, "Etobicoke", "CAN", 348845));
        cities.put (1820, new City (1820, "London", "CAN", 339917));
        cities.put (1821, new City (1821, "Hamilton", "CAN", 335614));
        cities.put (1822, new City (1822, "Ottawa", "CAN", 335277));
        cities.put (1823, new City (1823, "Laval", "CAN", 330393));
        cities.put (1824, new City (1824, "Surrey", "CAN", 304477));
        cities.put (1825, new City (1825, "Brampton", "CAN", 296711));
        cities.put (1826, new City (1826, "Windsor", "CAN", 207588));
        cities.put (1827, new City (1827, "Saskatoon", "CAN", 193647));
        cities.put (1828, new City (1828, "Kitchener", "CAN", 189959));
        cities.put (1829, new City (1829, "Markham", "CAN", 189098));
        cities.put (1830, new City (1830, "Regina", "CAN", 180400));
        cities.put (1831, new City (1831, "Burnaby", "CAN", 179209));
        cities.put (1832, new City (1832, "Quâ€šbec", "CAN", 167264));
        cities.put (1833, new City (1833, "York", "CAN", 154980));
        cities.put (1834, new City (1834, "Richmond", "CAN", 148867));
        cities.put (1835, new City (1835, "Vaughan", "CAN", 147889));
        cities.put (1836, new City (1836, "Burlington", "CAN", 145150));
        cities.put (1837, new City (1837, "Oshawa", "CAN", 140173));
        cities.put (1838, new City (1838, "Oakville", "CAN", 139192));
        cities.put (1839, new City (1839, "Saint Catharines", "CAN", 136216));
        cities.put (1840, new City (1840, "Longueuil", "CAN", 127977));
        cities.put (1841, new City (1841, "Richmond Hill", "CAN", 116428));
        cities.put (1842, new City (1842, "Thunder Bay", "CAN", 115913));
        cities.put (1843, new City (1843, "Nepean", "CAN", 115100));
        cities.put (1844, new City (1844, "Cape Breton", "CAN", 114733));
        cities.put (1845, new City (1845, "East York", "CAN", 114034));
        cities.put (1846, new City (1846, "Halifax", "CAN", 113910));
        cities.put (1847, new City (1847, "Cambridge", "CAN", 109186));
        cities.put (1848, new City (1848, "Gloucester", "CAN", 107314));
        cities.put (1849, new City (1849, "Abbotsford", "CAN", 105403));
        cities.put (1850, new City (1850, "Guelph", "CAN", 103593));
        cities.put (1851, new City (1851, "Saint JohnÃ¯s", "CAN", 101936));
        cities.put (1852, new City (1852, "Coquitlam", "CAN", 101820));
        cities.put (1853, new City (1853, "Saanich", "CAN", 101388));
        cities.put (1854, new City (1854, "Gatineau", "CAN", 100702));
        cities.put (1855, new City (1855, "Delta", "CAN", 95411));
        cities.put (1856, new City (1856, "Sudbury", "CAN", 92686));
        cities.put (1857, new City (1857, "Kelowna", "CAN", 89442));
        cities.put (1858, new City (1858, "Barrie", "CAN", 89269));
        cities.put (1859, new City (1859, "Praia", "CPV", 94800));
        cities.put (1860, new City (1860, "Almaty", "KAZ", 1129400));
        cities.put (1861, new City (1861, "Qaraghandy", "KAZ", 436900));
        cities.put (1862, new City (1862, "Shymkent", "KAZ", 360100));
        cities.put (1863, new City (1863, "Taraz", "KAZ", 330100));
        cities.put (1864, new City (1864, "Astana", "KAZ", 311200));
        cities.put (1865, new City (1865, "â„¢skemen", "KAZ", 311000));
        cities.put (1866, new City (1866, "Pavlodar", "KAZ", 300500));
        cities.put (1867, new City (1867, "Semey", "KAZ", 269600));
        cities.put (1868, new City (1868, "Aqtâ€�be", "KAZ", 253100));
        cities.put (1869, new City (1869, "Qostanay", "KAZ", 221400));
        cities.put (1870, new City (1870, "Petropavl", "KAZ", 203500));
        cities.put (1871, new City (1871, "Oral", "KAZ", 195500));
        cities.put (1872, new City (1872, "Temirtau", "KAZ", 170500));
        cities.put (1873, new City (1873, "Qyzylorda", "KAZ", 157400));
        cities.put (1874, new City (1874, "Aqtau", "KAZ", 143400));
        cities.put (1875, new City (1875, "Atyrau", "KAZ", 142500));
        cities.put (1876, new City (1876, "Ekibastuz", "KAZ", 127200));
        cities.put (1877, new City (1877, "Kâ€�kshetau", "KAZ", 123400));
        cities.put (1878, new City (1878, "Rudnyy", "KAZ", 109500));
        cities.put (1879, new City (1879, "Taldyqorghan", "KAZ", 98000));
        cities.put (1880, new City (1880, "Zhezqazghan", "KAZ", 90000));
        cities.put (1881, new City (1881, "Nairobi", "KEN", 2290000));
        cities.put (1882, new City (1882, "Mombasa", "KEN", 461753));
        cities.put (1883, new City (1883, "Kisumu", "KEN", 192733));
        cities.put (1884, new City (1884, "Nakuru", "KEN", 163927));
        cities.put (1885, new City (1885, "Machakos", "KEN", 116293));
        cities.put (1886, new City (1886, "Eldoret", "KEN", 111882));
        cities.put (1887, new City (1887, "Meru", "KEN", 94947));
        cities.put (1888, new City (1888, "Nyeri", "KEN", 91258));
        cities.put (1889, new City (1889, "Bangui", "CAF", 524000));
        cities.put (1890, new City (1890, "Shanghai", "CHN", 9696300));
        cities.put (1891, new City (1891, "Peking", "CHN", 7472000));
        cities.put (1892, new City (1892, "Chongqing", "CHN", 6351600));
        cities.put (1893, new City (1893, "Tianjin", "CHN", 5286800));
        cities.put (1894, new City (1894, "Wuhan", "CHN", 4344600));
        cities.put (1895, new City (1895, "Harbin", "CHN", 4289800));
        cities.put (1896, new City (1896, "Shenyang", "CHN", 4265200));
        cities.put (1897, new City (1897, "Kanton [Guangzhou]", "CHN", 4256300));
        cities.put (1898, new City (1898, "Chengdu", "CHN", 3361500));
        cities.put (1899, new City (1899, "Nanking [Nanjing]", "CHN", 2870300));
        cities.put (1900, new City (1900, "Changchun", "CHN", 2812000));
        cities.put (1901, new City (1901, "XiÃ¯an", "CHN", 2761400));
        cities.put (1902, new City (1902, "Dalian", "CHN", 2697000));
        cities.put (1903, new City (1903, "Qingdao", "CHN", 2596000));
        cities.put (1904, new City (1904, "Jinan", "CHN", 2278100));
        cities.put (1905, new City (1905, "Hangzhou", "CHN", 2190500));
        cities.put (1906, new City (1906, "Zhengzhou", "CHN", 2107200));
        cities.put (1907, new City (1907, "Shijiazhuang", "CHN", 2041500));
        cities.put (1908, new City (1908, "Taiyuan", "CHN", 1968400));
        cities.put (1909, new City (1909, "Kunming", "CHN", 1829500));
        cities.put (1910, new City (1910, "Changsha", "CHN", 1809800));
        cities.put (1911, new City (1911, "Nanchang", "CHN", 1691600));
        cities.put (1912, new City (1912, "Fuzhou", "CHN", 1593800));
        cities.put (1913, new City (1913, "Lanzhou", "CHN", 1565800));
        cities.put (1914, new City (1914, "Guiyang", "CHN", 1465200));
        cities.put (1915, new City (1915, "Ningbo", "CHN", 1371200));
        cities.put (1916, new City (1916, "Hefei", "CHN", 1369100));
        cities.put (1917, new City (1917, "Urumt?i [Å¡rÂ�mqi]", "CHN",
                1310100));
        cities.put (1918, new City (1918, "Anshan", "CHN", 1200000));
        cities.put (1919, new City (1919, "Fushun", "CHN", 1200000));
        cities.put (1920, new City (1920, "Nanning", "CHN", 1161800));
        cities.put (1921, new City (1921, "Zibo", "CHN", 1140000));
        cities.put (1922, new City (1922, "Qiqihar", "CHN", 1070000));
        cities.put (1923, new City (1923, "Jilin", "CHN", 1040000));
        cities.put (1924, new City (1924, "Tangshan", "CHN", 1040000));
        cities.put (1925, new City (1925, "Baotou", "CHN", 980000));
        cities.put (1926, new City (1926, "Shenzhen", "CHN", 950500));
        cities.put (1927, new City (1927, "Hohhot", "CHN", 916700));
        cities.put (1928, new City (1928, "Handan", "CHN", 840000));
        cities.put (1929, new City (1929, "Wuxi", "CHN", 830000));
        cities.put (1930, new City (1930, "Xuzhou", "CHN", 810000));
        cities.put (1931, new City (1931, "Datong", "CHN", 800000));
        cities.put (1932, new City (1932, "Yichun", "CHN", 800000));
        cities.put (1933, new City (1933, "Benxi", "CHN", 770000));
        cities.put (1934, new City (1934, "Luoyang", "CHN", 760000));
        cities.put (1935, new City (1935, "Suzhou", "CHN", 710000));
        cities.put (1936, new City (1936, "Xining", "CHN", 700200));
        cities.put (1937, new City (1937, "Huainan", "CHN", 700000));
        cities.put (1938, new City (1938, "Jixi", "CHN", 683885));
        cities.put (1939, new City (1939, "Daqing", "CHN", 660000));
        cities.put (1940, new City (1940, "Fuxin", "CHN", 640000));
        cities.put (1941, new City (1941, "Amoy [Xiamen]", "CHN", 627500));
        cities.put (1942, new City (1942, "Liuzhou", "CHN", 610000));
        cities.put (1943, new City (1943, "Shantou", "CHN", 580000));
        cities.put (1944, new City (1944, "Jinzhou", "CHN", 570000));
        cities.put (1945, new City (1945, "Mudanjiang", "CHN", 570000));
        cities.put (1946, new City (1946, "Yinchuan", "CHN", 544500));
        cities.put (1947, new City (1947, "Changzhou", "CHN", 530000));
        cities.put (1948, new City (1948, "Zhangjiakou", "CHN", 530000));
        cities.put (1949, new City (1949, "Dandong", "CHN", 520000));
        cities.put (1950, new City (1950, "Hegang", "CHN", 520000));
        cities.put (1951, new City (1951, "Kaifeng", "CHN", 510000));
        cities.put (1952, new City (1952, "Jiamusi", "CHN", 493409));
        cities.put (1953, new City (1953, "Liaoyang", "CHN", 492559));
        cities.put (1954, new City (1954, "Hengyang", "CHN", 487148));
        cities.put (1955, new City (1955, "Baoding", "CHN", 483155));
        cities.put (1956, new City (1956, "Hunjiang", "CHN", 482043));
        cities.put (1957, new City (1957, "Xinxiang", "CHN", 473762));
        cities.put (1958, new City (1958, "Huangshi", "CHN", 457601));
        cities.put (1959, new City (1959, "Haikou", "CHN", 454300));
        cities.put (1960, new City (1960, "Yantai", "CHN", 452127));
        cities.put (1961, new City (1961, "Bengbu", "CHN", 449245));
        cities.put (1962, new City (1962, "Xiangtan", "CHN", 441968));
        cities.put (1963, new City (1963, "Weifang", "CHN", 428522));
        cities.put (1964, new City (1964, "Wuhu", "CHN", 425740));
        cities.put (1965, new City (1965, "Pingxiang", "CHN", 425579));
        cities.put (1966, new City (1966, "Yingkou", "CHN", 421589));
        cities.put (1967, new City (1967, "Anyang", "CHN", 420332));
        cities.put (1968, new City (1968, "Panzhihua", "CHN", 415466));
        cities.put (1969, new City (1969, "Pingdingshan", "CHN", 410775));
        cities.put (1970, new City (1970, "Xiangfan", "CHN", 410407));
        cities.put (1971, new City (1971, "Zhuzhou", "CHN", 409924));
        cities.put (1972, new City (1972, "Jiaozuo", "CHN", 409100));
        cities.put (1973, new City (1973, "Wenzhou", "CHN", 401871));
        cities.put (1974, new City (1974, "Zhangjiang", "CHN", 400997));
        cities.put (1975, new City (1975, "Zigong", "CHN", 393184));
        cities.put (1976, new City (1976, "Shuangyashan", "CHN", 386081));
        cities.put (1977, new City (1977, "Zaozhuang", "CHN", 380846));
        cities.put (1978, new City (1978, "Yakeshi", "CHN", 377869));
        cities.put (1979, new City (1979, "Yichang", "CHN", 371601));
        cities.put (1980, new City (1980, "Zhenjiang", "CHN", 368316));
        cities.put (1981, new City (1981, "Huaibei", "CHN", 366549));
        cities.put (1982, new City (1982, "Qinhuangdao", "CHN", 364972));
        cities.put (1983, new City (1983, "Guilin", "CHN", 364130));
        cities.put (1984, new City (1984, "Liupanshui", "CHN", 363954));
        cities.put (1985, new City (1985, "Panjin", "CHN", 362773));
        cities.put (1986, new City (1986, "Yangquan", "CHN", 362268));
        cities.put (1987, new City (1987, "Jinxi", "CHN", 357052));
        cities.put (1988, new City (1988, "Liaoyuan", "CHN", 354141));
        cities.put (1989, new City (1989, "Lianyungang", "CHN", 354139));
        cities.put (1990, new City (1990, "Xianyang", "CHN", 352125));
        cities.put (1991, new City (1991, "TaiÃ¯an", "CHN", 350696));
        cities.put (1992, new City (1992, "Chifeng", "CHN", 350077));
        cities.put (1993, new City (1993, "Shaoguan", "CHN", 350043));
        cities.put (1994, new City (1994, "Nantong", "CHN", 343341));
        cities.put (1995, new City (1995, "Leshan", "CHN", 341128));
        cities.put (1996, new City (1996, "Baoji", "CHN", 337765));
        cities.put (1997, new City (1997, "Linyi", "CHN", 324720));
        cities.put (1998, new City (1998, "Tonghua", "CHN", 324600));
        cities.put (1999, new City (1999, "Siping", "CHN", 317223));
    }

    public void createCities2000() {
        cities.put (2000, new City (2000, "Changzhi", "CHN", 317144));
        cities.put (2001, new City (2001, "Tengzhou", "CHN", 315083));
        cities.put (2002, new City (2002, "Chaozhou", "CHN", 313469));
        cities.put (2003, new City (2003, "Yangzhou", "CHN", 312892));
        cities.put (2004, new City (2004, "Dongwan", "CHN", 308669));
        cities.put (2005, new City (2005, "MaÃ¯anshan", "CHN", 305421));
        cities.put (2006, new City (2006, "Foshan", "CHN", 303160));
        cities.put (2007, new City (2007, "Yueyang", "CHN", 302800));
        cities.put (2008, new City (2008, "Xingtai", "CHN", 302789));
        cities.put (2009, new City (2009, "Changde", "CHN", 301276));
        cities.put (2010, new City (2010, "Shihezi", "CHN", 299676));
        cities.put (2011, new City (2011, "Yancheng", "CHN", 296831));
        cities.put (2012, new City (2012, "Jiujiang", "CHN", 291187));
        cities.put (2013, new City (2013, "Dongying", "CHN", 281728));
        cities.put (2014, new City (2014, "Shashi", "CHN", 281352));
        cities.put (2015, new City (2015, "Xintai", "CHN", 281248));
        cities.put (2016, new City (2016, "Jingdezhen", "CHN", 281183));
        cities.put (2017, new City (2017, "Tongchuan", "CHN", 280657));
        cities.put (2018, new City (2018, "Zhongshan", "CHN", 278829));
        cities.put (2019, new City (2019, "Shiyan", "CHN", 273786));
        cities.put (2020, new City (2020, "Tieli", "CHN", 265683));
        cities.put (2021, new City (2021, "Jining", "CHN", 265248));
        cities.put (2022, new City (2022, "Wuhai", "CHN", 264081));
        cities.put (2023, new City (2023, "Mianyang", "CHN", 262947));
        cities.put (2024, new City (2024, "Luzhou", "CHN", 262892));
        cities.put (2025, new City (2025, "Zunyi", "CHN", 261862));
        cities.put (2026, new City (2026, "Shizuishan", "CHN", 257862));
        cities.put (2027, new City (2027, "Neijiang", "CHN", 256012));
        cities.put (2028, new City (2028, "Tongliao", "CHN", 255129));
        cities.put (2029, new City (2029, "Tieling", "CHN", 254842));
        cities.put (2030, new City (2030, "Wafangdian", "CHN", 251733));
        cities.put (2031, new City (2031, "Anqing", "CHN", 250718));
        cities.put (2032, new City (2032, "Shaoyang", "CHN", 247227));
        cities.put (2033, new City (2033, "Laiwu", "CHN", 246833));
        cities.put (2034, new City (2034, "Chengde", "CHN", 246799));
        cities.put (2035, new City (2035, "Tianshui", "CHN", 244974));
        cities.put (2036, new City (2036, "Nanyang", "CHN", 243303));
        cities.put (2037, new City (2037, "Cangzhou", "CHN", 242708));
        cities.put (2038, new City (2038, "Yibin", "CHN", 241019));
        cities.put (2039, new City (2039, "Huaiyin", "CHN", 239675));
        cities.put (2040, new City (2040, "Dunhua", "CHN", 235100));
        cities.put (2041, new City (2041, "Yanji", "CHN", 230892));
        cities.put (2042, new City (2042, "Jiangmen", "CHN", 230587));
        cities.put (2043, new City (2043, "Tongling", "CHN", 228017));
        cities.put (2044, new City (2044, "Suihua", "CHN", 227881));
        cities.put (2045, new City (2045, "Gongziling", "CHN", 226569));
        cities.put (2046, new City (2046, "Xiantao", "CHN", 222884));
        cities.put (2047, new City (2047, "Chaoyang", "CHN", 222394));
        cities.put (2048, new City (2048, "Ganzhou", "CHN", 220129));
        cities.put (2049, new City (2049, "Huzhou", "CHN", 218071));
        cities.put (2050, new City (2050, "Baicheng", "CHN", 217987));
        cities.put (2051, new City (2051, "Shangzi", "CHN", 215373));
        cities.put (2052, new City (2052, "Yangjiang", "CHN", 215196));
        cities.put (2053, new City (2053, "Qitaihe", "CHN", 214957));
        cities.put (2054, new City (2054, "Gejiu", "CHN", 214294));
        cities.put (2055, new City (2055, "Jiangyin", "CHN", 213659));
        cities.put (2056, new City (2056, "Hebi", "CHN", 212976));
        cities.put (2057, new City (2057, "Jiaxing", "CHN", 211526));
        cities.put (2058, new City (2058, "Wuzhou", "CHN", 210452));
        cities.put (2059, new City (2059, "Meihekou", "CHN", 209038));
        cities.put (2060, new City (2060, "Xuchang", "CHN", 208815));
        cities.put (2061, new City (2061, "Liaocheng", "CHN", 207844));
        cities.put (2062, new City (2062, "Haicheng", "CHN", 205560));
        cities.put (2063, new City (2063, "Qianjiang", "CHN", 205504));
        cities.put (2064, new City (2064, "Baiyin", "CHN", 204970));
        cities.put (2065, new City (2065, "BeiÃ¯an", "CHN", 204899));
        cities.put (2066, new City (2066, "Yixing", "CHN", 200824));
        cities.put (2067, new City (2067, "Laizhou", "CHN", 198664));
        cities.put (2068, new City (2068, "Qaramay", "CHN", 197602));
        cities.put (2069, new City (2069, "Acheng", "CHN", 197595));
        cities.put (2070, new City (2070, "Dezhou", "CHN", 195485));
        cities.put (2071, new City (2071, "Nanping", "CHN", 195064));
        cities.put (2072, new City (2072, "Zhaoqing", "CHN", 194784));
        cities.put (2073, new City (2073, "Beipiao", "CHN", 194301));
        cities.put (2074, new City (2074, "Fengcheng", "CHN", 193784));
        cities.put (2075, new City (2075, "Fuyu", "CHN", 192981));
        cities.put (2076, new City (2076, "Xinyang", "CHN", 192509));
        cities.put (2077, new City (2077, "Dongtai", "CHN", 192247));
        cities.put (2078, new City (2078, "Yuci", "CHN", 191356));
        cities.put (2079, new City (2079, "Honghu", "CHN", 190772));
        cities.put (2080, new City (2080, "Ezhou", "CHN", 190123));
        cities.put (2081, new City (2081, "Heze", "CHN", 189293));
        cities.put (2082, new City (2082, "Daxian", "CHN", 188101));
        cities.put (2083, new City (2083, "Linfen", "CHN", 187309));
        cities.put (2084, new City (2084, "Tianmen", "CHN", 186332));
        cities.put (2085, new City (2085, "Yiyang", "CHN", 185818));
        cities.put (2086, new City (2086, "Quanzhou", "CHN", 185154));
        cities.put (2087, new City (2087, "Rizhao", "CHN", 185048));
        cities.put (2088, new City (2088, "Deyang", "CHN", 182488));
        cities.put (2089, new City (2089, "Guangyuan", "CHN", 182241));
        cities.put (2090, new City (2090, "Changshu", "CHN", 181805));
        cities.put (2091, new City (2091, "Zhangzhou", "CHN", 181424));
        cities.put (2092, new City (2092, "Hailar", "CHN", 180650));
        cities.put (2093, new City (2093, "Nanchong", "CHN", 180273));
        cities.put (2094, new City (2094, "Jiutai", "CHN", 180130));
        cities.put (2095, new City (2095, "Zhaodong", "CHN", 179976));
        cities.put (2096, new City (2096, "Shaoxing", "CHN", 179818));
        cities.put (2097, new City (2097, "Fuyang", "CHN", 179572));
        cities.put (2098, new City (2098, "Maoming", "CHN", 178683));
        cities.put (2099, new City (2099, "Qujing", "CHN", 178669));
        cities.put (2100, new City (2100, "Ghulja", "CHN", 177193));
        cities.put (2101, new City (2101, "Jiaohe", "CHN", 176367));
        cities.put (2102, new City (2102, "Puyang", "CHN", 175988));
        cities.put (2103, new City (2103, "Huadian", "CHN", 175873));
        cities.put (2104, new City (2104, "Jiangyou", "CHN", 175753));
        cities.put (2105, new City (2105, "Qashqar", "CHN", 174570));
        cities.put (2106, new City (2106, "Anshun", "CHN", 174142));
        cities.put (2107, new City (2107, "Fuling", "CHN", 173878));
        cities.put (2108, new City (2108, "Xinyu", "CHN", 173524));
        cities.put (2109, new City (2109, "Hanzhong", "CHN", 169930));
        cities.put (2110, new City (2110, "Danyang", "CHN", 169603));
        cities.put (2111, new City (2111, "Chenzhou", "CHN", 169400));
        cities.put (2112, new City (2112, "Xiaogan", "CHN", 166280));
        cities.put (2113, new City (2113, "Shangqiu", "CHN", 164880));
        cities.put (2114, new City (2114, "Zhuhai", "CHN", 164747));
        cities.put (2115, new City (2115, "Qingyuan", "CHN", 164641));
        cities.put (2116, new City (2116, "Aqsu", "CHN", 164092));
        cities.put (2117, new City (2117, "Jining", "CHN", 163552));
        cities.put (2118, new City (2118, "Xiaoshan", "CHN", 162930));
        cities.put (2119, new City (2119, "Zaoyang", "CHN", 162198));
        cities.put (2120, new City (2120, "Xinghua", "CHN", 161910));
        cities.put (2121, new City (2121, "Hami", "CHN", 161315));
        cities.put (2122, new City (2122, "Huizhou", "CHN", 161023));
        cities.put (2123, new City (2123, "Jinmen", "CHN", 160794));
        cities.put (2124, new City (2124, "Sanming", "CHN", 160691));
        cities.put (2125, new City (2125, "Ulanhot", "CHN", 159538));
        cities.put (2126, new City (2126, "Korla", "CHN", 159344));
        cities.put (2127, new City (2127, "Wanxian", "CHN", 156823));
        cities.put (2128, new City (2128, "RuiÃ¯an", "CHN", 156468));
        cities.put (2129, new City (2129, "Zhoushan", "CHN", 156317));
        cities.put (2130, new City (2130, "Liangcheng", "CHN", 156307));
        cities.put (2131, new City (2131, "Jiaozhou", "CHN", 153364));
        cities.put (2132, new City (2132, "Taizhou", "CHN", 152442));
        cities.put (2133, new City (2133, "Suzhou", "CHN", 151862));
        cities.put (2134, new City (2134, "Yichun", "CHN", 151585));
        cities.put (2135, new City (2135, "Taonan", "CHN", 150168));
        cities.put (2136, new City (2136, "Pingdu", "CHN", 150123));
        cities.put (2137, new City (2137, "JiÃ¯an", "CHN", 148583));
        cities.put (2138, new City (2138, "Longkou", "CHN", 148362));
        cities.put (2139, new City (2139, "Langfang", "CHN", 148105));
        cities.put (2140, new City (2140, "Zhoukou", "CHN", 146288));
        cities.put (2141, new City (2141, "Suining", "CHN", 146086));
        cities.put (2142, new City (2142, "Yulin", "CHN", 144467));
        cities.put (2143, new City (2143, "Jinhua", "CHN", 144280));
        cities.put (2144, new City (2144, "LiuÃ¯an", "CHN", 144248));
        cities.put (2145, new City (2145, "Shuangcheng", "CHN", 142659));
        cities.put (2146, new City (2146, "Suizhou", "CHN", 142302));
        cities.put (2147, new City (2147, "Ankang", "CHN", 142170));
        cities.put (2148, new City (2148, "Weinan", "CHN", 140169));
        cities.put (2149, new City (2149, "Longjing", "CHN", 139417));
        cities.put (2150, new City (2150, "DaÃ¯an", "CHN", 138963));
        cities.put (2151, new City (2151, "Lengshuijiang", "CHN", 137994));
        cities.put (2152, new City (2152, "Laiyang", "CHN", 137080));
        cities.put (2153, new City (2153, "Xianning", "CHN", 136811));
        cities.put (2154, new City (2154, "Dali", "CHN", 136554));
        cities.put (2155, new City (2155, "Anda", "CHN", 136446));
        cities.put (2156, new City (2156, "Jincheng", "CHN", 136396));
        cities.put (2157, new City (2157, "Longyan", "CHN", 134481));
        cities.put (2158, new City (2158, "Xichang", "CHN", 134419));
        cities.put (2159, new City (2159, "Wendeng", "CHN", 133910));
        cities.put (2160, new City (2160, "Hailun", "CHN", 133565));
        cities.put (2161, new City (2161, "Binzhou", "CHN", 133555));
        cities.put (2162, new City (2162, "Linhe", "CHN", 133183));
        cities.put (2163, new City (2163, "Wuwei", "CHN", 133101));
        cities.put (2164, new City (2164, "Duyun", "CHN", 132971));
        cities.put (2165, new City (2165, "Mishan", "CHN", 132744));
        cities.put (2166, new City (2166, "Shangrao", "CHN", 132455));
        cities.put (2167, new City (2167, "Changji", "CHN", 132260));
        cities.put (2168, new City (2168, "Meixian", "CHN", 132156));
        cities.put (2169, new City (2169, "Yushu", "CHN", 131861));
        cities.put (2170, new City (2170, "Tiefa", "CHN", 131807));
        cities.put (2171, new City (2171, "HuaiÃ¯an", "CHN", 131149));
        cities.put (2172, new City (2172, "Leiyang", "CHN", 130115));
        cities.put (2173, new City (2173, "Zalantun", "CHN", 130031));
        cities.put (2174, new City (2174, "Weihai", "CHN", 128888));
        cities.put (2175, new City (2175, "Loudi", "CHN", 128418));
        cities.put (2176, new City (2176, "Qingzhou", "CHN", 128258));
        cities.put (2177, new City (2177, "Qidong", "CHN", 126872));
        cities.put (2178, new City (2178, "Huaihua", "CHN", 126785));
        cities.put (2179, new City (2179, "Luohe", "CHN", 126438));
        cities.put (2180, new City (2180, "Chuzhou", "CHN", 125341));
        cities.put (2181, new City (2181, "Kaiyuan", "CHN", 124219));
        cities.put (2182, new City (2182, "Linqing", "CHN", 123958));
        cities.put (2183, new City (2183, "Chaohu", "CHN", 123676));
        cities.put (2184, new City (2184, "Laohekou", "CHN", 123366));
        cities.put (2185, new City (2185, "Dujiangyan", "CHN", 123357));
        cities.put (2186, new City (2186, "Zhumadian", "CHN", 123232));
        cities.put (2187, new City (2187, "Linchuan", "CHN", 121949));
        cities.put (2188, new City (2188, "Jiaonan", "CHN", 121397));
        cities.put (2189, new City (2189, "Sanmenxia", "CHN", 120523));
        cities.put (2190, new City (2190, "Heyuan", "CHN", 120101));
        cities.put (2191, new City (2191, "Manzhouli", "CHN", 120023));
        cities.put (2192, new City (2192, "Lhasa", "CHN", 120000));
        cities.put (2193, new City (2193, "Lianyuan", "CHN", 118858));
        cities.put (2194, new City (2194, "Kuytun", "CHN", 118553));
        cities.put (2195, new City (2195, "Puqi", "CHN", 117264));
        cities.put (2196, new City (2196, "Hongjiang", "CHN", 116188));
        cities.put (2197, new City (2197, "Qinzhou", "CHN", 114586));
        cities.put (2198, new City (2198, "Renqiu", "CHN", 114256));
        cities.put (2199, new City (2199, "Yuyao", "CHN", 114065));
        cities.put (2200, new City (2200, "Guigang", "CHN", 114025));
        cities.put (2201, new City (2201, "Kaili", "CHN", 113958));
        cities.put (2202, new City (2202, "YanÃ¯an", "CHN", 113277));
        cities.put (2203, new City (2203, "Beihai", "CHN", 112673));
        cities.put (2204, new City (2204, "Xuangzhou", "CHN", 112673));
        cities.put (2205, new City (2205, "Quzhou", "CHN", 112373));
        cities.put (2206, new City (2206, "YongÃ¯an", "CHN", 111762));
        cities.put (2207, new City (2207, "Zixing", "CHN", 110048));
        cities.put (2208, new City (2208, "Liyang", "CHN", 109520));
        cities.put (2209, new City (2209, "Yizheng", "CHN", 109268));
        cities.put (2210, new City (2210, "Yumen", "CHN", 109234));
        cities.put (2211, new City (2211, "Liling", "CHN", 108504));
        cities.put (2212, new City (2212, "Yuncheng", "CHN", 108359));
        cities.put (2213, new City (2213, "Shanwei", "CHN", 107847));
        cities.put (2214, new City (2214, "Cixi", "CHN", 107329));
        cities.put (2215, new City (2215, "Yuanjiang", "CHN", 107004));
        cities.put (2216, new City (2216, "Bozhou", "CHN", 106346));
        cities.put (2217, new City (2217, "Jinchang", "CHN", 105287));
        cities.put (2218, new City (2218, "FuÃ¯an", "CHN", 105265));
        cities.put (2219, new City (2219, "Suqian", "CHN", 105021));
        cities.put (2220, new City (2220, "Shishou", "CHN", 104571));
        cities.put (2221, new City (2221, "Hengshui", "CHN", 104269));
        cities.put (2222, new City (2222, "Danjiangkou", "CHN", 103211));
        cities.put (2223, new City (2223, "Fujin", "CHN", 103104));
        cities.put (2224, new City (2224, "Sanya", "CHN", 102820));
        cities.put (2225, new City (2225, "Guangshui", "CHN", 102770));
        cities.put (2226, new City (2226, "Huangshan", "CHN", 102628));
        cities.put (2227, new City (2227, "Xingcheng", "CHN", 102384));
        cities.put (2228, new City (2228, "Zhucheng", "CHN", 102134));
        cities.put (2229, new City (2229, "Kunshan", "CHN", 102052));
        cities.put (2230, new City (2230, "Haining", "CHN", 100478));
        cities.put (2231, new City (2231, "Pingliang", "CHN", 99265));
        cities.put (2232, new City (2232, "Fuqing", "CHN", 99193));
        cities.put (2233, new City (2233, "Xinzhou", "CHN", 98667));
        cities.put (2234, new City (2234, "Jieyang", "CHN", 98531));
        cities.put (2235, new City (2235, "Zhangjiagang", "CHN", 97994));
        cities.put (2236, new City (2236, "Tong Xian", "CHN", 97168));
        cities.put (2237, new City (2237, "YaÃ¯an", "CHN", 95900));
        cities.put (2238, new City (2238, "Jinzhou", "CHN", 95761));
        cities.put (2239, new City (2239, "Emeishan", "CHN", 94000));
        cities.put (2240, new City (2240, "Enshi", "CHN", 93056));
        cities.put (2241, new City (2241, "Bose", "CHN", 93009));
        cities.put (2242, new City (2242, "Yuzhou", "CHN", 92889));
        cities.put (2243, new City (2243, "Kaiyuan", "CHN", 91999));
        cities.put (2244, new City (2244, "Tumen", "CHN", 91471));
        cities.put (2245, new City (2245, "Putian", "CHN", 91030));
        cities.put (2246, new City (2246, "Linhai", "CHN", 90870));
        cities.put (2247, new City (2247, "Xilin Hot", "CHN", 90646));
        cities.put (2248, new City (2248, "Shaowu", "CHN", 90286));
        cities.put (2249, new City (2249, "Junan", "CHN", 90222));
        cities.put (2250, new City (2250, "Huaying", "CHN", 89400));
        cities.put (2251, new City (2251, "Pingyi", "CHN", 89373));
        cities.put (2252, new City (2252, "Huangyan", "CHN", 89288));
        cities.put (2253, new City (2253, "Bishkek", "KGZ", 589400));
        cities.put (2254, new City (2254, "Osh", "KGZ", 222700));
        cities.put (2255, new City (2255, "Bikenibeu", "KIR", 5055));
        cities.put (2256, new City (2256, "Bairiki", "KIR", 2226));
        cities.put (2257, new City (2257, "Santafâ€š de BogotÂ ", "COL",
                6260862));
        cities.put (2258, new City (2258, "Cali", "COL", 2077386));
        cities.put (2259, new City (2259, "MedellÂ¡n", "COL", 1861265));
        cities.put (2260, new City (2260, "Barranquilla", "COL", 1223260));
        cities.put (2261, new City (2261, "Cartagena", "COL", 805757));
        cities.put (2262, new City (2262, "CÂ£cuta", "COL", 606932));
        cities.put (2263, new City (2263, "Bucaramanga", "COL", 515555));
        cities.put (2264, new City (2264, "Ibaguâ€š", "COL", 393664));
        cities.put (2265, new City (2265, "Pereira", "COL", 381725));
        cities.put (2266, new City (2266, "Santa Marta", "COL", 359147));
        cities.put (2267, new City (2267, "Manizales", "COL", 337580));
        cities.put (2268, new City (2268, "Bello", "COL", 333470));
        cities.put (2269, new City (2269, "Pasto", "COL", 332396));
        cities.put (2270, new City (2270, "Neiva", "COL", 300052));
        cities.put (2271, new City (2271, "Soledad", "COL", 295058));
        cities.put (2272, new City (2272, "Armenia", "COL", 288977));
        cities.put (2273, new City (2273, "Villavicencio", "COL", 273140));
        cities.put (2274, new City (2274, "Soacha", "COL", 272058));
        cities.put (2275, new City (2275, "Valledupar", "COL", 263247));
        cities.put (2276, new City (2276, "MonterÂ¡a", "COL", 248245));
        cities.put (2277, new City (2277, "ItagÂ�Â¡", "COL", 228985));
        cities.put (2278, new City (2278, "Palmira", "COL", 226509));
        cities.put (2279, new City (2279, "Buenaventura", "COL", 224336));
        cities.put (2280, new City (2280, "Floridablanca", "COL", 221913));
        cities.put (2281, new City (2281, "Sincelejo", "COL", 220704));
        cities.put (2282, new City (2282, "PopayÂ n", "COL", 200719));
        cities.put (2283, new City (2283, "Barrancabermeja", "COL", 178020));
        cities.put (2284, new City (2284, "Dos Quebradas", "COL", 159363));
        cities.put (2285, new City (2285, "TuluÂ ", "COL", 152488));
        cities.put (2286, new City (2286, "Envigado", "COL", 135848));
        cities.put (2287, new City (2287, "Cartago", "COL", 125884));
        cities.put (2288, new City (2288, "Girardot", "COL", 110963));
        cities.put (2289, new City (2289, "Buga", "COL", 110699));
        cities.put (2290, new City (2290, "Tunja", "COL", 109740));
        cities.put (2291, new City (2291, "Florencia", "COL", 108574));
        cities.put (2292, new City (2292, "Maicao", "COL", 108053));
        cities.put (2293, new City (2293, "Sogamoso", "COL", 107728));
        cities.put (2294, new City (2294, "Giron", "COL", 90688));
        cities.put (2295, new City (2295, "Moroni", "COM", 36000));
        cities.put (2296, new City (2296, "Brazzaville", "COG", 950000));
        cities.put (2297, new City (2297, "Pointe-Noire", "COG", 500000));
        cities.put (2298, new City (2298, "Kinshasa", "COD", 5064000));
        cities.put (2299, new City (2299, "Lubumbashi", "COD", 851381));
        cities.put (2300, new City (2300, "Mbuji-Mayi", "COD", 806475));
        cities.put (2301, new City (2301, "Kolwezi", "COD", 417810));
        cities.put (2302, new City (2302, "Kisangani", "COD", 417517));
        cities.put (2303, new City (2303, "Kananga", "COD", 393030));
        cities.put (2304, new City (2304, "Likasi", "COD", 299118));
        cities.put (2305, new City (2305, "Bukavu", "COD", 201569));
        cities.put (2306, new City (2306, "Kikwit", "COD", 182142));
        cities.put (2307, new City (2307, "Tshikapa", "COD", 180860));
        cities.put (2308, new City (2308, "Matadi", "COD", 172730));
        cities.put (2309, new City (2309, "Mbandaka", "COD", 169841));
        cities.put (2310, new City (2310, "Mwene-Ditu", "COD", 137459));
        cities.put (2311, new City (2311, "Boma", "COD", 135284));
        cities.put (2312, new City (2312, "Uvira", "COD", 115590));
        cities.put (2313, new City (2313, "Butembo", "COD", 109406));
        cities.put (2314, new City (2314, "Goma", "COD", 109094));
        cities.put (2315, new City (2315, "Kalemie", "COD", 101309));
        cities.put (2316, new City (2316, "Bantam", "CCK", 503));
        cities.put (2317, new City (2317, "West Island", "CCK", 167));
        cities.put (2318, new City (2318, "Pyongyang", "PRK", 2484000));
        cities.put (2319, new City (2319, "Hamhung", "PRK", 709730));
        cities.put (2320, new City (2320, "Chongjin", "PRK", 582480));
        cities.put (2321, new City (2321, "Nampo", "PRK", 566200));
        cities.put (2322, new City (2322, "Sinuiju", "PRK", 326011));
        cities.put (2323, new City (2323, "Wonsan", "PRK", 300148));
        cities.put (2324, new City (2324, "Phyongsong", "PRK", 272934));
        cities.put (2325, new City (2325, "Sariwon", "PRK", 254146));
        cities.put (2326, new City (2326, "Haeju", "PRK", 229172));
        cities.put (2327, new City (2327, "Kanggye", "PRK", 223410));
        cities.put (2328, new City (2328, "Kimchaek", "PRK", 179000));
        cities.put (2329, new City (2329, "Hyesan", "PRK", 178020));
        cities.put (2330, new City (2330, "Kaesong", "PRK", 171500));
        cities.put (2331, new City (2331, "Seoul", "KOR", 9981619));
        cities.put (2332, new City (2332, "Pusan", "KOR", 3804522));
        cities.put (2333, new City (2333, "Inchon", "KOR", 2559424));
        cities.put (2334, new City (2334, "Taegu", "KOR", 2548568));
        cities.put (2335, new City (2335, "Taejon", "KOR", 1425835));
        cities.put (2336, new City (2336, "Kwangju", "KOR", 1368341));
        cities.put (2337, new City (2337, "Ulsan", "KOR", 1084891));
        cities.put (2338, new City (2338, "Songnam", "KOR", 869094));
        cities.put (2339, new City (2339, "Puchon", "KOR", 779412));
        cities.put (2340, new City (2340, "Suwon", "KOR", 755550));
        cities.put (2341, new City (2341, "Anyang", "KOR", 591106));
        cities.put (2342, new City (2342, "Chonju", "KOR", 563153));
        cities.put (2343, new City (2343, "Chongju", "KOR", 531376));
        cities.put (2344, new City (2344, "Koyang", "KOR", 518282));
        cities.put (2345, new City (2345, "Ansan", "KOR", 510314));
        cities.put (2346, new City (2346, "Pohang", "KOR", 508899));
        cities.put (2347, new City (2347, "Chang-won", "KOR", 481694));
        cities.put (2348, new City (2348, "Masan", "KOR", 441242));
        cities.put (2349, new City (2349, "Kwangmyong", "KOR", 350914));
        cities.put (2350, new City (2350, "Chonan", "KOR", 330259));
        cities.put (2351, new City (2351, "Chinju", "KOR", 329886));
        cities.put (2352, new City (2352, "Iksan", "KOR", 322685));
        cities.put (2353, new City (2353, "Pyongtaek", "KOR", 312927));
        cities.put (2354, new City (2354, "Kumi", "KOR", 311431));
        cities.put (2355, new City (2355, "Uijongbu", "KOR", 276111));
        cities.put (2356, new City (2356, "Kyongju", "KOR", 272968));
        cities.put (2357, new City (2357, "Kunsan", "KOR", 266569));
        cities.put (2358, new City (2358, "Cheju", "KOR", 258511));
        cities.put (2359, new City (2359, "Kimhae", "KOR", 256370));
        cities.put (2360, new City (2360, "Sunchon", "KOR", 249263));
        cities.put (2361, new City (2361, "Mokpo", "KOR", 247452));
        cities.put (2362, new City (2362, "Yong-in", "KOR", 242643));
        cities.put (2363, new City (2363, "Wonju", "KOR", 237460));
        cities.put (2364, new City (2364, "Kunpo", "KOR", 235233));
        cities.put (2365, new City (2365, "Chunchon", "KOR", 234528));
        cities.put (2366, new City (2366, "Namyangju", "KOR", 229060));
        cities.put (2367, new City (2367, "Kangnung", "KOR", 220403));
        cities.put (2368, new City (2368, "Chungju", "KOR", 205206));
        cities.put (2369, new City (2369, "Andong", "KOR", 188443));
        cities.put (2370, new City (2370, "Yosu", "KOR", 183596));
        cities.put (2371, new City (2371, "Kyongsan", "KOR", 173746));
        cities.put (2372, new City (2372, "Paju", "KOR", 163379));
        cities.put (2373, new City (2373, "Yangsan", "KOR", 163351));
        cities.put (2374, new City (2374, "Ichon", "KOR", 155332));
        cities.put (2375, new City (2375, "Asan", "KOR", 154663));
        cities.put (2376, new City (2376, "Koje", "KOR", 147562));
        cities.put (2377, new City (2377, "Kimchon", "KOR", 147027));
        cities.put (2378, new City (2378, "Nonsan", "KOR", 146619));
        cities.put (2379, new City (2379, "Kuri", "KOR", 142173));
        cities.put (2380, new City (2380, "Chong-up", "KOR", 139111));
        cities.put (2381, new City (2381, "Chechon", "KOR", 137070));
        cities.put (2382, new City (2382, "Sosan", "KOR", 134746));
        cities.put (2383, new City (2383, "Shihung", "KOR", 133443));
        cities.put (2384, new City (2384, "Tong-yong", "KOR", 131717));
        cities.put (2385, new City (2385, "Kongju", "KOR", 131229));
        cities.put (2386, new City (2386, "Yongju", "KOR", 131097));
        cities.put (2387, new City (2387, "Chinhae", "KOR", 125997));
        cities.put (2388, new City (2388, "Sangju", "KOR", 124116));
        cities.put (2389, new City (2389, "Poryong", "KOR", 122604));
        cities.put (2390, new City (2390, "Kwang-yang", "KOR", 122052));
        cities.put (2391, new City (2391, "Miryang", "KOR", 121501));
        cities.put (2392, new City (2392, "Hanam", "KOR", 115812));
        cities.put (2393, new City (2393, "Kimje", "KOR", 115427));
        cities.put (2394, new City (2394, "Yongchon", "KOR", 113511));
        cities.put (2395, new City (2395, "Sachon", "KOR", 113494));
        cities.put (2396, new City (2396, "Uiwang", "KOR", 108788));
        cities.put (2397, new City (2397, "Naju", "KOR", 107831));
        cities.put (2398, new City (2398, "Namwon", "KOR", 103544));
        cities.put (2399, new City (2399, "Tonghae", "KOR", 95472));
        cities.put (2400, new City (2400, "Mun-gyong", "KOR", 92239));
        cities.put (2401, new City (2401, "Athenai", "GRC", 772072));
        cities.put (2402, new City (2402, "Thessaloniki", "GRC", 383967));
        cities.put (2403, new City (2403, "Pireus", "GRC", 182671));
        cities.put (2404, new City (2404, "Patras", "GRC", 153344));
        cities.put (2405, new City (2405, "Peristerion", "GRC", 137288));
        cities.put (2406, new City (2406, "Herakleion", "GRC", 116178));
        cities.put (2407, new City (2407, "Kallithea", "GRC", 114233));
        cities.put (2408, new City (2408, "Larisa", "GRC", 113090));
        cities.put (2409, new City (2409, "Zagreb", "HRV", 706770));
        cities.put (2410, new City (2410, "Split", "HRV", 189388));
        cities.put (2411, new City (2411, "Rijeka", "HRV", 167964));
        cities.put (2412, new City (2412, "Osijek", "HRV", 104761));
        cities.put (2413, new City (2413, "La Habana", "CUB", 2256000));
        cities.put (2414, new City (2414, "Santiago de Cuba", "CUB", 433180));
        cities.put (2415, new City (2415, "CamagÂ�ey", "CUB", 298726));
        cities.put (2416, new City (2416, "HolguÂ¡n", "CUB", 249492));
        cities.put (2417, new City (2417, "Santa Clara", "CUB", 207350));
        cities.put (2418, new City (2418, "GuantÂ namo", "CUB", 205078));
        cities.put (2419, new City (2419, "Pinar del RÂ¡o", "CUB", 142100));
        cities.put (2420, new City (2420, "Bayamo", "CUB", 141000));
        cities.put (2421, new City (2421, "Cienfuegos", "CUB", 132770));
        cities.put (2422, new City (2422, "Victoria de las Tunas", "CUB", 132350));
        cities.put (2423, new City (2423, "Matanzas", "CUB", 123273));
        cities.put (2424, new City (2424, "Manzanillo", "CUB", 109350));
        cities.put (2425, new City (2425, "Sancti-SpÂ¡ritus", "CUB", 100751));
        cities.put (2426, new City (2426, "Ciego de Âµvila", "CUB", 98505));
        cities.put (2427, new City (2427, "al-Salimiya", "KWT", 130215));
        cities.put (2428, new City (2428, "Jalib al-Shuyukh", "KWT", 102178));
        cities.put (2429, new City (2429, "Kuwait", "KWT", 28859));
        cities.put (2430, new City (2430, "Nicosia", "CYP", 195000));
        cities.put (2431, new City (2431, "Limassol", "CYP", 154400));
        cities.put (2432, new City (2432, "Vientiane", "LAO", 531800));
        cities.put (2433, new City (2433, "Savannakhet", "LAO", 96652));
        cities.put (2434, new City (2434, "Riga", "LVA", 764328));
        cities.put (2435, new City (2435, "Daugavpils", "LVA", 114829));
        cities.put (2436, new City (2436, "Liepaja", "LVA", 89439));
        cities.put (2437, new City (2437, "Maseru", "LSO", 297000));
        cities.put (2438, new City (2438, "Beirut", "LBN", 1100000));
        cities.put (2439, new City (2439, "Tripoli", "LBN", 240000));
        cities.put (2440, new City (2440, "Monrovia", "LBR", 850000));
        cities.put (2441, new City (2441, "Tripoli", "LBY", 1682000));
        cities.put (2442, new City (2442, "Bengasi", "LBY", 804000));
        cities.put (2443, new City (2443, "Misrata", "LBY", 121669));
        cities.put (2444, new City (2444, "al-Zawiya", "LBY", 89338));
        cities.put (2445, new City (2445, "Schaan", "LIE", 5346));
        cities.put (2446, new City (2446, "Vaduz", "LIE", 5043));
        cities.put (2447, new City (2447, "Vilnius", "LTU", 577969));
        cities.put (2448, new City (2448, "Kaunas", "LTU", 412639));
        cities.put (2449, new City (2449, "Klaipeda", "LTU", 202451));
        cities.put (2450, new City (2450, "?iauliai", "LTU", 146563));
        cities.put (2451, new City (2451, "Panevezys", "LTU", 133695));
        cities.put (2452, new City (2452,
                "Luxembourg [Luxemburg/Lâ€°tzebuerg]", "LUX", 80700));
        cities.put (2453, new City (2453, "El-AaiÂ£n", "ESH", 169000));
        cities.put (2454, new City (2454, "Macao", "MAC", 437500));
        cities.put (2455, new City (2455, "Antananarivo", "MDG", 675669));
        cities.put (2456, new City (2456, "Toamasina", "MDG", 127441));
        cities.put (2457, new City (2457, "Antsirabâ€š", "MDG", 120239));
        cities.put (2458, new City (2458, "Mahajanga", "MDG", 100807));
        cities.put (2459, new City (2459, "Fianarantsoa", "MDG", 99005));
        cities.put (2460, new City (2460, "Skopje", "MKD", 444299));
        cities.put (2461, new City (2461, "Blantyre", "MWI", 478155));
        cities.put (2462, new City (2462, "Lilongwe", "MWI", 435964));
        cities.put (2463, new City (2463, "Male", "MDV", 71000));
        cities.put (2464, new City (2464, "Kuala Lumpur", "MYS", 1297526));
        cities.put (2465, new City (2465, "Ipoh", "MYS", 382853));
        cities.put (2466, new City (2466, "Johor Baharu", "MYS", 328436));
        cities.put (2467, new City (2467, "Petaling Jaya", "MYS", 254350));
        cities.put (2468, new City (2468, "Kelang", "MYS", 243355));
        cities.put (2469, new City (2469, "Kuala Terengganu", "MYS", 228119));
        cities.put (2470, new City (2470, "Pinang", "MYS", 219603));
        cities.put (2471, new City (2471, "Kota Bharu", "MYS", 219582));
        cities.put (2472, new City (2472, "Kuantan", "MYS", 199484));
        cities.put (2473, new City (2473, "Taiping", "MYS", 183261));
        cities.put (2474, new City (2474, "Seremban", "MYS", 182869));
        cities.put (2475, new City (2475, "Kuching", "MYS", 148059));
        cities.put (2476, new City (2476, "Sibu", "MYS", 126381));
        cities.put (2477, new City (2477, "Sandakan", "MYS", 125841));
        cities.put (2478, new City (2478, "Alor Setar", "MYS", 124412));
        cities.put (2479, new City (2479, "Selayang Baru", "MYS", 124228));
        cities.put (2480, new City (2480, "Sungai Petani", "MYS", 114763));
        cities.put (2481, new City (2481, "Shah Alam", "MYS", 102019));
        cities.put (2482, new City (2482, "Bamako", "MLI", 809552));
        cities.put (2483, new City (2483, "Birkirkara", "MLT", 21445));
        cities.put (2484, new City (2484, "Valletta", "MLT", 7073));
        cities.put (2485, new City (2485, "Casablanca", "MAR", 2940623));
        cities.put (2486, new City (2486, "Rabat", "MAR", 623457));
        cities.put (2487, new City (2487, "Marrakech", "MAR", 621914));
        cities.put (2488, new City (2488, "FÅ s", "MAR", 541162));
        cities.put (2489, new City (2489, "Tanger", "MAR", 521735));
        cities.put (2490, new City (2490, "Salâ€š", "MAR", 504420));
        cities.put (2491, new City (2491, "MeknÅ s", "MAR", 460000));
        cities.put (2492, new City (2492, "Oujda", "MAR", 365382));
        cities.put (2493, new City (2493, "Kâ€šnitra", "MAR", 292600));
        cities.put (2494, new City (2494, "Tâ€štouan", "MAR", 277516));
        cities.put (2495, new City (2495, "Safi", "MAR", 262300));
        cities.put (2496, new City (2496, "Agadir", "MAR", 155244));
        cities.put (2497, new City (2497, "Mohammedia", "MAR", 154706));
        cities.put (2498, new City (2498, "Khouribga", "MAR", 152090));
        cities.put (2499, new City (2499, "Beni-Mellal", "MAR", 140212));
    }

    public void createCities2500() {
        cities.put (2500, new City (2500, "Tâ€šmara", "MAR", 126303));
        cities.put (2501, new City (2501, "El Jadida", "MAR", 119083));
        cities.put (2502, new City (2502, "Nador", "MAR", 112450));
        cities.put (2503, new City (2503, "Ksar el Kebir", "MAR", 107065));
        cities.put (2504, new City (2504, "Settat", "MAR", 96200));
        cities.put (2505, new City (2505, "Taza", "MAR", 92700));
        cities.put (2506, new City (2506, "El Araich", "MAR", 90400));
        cities.put (2507, new City (2507, "Dalap-Uliga-Darrit", "MHL", 28000));
        cities.put (2508, new City (2508, "Fort-de-France", "MTQ", 94050));
        cities.put (2509, new City (2509, "Nouakchott", "MRT", 667300));
        cities.put (2510, new City (2510, "NouÆ’dhibou", "MRT", 97600));
        cities.put (2511, new City (2511, "Port-Louis", "MUS", 138200));
        cities.put (2512, new City (2512, "Beau Bassin-Rose Hill", "MUS", 100616));
        cities.put (2513, new City (2513, "Vacoas-Phoenix", "MUS", 98464));
        cities.put (2514, new City (2514, "Mamoutzou", "MYT", 12000));
        cities.put (2515, new City (2515, "Ciudad de Mâ€šxico", "MEX",
                8591309));
        cities.put (2516, new City (2516, "Guadalajara", "MEX", 1647720));
        cities.put (2517, new City (2517, "Ecatepec de Morelos", "MEX", 1620303));
        cities.put (2518, new City (2518, "Puebla", "MEX", 1346176));
        cities.put (2519, new City (2519, "NezahualcÂ¢yotl", "MEX", 1224924));
        cities.put (2520, new City (2520, "JuÂ rez", "MEX", 1217818));
        cities.put (2521, new City (2521, "Tijuana", "MEX", 1212232));
        cities.put (2522, new City (2522, "LeÂ¢n", "MEX", 1133576));
        cities.put (2523, new City (2523, "Monterrey", "MEX", 1108499));
        cities.put (2524, new City (2524, "Zapopan", "MEX", 1002239));
        cities.put (2525,
                new City (2525, "Naucalpan de JuÂ rez", "MEX", 857511));
        cities.put (2526, new City (2526, "Mexicali", "MEX", 764902));
        cities.put (2527, new City (2527, "CuliacÂ n", "MEX", 744859));
        cities.put (2528, new City (2528, "Acapulco de JuÂ rez", "MEX", 721011));
        cities.put (2529, new City (2529, "Tlalnepantla de Baz", "MEX", 720755));
        cities.put (2530, new City (2530, "Mâ€šrida", "MEX", 703324));
        cities.put (2531, new City (2531, "Chihuahua", "MEX", 670208));
        cities.put (2532, new City (2532, "San Luis PotosÂ¡", "MEX", 669353));
        cities.put (2533, new City (2533, "Guadalupe", "MEX", 668780));
        cities.put (2534, new City (2534, "Toluca", "MEX", 665617));
        cities.put (2535, new City (2535, "Aguascalientes", "MEX", 643360));
        cities.put (2536, new City (2536, "Querâ€štaro", "MEX", 639839));
        cities.put (2537, new City (2537, "Morelia", "MEX", 619958));
        cities.put (2538, new City (2538, "Hermosillo", "MEX", 608697));
        cities.put (2539, new City (2539, "Saltillo", "MEX", 577352));
        cities.put (2540, new City (2540, "TorreÂ¢n", "MEX", 529093));
        cities.put (2541, new City (2541, "Centro (Villahermosa)", "MEX", 519873));
        cities.put (2542, new City (2542, "San NicolÂ s de los Garza", "MEX",
                495540));
        cities.put (2543, new City (2543, "Durango", "MEX", 490524));
        cities.put (2544, new City (2544, "ChimalhuacÂ n", "MEX", 490245));
        cities.put (2545, new City (2545, "Tlaquepaque", "MEX", 475472));
        cities.put (2546, new City (2546, "AtizapÂ n de Zaragoza", "MEX",
                467262));
        cities.put (2547, new City (2547, "Veracruz", "MEX", 457119));
        cities.put (2548, new City (2548, "CuautitlÂ n Izcalli", "MEX", 452976));
        cities.put (2549, new City (2549, "Irapuato", "MEX", 440039));
        cities.put (2550,
                new City (2550, "Tuxtla Gutiâ€šrrez", "MEX", 433544));
        cities.put (2551, new City (2551, "TultitlÂ n", "MEX", 432411));
        cities.put (2552, new City (2552, "Reynosa", "MEX", 419776));
        cities.put (2553, new City (2553, "Benito JuÂ rez", "MEX", 419276));
        cities.put (2554, new City (2554, "Matamoros", "MEX", 416428));
        cities.put (2555, new City (2555, "Xalapa", "MEX", 390058));
        cities.put (2556, new City (2556, "Celaya", "MEX", 382140));
        cities.put (2557, new City (2557, "MazatlÂ n", "MEX", 380265));
        cities.put (2558, new City (2558, "Ensenada", "MEX", 369573));
        cities.put (2559, new City (2559, "Ahome", "MEX", 358663));
        cities.put (2560, new City (2560, "Cajeme", "MEX", 355679));
        cities.put (2561, new City (2561, "Cuernavaca", "MEX", 337966));
        cities.put (2562, new City (2562, "TonalÂ ", "MEX", 336109));
        cities.put (2563, new City (2563, "Valle de Chalco Solidaridad", "MEX",
                323113));
        cities.put (2564, new City (2564, "Nuevo Laredo", "MEX", 310277));
        cities.put (2565, new City (2565, "Tepic", "MEX", 305025));
        cities.put (2566, new City (2566, "Tampico", "MEX", 294789));
        cities.put (2567, new City (2567, "Ixtapaluca", "MEX", 293160));
        cities.put (2568, new City (2568, "Apodaca", "MEX", 282941));
        cities.put (2569, new City (2569, "Guasave", "MEX", 277201));
        cities.put (2570, new City (2570, "GÂ¢mez Palacio", "MEX", 272806));
        cities.put (2571, new City (2571, "Tapachula", "MEX", 271141));
        cities.put (2572, new City (2572, "NicolÂ s Romero", "MEX", 269393));
        cities.put (2573, new City (2573, "Coatzacoalcos", "MEX", 267037));
        cities.put (2574, new City (2574, "Uruapan", "MEX", 265211));
        cities.put (2575, new City (2575, "Victoria", "MEX", 262686));
        cities.put (2576, new City (2576, "Oaxaca de JuÂ rez", "MEX", 256848));
        cities.put (2577, new City (2577, "Coacalco de BerriozÂ bal", "MEX",
                252270));
        cities.put (2578, new City (2578, "Pachuca de Soto", "MEX", 244688));
        cities.put (2579, new City (2579, "General Escobedo", "MEX", 232961));
        cities.put (2580, new City (2580, "Salamanca", "MEX", 226864));
        cities.put (2581, new City (2581, "Santa Catarina", "MEX", 226573));
        cities.put (2582, new City (2582, "TehuacÂ n", "MEX", 225943));
        cities.put (2583, new City (2583, "Chalco", "MEX", 222201));
        cities.put (2584, new City (2584, "CÂ rdenas", "MEX", 216903));
        cities.put (2585, new City (2585, "Campeche", "MEX", 216735));
        cities.put (2586, new City (2586, "La Paz", "MEX", 213045));
        cities.put (2587, new City (2587, "OthÂ¢n P. Blanco (Chetumal)", "MEX",
                208014));
        cities.put (2588, new City (2588, "Texcoco", "MEX", 203681));
        cities.put (2589, new City (2589, "La Paz", "MEX", 196708));
        cities.put (2590, new City (2590, "Metepec", "MEX", 194265));
        cities.put (2591, new City (2591, "Monclova", "MEX", 193657));
        cities.put (2592, new City (2592, "Huixquilucan", "MEX", 193156));
        cities.put (2593, new City (2593, "Chilpancingo de los Bravo", "MEX",
                192509));
        cities.put (2594, new City (2594, "Puerto Vallarta", "MEX", 183741));
        cities.put (2595, new City (2595, "Fresnillo", "MEX", 182744));
        cities.put (2596, new City (2596, "Ciudad Madero", "MEX", 182012));
        cities.put (2597, new City (2597, "Soledad de Graciano SÂ nchez",
                "MEX", 179956));
        cities.put (2598, new City (2598, "San Juan del RÂ¡o", "MEX", 179300));
        cities.put (2599, new City (2599, "San Felipe del Progreso", "MEX",
                177330));
        cities.put (2600, new City (2600, "CÂ¢rdoba", "MEX", 176952));
        cities.put (2601, new City (2601, "TecÂ mac", "MEX", 172410));
        cities.put (2602, new City (2602, "Ocosingo", "MEX", 171495));
        cities.put (2603, new City (2603, "Carmen", "MEX", 171367));
        cities.put (2604, new City (2604, "LÂ zaro CÂ rdenas", "MEX", 170878));
        cities.put (2605, new City (2605, "Jiutepec", "MEX", 170428));
        cities.put (2606, new City (2606, "Papantla", "MEX", 170123));
        cities.put (2607, new City (2607, "Comalcalco", "MEX", 164640));
        cities.put (2608, new City (2608, "Zamora", "MEX", 161191));
        cities.put (2609, new City (2609, "Nogales", "MEX", 159103));
        cities.put (2610, new City (2610, "Huimanguillo", "MEX", 158335));
        cities.put (2611, new City (2611, "Cuautla", "MEX", 153132));
        cities.put (2612, new City (2612, "MinatitlÂ n", "MEX", 152983));
        cities.put (2613, new City (2613, "Poza Rica de Hidalgo", "MEX", 152678));
        cities.put (2614, new City (2614, "Ciudad Valles", "MEX", 146411));
        cities.put (2615, new City (2615, "Navolato", "MEX", 145396));
        cities.put (2616, new City (2616, "San Luis RÂ¡o Colorado", "MEX",
                145276));
        cities.put (2617, new City (2617, "Pâ€šnjamo", "MEX", 143927));
        cities.put (2618, new City (2618, "San Andrâ€šs Tuxtla", "MEX",
                142251));
        cities.put (2619, new City (2619, "Guanajuato", "MEX", 141215));
        cities.put (2620, new City (2620, "Navojoa", "MEX", 140495));
        cities.put (2621, new City (2621, "ZitÂ cuaro", "MEX", 137970));
        cities.put (2622, new City (2622, "Boca del RÂ¡o", "MEX", 135721));
        cities.put (2623, new City (2623, "Allende", "MEX", 134645));
        cities.put (2624, new City (2624, "Silao", "MEX", 134037));
        cities.put (2625, new City (2625, "Macuspana", "MEX", 133795));
        cities.put (2626, new City (2626, "San Juan Bautista Tuxtepec", "MEX",
                133675));
        cities.put (2627, new City (2627, "San CristÂ¢bal de las Casas", "MEX",
                132317));
        cities.put (2628, new City (2628, "Valle de Santiago", "MEX", 130557));
        cities.put (2629, new City (2629, "Guaymas", "MEX", 130108));
        cities.put (2630, new City (2630, "Colima", "MEX", 129454));
        cities.put (2631, new City (2631, "Dolores Hidalgo", "MEX", 128675));
        cities.put (2632, new City (2632, "Lagos de Moreno", "MEX", 127949));
        cities.put (2633, new City (2633, "Piedras Negras", "MEX", 127898));
        cities.put (2634, new City (2634, "Altamira", "MEX", 127490));
        cities.put (2635, new City (2635, "TÂ£xpam", "MEX", 126475));
        cities.put (2636, new City (2636, "San Pedro Garza GarcÂ¡a", "MEX",
                126147));
        cities.put (2637, new City (2637, "Cuauhtâ€šmoc", "MEX", 124279));
        cities.put (2638, new City (2638, "Manzanillo", "MEX", 124014));
        cities.put (2639, new City (2639, "Iguala de la Independencia", "MEX",
                123883));
        cities.put (2640, new City (2640, "Zacatecas", "MEX", 123700));
        cities.put (2641, new City (2641, "Tlajomulco de ZÂ£Â¤iga", "MEX",
                123220));
        cities.put (2642, new City (2642, "Tulancingo de Bravo", "MEX", 121946));
        cities.put (2643, new City (2643, "Zinacantepec", "MEX", 121715));
        cities.put (2644, new City (2644, "San MartÂ¡n Texmelucan", "MEX",
                121093));
        cities.put (2645, new City (2645, "TepatitlÂ n de Morelos", "MEX",
                118948));
        cities.put (2646, new City (2646, "MartÂ¡nez de la Torre", "MEX",
                118815));
        cities.put (2647, new City (2647, "Orizaba", "MEX", 118488));
        cities.put (2648, new City (2648, "ApatzingÂ n", "MEX", 117849));
        cities.put (2649, new City (2649, "Atlixco", "MEX", 117019));
        cities.put (2650, new City (2650, "Delicias", "MEX", 116132));
        cities.put (2651, new City (2651, "Ixtlahuaca", "MEX", 115548));
        cities.put (2652, new City (2652, "El Mante", "MEX", 112453));
        cities.put (2653, new City (2653, "Lerdo", "MEX", 112272));
        cities.put (2654, new City (2654, "Almoloya de JuÂ rez", "MEX", 110550));
        cities.put (2655, new City (2655, "AcÂ mbaro", "MEX", 110487));
        cities.put (2656, new City (2656, "AcuÂ¤a", "MEX", 110388));
        cities.put (2657, new City (2657, "Guadalupe", "MEX", 108881));
        cities.put (2658, new City (2658, "Huejutla de Reyes", "MEX", 108017));
        cities.put (2659, new City (2659, "Hidalgo", "MEX", 106198));
        cities.put (2660, new City (2660, "Los Cabos", "MEX", 105199));
        cities.put (2661, new City (2661, "ComitÂ n de DomÂ¡nguez", "MEX",
                104986));
        cities.put (2662, new City (2662, "CunduacÂ n", "MEX", 104164));
        cities.put (2663, new City (2663, "RÂ¡o Bravo", "MEX", 103901));
        cities.put (2664, new City (2664, "Temapache", "MEX", 102824));
        cities.put (2665, new City (2665, "Chilapa de Alvarez", "MEX", 102716));
        cities.put (2666, new City (2666, "Hidalgo del Parral", "MEX", 100881));
        cities.put (2667, new City (2667, "San Francisco del RincÂ¢n", "MEX",
                100149));
        cities.put (2668, new City (2668, "Taxco de AlarcÂ¢n", "MEX", 99907));
        cities.put (2669, new City (2669, "Zumpango", "MEX", 99781));
        cities.put (2670, new City (2670, "San Pedro Cholula", "MEX", 99734));
        cities.put (2671, new City (2671, "Lerma", "MEX", 99714));
        cities.put (2672, new City (2672, "TecomÂ n", "MEX", 99296));
        cities.put (2673, new City (2673, "Las Margaritas", "MEX", 97389));
        cities.put (2674, new City (2674, "Cosoleacaque", "MEX", 97199));
        cities.put (2675, new City (2675, "San Luis de la Paz", "MEX", 96763));
        cities.put (2676, new City (2676, "Josâ€š Azueta", "MEX", 95448));
        cities.put (2677, new City (2677, "Santiago Ixcuintla", "MEX", 95311));
        cities.put (2678, new City (2678, "San Felipe", "MEX", 95305));
        cities.put (2679, new City (2679, "Tejupilco", "MEX", 94934));
        cities.put (2680, new City (2680, "Tantoyuca", "MEX", 94709));
        cities.put (2681, new City (2681, "Salvatierra", "MEX", 94322));
        cities.put (2682, new City (2682, "Tultepec", "MEX", 93364));
        cities.put (2683, new City (2683, "Temixco", "MEX", 92686));
        cities.put (2684, new City (2684, "Matamoros", "MEX", 91858));
        cities.put (2685, new City (2685, "PÂ nuco", "MEX", 90551));
        cities.put (2686, new City (2686, "El Fuerte", "MEX", 89556));
        cities.put (2687, new City (2687, "Tierra Blanca", "MEX", 89143));
        cities.put (2688, new City (2688, "Weno", "FSM", 22000));
        cities.put (2689, new City (2689, "Palikir", "FSM", 8600));
        cities.put (2690, new City (2690, "Chisinau", "MDA", 719900));
        cities.put (2691, new City (2691, "Tiraspol", "MDA", 194300));
        cities.put (2692, new City (2692, "Balti", "MDA", 153400));
        cities.put (2693, new City (2693, "Bender (TÅ’ghina)", "MDA", 125700));
        cities.put (2694, new City (2694, "Monte-Carlo", "MCO", 13154));
        cities.put (2695, new City (2695, "Monaco-Ville", "MCO", 1234));
        cities.put (2696, new City (2696, "Ulan Bator", "MNG", 773700));
        cities.put (2697, new City (2697, "Plymouth", "MSR", 2000));
        cities.put (2698, new City (2698, "Maputo", "MOZ", 1018938));
        cities.put (2699, new City (2699, "Matola", "MOZ", 424662));
        cities.put (2700, new City (2700, "Beira", "MOZ", 397368));
        cities.put (2701, new City (2701, "Nampula", "MOZ", 303346));
        cities.put (2702, new City (2702, "Chimoio", "MOZ", 171056));
        cities.put (2703, new City (2703, "Naâ€¡ala-Porto", "MOZ", 158248));
        cities.put (2704, new City (2704, "Quelimane", "MOZ", 150116));
        cities.put (2705, new City (2705, "Mocuba", "MOZ", 124700));
        cities.put (2706, new City (2706, "Tete", "MOZ", 101984));
        cities.put (2707, new City (2707, "Xai-Xai", "MOZ", 99442));
        cities.put (2708, new City (2708, "Gurue", "MOZ", 99300));
        cities.put (2709, new City (2709, "Maxixe", "MOZ", 93985));
        cities.put (2710, new City (2710, "Rangoon (Yangon)", "MMR", 3361700));
        cities.put (2711, new City (2711, "Mandalay", "MMR", 885300));
        cities.put (2712, new City (2712, "Moulmein (Mawlamyine)", "MMR", 307900));
        cities.put (2713, new City (2713, "Pegu (Bago)", "MMR", 190900));
        cities.put (2714, new City (2714, "Bassein (Pathein)", "MMR", 183900));
        cities.put (2715, new City (2715, "Monywa", "MMR", 138600));
        cities.put (2716, new City (2716, "Sittwe (Akyab)", "MMR", 137600));
        cities.put (2717, new City (2717, "Taunggyi (Taunggye)", "MMR", 131500));
        cities.put (2718, new City (2718, "Meikhtila", "MMR", 129700));
        cities.put (2719, new City (2719, "Mergui (Myeik)", "MMR", 122700));
        cities.put (2720, new City (2720, "Lashio (Lasho)", "MMR", 107600));
        cities.put (2721, new City (2721, "Prome (Pyay)", "MMR", 105700));
        cities.put (2722, new City (2722, "Henzada (Hinthada)", "MMR", 104700));
        cities.put (2723, new City (2723, "Myingyan", "MMR", 103600));
        cities.put (2724, new City (2724, "Tavoy (Dawei)", "MMR", 96800));
        cities.put (2725, new City (2725, "Pagakku (Pakokku)", "MMR", 94800));
        cities.put (2726, new City (2726, "Windhoek", "NAM", 169000));
        cities.put (2727, new City (2727, "Yangor", "NRU", 4050));
        cities.put (2728, new City (2728, "Yaren", "NRU", 559));
        cities.put (2729, new City (2729, "Kathmandu", "NPL", 591835));
        cities.put (2730, new City (2730, "Biratnagar", "NPL", 157764));
        cities.put (2731, new City (2731, "Pokhara", "NPL", 146318));
        cities.put (2732, new City (2732, "Lalitapur", "NPL", 145847));
        cities.put (2733, new City (2733, "Birgunj", "NPL", 90639));
        cities.put (2734, new City (2734, "Managua", "NIC", 959000));
        cities.put (2735, new City (2735, "LeÂ¢n", "NIC", 123865));
        cities.put (2736, new City (2736, "Chinandega", "NIC", 97387));
        cities.put (2737, new City (2737, "Masaya", "NIC", 88971));
        cities.put (2738, new City (2738, "Niamey", "NER", 420000));
        cities.put (2739, new City (2739, "Zinder", "NER", 120892));
        cities.put (2740, new City (2740, "Maradi", "NER", 112965));
        cities.put (2741, new City (2741, "Lagos", "NGA", 1518000));
        cities.put (2742, new City (2742, "Ibadan", "NGA", 1432000));
        cities.put (2743, new City (2743, "Ogbomosho", "NGA", 730000));
        cities.put (2744, new City (2744, "Kano", "NGA", 674100));
        cities.put (2745, new City (2745, "Oshogbo", "NGA", 476800));
        cities.put (2746, new City (2746, "Ilorin", "NGA", 475800));
        cities.put (2747, new City (2747, "Abeokuta", "NGA", 427400));
        cities.put (2748, new City (2748, "Port Harcourt", "NGA", 410000));
        cities.put (2749, new City (2749, "Zaria", "NGA", 379200));
        cities.put (2750, new City (2750, "Ilesha", "NGA", 378400));
        cities.put (2751, new City (2751, "Onitsha", "NGA", 371900));
        cities.put (2752, new City (2752, "Iwo", "NGA", 362000));
        cities.put (2753, new City (2753, "Ado-Ekiti", "NGA", 359400));
        cities.put (2754, new City (2754, "Abuja", "NGA", 350100));
        cities.put (2755, new City (2755, "Kaduna", "NGA", 342200));
        cities.put (2756, new City (2756, "Mushin", "NGA", 333200));
        cities.put (2757, new City (2757, "Maiduguri", "NGA", 320000));
        cities.put (2758, new City (2758, "Enugu", "NGA", 316100));
        cities.put (2759, new City (2759, "Ede", "NGA", 307100));
        cities.put (2760, new City (2760, "Aba", "NGA", 298900));
        cities.put (2761, new City (2761, "Ife", "NGA", 296800));
        cities.put (2762, new City (2762, "Ila", "NGA", 264000));
        cities.put (2763, new City (2763, "Oyo", "NGA", 256400));
        cities.put (2764, new City (2764, "Ikerre", "NGA", 244600));
        cities.put (2765, new City (2765, "Benin City", "NGA", 229400));
        cities.put (2766, new City (2766, "Iseyin", "NGA", 217300));
        cities.put (2767, new City (2767, "Katsina", "NGA", 206500));
        cities.put (2768, new City (2768, "Jos", "NGA", 206300));
        cities.put (2769, new City (2769, "Sokoto", "NGA", 204900));
        cities.put (2770, new City (2770, "Ilobu", "NGA", 199000));
        cities.put (2771, new City (2771, "Offa", "NGA", 197200));
        cities.put (2772, new City (2772, "Ikorodu", "NGA", 184900));
        cities.put (2773, new City (2773, "Ilawe-Ekiti", "NGA", 184500));
        cities.put (2774, new City (2774, "Owo", "NGA", 183500));
        cities.put (2775, new City (2775, "Ikirun", "NGA", 181400));
        cities.put (2776, new City (2776, "Shaki", "NGA", 174500));
        cities.put (2777, new City (2777, "Calabar", "NGA", 174400));
        cities.put (2778, new City (2778, "Ondo", "NGA", 173600));
        cities.put (2779, new City (2779, "Akure", "NGA", 162300));
        cities.put (2780, new City (2780, "Gusau", "NGA", 158000));
        cities.put (2781, new City (2781, "Ijebu-Ode", "NGA", 156400));
        cities.put (2782, new City (2782, "Effon-Alaiye", "NGA", 153100));
        cities.put (2783, new City (2783, "Kumo", "NGA", 148000));
        cities.put (2784, new City (2784, "Shomolu", "NGA", 147700));
        cities.put (2785, new City (2785, "Oka-Akoko", "NGA", 142900));
        cities.put (2786, new City (2786, "Ikare", "NGA", 140800));
        cities.put (2787, new City (2787, "Sapele", "NGA", 139200));
        cities.put (2788, new City (2788, "Deba Habe", "NGA", 138600));
        cities.put (2789, new City (2789, "Minna", "NGA", 136900));
        cities.put (2790, new City (2790, "Warri", "NGA", 126100));
        cities.put (2791, new City (2791, "Bida", "NGA", 125500));
        cities.put (2792, new City (2792, "Ikire", "NGA", 123300));
        cities.put (2793, new City (2793, "Makurdi", "NGA", 123100));
        cities.put (2794, new City (2794, "Lafia", "NGA", 122500));
        cities.put (2795, new City (2795, "Inisa", "NGA", 119800));
        cities.put (2796, new City (2796, "Shagamu", "NGA", 117200));
        cities.put (2797, new City (2797, "Awka", "NGA", 111200));
        cities.put (2798, new City (2798, "Gombe", "NGA", 107800));
        cities.put (2799, new City (2799, "Igboho", "NGA", 106800));
        cities.put (2800, new City (2800, "Ejigbo", "NGA", 105900));
        cities.put (2801, new City (2801, "Agege", "NGA", 105000));
        cities.put (2802, new City (2802, "Ise-Ekiti", "NGA", 103400));
        cities.put (2803, new City (2803, "Ugep", "NGA", 102600));
        cities.put (2804, new City (2804, "Epe", "NGA", 101000));
        cities.put (2805, new City (2805, "Alofi", "NIU", 682));
        cities.put (2806, new City (2806, "Kingston", "NFK", 800));
        cities.put (2807, new City (2807, "Oslo", "NOR", 508726));
        cities.put (2808, new City (2808, "Bergen", "NOR", 230948));
        cities.put (2809, new City (2809, "Trondheim", "NOR", 150166));
        cities.put (2810, new City (2810, "Stavanger", "NOR", 108848));
        cities.put (2811, new City (2811, "Bâ€˜rum", "NOR", 101340));
        cities.put (2812, new City (2812, "Abidjan", "CIV", 2500000));
        cities.put (2813, new City (2813, "Bouakâ€š", "CIV", 329850));
        cities.put (2814, new City (2814, "Yamoussoukro", "CIV", 130000));
        cities.put (2815, new City (2815, "Daloa", "CIV", 121842));
        cities.put (2816, new City (2816, "Korhogo", "CIV", 109445));
        cities.put (2817, new City (2817, "al-Sib", "OMN", 155000));
        cities.put (2818, new City (2818, "Salala", "OMN", 131813));
        cities.put (2819, new City (2819, "Bawshar", "OMN", 107500));
        cities.put (2820, new City (2820, "Suhar", "OMN", 90814));
        cities.put (2821, new City (2821, "Masqat", "OMN", 51969));
        cities.put (2822, new City (2822, "Karachi", "PAK", 9269265));
        cities.put (2823, new City (2823, "Lahore", "PAK", 5063499));
        cities.put (2824, new City (2824, "Faisalabad", "PAK", 1977246));
        cities.put (2825, new City (2825, "Rawalpindi", "PAK", 1406214));
        cities.put (2826, new City (2826, "Multan", "PAK", 1182441));
        cities.put (2827, new City (2827, "Hyderabad", "PAK", 1151274));
        cities.put (2828, new City (2828, "Gujranwala", "PAK", 1124749));
        cities.put (2829, new City (2829, "Peshawar", "PAK", 988005));
        cities.put (2830, new City (2830, "Quetta", "PAK", 560307));
        cities.put (2831, new City (2831, "Islamabad", "PAK", 524500));
        cities.put (2832, new City (2832, "Sargodha", "PAK", 455360));
        cities.put (2833, new City (2833, "Sialkot", "PAK", 417597));
        cities.put (2834, new City (2834, "Bahawalpur", "PAK", 403408));
        cities.put (2835, new City (2835, "Sukkur", "PAK", 329176));
        cities.put (2836, new City (2836, "Jhang", "PAK", 292214));
        cities.put (2837, new City (2837, "Sheikhupura", "PAK", 271875));
        cities.put (2838, new City (2838, "Larkana", "PAK", 270366));
        cities.put (2839, new City (2839, "Gujrat", "PAK", 250121));
        cities.put (2840, new City (2840, "Mardan", "PAK", 244511));
        cities.put (2841, new City (2841, "Kasur", "PAK", 241649));
        cities.put (2842, new City (2842, "Rahim Yar Khan", "PAK", 228479));
        cities.put (2843, new City (2843, "Sahiwal", "PAK", 207388));
        cities.put (2844, new City (2844, "Okara", "PAK", 200901));
        cities.put (2845, new City (2845, "Wah", "PAK", 198400));
        cities.put (2846, new City (2846, "Dera Ghazi Khan", "PAK", 188100));
        cities.put (2847, new City (2847, "Mirpur Khas", "PAK", 184500));
        cities.put (2848, new City (2848, "Nawabshah", "PAK", 183100));
        cities.put (2849, new City (2849, "Mingora", "PAK", 174500));
        cities.put (2850, new City (2850, "Chiniot", "PAK", 169300));
        cities.put (2851, new City (2851, "Kamoke", "PAK", 151000));
        cities.put (2852, new City (2852, "Mandi Burewala", "PAK", 149900));
        cities.put (2853, new City (2853, "Jhelum", "PAK", 145800));
        cities.put (2854, new City (2854, "Sadiqabad", "PAK", 141500));
        cities.put (2855, new City (2855, "Jacobabad", "PAK", 137700));
        cities.put (2856, new City (2856, "Shikarpur", "PAK", 133300));
        cities.put (2857, new City (2857, "Khanewal", "PAK", 133000));
        cities.put (2858, new City (2858, "Hafizabad", "PAK", 130200));
        cities.put (2859, new City (2859, "Kohat", "PAK", 125300));
        cities.put (2860, new City (2860, "Muzaffargarh", "PAK", 121600));
        cities.put (2861, new City (2861, "Khanpur", "PAK", 117800));
        cities.put (2862, new City (2862, "Gojra", "PAK", 115000));
        cities.put (2863, new City (2863, "Bahawalnagar", "PAK", 109600));
        cities.put (2864, new City (2864, "Muridke", "PAK", 108600));
        cities.put (2865, new City (2865, "Pak Pattan", "PAK", 107800));
        cities.put (2866, new City (2866, "Abottabad", "PAK", 106000));
        cities.put (2867, new City (2867, "Tando Adam", "PAK", 103400));
        cities.put (2868, new City (2868, "Jaranwala", "PAK", 103300));
        cities.put (2869, new City (2869, "Khairpur", "PAK", 102200));
        cities.put (2870, new City (2870, "Chishtian Mandi", "PAK", 101700));
        cities.put (2871, new City (2871, "Daska", "PAK", 101500));
        cities.put (2872, new City (2872, "Dadu", "PAK", 98600));
        cities.put (2873, new City (2873, "Mandi Bahauddin", "PAK", 97300));
        cities.put (2874, new City (2874, "Ahmadpur East", "PAK", 96000));
        cities.put (2875, new City (2875, "Kamalia", "PAK", 95300));
        cities.put (2876, new City (2876, "Khuzdar", "PAK", 93100));
        cities.put (2877, new City (2877, "Vihari", "PAK", 92300));
        cities.put (2878, new City (2878, "Dera Ismail Khan", "PAK", 90400));
        cities.put (2879, new City (2879, "Wazirabad", "PAK", 89700));
        cities.put (2880, new City (2880, "Nowshera", "PAK", 89400));
        cities.put (2881, new City (2881, "Koror", "PLW", 12000));
        cities.put (2882, new City (2882, "Ciudad de PanamÂ ", "PAN", 471373));
        cities.put (2883, new City (2883, "San Miguelito", "PAN", 315382));
        cities.put (2884, new City (2884, "Port Moresby", "PNG", 247000));
        cities.put (2885, new City (2885, "AsunciÂ¢n", "PRY", 557776));
        cities.put (2886, new City (2886, "Ciudad del Este", "PRY", 133881));
        cities.put (2887, new City (2887, "San Lorenzo", "PRY", 133395));
        cities.put (2888, new City (2888, "Lambarâ€š", "PRY", 99681));
        cities.put (2889, new City (2889, "Fernando de la Mora", "PRY", 95287));
        cities.put (2890, new City (2890, "Lima", "PER", 6464693));
        cities.put (2891, new City (2891, "Arequipa", "PER", 762000));
        cities.put (2892, new City (2892, "Trujillo", "PER", 652000));
        cities.put (2893, new City (2893, "Chiclayo", "PER", 517000));
        cities.put (2894, new City (2894, "Callao", "PER", 424294));
        cities.put (2895, new City (2895, "Iquitos", "PER", 367000));
        cities.put (2896, new City (2896, "Chimbote", "PER", 336000));
        cities.put (2897, new City (2897, "Huancayo", "PER", 327000));
        cities.put (2898, new City (2898, "Piura", "PER", 325000));
        cities.put (2899, new City (2899, "Cusco", "PER", 291000));
        cities.put (2900, new City (2900, "Pucallpa", "PER", 220866));
        cities.put (2901, new City (2901, "Tacna", "PER", 215683));
        cities.put (2902, new City (2902, "Ica", "PER", 194820));
        cities.put (2903, new City (2903, "Sullana", "PER", 147361));
        cities.put (2904, new City (2904, "Juliaca", "PER", 142576));
        cities.put (2905, new City (2905, "HuÂ nuco", "PER", 129688));
        cities.put (2906, new City (2906, "Ayacucho", "PER", 118960));
        cities.put (2907, new City (2907, "Chincha Alta", "PER", 110016));
        cities.put (2908, new City (2908, "Cajamarca", "PER", 108009));
        cities.put (2909, new City (2909, "Puno", "PER", 101578));
        cities.put (2910, new City (2910, "Ventanilla", "PER", 101056));
        cities.put (2911, new City (2911, "Castilla", "PER", 90642));
        cities.put (2912, new City (2912, "Adamstown", "PCN", 42));
        cities.put (2913, new City (2913, "Garapan", "MNP", 9200));
        cities.put (2914, new City (2914, "Lisboa", "PRT", 563210));
        cities.put (2915, new City (2915, "Porto", "PRT", 273060));
        cities.put (2916, new City (2916, "Amadora", "PRT", 122106));
        cities.put (2917, new City (2917, "CoÂ¡mbra", "PRT", 96100));
        cities.put (2918, new City (2918, "Braga", "PRT", 90535));
        cities.put (2919, new City (2919, "San Juan", "PRI", 434374));
        cities.put (2920, new City (2920, "BayamÂ¢n", "PRI", 224044));
        cities.put (2921, new City (2921, "Ponce", "PRI", 186475));
        cities.put (2922, new City (2922, "Carolina", "PRI", 186076));
        cities.put (2923, new City (2923, "Caguas", "PRI", 140502));
        cities.put (2924, new City (2924, "Arecibo", "PRI", 100131));
        cities.put (2925, new City (2925, "Guaynabo", "PRI", 100053));
        cities.put (2926, new City (2926, "MayagÂ�ez", "PRI", 98434));
        cities.put (2927, new City (2927, "Toa Baja", "PRI", 94085));
        cities.put (2928, new City (2928, "Warszawa", "POL", 1615369));
        cities.put (2929, new City (2929, "LÂ¢dz", "POL", 800110));
        cities.put (2930, new City (2930, "KrakÂ¢w", "POL", 738150));
        cities.put (2931, new City (2931, "Wroclaw", "POL", 636765));
        cities.put (2932, new City (2932, "Poznan", "POL", 576899));
        cities.put (2933, new City (2933, "Gdansk", "POL", 458988));
        cities.put (2934, new City (2934, "Szczecin", "POL", 416988));
        cities.put (2935, new City (2935, "Bydgoszcz", "POL", 386855));
        cities.put (2936, new City (2936, "Lublin", "POL", 356251));
        cities.put (2937, new City (2937, "Katowice", "POL", 345934));
        cities.put (2938, new City (2938, "Bialystok", "POL", 283937));
        cities.put (2939, new City (2939, "Czestochowa", "POL", 257812));
        cities.put (2940, new City (2940, "Gdynia", "POL", 253521));
        cities.put (2941, new City (2941, "Sosnowiec", "POL", 244102));
        cities.put (2942, new City (2942, "Radom", "POL", 232262));
        cities.put (2943, new City (2943, "Kielce", "POL", 212383));
        cities.put (2944, new City (2944, "Gliwice", "POL", 212164));
        cities.put (2945, new City (2945, "Torun", "POL", 206158));
        cities.put (2946, new City (2946, "Bytom", "POL", 205560));
        cities.put (2947, new City (2947, "Zabrze", "POL", 200177));
        cities.put (2948, new City (2948, "Bielsko-Biala", "POL", 180307));
        cities.put (2949, new City (2949, "Olsztyn", "POL", 170904));
        cities.put (2950, new City (2950, "RzeszÂ¢w", "POL", 162049));
        cities.put (2951, new City (2951, "Ruda Slaska", "POL", 159665));
        cities.put (2952, new City (2952, "Rybnik", "POL", 144582));
        cities.put (2953, new City (2953, "Walbrzych", "POL", 136923));
        cities.put (2954, new City (2954, "Tychy", "POL", 133178));
        cities.put (2955, new City (2955, "Dabrowa GÂ¢rnicza", "POL", 131037));
        cities.put (2956, new City (2956, "Plock", "POL", 131011));
        cities.put (2957, new City (2957, "Elblag", "POL", 129782));
        cities.put (2958, new City (2958, "Opole", "POL", 129553));
        cities.put (2959,
                new City (2959, "GorzÂ¢w Wielkopolski", "POL", 126019));
        cities.put (2960, new City (2960, "Wloclawek", "POL", 123373));
        cities.put (2961, new City (2961, "ChorzÂ¢w", "POL", 121708));
        cities.put (2962, new City (2962, "TarnÂ¢w", "POL", 121494));
        cities.put (2963, new City (2963, "Zielona GÂ¢ra", "POL", 118182));
        cities.put (2964, new City (2964, "Koszalin", "POL", 112375));
        cities.put (2965, new City (2965, "Legnica", "POL", 109335));
        cities.put (2966, new City (2966, "Kalisz", "POL", 106641));
        cities.put (2967, new City (2967, "Grudziadz", "POL", 102434));
        cities.put (2968, new City (2968, "Slupsk", "POL", 102370));
        cities.put (2969, new City (2969, "Jastrzebie-ZdrÂ¢j", "POL", 102294));
        cities.put (2970, new City (2970, "Jaworzno", "POL", 97929));
        cities.put (2971, new City (2971, "Jelenia GÂ¢ra", "POL", 93901));
        cities.put (2972, new City (2972, "Malabo", "GNQ", 40000));
        cities.put (2973, new City (2973, "Doha", "QAT", 355000));
        cities.put (2974, new City (2974, "Paris", "FRA", 2125246));
        cities.put (2975, new City (2975, "Marseille", "FRA", 798430));
        cities.put (2976, new City (2976, "Lyon", "FRA", 445452));
        cities.put (2977, new City (2977, "Toulouse", "FRA", 390350));
        cities.put (2978, new City (2978, "Nice", "FRA", 342738));
        cities.put (2979, new City (2979, "Nantes", "FRA", 270251));
        cities.put (2980, new City (2980, "Strasbourg", "FRA", 264115));
        cities.put (2981, new City (2981, "Montpellier", "FRA", 225392));
        cities.put (2982, new City (2982, "Bordeaux", "FRA", 215363));
        cities.put (2983, new City (2983, "Rennes", "FRA", 206229));
        cities.put (2984, new City (2984, "Le Havre", "FRA", 190905));
        cities.put (2985, new City (2985, "Reims", "FRA", 187206));
        cities.put (2986, new City (2986, "Lille", "FRA", 184657));
        cities.put (2987, new City (2987, "St-Â�tienne", "FRA", 180210));
        cities.put (2988, new City (2988, "Toulon", "FRA", 160639));
        cities.put (2989, new City (2989, "Grenoble", "FRA", 153317));
        cities.put (2990, new City (2990, "Angers", "FRA", 151279));
        cities.put (2991, new City (2991, "Dijon", "FRA", 149867));
        cities.put (2992, new City (2992, "Brest", "FRA", 149634));
        cities.put (2993, new City (2993, "Le Mans", "FRA", 146105));
        cities.put (2994, new City (2994, "Clermont-Ferrand", "FRA", 137140));
        cities.put (2995, new City (2995, "Amiens", "FRA", 135501));
        cities.put (2996, new City (2996, "Aix-en-Provence", "FRA", 134222));
        cities.put (2997, new City (2997, "Limoges", "FRA", 133968));
        cities.put (2998, new City (2998, "NÅ’mes", "FRA", 133424));
        cities.put (2999, new City (2999, "Tours", "FRA", 132820));

    }

    public void createCities3000() {
        cities.put (3000, new City (3000, "Villeurbanne", "FRA", 124215));
        cities.put (3001, new City (3001, "Metz", "FRA", 123776));
        cities.put (3002, new City (3002, "Besanâ€¡on", "FRA", 117733));
        cities.put (3003, new City (3003, "Caen", "FRA", 113987));
        cities.put (3004, new City (3004, "Orlâ€šans", "FRA", 113126));
        cities.put (3005, new City (3005, "Mulhouse", "FRA", 110359));
        cities.put (3006, new City (3006, "Rouen", "FRA", 106592));
        cities.put (3007, new City (3007, "Boulogne-Billancourt", "FRA", 106367));
        cities.put (3008, new City (3008, "Perpignan", "FRA", 105115));
        cities.put (3009, new City (3009, "Nancy", "FRA", 103605));
        cities.put (3010, new City (3010, "Roubaix", "FRA", 96984));
        cities.put (3011, new City (3011, "Argenteuil", "FRA", 93961));
        cities.put (3012, new City (3012, "Tourcoing", "FRA", 93540));
        cities.put (3013, new City (3013, "Montreuil", "FRA", 90674));
        cities.put (3014, new City (3014, "Cayenne", "GUF", 50699));
        cities.put (3015, new City (3015, "Faaa", "PYF", 25888));
        cities.put (3016, new City (3016, "Papeete", "PYF", 25553));
        cities.put (3017, new City (3017, "Saint-Denis", "REU", 131480));
        cities.put (3018, new City (3018, "Bucuresti", "ROM", 2016131));
        cities.put (3019, new City (3019, "Iasi", "ROM", 348070));
        cities.put (3020, new City (3020, "Constanta", "ROM", 342264));
        cities.put (3021, new City (3021, "Cluj-Napoca", "ROM", 332498));
        cities.put (3022, new City (3022, "Galati", "ROM", 330276));
        cities.put (3023, new City (3023, "Timisoara", "ROM", 324304));
        cities.put (3024, new City (3024, "Brasov", "ROM", 314225));
        cities.put (3025, new City (3025, "Craiova", "ROM", 313530));
        cities.put (3026, new City (3026, "Ploiesti", "ROM", 251348));
        cities.put (3027, new City (3027, "Braila", "ROM", 233756));
        cities.put (3028, new City (3028, "Oradea", "ROM", 222239));
        cities.put (3029, new City (3029, "Bacau", "ROM", 209235));
        cities.put (3030, new City (3030, "Pitesti", "ROM", 187170));
        cities.put (3031, new City (3031, "Arad", "ROM", 184408));
        cities.put (3032, new City (3032, "Sibiu", "ROM", 169611));
        cities.put (3033, new City (3033, "TÆ’rgu Mures", "ROM", 165153));
        cities.put (3034, new City (3034, "Baia Mare", "ROM", 149665));
        cities.put (3035, new City (3035, "Buzau", "ROM", 148372));
        cities.put (3036, new City (3036, "Satu Mare", "ROM", 130059));
        cities.put (3037, new City (3037, "Botosani", "ROM", 128730));
        cities.put (3038, new City (3038, "Piatra Neamt", "ROM", 125070));
        cities.put (3039,
                new City (3039, "RÆ’mnicu VÆ’lcea", "ROM", 119741));
        cities.put (3040, new City (3040, "Suceava", "ROM", 118549));
        cities.put (3041, new City (3041, "Drobeta-Turnu Severin", "ROM", 117865));
        cities.put (3042, new City (3042, "TÆ’rgoviste", "ROM", 98980));
        cities.put (3043, new City (3043, "Focsani", "ROM", 98979));
        cities.put (3044, new City (3044, "TÆ’rgu Jiu", "ROM", 98524));
        cities.put (3045, new City (3045, "Tulcea", "ROM", 96278));
        cities.put (3046, new City (3046, "Resita", "ROM", 93976));
        cities.put (3047, new City (3047, "Kigali", "RWA", 286000));
        cities.put (3048, new City (3048, "Stockholm", "SWE", 750348));
        cities.put (3049, new City (3049, "Gothenburg [Gâ€�teborg]", "SWE",
                466990));
        cities.put (3050, new City (3050, "Malmâ€�", "SWE", 259579));
        cities.put (3051, new City (3051, "Uppsala", "SWE", 189569));
        cities.put (3052, new City (3052, "Linkâ€�ping", "SWE", 133168));
        cities.put (3053, new City (3053, "Vâ€žsterâ€ s", "SWE", 126328));
        cities.put (3054, new City (3054, "â„¢rebro", "SWE", 124207));
        cities.put (3055, new City (3055, "Norrkâ€�ping", "SWE", 122199));
        cities.put (3056, new City (3056, "Helsingborg", "SWE", 117737));
        cities.put (3057, new City (3057, "Jâ€�nkâ€�ping", "SWE",
                117095));
        cities.put (3058, new City (3058, "Umeâ€ ", "SWE", 104512));
        cities.put (3059, new City (3059, "Lund", "SWE", 98948));
        cities.put (3060, new City (3060, "Borâ€ s", "SWE", 96883));
        cities.put (3061, new City (3061, "Sundsvall", "SWE", 93126));
        cities.put (3062, new City (3062, "Gâ€žvle", "SWE", 90742));
        cities.put (3063, new City (3063, "Jamestown", "SHN", 1500));
        cities.put (3064, new City (3064, "Basseterre", "KNA", 11600));
        cities.put (3065, new City (3065, "Castries", "LCA", 2301));
        cities.put (3066, new City (3066, "Kingstown", "VCT", 17100));
        cities.put (3067, new City (3067, "Saint-Pierre", "SPM", 5808));
        cities.put (3068, new City (3068, "Berlin", "DEU", 3386667));
        cities.put (3069, new City (3069, "Hamburg", "DEU", 1704735));
        cities.put (3070, new City (3070, "Munich [MÂ�nchen]", "DEU", 1194560));
        cities.put (3071, new City (3071, "Kâ€�ln", "DEU", 962507));
        cities.put (3072, new City (3072, "Frankfurt am Main", "DEU", 643821));
        cities.put (3073, new City (3073, "Essen", "DEU", 599515));
        cities.put (3074, new City (3074, "Dortmund", "DEU", 590213));
        cities.put (3075, new City (3075, "Stuttgart", "DEU", 582443));
        cities.put (3076, new City (3076, "DÂ�sseldorf", "DEU", 568855));
        cities.put (3077, new City (3077, "Bremen", "DEU", 540330));
        cities.put (3078, new City (3078, "Duisburg", "DEU", 519793));
        cities.put (3079, new City (3079, "Hannover", "DEU", 514718));
        cities.put (3080, new City (3080, "Leipzig", "DEU", 489532));
        cities.put (3081, new City (3081, "NÂ�rnberg", "DEU", 486628));
        cities.put (3082, new City (3082, "Dresden", "DEU", 476668));
        cities.put (3083, new City (3083, "Bochum", "DEU", 392830));
        cities.put (3084, new City (3084, "Wuppertal", "DEU", 368993));
        cities.put (3085, new City (3085, "Bielefeld", "DEU", 321125));
        cities.put (3086, new City (3086, "Mannheim", "DEU", 307730));
        cities.put (3087, new City (3087, "Bonn", "DEU", 301048));
        cities.put (3088, new City (3088, "Gelsenkirchen", "DEU", 281979));
        cities.put (3089, new City (3089, "Karlsruhe", "DEU", 277204));
        cities.put (3090, new City (3090, "Wiesbaden", "DEU", 268716));
        cities.put (3091, new City (3091, "MÂ�nster", "DEU", 264670));
        cities.put (3092,
                new City (3092, "Mâ€�nchengladbach", "DEU", 263697));
        cities.put (3093, new City (3093, "Chemnitz", "DEU", 263222));
        cities.put (3094, new City (3094, "Augsburg", "DEU", 254867));
        cities.put (3095, new City (3095, "Halle/Saale", "DEU", 254360));
        cities.put (3096, new City (3096, "Braunschweig", "DEU", 246322));
        cities.put (3097, new City (3097, "Aachen", "DEU", 243825));
        cities.put (3098, new City (3098, "Krefeld", "DEU", 241769));
        cities.put (3099, new City (3099, "Magdeburg", "DEU", 235073));
        cities.put (3100, new City (3100, "Kiel", "DEU", 233795));
        cities.put (3101, new City (3101, "Oberhausen", "DEU", 222349));
        cities.put (3102, new City (3102, "LÂ�beck", "DEU", 213326));
        cities.put (3103, new City (3103, "Hagen", "DEU", 205201));
        cities.put (3104, new City (3104, "Rostock", "DEU", 203279));
        cities.put (3105, new City (3105, "Freiburg im Breisgau", "DEU", 202455));
        cities.put (3106, new City (3106, "Erfurt", "DEU", 201267));
        cities.put (3107, new City (3107, "Kassel", "DEU", 196211));
        cities.put (3108, new City (3108, "SaarbrÂ�cken", "DEU", 183836));
        cities.put (3109, new City (3109, "Mainz", "DEU", 183134));
        cities.put (3110, new City (3110, "Hamm", "DEU", 181804));
        cities.put (3111, new City (3111, "Herne", "DEU", 175661));
        cities.put (3112, new City (3112, "MÂ�lheim an der Ruhr", "DEU",
                173895));
        cities.put (3113, new City (3113, "Solingen", "DEU", 165583));
        cities.put (3114, new City (3114, "OsnabrÂ�ck", "DEU", 164539));
        cities.put (3115, new City (3115, "Ludwigshafen am Rhein", "DEU", 163771));
        cities.put (3116, new City (3116, "Leverkusen", "DEU", 160841));
        cities.put (3117, new City (3117, "Oldenburg", "DEU", 154125));
        cities.put (3118, new City (3118, "Neuss", "DEU", 149702));
        cities.put (3119, new City (3119, "Heidelberg", "DEU", 139672));
        cities.put (3120, new City (3120, "Darmstadt", "DEU", 137776));
        cities.put (3121, new City (3121, "Paderborn", "DEU", 137647));
        cities.put (3122, new City (3122, "Potsdam", "DEU", 128983));
        cities.put (3123, new City (3123, "WÂ�rzburg", "DEU", 127350));
        cities.put (3124, new City (3124, "Regensburg", "DEU", 125236));
        cities.put (3125, new City (3125, "Recklinghausen", "DEU", 125022));
        cities.put (3126, new City (3126, "Gâ€�ttingen", "DEU", 124775));
        cities.put (3127, new City (3127, "Bremerhaven", "DEU", 122735));
        cities.put (3128, new City (3128, "Wolfsburg", "DEU", 121954));
        cities.put (3129, new City (3129, "Bottrop", "DEU", 121097));
        cities.put (3130, new City (3130, "Remscheid", "DEU", 120125));
        cities.put (3131, new City (3131, "Heilbronn", "DEU", 119526));
        cities.put (3132, new City (3132, "Pforzheim", "DEU", 117227));
        cities.put (3133, new City (3133, "Offenbach am Main", "DEU", 116627));
        cities.put (3134, new City (3134, "Ulm", "DEU", 116103));
        cities.put (3135, new City (3135, "Ingolstadt", "DEU", 114826));
        cities.put (3136, new City (3136, "Gera", "DEU", 114718));
        cities.put (3137, new City (3137, "Salzgitter", "DEU", 112934));
        cities.put (3138, new City (3138, "Cottbus", "DEU", 110894));
        cities.put (3139, new City (3139, "Reutlingen", "DEU", 110343));
        cities.put (3140, new City (3140, "FÂ�rth", "DEU", 109771));
        cities.put (3141, new City (3141, "Siegen", "DEU", 109225));
        cities.put (3142, new City (3142, "Koblenz", "DEU", 108003));
        cities.put (3143, new City (3143, "Moers", "DEU", 106837));
        cities.put (3144, new City (3144, "Bergisch Gladbach", "DEU", 106150));
        cities.put (3145, new City (3145, "Zwickau", "DEU", 104146));
        cities.put (3146, new City (3146, "Hildesheim", "DEU", 104013));
        cities.put (3147, new City (3147, "Witten", "DEU", 103384));
        cities.put (3148, new City (3148, "Schwerin", "DEU", 102878));
        cities.put (3149, new City (3149, "Erlangen", "DEU", 100750));
        cities.put (3150, new City (3150, "Kaiserslautern", "DEU", 100025));
        cities.put (3151, new City (3151, "Trier", "DEU", 99891));
        cities.put (3152, new City (3152, "Jena", "DEU", 99779));
        cities.put (3153, new City (3153, "Iserlohn", "DEU", 99474));
        cities.put (3154, new City (3154, "GÂ�tersloh", "DEU", 95028));
        cities.put (3155, new City (3155, "Marl", "DEU", 93735));
        cities.put (3156, new City (3156, "LÂ�nen", "DEU", 92044));
        cities.put (3157, new City (3157, "DÂ�ren", "DEU", 91092));
        cities.put (3158, new City (3158, "Ratingen", "DEU", 90951));
        cities.put (3159, new City (3159, "Velbert", "DEU", 89881));
        cities.put (3160, new City (3160, "Esslingen am Neckar", "DEU", 89667));
        cities.put (3161, new City (3161, "Honiara", "SLB", 50100));
        cities.put (3162, new City (3162, "Lusaka", "ZMB", 1317000));
        cities.put (3163, new City (3163, "Ndola", "ZMB", 329200));
        cities.put (3164, new City (3164, "Kitwe", "ZMB", 288600));
        cities.put (3165, new City (3165, "Kabwe", "ZMB", 154300));
        cities.put (3166, new City (3166, "Chingola", "ZMB", 142400));
        cities.put (3167, new City (3167, "Mufulira", "ZMB", 123900));
        cities.put (3168, new City (3168, "Luanshya", "ZMB", 118100));
        cities.put (3169, new City (3169, "Apia", "WSM", 35900));
        cities.put (3170, new City (3170, "Serravalle", "SMR", 4802));
        cities.put (3171, new City (3171, "San Marino", "SMR", 2294));
        cities.put (3172, new City (3172, "SÃ†o Tomâ€š", "STP", 49541));
        cities.put (3173, new City (3173, "Riyadh", "SAU", 3324000));
        cities.put (3174, new City (3174, "Jedda", "SAU", 2046300));
        cities.put (3175, new City (3175, "Mekka", "SAU", 965700));
        cities.put (3176, new City (3176, "Medina", "SAU", 608300));
        cities.put (3177, new City (3177, "al-Dammam", "SAU", 482300));
        cities.put (3178, new City (3178, "al-Taif", "SAU", 416100));
        cities.put (3179, new City (3179, "Tabuk", "SAU", 292600));
        cities.put (3180, new City (3180, "Burayda", "SAU", 248600));
        cities.put (3181, new City (3181, "al-Hufuf", "SAU", 225800));
        cities.put (3182, new City (3182, "al-Mubarraz", "SAU", 219100));
        cities.put (3183, new City (3183, "Khamis Mushayt", "SAU", 217900));
        cities.put (3184, new City (3184, "Hail", "SAU", 176800));
        cities.put (3185, new City (3185, "al-Kharj", "SAU", 152100));
        cities.put (3186, new City (3186, "al-Khubar", "SAU", 141700));
        cities.put (3187, new City (3187, "Jubayl", "SAU", 140800));
        cities.put (3188, new City (3188, "Hafar al-Batin", "SAU", 137800));
        cities.put (3189, new City (3189, "al-Tuqba", "SAU", 125700));
        cities.put (3190, new City (3190, "Yanbu", "SAU", 119800));
        cities.put (3191, new City (3191, "Abha", "SAU", 112300));
        cities.put (3192, new City (3192, "AraÃ¯ar", "SAU", 108100));
        cities.put (3193, new City (3193, "al-Qatif", "SAU", 98900));
        cities.put (3194, new City (3194, "al-Hawiya", "SAU", 93900));
        cities.put (3195, new City (3195, "Unayza", "SAU", 91100));
        cities.put (3196, new City (3196, "Najran", "SAU", 91000));
        cities.put (3197, new City (3197, "Pikine", "SEN", 855287));
        cities.put (3198, new City (3198, "Dakar", "SEN", 785071));
        cities.put (3199, new City (3199, "ThiÅ s", "SEN", 248000));
        cities.put (3200, new City (3200, "Kaolack", "SEN", 199000));
        cities.put (3201, new City (3201, "Ziguinchor", "SEN", 192000));
        cities.put (3202, new City (3202, "Rufisque", "SEN", 150000));
        cities.put (3203, new City (3203, "Saint-Louis", "SEN", 132400));
        cities.put (3204, new City (3204, "Mbour", "SEN", 109300));
        cities.put (3205, new City (3205, "Diourbel", "SEN", 99400));
        cities.put (3206, new City (3206, "Victoria", "SYC", 41000));
        cities.put (3207, new City (3207, "Freetown", "SLE", 850000));
        cities.put (3208, new City (3208, "Singapore", "SGP", 4017733));
        cities.put (3209, new City (3209, "Bratislava", "SVK", 448292));
        cities.put (3210, new City (3210, "Ko?ice", "SVK", 241874));
        cities.put (3211, new City (3211, "Pre?ov", "SVK", 93977));
        cities.put (3212, new City (3212, "Ljubljana", "SVN", 270986));
        cities.put (3213, new City (3213, "Maribor", "SVN", 115532));
        cities.put (3214, new City (3214, "Mogadishu", "SOM", 997000));
        cities.put (3215, new City (3215, "Hargeysa", "SOM", 90000));
        cities.put (3216, new City (3216, "Kismaayo", "SOM", 90000));
        cities.put (3217, new City (3217, "Colombo", "LKA", 645000));
        cities.put (3218, new City (3218, "Dehiwala", "LKA", 203000));
        cities.put (3219, new City (3219, "Moratuwa", "LKA", 190000));
        cities.put (3220, new City (3220, "Jaffna", "LKA", 149000));
        cities.put (3221, new City (3221, "Kandy", "LKA", 140000));
        cities.put (3222, new City (3222, "Sri Jayawardenepura Kotte", "LKA",
                118000));
        cities.put (3223, new City (3223, "Negombo", "LKA", 100000));
        cities.put (3224, new City (3224, "Omdurman", "SDN", 1271403));
        cities.put (3225, new City (3225, "Khartum", "SDN", 947483));
        cities.put (3226, new City (3226, "Sharq al-Nil", "SDN", 700887));
        cities.put (3227, new City (3227, "Port Sudan", "SDN", 308195));
        cities.put (3228, new City (3228, "Kassala", "SDN", 234622));
        cities.put (3229, new City (3229, "Obeid", "SDN", 229425));
        cities.put (3230, new City (3230, "Nyala", "SDN", 227183));
        cities.put (3231, new City (3231, "Wad Madani", "SDN", 211362));
        cities.put (3232, new City (3232, "al-Qadarif", "SDN", 191164));
        cities.put (3233, new City (3233, "Kusti", "SDN", 173599));
        cities.put (3234, new City (3234, "al-Fashir", "SDN", 141884));
        cities.put (3235, new City (3235, "Juba", "SDN", 114980));
        cities.put (3236,
                new City (3236, "Helsinki [Helsingfors]", "FIN", 555474));
        cities.put (3237, new City (3237, "Espoo", "FIN", 213271));
        cities.put (3238, new City (3238, "Tampere", "FIN", 195468));
        cities.put (3239, new City (3239, "Vantaa", "FIN", 178471));
        cities.put (3240, new City (3240, "Turku [Â�bo]", "FIN", 172561));
        cities.put (3241, new City (3241, "Oulu", "FIN", 120753));
        cities.put (3242, new City (3242, "Lahti", "FIN", 96921));
        cities.put (3243, new City (3243, "Paramaribo", "SUR", 112000));
        cities.put (3244, new City (3244, "Mbabane", "SWZ", 61000));
        cities.put (3245, new City (3245, "ZÂ�rich", "CHE", 336800));
        cities.put (3246, new City (3246, "Geneve", "CHE", 173500));
        cities.put (3247, new City (3247, "Basel", "CHE", 166700));
        cities.put (3248, new City (3248, "Bern", "CHE", 122700));
        cities.put (3249, new City (3249, "Lausanne", "CHE", 114500));
        cities.put (3250, new City (3250, "Damascus", "SYR", 1347000));
        cities.put (3251, new City (3251, "Aleppo", "SYR", 1261983));
        cities.put (3252, new City (3252, "Hims", "SYR", 507404));
        cities.put (3253, new City (3253, "Hama", "SYR", 343361));
        cities.put (3254, new City (3254, "Latakia", "SYR", 264563));
        cities.put (3255, new City (3255, "al-Qamishliya", "SYR", 144286));
        cities.put (3256, new City (3256, "Dayr al-Zawr", "SYR", 140459));
        cities.put (3257, new City (3257, "Jaramana", "SYR", 138469));
        cities.put (3258, new City (3258, "Duma", "SYR", 131158));
        cities.put (3259, new City (3259, "al-Raqqa", "SYR", 108020));
        cities.put (3260, new City (3260, "Idlib", "SYR", 91081));
        cities.put (3261, new City (3261, "Dushanbe", "TJK", 524000));
        cities.put (3262, new City (3262, "Khujand", "TJK", 161500));
        cities.put (3263, new City (3263, "Taipei", "TWN", 2641312));
        cities.put (3264, new City (3264, "Kaohsiung", "TWN", 1475505));
        cities.put (3265, new City (3265, "Taichung", "TWN", 940589));
        cities.put (3266, new City (3266, "Tainan", "TWN", 728060));
        cities.put (3267, new City (3267, "Panchiao", "TWN", 523850));
        cities.put (3268, new City (3268, "Chungho", "TWN", 392176));
        cities.put (3269, new City (3269, "Keelung (Chilung)", "TWN", 385201));
        cities.put (3270, new City (3270, "Sanchung", "TWN", 380084));
        cities.put (3271, new City (3271, "Hsinchuang", "TWN", 365048));
        cities.put (3272, new City (3272, "Hsinchu", "TWN", 361958));
        cities.put (3273, new City (3273, "Chungli", "TWN", 318649));
        cities.put (3274, new City (3274, "Fengshan", "TWN", 318562));
        cities.put (3275, new City (3275, "Taoyuan", "TWN", 316438));
        cities.put (3276, new City (3276, "Chiayi", "TWN", 265109));
        cities.put (3277, new City (3277, "Hsintien", "TWN", 263603));
        cities.put (3278, new City (3278, "Changhwa", "TWN", 227715));
        cities.put (3279, new City (3279, "Yungho", "TWN", 227700));
        cities.put (3280, new City (3280, "Tucheng", "TWN", 224897));
        cities.put (3281, new City (3281, "Pingtung", "TWN", 214727));
        cities.put (3282, new City (3282, "Yungkang", "TWN", 193005));
        cities.put (3283, new City (3283, "Pingchen", "TWN", 188344));
        cities.put (3284, new City (3284, "Tali", "TWN", 171940));
        cities.put (3285, new City (3285, "Taiping", "TWN", 165524));
        cities.put (3286, new City (3286, "Pate", "TWN", 161700));
        cities.put (3287, new City (3287, "Fengyuan", "TWN", 161032));
        cities.put (3288, new City (3288, "Luchou", "TWN", 160516));
        cities.put (3289, new City (3289, "Hsichuh", "TWN", 154976));
        cities.put (3290, new City (3290, "Shulin", "TWN", 151260));
        cities.put (3291, new City (3291, "Yuanlin", "TWN", 126402));
        cities.put (3292, new City (3292, "Yangmei", "TWN", 126323));
        cities.put (3293, new City (3293, "Taliao", "TWN", 115897));
        cities.put (3294, new City (3294, "Kueishan", "TWN", 112195));
        cities.put (3295, new City (3295, "Tanshui", "TWN", 111882));
        cities.put (3296, new City (3296, "Taitung", "TWN", 111039));
        cities.put (3297, new City (3297, "Hualien", "TWN", 108407));
        cities.put (3298, new City (3298, "Nantou", "TWN", 104723));
        cities.put (3299, new City (3299, "Lungtan", "TWN", 103088));
        cities.put (3300, new City (3300, "Touliu", "TWN", 98900));
        cities.put (3301, new City (3301, "Tsaotun", "TWN", 96800));
        cities.put (3302, new City (3302, "Kangshan", "TWN", 92200));
        cities.put (3303, new City (3303, "Ilan", "TWN", 92000));
        cities.put (3304, new City (3304, "Miaoli", "TWN", 90000));
        cities.put (3305, new City (3305, "Dar es Salaam", "TZA", 1747000));
        cities.put (3306, new City (3306, "Dodoma", "TZA", 189000));
        cities.put (3307, new City (3307, "Mwanza", "TZA", 172300));
        cities.put (3308, new City (3308, "Zanzibar", "TZA", 157634));
        cities.put (3309, new City (3309, "Tanga", "TZA", 137400));
        cities.put (3310, new City (3310, "Mbeya", "TZA", 130800));
        cities.put (3311, new City (3311, "Morogoro", "TZA", 117800));
        cities.put (3312, new City (3312, "Arusha", "TZA", 102500));
        cities.put (3313, new City (3313, "Moshi", "TZA", 96800));
        cities.put (3314, new City (3314, "Tabora", "TZA", 92800));
        cities.put (3315, new City (3315, "Kâ€ºbenhavn", "DNK", 495699));
        cities.put (3316, new City (3316, "Â�rhus", "DNK", 284846));
        cities.put (3317, new City (3317, "Odense", "DNK", 183912));
        cities.put (3318, new City (3318, "Aalborg", "DNK", 161161));
        cities.put (3319, new City (3319, "Frederiksberg", "DNK", 90327));
        cities.put (3320, new City (3320, "Bangkok", "THA", 6320174));
        cities.put (3321, new City (3321, "Nonthaburi", "THA", 292100));
        cities.put (3322, new City (3322, "Nakhon Ratchasima", "THA", 181400));
        cities.put (3323, new City (3323, "Chiang Mai", "THA", 171100));
        cities.put (3324, new City (3324, "Udon Thani", "THA", 158100));
        cities.put (3325, new City (3325, "Hat Yai", "THA", 148632));
        cities.put (3326, new City (3326, "Khon Kaen", "THA", 126500));
        cities.put (3327, new City (3327, "Pak Kret", "THA", 126055));
        cities.put (3328, new City (3328, "Nakhon Sawan", "THA", 123800));
        cities.put (3329, new City (3329, "Ubon Ratchathani", "THA", 116300));
        cities.put (3330, new City (3330, "Songkhla", "THA", 94900));
        cities.put (3331, new City (3331, "Nakhon Pathom", "THA", 94100));
        cities.put (3332, new City (3332, "Lomâ€š", "TGO", 375000));
        cities.put (3333, new City (3333, "Fakaofo", "TKL", 300));
        cities.put (3334, new City (3334, "NukuÃ¯alofa", "TON", 22400));
        cities.put (3335, new City (3335, "Chaguanas", "TTO", 56601));
        cities.put (3336, new City (3336, "Port-of-Spain", "TTO", 43396));
        cities.put (3337, new City (3337, "NÃ¯Djamâ€šna", "TCD", 530965));
        cities.put (3338, new City (3338, "Moundou", "TCD", 99500));
        cities.put (3339, new City (3339, "Praha", "CZE", 1181126));
        cities.put (3340, new City (3340, "Brno", "CZE", 381862));
        cities.put (3341, new City (3341, "Ostrava", "CZE", 320041));
        cities.put (3342, new City (3342, "Plzen", "CZE", 166759));
        cities.put (3343, new City (3343, "Olomouc", "CZE", 102702));
        cities.put (3344, new City (3344, "Liberec", "CZE", 99155));
        cities.put (3345, new City (3345, "Ceskâ€š Budejovice", "CZE", 98186));
        cities.put (3346,
                new City (3346, "Hradec KrÂ lovâ€š", "CZE", 98080));
        cities.put (3347, new City (3347, "Ã©stÂ¡ nad Labem", "CZE", 95491));
        cities.put (3348, new City (3348, "Pardubice", "CZE", 91309));
        cities.put (3349, new City (3349, "Tunis", "TUN", 690600));
        cities.put (3350, new City (3350, "Sfax", "TUN", 257800));
        cities.put (3351, new City (3351, "Ariana", "TUN", 197000));
        cities.put (3352, new City (3352, "Ettadhamen", "TUN", 178600));
        cities.put (3353, new City (3353, "Sousse", "TUN", 145900));
        cities.put (3354, new City (3354, "Kairouan", "TUN", 113100));
        cities.put (3355, new City (3355, "Biserta", "TUN", 108900));
        cities.put (3356, new City (3356, "GabÅ s", "TUN", 106600));
        cities.put (3357, new City (3357, "Istanbul", "TUR", 8787958));
        cities.put (3358, new City (3358, "Ankara", "TUR", 3038159));
        cities.put (3359, new City (3359, "Izmir", "TUR", 2130359));
        cities.put (3360, new City (3360, "Adana", "TUR", 1131198));
        cities.put (3361, new City (3361, "Bursa", "TUR", 1095842));
        cities.put (3362, new City (3362, "Gaziantep", "TUR", 789056));
        cities.put (3363, new City (3363, "Konya", "TUR", 628364));
        cities.put (3364, new City (3364, "Mersin (Iâ€¡el)", "TUR", 587212));
        cities.put (3365, new City (3365, "Antalya", "TUR", 564914));
        cities.put (3366, new City (3366, "Diyarbakir", "TUR", 479884));
        cities.put (3367, new City (3367, "Kayseri", "TUR", 475657));
        cities.put (3368, new City (3368, "Eskisehir", "TUR", 470781));
        cities.put (3369, new City (3369, "Sanliurfa", "TUR", 405905));
        cities.put (3370, new City (3370, "Samsun", "TUR", 339871));
        cities.put (3371, new City (3371, "Malatya", "TUR", 330312));
        cities.put (3372, new City (3372, "Gebze", "TUR", 264170));
        cities.put (3373, new City (3373, "Denizli", "TUR", 253848));
        cities.put (3374, new City (3374, "Sivas", "TUR", 246642));
        cities.put (3375, new City (3375, "Erzurum", "TUR", 246535));
        cities.put (3376, new City (3376, "Tarsus", "TUR", 246206));
        cities.put (3377, new City (3377, "Kahramanmaras", "TUR", 245772));
        cities.put (3378, new City (3378, "ElÆ’zig", "TUR", 228815));
        cities.put (3379, new City (3379, "Van", "TUR", 219319));
        cities.put (3380, new City (3380, "Sultanbeyli", "TUR", 211068));
        cities.put (3381, new City (3381, "Izmit (Kocaeli)", "TUR", 210068));
        cities.put (3382, new City (3382, "Manisa", "TUR", 207148));
        cities.put (3383, new City (3383, "Batman", "TUR", 203793));
        cities.put (3384, new City (3384, "Balikesir", "TUR", 196382));
        cities.put (3385, new City (3385, "Sakarya (Adapazari)", "TUR", 190641));
        cities.put (3386, new City (3386, "Iskenderun", "TUR", 153022));
        cities.put (3387, new City (3387, "Osmaniye", "TUR", 146003));
        cities.put (3388, new City (3388, "â‚¬orum", "TUR", 145495));
        cities.put (3389, new City (3389, "KÂ�tahya", "TUR", 144761));
        cities.put (3390, new City (3390, "Hatay (Antakya)", "TUR", 143982));
        cities.put (3391, new City (3391, "Kirikkale", "TUR", 142044));
        cities.put (3392, new City (3392, "Adiyaman", "TUR", 141529));
        cities.put (3393, new City (3393, "Trabzon", "TUR", 138234));
        cities.put (3394, new City (3394, "Ordu", "TUR", 133642));
        cities.put (3395, new City (3395, "Aydin", "TUR", 128651));
        cities.put (3396, new City (3396, "Usak", "TUR", 128162));
        cities.put (3397, new City (3397, "Edirne", "TUR", 123383));
        cities.put (3398, new City (3398, "â‚¬orlu", "TUR", 123300));
        cities.put (3399, new City (3399, "Isparta", "TUR", 121911));
        cities.put (3400, new City (3400, "KarabÂ�k", "TUR", 118285));
        cities.put (3401, new City (3401, "Kilis", "TUR", 118245));
        cities.put (3402, new City (3402, "Alanya", "TUR", 117300));
        cities.put (3403, new City (3403, "Kiziltepe", "TUR", 112000));
        cities.put (3404, new City (3404, "Zonguldak", "TUR", 111542));
        cities.put (3405, new City (3405, "Siirt", "TUR", 107100));
        cities.put (3406, new City (3406, "Viransehir", "TUR", 106400));
        cities.put (3407, new City (3407, "Tekirdag", "TUR", 106077));
        cities.put (3408, new City (3408, "Karaman", "TUR", 104200));
        cities.put (3409, new City (3409, "Afyon", "TUR", 103984));
        cities.put (3410, new City (3410, "Aksaray", "TUR", 102681));
        cities.put (3411, new City (3411, "Ceyhan", "TUR", 102412));
        cities.put (3412, new City (3412, "Erzincan", "TUR", 102304));
        cities.put (3413, new City (3413, "Bismil", "TUR", 101400));
        cities.put (3414, new City (3414, "Nazilli", "TUR", 99900));
        cities.put (3415, new City (3415, "Tokat", "TUR", 99500));
        cities.put (3416, new City (3416, "Kars", "TUR", 93000));
        cities.put (3417, new City (3417, "Inegâ€�l", "TUR", 90500));
        cities.put (3418, new City (3418, "Bandirma", "TUR", 90200));
        cities.put (3419, new City (3419, "Ashgabat", "TKM", 540600));
        cities.put (3420, new City (3420, "Châ€žrjew", "TKM", 189200));
        cities.put (3421, new City (3421, "Dashhowuz", "TKM", 141800));
        cities.put (3422, new City (3422, "Mary", "TKM", 101000));
        cities.put (3423, new City (3423, "Cockburn Town", "TCA", 4800));
        cities.put (3424, new City (3424, "Funafuti", "TUV", 4600));
        cities.put (3425, new City (3425, "Kampala", "UGA", 890800));
        cities.put (3426, new City (3426, "Kyiv", "UKR", 2624000));
        cities.put (3427, new City (3427, "Harkova [Harkiv]", "UKR", 1500000));
        cities.put (3428, new City (3428, "Dnipropetrovsk", "UKR", 1103000));
        cities.put (3429, new City (3429, "Donetsk", "UKR", 1050000));
        cities.put (3430, new City (3430, "Odesa", "UKR", 1011000));
        cities.put (3431, new City (3431, "Zaporizzja", "UKR", 848000));
        cities.put (3432, new City (3432, "Lviv", "UKR", 788000));
        cities.put (3433, new City (3433, "Kryvyi Rig", "UKR", 703000));
        cities.put (3434, new City (3434, "Mykolajiv", "UKR", 508000));
        cities.put (3435, new City (3435, "Mariupol", "UKR", 490000));
        cities.put (3436, new City (3436, "Lugansk", "UKR", 469000));
        cities.put (3437, new City (3437, "Vinnytsja", "UKR", 391000));
        cities.put (3438, new City (3438, "Makijivka", "UKR", 384000));
        cities.put (3439, new City (3439, "Herson", "UKR", 353000));
        cities.put (3440, new City (3440, "Sevastopol", "UKR", 348000));
        cities.put (3441, new City (3441, "Simferopol", "UKR", 339000));
        cities.put (3442, new City (3442, "Pultava [Poltava]", "UKR", 313000));
        cities.put (3443, new City (3443, "T?ernigiv", "UKR", 313000));
        cities.put (3444, new City (3444, "T?erkasy", "UKR", 309000));
        cities.put (3445, new City (3445, "Gorlivka", "UKR", 299000));
        cities.put (3446, new City (3446, "Zytomyr", "UKR", 297000));
        cities.put (3447, new City (3447, "Sumy", "UKR", 294000));
        cities.put (3448, new City (3448, "Dniprodzerzynsk", "UKR", 270000));
        cities.put (3449, new City (3449, "Kirovograd", "UKR", 265000));
        cities.put (3450, new City (3450, "Hmelnytskyi", "UKR", 262000));
        cities.put (3451, new City (3451, "T?ernivtsi", "UKR", 259000));
        cities.put (3452, new City (3452, "Rivne", "UKR", 245000));
        cities.put (3453, new City (3453, "Krement?uk", "UKR", 239000));
        cities.put (3454, new City (3454, "Ivano-Frankivsk", "UKR", 237000));
        cities.put (3455, new City (3455, "Ternopil", "UKR", 236000));
        cities.put (3456, new City (3456, "Lutsk", "UKR", 217000));
        cities.put (3457, new City (3457, "Bila Tserkva", "UKR", 215000));
        cities.put (3458, new City (3458, "Kramatorsk", "UKR", 186000));
        cities.put (3459, new City (3459, "Melitopol", "UKR", 169000));
        cities.put (3460, new City (3460, "Kert?", "UKR", 162000));
        cities.put (3461, new City (3461, "Nikopol", "UKR", 149000));
        cities.put (3462, new City (3462, "Berdjansk", "UKR", 130000));
        cities.put (3463, new City (3463, "Pavlograd", "UKR", 127000));
        cities.put (3464, new City (3464, "Sjeverodonetsk", "UKR", 127000));
        cities.put (3465, new City (3465, "Slovjansk", "UKR", 127000));
        cities.put (3466, new City (3466, "Uzgorod", "UKR", 127000));
        cities.put (3467, new City (3467, "Alt?evsk", "UKR", 119000));
        cities.put (3468, new City (3468, "Lysyt?ansk", "UKR", 116000));
        cities.put (3469, new City (3469, "Jevpatorija", "UKR", 112000));
        cities.put (3470, new City (3470, "Kamjanets-Podilskyi", "UKR", 109000));
        cities.put (3471, new City (3471, "Jenakijeve", "UKR", 105000));
        cities.put (3472, new City (3472, "Krasnyi Lut?", "UKR", 101000));
        cities.put (3473, new City (3473, "Stahanov", "UKR", 101000));
        cities.put (3474, new City (3474, "Oleksandrija", "UKR", 99000));
        cities.put (3475, new City (3475, "Konotop", "UKR", 96000));
        cities.put (3476, new City (3476, "Kostjantynivka", "UKR", 95000));
        cities.put (3477, new City (3477, "Berdyt?iv", "UKR", 90000));
        cities.put (3478, new City (3478, "Izmajil", "UKR", 90000));
        cities.put (3479, new City (3479, "?ostka", "UKR", 90000));
        cities.put (3480, new City (3480, "Uman", "UKR", 90000));
        cities.put (3481, new City (3481, "Brovary", "UKR", 89000));
        cities.put (3482, new City (3482, "Mukat?eve", "UKR", 89000));
        cities.put (3483, new City (3483, "Budapest", "HUN", 1811552));
        cities.put (3484, new City (3484, "Debrecen", "HUN", 203648));
        cities.put (3485, new City (3485, "Miskolc", "HUN", 172357));
        cities.put (3486, new City (3486, "Szeged", "HUN", 158158));
        cities.put (3487, new City (3487, "Pâ€šcs", "HUN", 157332));
        cities.put (3488, new City (3488, "Gyâ€�r", "HUN", 127119));
        cities.put (3489, new City (3489, "NyiregyhÂ za", "HUN", 112419));
        cities.put (3490, new City (3490, "Kecskemâ€št", "HUN", 105606));
        cities.put (3491, new City (3491, "Szâ€škesfehâ€šrvÂ r", "HUN",
                105119));
        cities.put (3492, new City (3492, "Montevideo", "URY", 1236000));
        cities.put (3493, new City (3493, "Noumâ€ša", "NCL", 76293));
        cities.put (3494, new City (3494, "Auckland", "NZL", 381800));
        cities.put (3495, new City (3495, "Christchurch", "NZL", 324200));
        cities.put (3496, new City (3496, "Manukau", "NZL", 281800));
        cities.put (3497, new City (3497, "North Shore", "NZL", 187700));
        cities.put (3498, new City (3498, "Waitakere", "NZL", 170600));
        cities.put (3499, new City (3499, "Wellington", "NZL", 166700));
        cities.put (3500, new City (3500, "Dunedin", "NZL", 119600));
        cities.put (3501, new City (3501, "Hamilton", "NZL", 117100));
        cities.put (3502, new City (3502, "Lower Hutt", "NZL", 98100));
        cities.put (3503, new City (3503, "Toskent", "UZB", 2117500));
        cities.put (3504, new City (3504, "Namangan", "UZB", 370500));
        cities.put (3505, new City (3505, "Samarkand", "UZB", 361800));
        cities.put (3506, new City (3506, "Andijon", "UZB", 318600));
        cities.put (3507, new City (3507, "Buhoro", "UZB", 237100));
        cities.put (3508, new City (3508, "Karsi", "UZB", 194100));
        cities.put (3509, new City (3509, "Nukus", "UZB", 194100));
        cities.put (3510, new City (3510, "KÂ�kon", "UZB", 190100));
        cities.put (3511, new City (3511, "Fargona", "UZB", 180500));
        cities.put (3512, new City (3512, "Circik", "UZB", 146400));
        cities.put (3513, new City (3513, "Margilon", "UZB", 140800));
        cities.put (3514, new City (3514, "Å¡rgenc", "UZB", 138900));
        cities.put (3515, new City (3515, "Angren", "UZB", 128000));
        cities.put (3516, new City (3516, "Cizah", "UZB", 124800));
        cities.put (3517, new City (3517, "Navoi", "UZB", 116300));
        cities.put (3518, new City (3518, "Olmalik", "UZB", 114900));
        cities.put (3519, new City (3519, "Termiz", "UZB", 109500));
        cities.put (3520, new City (3520, "Minsk", "BLR", 1674000));
        cities.put (3521, new City (3521, "Gomel", "BLR", 475000));
        cities.put (3522, new City (3522, "Mogiljov", "BLR", 356000));
        cities.put (3523, new City (3523, "Vitebsk", "BLR", 340000));
        cities.put (3524, new City (3524, "Grodno", "BLR", 302000));
        cities.put (3525, new City (3525, "Brest", "BLR", 286000));
        cities.put (3526, new City (3526, "Bobruisk", "BLR", 221000));
        cities.put (3527, new City (3527, "Baranovit?i", "BLR", 167000));
        cities.put (3528, new City (3528, "Borisov", "BLR", 151000));
        cities.put (3529, new City (3529, "Pinsk", "BLR", 130000));
        cities.put (3530, new City (3530, "Or?a", "BLR", 124000));
        cities.put (3531, new City (3531, "Mozyr", "BLR", 110000));
        cities.put (3532, new City (3532, "Novopolotsk", "BLR", 106000));
        cities.put (3533, new City (3533, "Lida", "BLR", 101000));
        cities.put (3534, new City (3534, "Soligorsk", "BLR", 101000));
        cities.put (3535, new City (3535, "Molodet?no", "BLR", 97000));
        cities.put (3536, new City (3536, "Mata-Utu", "WLF", 1137));
        cities.put (3537, new City (3537, "Port-Vila", "VUT", 33700));
        cities.put (3538, new City (3538, "Cittâ€¦ del Vaticano", "VAT", 455));
        cities.put (3539, new City (3539, "Caracas", "VEN", 1975294));
        cities.put (3540, new City (3540, "MaracaÂ¡bo", "VEN", 1304776));
        cities.put (3541, new City (3541, "Barquisimeto", "VEN", 877239));
        cities.put (3542, new City (3542, "Valencia", "VEN", 794246));
        cities.put (3543, new City (3543, "Ciudad Guayana", "VEN", 663713));
        cities.put (3544, new City (3544, "Petare", "VEN", 488868));
        cities.put (3545, new City (3545, "Maracay", "VEN", 444443));
        cities.put (3546, new City (3546, "Barcelona", "VEN", 322267));
        cities.put (3547, new City (3547, "MaturÂ¡n", "VEN", 319726));
        cities.put (3548, new City (3548, "San CristÂ¢bal", "VEN", 319373));
        cities.put (3549, new City (3549, "Ciudad BolÂ¡var", "VEN", 301107));
        cities.put (3550, new City (3550, "CumanÂ ", "VEN", 293105));
        cities.put (3551, new City (3551, "Mâ€šrida", "VEN", 224887));
        cities.put (3552, new City (3552, "Cabimas", "VEN", 221329));
        cities.put (3553, new City (3553, "Barinas", "VEN", 217831));
        cities.put (3554, new City (3554, "Turmero", "VEN", 217499));
        cities.put (3555, new City (3555, "Baruta", "VEN", 207290));
        cities.put (3556, new City (3556, "Puerto Cabello", "VEN", 187722));
        cities.put (3557, new City (3557, "Santa Ana de Coro", "VEN", 185766));
        cities.put (3558, new City (3558, "Los Teques", "VEN", 178784));
        cities.put (3559, new City (3559, "Punto Fijo", "VEN", 167215));
        cities.put (3560, new City (3560, "Guarenas", "VEN", 165889));
        cities.put (3561, new City (3561, "Acarigua", "VEN", 158954));
        cities.put (3562, new City (3562, "Puerto La Cruz", "VEN", 155700));
        cities.put (3563, new City (3563, "Ciudad Losada", "VEN", 134501));
        cities.put (3564, new City (3564, "Guacara", "VEN", 131334));
        cities.put (3565, new City (3565, "Valera", "VEN", 130281));
        cities.put (3566, new City (3566, "Guanare", "VEN", 125621));
        cities.put (3567, new City (3567, "CarÂ£pano", "VEN", 119639));
        cities.put (3568, new City (3568, "Catia La Mar", "VEN", 117012));
        cities.put (3569, new City (3569, "El Tigre", "VEN", 116256));
        cities.put (3570, new City (3570, "Guatire", "VEN", 109121));
        cities.put (3571, new City (3571, "Calabozo", "VEN", 107146));
        cities.put (3572, new City (3572, "Pozuelos", "VEN", 105690));
        cities.put (3573, new City (3573, "Ciudad Ojeda", "VEN", 99354));
        cities.put (3574, new City (3574, "Ocumare del Tuy", "VEN", 97168));
        cities.put (3575, new City (3575, "Valle de la Pascua", "VEN", 95927));
        cities.put (3576, new City (3576, "Araure", "VEN", 94269));
        cities.put (3577, new City (3577, "San Fernando de Apure", "VEN", 93809));
        cities.put (3578, new City (3578, "San Felipe", "VEN", 90940));
        cities.put (3579, new City (3579, "El LimÂ¢n", "VEN", 90000));
        cities.put (3580, new City (3580, "Moscow", "RUS", 8389200));
        cities.put (3581, new City (3581, "St Petersburg", "RUS", 4694000));
        cities.put (3582, new City (3582, "Novosibirsk", "RUS", 1398800));
        cities.put (3583, new City (3583, "Nizni Novgorod", "RUS", 1357000));
        cities.put (3584, new City (3584, "Jekaterinburg", "RUS", 1266300));
        cities.put (3585, new City (3585, "Samara", "RUS", 1156100));
        cities.put (3586, new City (3586, "Omsk", "RUS", 1148900));
        cities.put (3587, new City (3587, "Kazan", "RUS", 1101000));
        cities.put (3588, new City (3588, "Ufa", "RUS", 1091200));
        cities.put (3589, new City (3589, "T?eljabinsk", "RUS", 1083200));
        cities.put (3590, new City (3590, "Rostov-na-Donu", "RUS", 1012700));
        cities.put (3591, new City (3591, "Perm", "RUS", 1009700));
        cities.put (3592, new City (3592, "Volgograd", "RUS", 993400));
        cities.put (3593, new City (3593, "Voronez", "RUS", 907700));
        cities.put (3594, new City (3594, "Krasnojarsk", "RUS", 875500));
        cities.put (3595, new City (3595, "Saratov", "RUS", 874000));
        cities.put (3596, new City (3596, "Toljatti", "RUS", 722900));
        cities.put (3597, new City (3597, "Uljanovsk", "RUS", 667400));
        cities.put (3598, new City (3598, "Izevsk", "RUS", 652800));
        cities.put (3599, new City (3599, "Krasnodar", "RUS", 639000));

    }

    public void createCities3600() {
        cities.put (3600, new City (3600, "Jaroslavl", "RUS", 616700));
        cities.put (3601, new City (3601, "Habarovsk", "RUS", 609400));
        cities.put (3602, new City (3602, "Vladivostok", "RUS", 606200));
        cities.put (3603, new City (3603, "Irkutsk", "RUS", 593700));
        cities.put (3604, new City (3604, "Barnaul", "RUS", 580100));
        cities.put (3605, new City (3605, "Novokuznetsk", "RUS", 561600));
        cities.put (3606, new City (3606, "Penza", "RUS", 532200));
        cities.put (3607, new City (3607, "Rjazan", "RUS", 529900));
        cities.put (3608, new City (3608, "Orenburg", "RUS", 523600));
        cities.put (3609, new City (3609, "Lipetsk", "RUS", 521000));
        cities.put (3610, new City (3610, "Nabereznyje T?elny", "RUS", 514700));
        cities.put (3611, new City (3611, "Tula", "RUS", 506100));
        cities.put (3612, new City (3612, "Tjumen", "RUS", 503400));
        cities.put (3613, new City (3613, "Kemerovo", "RUS", 492700));
        cities.put (3614, new City (3614, "Astrahan", "RUS", 486100));
        cities.put (3615, new City (3615, "Tomsk", "RUS", 482100));
        cities.put (3616, new City (3616, "Kirov", "RUS", 466200));
        cities.put (3617, new City (3617, "Ivanovo", "RUS", 459200));
        cities.put (3618, new City (3618, "T?eboksary", "RUS", 459200));
        cities.put (3619, new City (3619, "Brjansk", "RUS", 457400));
        cities.put (3620, new City (3620, "Tver", "RUS", 454900));
        cities.put (3621, new City (3621, "Kursk", "RUS", 443500));
        cities.put (3622, new City (3622, "Magnitogorsk", "RUS", 427900));
        cities.put (3623, new City (3623, "Kaliningrad", "RUS", 424400));
        cities.put (3624, new City (3624, "Nizni Tagil", "RUS", 390900));
        cities.put (3625, new City (3625, "Murmansk", "RUS", 376300));
        cities.put (3626, new City (3626, "Ulan-Ude", "RUS", 370400));
        cities.put (3627, new City (3627, "Kurgan", "RUS", 364700));
        cities.put (3628, new City (3628, "Arkangeli", "RUS", 361800));
        cities.put (3629, new City (3629, "Sot?i", "RUS", 358600));
        cities.put (3630, new City (3630, "Smolensk", "RUS", 353400));
        cities.put (3631, new City (3631, "Orjol", "RUS", 344500));
        cities.put (3632, new City (3632, "Stavropol", "RUS", 343300));
        cities.put (3633, new City (3633, "Belgorod", "RUS", 342000));
        cities.put (3634, new City (3634, "Kaluga", "RUS", 339300));
        cities.put (3635, new City (3635, "Vladimir", "RUS", 337100));
        cities.put (3636, new City (3636, "Mahat?kala", "RUS", 332800));
        cities.put (3637, new City (3637, "T?erepovets", "RUS", 324400));
        cities.put (3638, new City (3638, "Saransk", "RUS", 314800));
        cities.put (3639, new City (3639, "Tambov", "RUS", 312000));
        cities.put (3640, new City (3640, "Vladikavkaz", "RUS", 310100));
        cities.put (3641, new City (3641, "T?ita", "RUS", 309900));
        cities.put (3642, new City (3642, "Vologda", "RUS", 302500));
        cities.put (3643, new City (3643, "Veliki Novgorod", "RUS", 299500));
        cities.put (3644, new City (3644, "Komsomolsk-na-Amure", "RUS", 291600));
        cities.put (3645, new City (3645, "Kostroma", "RUS", 288100));
        cities.put (3646, new City (3646, "Volzski", "RUS", 286900));
        cities.put (3647, new City (3647, "Taganrog", "RUS", 284400));
        cities.put (3648, new City (3648, "Petroskoi", "RUS", 282100));
        cities.put (3649, new City (3649, "Bratsk", "RUS", 277600));
        cities.put (3650, new City (3650, "Dzerzinsk", "RUS", 277100));
        cities.put (3651, new City (3651, "Surgut", "RUS", 274900));
        cities.put (3652, new City (3652, "Orsk", "RUS", 273900));
        cities.put (3653, new City (3653, "Sterlitamak", "RUS", 265200));
        cities.put (3654, new City (3654, "Angarsk", "RUS", 264700));
        cities.put (3655, new City (3655, "Jo?kar-Ola", "RUS", 249200));
        cities.put (3656, new City (3656, "Rybinsk", "RUS", 239600));
        cities.put (3657, new City (3657, "Prokopjevsk", "RUS", 237300));
        cities.put (3658, new City (3658, "Niznevartovsk", "RUS", 233900));
        cities.put (3659, new City (3659, "Nalt?ik", "RUS", 233400));
        cities.put (3660, new City (3660, "Syktyvkar", "RUS", 229700));
        cities.put (3661, new City (3661, "Severodvinsk", "RUS", 229300));
        cities.put (3662, new City (3662, "Bijsk", "RUS", 225000));
        cities.put (3663, new City (3663, "Niznekamsk", "RUS", 223400));
        cities.put (3664, new City (3664, "Blagove?t?ensk", "RUS", 222000));
        cities.put (3665, new City (3665, "?ahty", "RUS", 221800));
        cities.put (3666, new City (3666, "Staryi Oskol", "RUS", 213800));
        cities.put (3667, new City (3667, "Zelenograd", "RUS", 207100));
        cities.put (3668, new City (3668, "Balakovo", "RUS", 206000));
        cities.put (3669, new City (3669, "Novorossijsk", "RUS", 203300));
        cities.put (3670, new City (3670, "Pihkova", "RUS", 201500));
        cities.put (3671, new City (3671, "Zlatoust", "RUS", 196900));
        cities.put (3672, new City (3672, "Jakutsk", "RUS", 195400));
        cities.put (3673, new City (3673, "Podolsk", "RUS", 194300));
        cities.put (3674, new City (3674, "Petropavlovsk-Kamt?atski", "RUS",
                194100));
        cities.put (3675, new City (3675, "Kamensk-Uralski", "RUS", 190600));
        cities.put (3676, new City (3676, "Engels", "RUS", 189000));
        cities.put (3677, new City (3677, "Syzran", "RUS", 186900));
        cities.put (3678, new City (3678, "Grozny", "RUS", 186000));
        cities.put (3679, new City (3679, "Novot?erkassk", "RUS", 184400));
        cities.put (3680, new City (3680, "Berezniki", "RUS", 181900));
        cities.put (3681, new City (3681, "Juzno-Sahalinsk", "RUS", 179200));
        cities.put (3682, new City (3682, "Volgodonsk", "RUS", 178200));
        cities.put (3683, new City (3683, "Abakan", "RUS", 169200));
        cities.put (3684, new City (3684, "Maikop", "RUS", 167300));
        cities.put (3685, new City (3685, "Miass", "RUS", 166200));
        cities.put (3686, new City (3686, "Armavir", "RUS", 164900));
        cities.put (3687, new City (3687, "Ljubertsy", "RUS", 163900));
        cities.put (3688, new City (3688, "Rubtsovsk", "RUS", 162600));
        cities.put (3689, new City (3689, "Kovrov", "RUS", 159900));
        cities.put (3690, new City (3690, "Nahodka", "RUS", 157700));
        cities.put (3691, new City (3691, "Ussurijsk", "RUS", 157300));
        cities.put (3692, new City (3692, "Salavat", "RUS", 156800));
        cities.put (3693, new City (3693, "Myti?t?i", "RUS", 155700));
        cities.put (3694, new City (3694, "Kolomna", "RUS", 150700));
        cities.put (3695, new City (3695, "Elektrostal", "RUS", 147000));
        cities.put (3696, new City (3696, "Murom", "RUS", 142400));
        cities.put (3697, new City (3697, "Kolpino", "RUS", 141200));
        cities.put (3698, new City (3698, "Norilsk", "RUS", 140800));
        cities.put (3699, new City (3699, "Almetjevsk", "RUS", 140700));
        cities.put (3700, new City (3700, "Novomoskovsk", "RUS", 138100));
        cities.put (3701, new City (3701, "Dimitrovgrad", "RUS", 137000));
        cities.put (3702, new City (3702, "Pervouralsk", "RUS", 136100));
        cities.put (3703, new City (3703, "Himki", "RUS", 133700));
        cities.put (3704, new City (3704, "Bala?iha", "RUS", 132900));
        cities.put (3705, new City (3705, "Nevinnomyssk", "RUS", 132600));
        cities.put (3706, new City (3706, "Pjatigorsk", "RUS", 132500));
        cities.put (3707, new City (3707, "Korolev", "RUS", 132400));
        cities.put (3708, new City (3708, "Serpuhov", "RUS", 132000));
        cities.put (3709, new City (3709, "Odintsovo", "RUS", 127400));
        cities.put (3710, new City (3710, "Orehovo-Zujevo", "RUS", 124900));
        cities.put (3711, new City (3711, "Kamy?in", "RUS", 124600));
        cities.put (3712, new City (3712, "Novot?eboksarsk", "RUS", 123400));
        cities.put (3713, new City (3713, "T?erkessk", "RUS", 121700));
        cities.put (3714, new City (3714, "At?insk", "RUS", 121600));
        cities.put (3715, new City (3715, "Magadan", "RUS", 121000));
        cities.put (3716, new City (3716, "Mit?urinsk", "RUS", 120700));
        cities.put (3717, new City (3717, "Kislovodsk", "RUS", 120400));
        cities.put (3718, new City (3718, "Jelets", "RUS", 119400));
        cities.put (3719, new City (3719, "Seversk", "RUS", 118600));
        cities.put (3720, new City (3720, "Noginsk", "RUS", 117200));
        cities.put (3721, new City (3721, "Velikije Luki", "RUS", 116300));
        cities.put (3722, new City (3722, "Novokuiby?evsk", "RUS", 116200));
        cities.put (3723, new City (3723, "Neftekamsk", "RUS", 115700));
        cities.put (3724, new City (3724, "Leninsk-Kuznetski", "RUS", 113800));
        cities.put (3725, new City (3725, "Oktjabrski", "RUS", 111500));
        cities.put (3726, new City (3726, "Sergijev Posad", "RUS", 111100));
        cities.put (3727, new City (3727, "Arzamas", "RUS", 110700));
        cities.put (3728, new City (3728, "Kiseljovsk", "RUS", 110000));
        cities.put (3729, new City (3729, "Novotroitsk", "RUS", 109600));
        cities.put (3730, new City (3730, "Obninsk", "RUS", 108300));
        cities.put (3731, new City (3731, "Kansk", "RUS", 107400));
        cities.put (3732, new City (3732, "Glazov", "RUS", 106300));
        cities.put (3733, new City (3733, "Solikamsk", "RUS", 106000));
        cities.put (3734, new City (3734, "Sarapul", "RUS", 105700));
        cities.put (3735, new City (3735, "Ust-Ilimsk", "RUS", 105200));
        cities.put (3736, new City (3736, "?t?olkovo", "RUS", 104900));
        cities.put (3737, new City (3737, "Mezduret?ensk", "RUS", 104400));
        cities.put (3738, new City (3738, "Usolje-Sibirskoje", "RUS", 103500));
        cities.put (3739, new City (3739, "Elista", "RUS", 103300));
        cities.put (3740, new City (3740, "Novo?ahtinsk", "RUS", 101900));
        cities.put (3741, new City (3741, "Votkinsk", "RUS", 101700));
        cities.put (3742, new City (3742, "Kyzyl", "RUS", 101100));
        cities.put (3743, new City (3743, "Serov", "RUS", 100400));
        cities.put (3744, new City (3744, "Zelenodolsk", "RUS", 100200));
        cities.put (3745, new City (3745, "Zeleznodoroznyi", "RUS", 100100));
        cities.put (3746, new City (3746, "Kine?ma", "RUS", 100000));
        cities.put (3747, new City (3747, "Kuznetsk", "RUS", 98200));
        cities.put (3748, new City (3748, "Uhta", "RUS", 98000));
        cities.put (3749, new City (3749, "Jessentuki", "RUS", 97900));
        cities.put (3750, new City (3750, "Tobolsk", "RUS", 97600));
        cities.put (3751, new City (3751, "Neftejugansk", "RUS", 97400));
        cities.put (3752, new City (3752, "Bataisk", "RUS", 97300));
        cities.put (3753, new City (3753, "Nojabrsk", "RUS", 97300));
        cities.put (3754, new City (3754, "Bala?ov", "RUS", 97100));
        cities.put (3755, new City (3755, "Zeleznogorsk", "RUS", 96900));
        cities.put (3756, new City (3756, "Zukovski", "RUS", 96500));
        cities.put (3757, new City (3757, "Anzero-Sudzensk", "RUS", 96100));
        cities.put (3758, new City (3758, "Bugulma", "RUS", 94100));
        cities.put (3759, new City (3759, "Zeleznogorsk", "RUS", 94000));
        cities.put (3760, new City (3760, "Novouralsk", "RUS", 93300));
        cities.put (3761, new City (3761, "Pu?kin", "RUS", 92900));
        cities.put (3762, new City (3762, "Vorkuta", "RUS", 92600));
        cities.put (3763, new City (3763, "Derbent", "RUS", 92300));
        cities.put (3764, new City (3764, "Kirovo-T?epetsk", "RUS", 91600));
        cities.put (3765, new City (3765, "Krasnogorsk", "RUS", 91000));
        cities.put (3766, new City (3766, "Klin", "RUS", 90000));
        cities.put (3767, new City (3767, "T?aikovski", "RUS", 90000));
        cities.put (3768, new City (3768, "Novyi Urengoi", "RUS", 89800));
        cities.put (3769, new City (3769, "Ho Chi Minh City", "VNM", 3980000));
        cities.put (3770, new City (3770, "Hanoi", "VNM", 1410000));
        cities.put (3771, new City (3771, "Haiphong", "VNM", 783133));
        cities.put (3772, new City (3772, "Da Nang", "VNM", 382674));
        cities.put (3773, new City (3773, "BiË†n Hoa", "VNM", 282095));
        cities.put (3774, new City (3774, "Nha Trang", "VNM", 221331));
        cities.put (3775, new City (3775, "Hue", "VNM", 219149));
        cities.put (3776, new City (3776, "Can Tho", "VNM", 215587));
        cities.put (3777, new City (3777, "Cam Pha", "VNM", 209086));
        cities.put (3778, new City (3778, "Nam Dinh", "VNM", 171699));
        cities.put (3779, new City (3779, "Quy Nhon", "VNM", 163385));
        cities.put (3780, new City (3780, "Vung Tau", "VNM", 145145));
        cities.put (3781, new City (3781, "Rach Gia", "VNM", 141132));
        cities.put (3782, new City (3782, "Long Xuyen", "VNM", 132681));
        cities.put (3783, new City (3783, "Thai Nguyen", "VNM", 127643));
        cities.put (3784, new City (3784, "Hong Gai", "VNM", 127484));
        cities.put (3785, new City (3785, "Phan ThiË†t", "VNM", 114236));
        cities.put (3786, new City (3786, "Cam Ranh", "VNM", 114041));
        cities.put (3787, new City (3787, "Vinh", "VNM", 112455));
        cities.put (3788, new City (3788, "My Tho", "VNM", 108404));
        cities.put (3789, new City (3789, "Da Lat", "VNM", 106409));
        cities.put (3790, new City (3790, "Buon Ma Thuot", "VNM", 97044));
        cities.put (3791, new City (3791, "Tallinn", "EST", 403981));
        cities.put (3792, new City (3792, "Tartu", "EST", 101246));
        cities.put (3793, new City (3793, "New York", "USA", 8008278));
        cities.put (3794, new City (3794, "Los Angeles", "USA", 3694820));
        cities.put (3795, new City (3795, "Chicago", "USA", 2896016));
        cities.put (3796, new City (3796, "Houston", "USA", 1953631));
        cities.put (3797, new City (3797, "Philadelphia", "USA", 1517550));
        cities.put (3798, new City (3798, "Phoenix", "USA", 1321045));
        cities.put (3799, new City (3799, "San Diego", "USA", 1223400));
        cities.put (3800, new City (3800, "Dallas", "USA", 1188580));
        cities.put (3801, new City (3801, "San Antonio", "USA", 1144646));
        cities.put (3802, new City (3802, "Detroit", "USA", 951270));
        cities.put (3803, new City (3803, "San Jose", "USA", 894943));
        cities.put (3804, new City (3804, "Indianapolis", "USA", 791926));
        cities.put (3805, new City (3805, "San Francisco", "USA", 776733));
        cities.put (3806, new City (3806, "Jacksonville", "USA", 735167));
        cities.put (3807, new City (3807, "Columbus", "USA", 711470));
        cities.put (3808, new City (3808, "Austin", "USA", 656562));
        cities.put (3809, new City (3809, "Baltimore", "USA", 651154));
        cities.put (3810, new City (3810, "Memphis", "USA", 650100));
        cities.put (3811, new City (3811, "Milwaukee", "USA", 596974));
        cities.put (3812, new City (3812, "Boston", "USA", 589141));
        cities.put (3813, new City (3813, "Washington", "USA", 572059));
        cities.put (3814, new City (3814, "Nashville-Davidson", "USA", 569891));
        cities.put (3815, new City (3815, "El Paso", "USA", 563662));
        cities.put (3816, new City (3816, "Seattle", "USA", 563374));
        cities.put (3817, new City (3817, "Denver", "USA", 554636));
        cities.put (3818, new City (3818, "Charlotte", "USA", 540828));
        cities.put (3819, new City (3819, "Fort Worth", "USA", 534694));
        cities.put (3820, new City (3820, "Portland", "USA", 529121));
        cities.put (3821, new City (3821, "Oklahoma City", "USA", 506132));
        cities.put (3822, new City (3822, "Tucson", "USA", 486699));
        cities.put (3823, new City (3823, "New Orleans", "USA", 484674));
        cities.put (3824, new City (3824, "Las Vegas", "USA", 478434));
        cities.put (3825, new City (3825, "Cleveland", "USA", 478403));
        cities.put (3826, new City (3826, "Long Beach", "USA", 461522));
        cities.put (3827, new City (3827, "Albuquerque", "USA", 448607));
        cities.put (3828, new City (3828, "Kansas City", "USA", 441545));
        cities.put (3829, new City (3829, "Fresno", "USA", 427652));
        cities.put (3830, new City (3830, "Virginia Beach", "USA", 425257));
        cities.put (3831, new City (3831, "Atlanta", "USA", 416474));
        cities.put (3832, new City (3832, "Sacramento", "USA", 407018));
        cities.put (3833, new City (3833, "Oakland", "USA", 399484));
        cities.put (3834, new City (3834, "Mesa", "USA", 396375));
        cities.put (3835, new City (3835, "Tulsa", "USA", 393049));
        cities.put (3836, new City (3836, "Omaha", "USA", 390007));
        cities.put (3837, new City (3837, "Minneapolis", "USA", 382618));
        cities.put (3838, new City (3838, "Honolulu", "USA", 371657));
        cities.put (3839, new City (3839, "Miami", "USA", 362470));
        cities.put (3840, new City (3840, "Colorado Springs", "USA", 360890));
        cities.put (3841, new City (3841, "Saint Louis", "USA", 348189));
        cities.put (3842, new City (3842, "Wichita", "USA", 344284));
        cities.put (3843, new City (3843, "Santa Ana", "USA", 337977));
        cities.put (3844, new City (3844, "Pittsburgh", "USA", 334563));
        cities.put (3845, new City (3845, "Arlington", "USA", 332969));
        cities.put (3846, new City (3846, "Cincinnati", "USA", 331285));
        cities.put (3847, new City (3847, "Anaheim", "USA", 328014));
        cities.put (3848, new City (3848, "Toledo", "USA", 313619));
        cities.put (3849, new City (3849, "Tampa", "USA", 303447));
        cities.put (3850, new City (3850, "Buffalo", "USA", 292648));
        cities.put (3851, new City (3851, "Saint Paul", "USA", 287151));
        cities.put (3852, new City (3852, "Corpus Christi", "USA", 277454));
        cities.put (3853, new City (3853, "Aurora", "USA", 276393));
        cities.put (3854, new City (3854, "Raleigh", "USA", 276093));
        cities.put (3855, new City (3855, "Newark", "USA", 273546));
        cities.put (3856, new City (3856, "Lexington-Fayette", "USA", 260512));
        cities.put (3857, new City (3857, "Anchorage", "USA", 260283));
        cities.put (3858, new City (3858, "Louisville", "USA", 256231));
        cities.put (3859, new City (3859, "Riverside", "USA", 255166));
        cities.put (3860, new City (3860, "Saint Petersburg", "USA", 248232));
        cities.put (3861, new City (3861, "Bakersfield", "USA", 247057));
        cities.put (3862, new City (3862, "Stockton", "USA", 243771));
        cities.put (3863, new City (3863, "Birmingham", "USA", 242820));
        cities.put (3864, new City (3864, "Jersey City", "USA", 240055));
        cities.put (3865, new City (3865, "Norfolk", "USA", 234403));
        cities.put (3866, new City (3866, "Baton Rouge", "USA", 227818));
        cities.put (3867, new City (3867, "Hialeah", "USA", 226419));
        cities.put (3868, new City (3868, "Lincoln", "USA", 225581));
        cities.put (3869, new City (3869, "Greensboro", "USA", 223891));
        cities.put (3870, new City (3870, "Plano", "USA", 222030));
        cities.put (3871, new City (3871, "Rochester", "USA", 219773));
        cities.put (3872, new City (3872, "Glendale", "USA", 218812));
        cities.put (3873, new City (3873, "Akron", "USA", 217074));
        cities.put (3874, new City (3874, "Garland", "USA", 215768));
        cities.put (3875, new City (3875, "Madison", "USA", 208054));
        cities.put (3876, new City (3876, "Fort Wayne", "USA", 205727));
        cities.put (3877, new City (3877, "Fremont", "USA", 203413));
        cities.put (3878, new City (3878, "Scottsdale", "USA", 202705));
        cities.put (3879, new City (3879, "Montgomery", "USA", 201568));
        cities.put (3880, new City (3880, "Shreveport", "USA", 200145));
        cities.put (3881, new City (3881, "Augusta-Richmond County", "USA",
                199775));
        cities.put (3882, new City (3882, "Lubbock", "USA", 199564));
        cities.put (3883, new City (3883, "Chesapeake", "USA", 199184));
        cities.put (3884, new City (3884, "Mobile", "USA", 198915));
        cities.put (3885, new City (3885, "Des Moines", "USA", 198682));
        cities.put (3886, new City (3886, "Grand Rapids", "USA", 197800));
        cities.put (3887, new City (3887, "Richmond", "USA", 197790));
        cities.put (3888, new City (3888, "Yonkers", "USA", 196086));
        cities.put (3889, new City (3889, "Spokane", "USA", 195629));
        cities.put (3890, new City (3890, "Glendale", "USA", 194973));
        cities.put (3891, new City (3891, "Tacoma", "USA", 193556));
        cities.put (3892, new City (3892, "Irving", "USA", 191615));
        cities.put (3893, new City (3893, "Huntington Beach", "USA", 189594));
        cities.put (3894, new City (3894, "Modesto", "USA", 188856));
        cities.put (3895, new City (3895, "Durham", "USA", 187035));
        cities.put (3896, new City (3896, "Columbus", "USA", 186291));
        cities.put (3897, new City (3897, "Orlando", "USA", 185951));
        cities.put (3898, new City (3898, "Boise City", "USA", 185787));
        cities.put (3899, new City (3899, "Winston-Salem", "USA", 185776));
        cities.put (3900, new City (3900, "San Bernardino", "USA", 185401));
        cities.put (3901, new City (3901, "Jackson", "USA", 184256));
        cities.put (3902, new City (3902, "Little Rock", "USA", 183133));
        cities.put (3903, new City (3903, "Salt Lake City", "USA", 181743));
        cities.put (3904, new City (3904, "Reno", "USA", 180480));
        cities.put (3905, new City (3905, "Newport News", "USA", 180150));
        cities.put (3906, new City (3906, "Chandler", "USA", 176581));
        cities.put (3907, new City (3907, "Laredo", "USA", 176576));
        cities.put (3908, new City (3908, "Henderson", "USA", 175381));
        cities.put (3909, new City (3909, "Arlington", "USA", 174838));
        cities.put (3910, new City (3910, "Knoxville", "USA", 173890));
        cities.put (3911, new City (3911, "Amarillo", "USA", 173627));
        cities.put (3912, new City (3912, "Providence", "USA", 173618));
        cities.put (3913, new City (3913, "Chula Vista", "USA", 173556));
        cities.put (3914, new City (3914, "Worcester", "USA", 172648));
        cities.put (3915, new City (3915, "Oxnard", "USA", 170358));
        cities.put (3916, new City (3916, "Dayton", "USA", 166179));
        cities.put (3917, new City (3917, "Garden Grove", "USA", 165196));
        cities.put (3918, new City (3918, "Oceanside", "USA", 161029));
        cities.put (3919, new City (3919, "Tempe", "USA", 158625));
        cities.put (3920, new City (3920, "Huntsville", "USA", 158216));
        cities.put (3921, new City (3921, "Ontario", "USA", 158007));
        cities.put (3922, new City (3922, "Chattanooga", "USA", 155554));
        cities.put (3923, new City (3923, "Fort Lauderdale", "USA", 152397));
        cities.put (3924, new City (3924, "Springfield", "USA", 152082));
        cities.put (3925, new City (3925, "Springfield", "USA", 151580));
        cities.put (3926, new City (3926, "Santa Clarita", "USA", 151088));
        cities.put (3927, new City (3927, "Salinas", "USA", 151060));
        cities.put (3928, new City (3928, "Tallahassee", "USA", 150624));
        cities.put (3929, new City (3929, "Rockford", "USA", 150115));
        cities.put (3930, new City (3930, "Pomona", "USA", 149473));
        cities.put (3931, new City (3931, "Metairie", "USA", 149428));
        cities.put (3932, new City (3932, "Paterson", "USA", 149222));
        cities.put (3933, new City (3933, "Overland Park", "USA", 149080));
        cities.put (3934, new City (3934, "Santa Rosa", "USA", 147595));
        cities.put (3935, new City (3935, "Syracuse", "USA", 147306));
        cities.put (3936, new City (3936, "Kansas City", "USA", 146866));
        cities.put (3937, new City (3937, "Hampton", "USA", 146437));
        cities.put (3938, new City (3938, "Lakewood", "USA", 144126));
        cities.put (3939, new City (3939, "Vancouver", "USA", 143560));
        cities.put (3940, new City (3940, "Irvine", "USA", 143072));
        cities.put (3941, new City (3941, "Aurora", "USA", 142990));
        cities.put (3942, new City (3942, "Moreno Valley", "USA", 142381));
        cities.put (3943, new City (3943, "Pasadena", "USA", 141674));
        cities.put (3944, new City (3944, "Hayward", "USA", 140030));
        cities.put (3945, new City (3945, "Brownsville", "USA", 139722));
        cities.put (3946, new City (3946, "Bridgeport", "USA", 139529));
        cities.put (3947, new City (3947, "Hollywood", "USA", 139357));
        cities.put (3948, new City (3948, "Warren", "USA", 138247));
        cities.put (3949, new City (3949, "Torrance", "USA", 137946));
        cities.put (3950, new City (3950, "Eugene", "USA", 137893));
        cities.put (3951, new City (3951, "Pembroke Pines", "USA", 137427));
        cities.put (3952, new City (3952, "Salem", "USA", 136924));
        cities.put (3953, new City (3953, "Pasadena", "USA", 133936));
        cities.put (3954, new City (3954, "Escondido", "USA", 133559));
        cities.put (3955, new City (3955, "Sunnyvale", "USA", 131760));
        cities.put (3956, new City (3956, "Savannah", "USA", 131510));
        cities.put (3957, new City (3957, "Fontana", "USA", 128929));
        cities.put (3958, new City (3958, "Orange", "USA", 128821));
        cities.put (3959, new City (3959, "Naperville", "USA", 128358));
        cities.put (3960, new City (3960, "Alexandria", "USA", 128283));
        cities.put (3961, new City (3961, "Rancho Cucamonga", "USA", 127743));
        cities.put (3962, new City (3962, "Grand Prairie", "USA", 127427));
        cities.put (3963, new City (3963, "East Los Angeles", "USA", 126379));
        cities.put (3964, new City (3964, "Fullerton", "USA", 126003));
        cities.put (3965, new City (3965, "Corona", "USA", 124966));
        cities.put (3966, new City (3966, "Flint", "USA", 124943));
        cities.put (3967, new City (3967, "Paradise", "USA", 124682));
        cities.put (3968, new City (3968, "Mesquite", "USA", 124523));
        cities.put (3969, new City (3969, "Sterling Heights", "USA", 124471));
        cities.put (3970, new City (3970, "Sioux Falls", "USA", 123975));
        cities.put (3971, new City (3971, "New Haven", "USA", 123626));
        cities.put (3972, new City (3972, "Topeka", "USA", 122377));
        cities.put (3973, new City (3973, "Concord", "USA", 121780));
        cities.put (3974, new City (3974, "Evansville", "USA", 121582));
        cities.put (3975, new City (3975, "Hartford", "USA", 121578));
        cities.put (3976, new City (3976, "Fayetteville", "USA", 121015));
        cities.put (3977, new City (3977, "Cedar Rapids", "USA", 120758));
        cities.put (3978, new City (3978, "Elizabeth", "USA", 120568));
        cities.put (3979, new City (3979, "Lansing", "USA", 119128));
        cities.put (3980, new City (3980, "Lancaster", "USA", 118718));
        cities.put (3981, new City (3981, "Fort Collins", "USA", 118652));
        cities.put (3982, new City (3982, "Coral Springs", "USA", 117549));
        cities.put (3983, new City (3983, "Stamford", "USA", 117083));
        cities.put (3984, new City (3984, "Thousand Oaks", "USA", 117005));
        cities.put (3985, new City (3985, "Vallejo", "USA", 116760));
        cities.put (3986, new City (3986, "Palmdale", "USA", 116670));
        cities.put (3987, new City (3987, "Columbia", "USA", 116278));
        cities.put (3988, new City (3988, "El Monte", "USA", 115965));
        cities.put (3989, new City (3989, "Abilene", "USA", 115930));
        cities.put (3990, new City (3990, "North Las Vegas", "USA", 115488));
        cities.put (3991, new City (3991, "Ann Arbor", "USA", 114024));
        cities.put (3992, new City (3992, "Beaumont", "USA", 113866));
        cities.put (3993, new City (3993, "Waco", "USA", 113726));
        cities.put (3994, new City (3994, "Macon", "USA", 113336));
        cities.put (3995, new City (3995, "Independence", "USA", 113288));
        cities.put (3996, new City (3996, "Peoria", "USA", 112936));
        cities.put (3997, new City (3997, "Inglewood", "USA", 112580));
        cities.put (3998, new City (3998, "Springfield", "USA", 111454));
        cities.put (3999, new City (3999, "Simi Valley", "USA", 111351));
        cities.put (4000, new City (4000, "Lafayette", "USA", 110257));
        cities.put (4001, new City (4001, "Gilbert", "USA", 109697));
        cities.put (4002, new City (4002, "Carrollton", "USA", 109576));
        cities.put (4003, new City (4003, "Bellevue", "USA", 109569));
        cities.put (4004, new City (4004, "West Valley City", "USA", 108896));
        cities.put (4005, new City (4005, "Clarksville", "USA", 108787));
        cities.put (4006, new City (4006, "Costa Mesa", "USA", 108724));
        cities.put (4007, new City (4007, "Peoria", "USA", 108364));
        cities.put (4008, new City (4008, "South Bend", "USA", 107789));
        cities.put (4009, new City (4009, "Downey", "USA", 107323));
        cities.put (4010, new City (4010, "Waterbury", "USA", 107271));
        cities.put (4011, new City (4011, "Manchester", "USA", 107006));
        cities.put (4012, new City (4012, "Allentown", "USA", 106632));
        cities.put (4013, new City (4013, "McAllen", "USA", 106414));
        cities.put (4014, new City (4014, "Joliet", "USA", 106221));
        cities.put (4015, new City (4015, "Lowell", "USA", 105167));
        cities.put (4016, new City (4016, "Provo", "USA", 105166));
        cities.put (4017, new City (4017, "West Covina", "USA", 105080));
        cities.put (4018, new City (4018, "Wichita Falls", "USA", 104197));
        cities.put (4019, new City (4019, "Erie", "USA", 103717));
        cities.put (4020, new City (4020, "Daly City", "USA", 103621));
        cities.put (4021, new City (4021, "Citrus Heights", "USA", 103455));
        cities.put (4022, new City (4022, "Norwalk", "USA", 103298));
        cities.put (4023, new City (4023, "Gary", "USA", 102746));
        cities.put (4024, new City (4024, "Berkeley", "USA", 102743));
        cities.put (4025, new City (4025, "Santa Clara", "USA", 102361));
        cities.put (4026, new City (4026, "Green Bay", "USA", 102313));
        cities.put (4027, new City (4027, "Cape Coral", "USA", 102286));
        cities.put (4028, new City (4028, "Arvada", "USA", 102153));
        cities.put (4029, new City (4029, "Pueblo", "USA", 102121));
        cities.put (4030, new City (4030, "Sandy", "USA", 101853));
        cities.put (4031, new City (4031, "Athens-Clarke County", "USA", 101489));
        cities.put (4032, new City (4032, "Cambridge", "USA", 101355));
        cities.put (4033, new City (4033, "Westminster", "USA", 100940));
        cities.put (4034, new City (4034, "San Buenaventura", "USA", 100916));
        cities.put (4035, new City (4035, "Portsmouth", "USA", 100565));
        cities.put (4036, new City (4036, "Livonia", "USA", 100545));
        cities.put (4037, new City (4037, "Burbank", "USA", 100316));
        cities.put (4038, new City (4038, "Clearwater", "USA", 99936));
        cities.put (4039, new City (4039, "Midland", "USA", 98293));
        cities.put (4040, new City (4040, "Davenport", "USA", 98256));
        cities.put (4041, new City (4041, "Mission Viejo", "USA", 98049));
        cities.put (4042, new City (4042, "Miami Beach", "USA", 97855));
        cities.put (4043, new City (4043, "Sunrise Manor", "USA", 95362));
        cities.put (4044, new City (4044, "New Bedford", "USA", 94780));
        cities.put (4045, new City (4045, "El Cajon", "USA", 94578));
        cities.put (4046, new City (4046, "Norman", "USA", 94193));
        cities.put (4047, new City (4047, "Richmond", "USA", 94100));
        cities.put (4048, new City (4048, "Albany", "USA", 93994));
        cities.put (4049, new City (4049, "Brockton", "USA", 93653));
        cities.put (4050, new City (4050, "Roanoke", "USA", 93357));
        cities.put (4051, new City (4051, "Billings", "USA", 92988));
        cities.put (4052, new City (4052, "Compton", "USA", 92864));
        cities.put (4053, new City (4053, "Gainesville", "USA", 92291));
        cities.put (4054, new City (4054, "Fairfield", "USA", 92256));
        cities.put (4055, new City (4055, "Arden-Arcade", "USA", 92040));
        cities.put (4056, new City (4056, "San Mateo", "USA", 91799));
        cities.put (4057, new City (4057, "Visalia", "USA", 91762));
        cities.put (4058, new City (4058, "Boulder", "USA", 91238));
        cities.put (4059, new City (4059, "Cary", "USA", 91213));
        cities.put (4060, new City (4060, "Santa Monica", "USA", 91084));
        cities.put (4061, new City (4061, "Fall River", "USA", 90555));
        cities.put (4062, new City (4062, "Kenosha", "USA", 89447));
        cities.put (4063, new City (4063, "Elgin", "USA", 89408));
        cities.put (4064, new City (4064, "Odessa", "USA", 89293));
        cities.put (4065, new City (4065, "Carson", "USA", 89089));
        cities.put (4066, new City (4066, "Charleston", "USA", 89063));
        cities.put (4067, new City (4067, "Charlotte Amalie", "VIR", 13000));
        cities.put (4068, new City (4068, "Harare", "ZWE", 1410000));
        cities.put (4069, new City (4069, "Bulawayo", "ZWE", 621742));
        cities.put (4070, new City (4070, "Chitungwiza", "ZWE", 274912));
        cities.put (4071, new City (4071, "Mount Darwin", "ZWE", 164362));
        cities.put (4072, new City (4072, "Mutare", "ZWE", 131367));
        cities.put (4073, new City (4073, "Gweru", "ZWE", 128037));
        cities.put (4074, new City (4074, "Gaza", "PSE", 353632));
        cities.put (4075, new City (4075, "Khan Yunis", "PSE", 123175));
        cities.put (4076, new City (4076, "Hebron", "PSE", 119401));
        cities.put (4077, new City (4077, "Jabaliya", "PSE", 113901));
        cities.put (4078, new City (4078, "Nablus", "PSE", 100231));
        cities.put (4079, new City (4079, "Rafah", "PSE", 92020));
    }

    public void createCountries() {
        countries.put ("ABW", new Country ("ABW", "Aruba", "North America",
                103000, 193.00, 828.00, 129));
        countries.put ("AFG", new Country ("AFG", "Afghanistan", "Asia",
                22720000, 652090.00, 5976.00, 1));
        countries.put ("AGO", new Country ("AGO", "Angola", "Africa", 12878000,
                1246700.00, 6648.00, 56));
        countries.put ("AIA", new Country ("AIA", "Anguilla", "North America",
                8000, 96.00, 63.20, 62));
        countries.put ("ALB", new Country ("ALB", "Albania", "Europe", 3401200,
                28748.00, 3205.00, 34));
        countries.put ("AND", new Country ("AND", "Andorra", "Europe", 78000,
                468.00, 1630.00, 55));
        countries.put ("ANT", new Country ("ANT", "Netherlands Antilles",
                "North America", 217000, 800.00, 1941.00, 33));
        countries.put ("ARE", new Country ("ARE", "United Arab Emirates", "Asia",
                2441000, 83600.00, 37966.00, 65));
        countries.put ("ARG", new Country ("ARG", "Argentina", "South America",
                37032000, 2780400.00, 340238.00, 69));
        countries.put ("ARM", new Country ("ARM", "Armenia", "Asia", 3520000,
                29800.00, 1813.00, 126));
        countries.put ("ASM", new Country ("ASM", "American Samoa", "Oceania",
                68000, 199.00, 334.00, 54));
        countries.put ("ATA", new Country ("ATA", "Antarctica", "Antarctica", 0,
                13120000.00, 0.00, -1));
        countries.put ("ATF", new Country ("ATF", "French Southern territories",
                "Antarctica", 0, 7780.00, 0.00, -1));
        countries.put ("ATG", new Country ("ATG", "Antigua and Barbuda",
                "North America", 68000, 442.00, 612.00, 63));
        countries.put ("AUS", new Country ("AUS", "Australia", "Oceania",
                18886000, 7741220.00, 351182.00, 135));
        countries.put ("AUT", new Country ("AUT", "Austria", "Europe", 8091800,
                83859.00, 211860.00, 1523));
        countries.put ("AZE", new Country ("AZE", "Azerbaijan", "Asia", 7734000,
                86600.00, 4127.00, 144));
        countries.put ("BDI", new Country ("BDI", "Burundi", "Africa", 6695000,
                27834.00, 903.00, 552));
        countries.put ("BEL", new Country ("BEL", "Belgium", "Europe", 10239000,
                30518.00, 249704.00, 179));
        countries.put ("BEN", new Country ("BEN", "Benin", "Africa", 6097000,
                112622.00, 2357.00, 187));
        countries.put ("BFA", new Country ("BFA", "Burkina Faso", "Africa",
                11937000, 274000.00, 2425.00, 549));
        countries.put ("BGD", new Country ("BGD", "Bangladesh", "Asia",
                129155000, 143998.00, 32852.00, 150));
        countries.put ("BGR", new Country ("BGR", "Bulgaria", "Europe", 8190900,
                110994.00, 12178.00, 539));
        countries.put ("BHR", new Country ("BHR", "Bahrain", "Asia", 617000,
                694.00, 6366.00, 149));
        countries.put ("BHS", new Country ("BHS", "Bahamas", "North America",
                307000, 13878.00, 3527.00, 148));
        countries.put ("BIH", new Country ("BIH", "Bosnia and Herzegovina",
                "Europe", 3972000, 51197.00, 2841.00, 201));
        countries.put ("BLR", new Country ("BLR", "Belarus", "Europe", 10236000,
                207600.00, 13714.00, 3520));
        countries.put ("BLZ", new Country ("BLZ", "Belize", "North America",
                241000, 22696.00, 630.00, 185));
        countries.put ("BMU", new Country ("BMU", "Bermuda", "North America",
                65000, 53.00, 2328.00, 191));
        countries.put ("BOL", new Country ("BOL", "Bolivia", "South America",
                8329000, 1098581.00, 8571.00, 194));
        countries.put ("BRA", new Country ("BRA", "Brazil", "South America",
                170115000, 8547403.00, 776739.00, 211));
        countries.put ("BRB", new Country ("BRB", "Barbados", "North America",
                270000, 430.00, 2223.00, 174));
        countries.put ("BRN", new Country ("BRN", "Brunei", "Asia", 328000,
                5765.00, 11705.00, 538));
        countries.put ("BTN", new Country ("BTN", "Bhutan", "Asia", 2124000,
                47000.00, 372.00, 192));
        countries.put ("BVT", new Country ("BVT", "Bouvet Island", "Antarctica",
                0, 59.00, 0.00, -1));
        countries.put ("BWA", new Country ("BWA", "Botswana", "Africa", 1622000,
                581730.00, 4834.00, 204));
        countries.put ("CAF", new Country ("CAF", "Central African Republic",
                "Africa", 3615000, 622984.00, 1054.00, 1889));
        countries.put ("CAN", new Country ("CAN", "Canada", "North America",
                31147000, 9970610.00, 598862.00, 1822));
        countries.put ("CCK", new Country ("CCK", "Cocos (Keeling) Islands",
                "Oceania", 600, 14.00, 0.00, 2317));
        countries.put ("CHE", new Country ("CHE", "Switzerland", "Europe",
                7160400, 41284.00, 264478.00, 3248));
        countries.put ("CHL", new Country ("CHL", "Chile", "South America",
                15211000, 756626.00, 72949.00, 554));
        countries.put ("CHN", new Country ("CHN", "China", "Asia", 1277558000,
                9572900.00, 982268.00, 1891));
        countries.put ("CIV", new Country ("CIV", "Câ€œte d?Ivoire",
                "Africa", 14786000, 322463.00, 11345.00, 2814));
        countries.put ("CMR", new Country ("CMR", "Cameroon", "Africa", 15085000,
                475442.00, 9174.00, 1804));
        countries.put ("COD", new Country ("COD",
                "Congo, The Democratic Republic of the", "Africa", 51654000,
                2344858.00, 6964.00, 2298));
        countries.put ("COG", new Country ("COG", "Congo", "Africa", 2943000,
                342000.00, 2108.00, 2296));
        countries.put ("COK", new Country ("COK", "Cook Islands", "Oceania",
                20000, 236.00, 100.00, 583));
        countries.put ("COL", new Country ("COL", "Colombia", "South America",
                42321000, 1138914.00, 102896.00, 2257));
        countries.put ("COM", new Country ("COM", "Comoros", "Africa", 578000,
                1862.00, 4401.00, 2295));
        countries.put ("CPV", new Country ("CPV", "Cape Verde", "Africa", 428000,
                4033.00, 435.00, 1859));
        countries.put ("CRI", new Country ("CRI", "Costa Rica", "North America",
                4023000, 51100.00, 10226.00, 584));
        countries.put ("CUB", new Country ("CUB", "Cuba", "North America",
                11201000, 110861.00, 17843.00, 2413));
        countries.put ("CXR", new Country ("CXR", "Christmas Island", "Oceania",
                2500, 135.00, 0.00, 1791));
        countries.put ("CYM", new Country ("CYM", "Cayman Islands",
                "North America", 38000, 264.00, 1263.00, 553));
        countries.put ("CYP", new Country ("CYP", "Cyprus", "Asia", 754700,
                9251.00, 9333.00, 2430));
        countries.put ("CZE", new Country ("CZE", "Czech Republic", "Europe",
                10278100, 78866.00, 55017.00, 3339));
        countries.put ("DEU", new Country ("DEU", "Germany", "Europe", 82164700,
                357022.00, 2133367.00, 3068));
        countries.put ("DJI", new Country ("DJI", "Djibouti", "Africa", 638000,
                23200.00, 382.00, 585));
        countries.put ("DMA", new Country ("DMA", "Dominica", "North America",
                71000, 751.00, 256.00, 586));
        countries.put ("DNK", new Country ("DNK", "Denmark", "Europe", 5330000,
                43094.00, 174099.00, 3315));
        countries.put ("DOM", new Country ("DOM", "Dominican Republic",
                "North America", 8495000, 48511.00, 15846.00, 587));
        countries.put ("DZA", new Country ("DZA", "Algeria", "Africa", 31471000,
                2381741.00, 49982.00, 35));
        countries.put ("ECU", new Country ("ECU", "Ecuador", "South America",
                12646000, 283561.00, 19770.00, 594));
        countries.put ("EGY", new Country ("EGY", "Egypt", "Africa", 68470000,
                1001449.00, 82710.00, 608));
        countries.put ("ERI", new Country ("ERI", "Eritrea", "Africa", 3850000,
                117600.00, 650.00, 652));
        countries.put ("ESH", new Country ("ESH", "Western Sahara", "Africa",
                293000, 266000.00, 60.00, 2453));
        countries.put ("ESP", new Country ("ESP", "Spain", "Europe", 39441700,
                505992.00, 553233.00, 653));
        countries.put ("EST", new Country ("EST", "Estonia", "Europe", 1439200,
                45227.00, 5328.00, 3791));
        countries.put ("ETH", new Country ("ETH", "Ethiopia", "Africa", 62565000,
                1104300.00, 6353.00, 756));
        countries.put ("FIN", new Country ("FIN", "Finland", "Europe", 5171300,
                338145.00, 121914.00, 3236));
        countries.put ("FJI", new Country ("FJI", "Fiji Islands", "Oceania",
                817000, 18274.00, 1536.00, 764));
        countries.put ("FLK", new Country ("FLK", "Falkland Islands",
                "South America", 2000, 12173.00, 0.00, 763));
        countries.put ("FRA", new Country ("FRA", "France", "Europe", 59225700,
                551500.00, 1424285.00, 2974));
        countries.put ("FRO", new Country ("FRO", "Faroe Islands", "Europe",
                43000, 1399.00, 0.00, 901));
        countries.put ("FSM", new Country ("FSM",
                "Micronesia, Federated States of", "Oceania", 119000, 702.00,
                212.00, 2689));
        countries.put ("GAB", new Country ("GAB", "Gabon", "Africa", 1226000,
                267668.00, 5493.00, 902));
        countries.put ("GBR", new Country ("GBR", "United Kingdom", "Europe",
                59623400, 242900.00, 1378330.00, 456));
        countries.put ("GEO", new Country ("GEO", "Georgia", "Asia", 4968000,
                69700.00, 6064.00, 905));
        countries.put ("GHA", new Country ("GHA", "Ghana", "Africa", 20212000,
                238533.00, 7137.00, 910));
        countries.put ("GIB", new Country ("GIB", "Gibraltar", "Europe", 25000,
                6.00, 258.00, 915));
        countries.put ("GIN", new Country ("GIN", "Guinea", "Africa", 7430000,
                245857.00, 2352.00, 926));
        countries.put ("GLP", new Country ("GLP", "Guadeloupe", "North America",
                456000, 1705.00, 3501.00, 919));
        countries.put ("GMB", new Country ("GMB", "Gambia", "Africa", 1305000,
                11295.00, 320.00, 904));
        countries.put ("GNB", new Country ("GNB", "Guinea-Bissau", "Africa",
                1213000, 36125.00, 293.00, 927));
        countries.put ("GNQ", new Country ("GNQ", "Equatorial Guinea", "Africa",
                453000, 28051.00, 283.00, 2972));
        countries.put ("GRC", new Country ("GRC", "Greece", "Europe", 10545700,
                131626.00, 120724.00, 2401));
        countries.put ("GRD", new Country ("GRD", "Grenada", "North America",
                94000, 344.00, 318.00, 916));
        countries.put ("GRL", new Country ("GRL", "Greenland", "North America",
                56000, 2166090.00, 0.00, 917));
        countries.put ("GTM", new Country ("GTM", "Guatemala", "North America",
                11385000, 108889.00, 19008.00, 922));
        countries.put ("GUF", new Country ("GUF", "French Guiana",
                "South America", 181000, 90000.00, 681.00, 3014));
        countries.put ("GUM", new Country ("GUM", "Guam", "Oceania", 168000,
                549.00, 1197.00, 921));
        countries.put ("GUY", new Country ("GUY", "Guyana", "South America",
                861000, 214969.00, 722.00, 928));
        countries.put ("HKG", new Country ("HKG", "Hong Kong", "Asia", 6782000,
                1075.00, 166448.00, 937));
        countries.put ("HMD", new Country ("HMD",
                "Heard Island and McDonald Islands", "Antarctica", 0, 359.00,
                0.00, -1));
        countries.put ("HND", new Country ("HND", "Honduras", "North America",
                6485000, 112088.00, 5333.00, 933));
        countries.put ("HRV", new Country ("HRV", "Croatia", "Europe", 4473000,
                56538.00, 20208.00, 2409));
        countries.put ("HTI", new Country ("HTI", "Haiti", "North America",
                8222000, 27750.00, 3459.00, 929));
        countries.put ("HUN", new Country ("HUN", "Hungary", "Europe", 10043200,
                93030.00, 48267.00, 3483));
        countries.put ("IDN", new Country ("IDN", "Indonesia", "Asia", 212107000,
                1904569.00, 84982.00, 939));
        countries.put ("IND", new Country ("IND", "India", "Asia", 1013662000,
                3287263.00, 447114.00, 1109));
        countries
                .put ("IOT", new Country ("IOT",
                        "British Indian Ocean Territory", "Africa", 0, 78.00,
                        0.00, -1));
        countries.put ("IRL", new Country ("IRL", "Ireland", "Europe", 3775100,
                70273.00, 75921.00, 1447));
        countries.put ("IRN", new Country ("IRN", "Iran", "Asia", 67702000,
                1648195.00, 195746.00, 1380));
        countries.put ("IRQ", new Country ("IRQ", "Iraq", "Asia", 23115000,
                438317.00, 11500.00, 1365));
        countries.put ("ISL", new Country ("ISL", "Iceland", "Europe", 279000,
                103000.00, 8255.00, 1449));
        countries.put ("ISR", new Country ("ISR", "Israel", "Asia", 6217000,
                21056.00, 97477.00, 1450));
        countries.put ("ITA", new Country ("ITA", "Italy", "Europe", 57680000,
                301316.00, 1161755.00, 1464));
        countries.put ("JAM", new Country ("JAM", "Jamaica", "North America",
                2583000, 10990.00, 6871.00, 1530));
        countries.put ("JOR", new Country ("JOR", "Jordan", "Asia", 5083000,
                88946.00, 7526.00, 1786));
        countries.put ("JPN", new Country ("JPN", "Japan", "Asia", 126714000,
                377829.00, 3787042.00, 1532));
        countries.put ("KAZ", new Country ("KAZ", "Kazakstan", "Asia", 16223000,
                2724900.00, 24375.00, 1864));
        countries.put ("KEN", new Country ("KEN", "Kenya", "Africa", 30080000,
                580367.00, 9217.00, 1881));
        countries.put ("KGZ", new Country ("KGZ", "Kyrgyzstan", "Asia", 4699000,
                199900.00, 1626.00, 2253));
        countries.put ("KHM", new Country ("KHM", "Cambodia", "Asia", 11168000,
                181035.00, 5121.00, 1800));
        countries.put ("KIR", new Country ("KIR", "Kiribati", "Oceania", 83000,
                726.00, 40.70, 2256));
        countries.put ("KNA", new Country ("KNA", "Saint Kitts and Nevis",
                "North America", 38000, 261.00, 299.00, 3064));
        countries.put ("KOR", new Country ("KOR", "South Korea", "Asia",
                46844000, 99434.00, 320749.00, 2331));
        countries.put ("KWT", new Country ("KWT", "Kuwait", "Asia", 1972000,
                17818.00, 27037.00, 2429));
        countries.put ("LAO", new Country ("LAO", "Laos", "Asia", 5433000,
                236800.00, 1292.00, 2432));
        countries.put ("LBN", new Country ("LBN", "Lebanon", "Asia", 3282000,
                10400.00, 17121.00, 2438));
        countries.put ("LBR", new Country ("LBR", "Liberia", "Africa", 3154000,
                111369.00, 2012.00, 2440));
        countries.put ("LBY", new Country ("LBY", "Libyan Arab Jamahiriya",
                "Africa", 5605000, 1759540.00, 44806.00, 2441));
        countries.put ("LCA", new Country ("LCA", "Saint Lucia", "North America",
                154000, 622.00, 571.00, 3065));
        countries.put ("LIE", new Country ("LIE", "Liechtenstein", "Europe",
                32300, 160.00, 1119.00, 2446));
        countries.put ("LKA", new Country ("LKA", "Sri Lanka", "Asia", 18827000,
                65610.00, 15706.00, 3217));
        countries.put ("LSO", new Country ("LSO", "Lesotho", "Africa", 2153000,
                30355.00, 1061.00, 2437));
        countries.put ("LTU", new Country ("LTU", "Lithuania", "Europe", 3698500,
                65301.00, 10692.00, 2447));
        countries.put ("LUX", new Country ("LUX", "Luxembourg", "Europe", 435700,
                2586.00, 16321.00, 2452));
        countries.put ("LVA", new Country ("LVA", "Latvia", "Europe", 2424200,
                64589.00, 6398.00, 2434));
        countries.put ("MAC", new Country ("MAC", "Macao", "Asia", 473000, 18.00,
                5749.00, 2454));
        countries.put ("MAR", new Country ("MAR", "Morocco", "Africa", 28351000,
                446550.00, 36124.00, 2486));
        countries.put ("MCO", new Country ("MCO", "Monaco", "Europe", 34000,
                1.50, 776.00, 2695));
        countries.put ("MDA", new Country ("MDA", "Moldova", "Europe", 4380000,
                33851.00, 1579.00, 2690));
        countries.put ("MDG", new Country ("MDG", "Madagascar", "Africa",
                15942000, 587041.00, 3750.00, 2455));
        countries.put ("MDV", new Country ("MDV", "Maldives", "Asia", 286000,
                298.00, 199.00, 2463));
        countries.put ("MEX", new Country ("MEX", "Mexico", "North America",
                98881000, 1958201.00, 414972.00, 2515));
        countries.put ("MHL", new Country ("MHL", "Marshall Islands", "Oceania",
                64000, 181.00, 97.00, 2507));
        countries.put ("MKD", new Country ("MKD", "Macedonia", "Europe", 2024000,
                25713.00, 1694.00, 2460));
        countries.put ("MLI", new Country ("MLI", "Mali", "Africa", 11234000,
                1240192.00, 2642.00, 2482));
        countries.put ("MLT", new Country ("MLT", "Malta", "Europe", 380200,
                316.00, 3512.00, 2484));
        countries.put ("MMR", new Country ("MMR", "Myanmar", "Asia", 45611000,
                676578.00, 180375.00, 2710));
        countries.put ("MNG", new Country ("MNG", "Mongolia", "Asia", 2662000,
                1566500.00, 1043.00, 2696));
        countries.put ("MNP", new Country ("MNP", "Northern Mariana Islands",
                "Oceania", 78000, 464.00, 0.00, 2913));
        countries.put ("MOZ", new Country ("MOZ", "Mozambique", "Africa",
                19680000, 801590.00, 2891.00, 2698));
        countries.put ("MRT", new Country ("MRT", "Mauritania", "Africa",
                2670000, 1025520.00, 998.00, 2509));
        countries.put ("MSR", new Country ("MSR", "Montserrat", "North America",
                11000, 102.00, 109.00, 2697));
        countries.put ("MTQ", new Country ("MTQ", "Martinique", "North America",
                395000, 1102.00, 2731.00, 2508));
        countries.put ("MUS", new Country ("MUS", "Mauritius", "Africa", 1158000,
                2040.00, 4251.00, 2511));
        countries.put ("MWI", new Country ("MWI", "Malawi", "Africa", 10925000,
                118484.00, 1687.00, 2462));
        countries.put ("MYS", new Country ("MYS", "Malaysia", "Asia", 22244000,
                329758.00, 69213.00, 2464));
        countries.put ("MYT", new Country ("MYT", "Mayotte", "Africa", 149000,
                373.00, 0.00, 2514));
        countries.put ("NAM", new Country ("NAM", "Namibia", "Africa", 1726000,
                824292.00, 3101.00, 2726));
        countries.put ("NCL", new Country ("NCL", "New Caledonia", "Oceania",
                214000, 18575.00, 3563.00, 3493));
        countries.put ("NER", new Country ("NER", "Niger", "Africa", 10730000,
                1267000.00, 1706.00, 2738));
        countries.put ("NFK", new Country ("NFK", "Norfolk Island", "Oceania",
                2000, 36.00, 0.00, 2806));
        countries.put ("NGA", new Country ("NGA", "Nigeria", "Africa", 111506000,
                923768.00, 65707.00, 2754));
        countries.put ("NIC", new Country ("NIC", "Nicaragua", "North America",
                5074000, 130000.00, 1988.00, 2734));
        countries.put ("NIU", new Country ("NIU", "Niue", "Oceania", 2000,
                260.00, 0.00, 2805));
        countries.put ("NLD", new Country ("NLD", "Netherlands", "Europe",
                15864000, 41526.00, 371362.00, 5));
        countries.put ("NOR", new Country ("NOR", "Norway", "Europe", 4478500,
                323877.00, 145895.00, 2807));
        countries.put ("NPL", new Country ("NPL", "Nepal", "Asia", 23930000,
                147181.00, 4768.00, 2729));
        countries.put ("NRU", new Country ("NRU", "Nauru", "Oceania", 12000,
                21.00, 197.00, 2728));
        countries.put ("NZL", new Country ("NZL", "New Zealand", "Oceania",
                3862000, 270534.00, 54669.00, 3499));
        countries.put ("OMN", new Country ("OMN", "Oman", "Asia", 2542000,
                309500.00, 16904.00, 2821));
        countries.put ("PAK", new Country ("PAK", "Pakistan", "Asia", 156483000,
                796095.00, 61289.00, 2831));
        countries.put ("PAN", new Country ("PAN", "Panama", "North America",
                2856000, 75517.00, 9131.00, 2882));
        countries.put ("PCN", new Country ("PCN", "Pitcairn", "Oceania", 50,
                49.00, 0.00, 2912));
        countries.put ("PER", new Country ("PER", "Peru", "South America",
                25662000, 1285216.00, 64140.00, 2890));
        countries.put ("PHL", new Country ("PHL", "Philippines", "Asia",
                75967000, 300000.00, 65107.00, 766));
        countries.put ("PLW", new Country ("PLW", "Palau", "Oceania", 19000,
                459.00, 105.00, 2881));
        countries.put ("PNG", new Country ("PNG", "Papua New Guinea", "Oceania",
                4807000, 462840.00, 4988.00, 2884));
        countries.put ("POL", new Country ("POL", "Poland", "Europe", 38653600,
                323250.00, 151697.00, 2928));
        countries.put ("PRI", new Country ("PRI", "Puerto Rico", "North America",
                3869000, 8875.00, 34100.00, 2919));
        countries.put ("PRK", new Country ("PRK", "North Korea", "Asia",
                24039000, 120538.00, 5332.00, 2318));
        countries.put ("PRT", new Country ("PRT", "Portugal", "Europe", 9997600,
                91982.00, 105954.00, 2914));
        countries.put ("PRY", new Country ("PRY", "Paraguay", "South America",
                5496000, 406752.00, 8444.00, 2885));
        countries.put ("PSE", new Country ("PSE", "Palestine", "Asia", 3101000,
                6257.00, 4173.00, 4074));
        countries.put ("PYF", new Country ("PYF", "French Polynesia", "Oceania",
                235000, 4000.00, 818.00, 3016));
        countries.put ("QAT", new Country ("QAT", "Qatar", "Asia", 599000,
                11000.00, 9472.00, 2973));
        countries.put ("REU", new Country ("REU", "Râ€šunion", "Africa",
                699000, 2510.00, 8287.00, 3017));
        countries.put ("ROM", new Country ("ROM", "Romania", "Europe", 22455500,
                238391.00, 38158.00, 3018));
        countries.put ("RUS", new Country ("RUS", "Russian Federation", "Europe",
                146934000, 17075400.00, 276608.00, 3580));
        countries.put ("RWA", new Country ("RWA", "Rwanda", "Africa", 7733000,
                26338.00, 2036.00, 3047));
        countries.put ("SAU", new Country ("SAU", "Saudi Arabia", "Asia",
                21607000, 2149690.00, 137635.00, 3173));
        countries.put ("SDN", new Country ("SDN", "Sudan", "Africa", 29490000,
                2505813.00, 10162.00, 3225));
        countries.put ("SEN", new Country ("SEN", "Senegal", "Africa", 9481000,
                196722.00, 4787.00, 3198));
        countries.put ("SGP", new Country ("SGP", "Singapore", "Asia", 3567000,
                618.00, 86503.00, 3208));
        countries.put ("SGS", new Country ("SGS",
                "South Georgia and the South Sandwich Islands", "Antarctica",
                0, 3903.00, 0.00, -1));
        countries.put ("SHN", new Country ("SHN", "Saint Helena", "Africa", 6000,
                314.00, 0.00, 3063));
        countries.put ("SJM", new Country ("SJM", "Svalbard and Jan Mayen",
                "Europe", 3200, 62422.00, 0.00, 938));
        countries.put ("SLB", new Country ("SLB", "Solomon Islands", "Oceania",
                444000, 28896.00, 182.00, 3161));
        countries.put ("SLE", new Country ("SLE", "Sierra Leone", "Africa",
                4854000, 71740.00, 746.00, 3207));
        countries.put ("SLV", new Country ("SLV", "El Salvador", "North America",
                6276000, 21041.00, 11863.00, 645));
        countries.put ("SMR", new Country ("SMR", "San Marino", "Europe", 27000,
                61.00, 510.00, 3171));
        countries.put ("SOM", new Country ("SOM", "Somalia", "Africa", 10097000,
                637657.00, 935.00, 3214));
        countries.put ("SPM", new Country ("SPM", "Saint Pierre and Miquelon",
                "North America", 7000, 242.00, 0.00, 3067));
        countries.put ("STP", new Country ("STP", "Sao Tome and Principe",
                "Africa", 147000, 964.00, 6.00, 3172));
        countries.put ("SUR", new Country ("SUR", "Suriname", "South America",
                417000, 163265.00, 870.00, 3243));
        countries.put ("SVK", new Country ("SVK", "Slovakia", "Europe", 5398700,
                49012.00, 20594.00, 3209));
        countries.put ("SVN", new Country ("SVN", "Slovenia", "Europe", 1987800,
                20256.00, 19756.00, 3212));
        countries.put ("SWE", new Country ("SWE", "Sweden", "Europe", 8861400,
                449964.00, 226492.00, 3048));
        countries.put ("SWZ", new Country ("SWZ", "Swaziland", "Africa", 1008000,
                17364.00, 1206.00, 3244));
        countries.put ("SYC", new Country ("SYC", "Seychelles", "Africa", 77000,
                455.00, 536.00, 3206));
        countries.put ("SYR", new Country ("SYR", "Syria", "Asia", 16125000,
                185180.00, 65984.00, 3250));
        countries.put ("TCA", new Country ("TCA", "Turks and Caicos Islands",
                "North America", 17000, 430.00, 96.00, 3423));
        countries.put ("TCD", new Country ("TCD", "Chad", "Africa", 7651000,
                1284000.00, 1208.00, 3337));
        countries.put ("TGO", new Country ("TGO", "Togo", "Africa", 4629000,
                56785.00, 1449.00, 3332));
        countries.put ("THA", new Country ("THA", "Thailand", "Asia", 61399000,
                513115.00, 116416.00, 3320));
        countries.put ("TJK", new Country ("TJK", "Tajikistan", "Asia", 6188000,
                143100.00, 1990.00, 3261));
        countries.put ("TKL", new Country ("TKL", "Tokelau", "Oceania", 2000,
                12.00, 0.00, 3333));
        countries.put ("TKM", new Country ("TKM", "Turkmenistan", "Asia",
                4459000, 488100.00, 4397.00, 3419));
        countries.put ("TMP", new Country ("TMP", "East Timor", "Asia", 885000,
                14874.00, 0.00, 1522));
        countries.put ("TON", new Country ("TON", "Tonga", "Oceania", 99000,
                650.00, 146.00, 3334));
        countries.put ("TTO", new Country ("TTO", "Trinidad and Tobago",
                "North America", 1295000, 5130.00, 6232.00, 3336));
        countries.put ("TUN", new Country ("TUN", "Tunisia", "Africa", 9586000,
                163610.00, 20026.00, 3349));
        countries.put ("TUR", new Country ("TUR", "Turkey", "Asia", 66591000,
                774815.00, 210721.00, 3358));
        countries.put ("TUV", new Country ("TUV", "Tuvalu", "Oceania", 12000,
                26.00, 6.00, 3424));
        countries.put ("TWN", new Country ("TWN", "Taiwan", "Asia", 22256000,
                36188.00, 256254.00, 3263));
        countries.put ("TZA", new Country ("TZA", "Tanzania", "Africa", 33517000,
                883749.00, 8005.00, 3306));
        countries.put ("UGA", new Country ("UGA", "Uganda", "Africa", 21778000,
                241038.00, 6313.00, 3425));
        countries.put ("UKR", new Country ("UKR", "Ukraine", "Europe", 50456000,
                603700.00, 42168.00, 3426));
        countries.put ("UMI", new Country ("UMI",
                "United States Minor Outlying Islands", "Oceania", 0, 16.00,
                0.00, -1));
        countries.put ("URY", new Country ("URY", "Uruguay", "South America",
                3337000, 175016.00, 20831.00, 3492));
        countries.put ("USA", new Country ("USA", "United States",
                "North America", 278357000, 9363520.00, 8510700.00, 3813));
        countries.put ("UZB", new Country ("UZB", "Uzbekistan", "Asia", 24318000,
                447400.00, 14194.00, 3503));
        countries.put ("VAT", new Country ("VAT",
                "Holy See (Vatican City State)", "Europe", 1000, 0.40, 9.00,
                3538));
        countries.put ("VCT", new Country ("VCT",
                "Saint Vincent and the Grenadines", "North America", 114000,
                388.00, 285.00, 3066));
        countries.put ("VEN", new Country ("VEN", "Venezuela", "South America",
                24170000, 912050.00, 95023.00, 3539));
        countries.put ("VGB", new Country ("VGB", "Virgin Islands, British",
                "North America", 21000, 151.00, 612.00, 537));
        countries.put ("VIR", new Country ("VIR", "Virgin Islands, U.S.",
                "North America", 93000, 347.00, 0.00, 4067));
        countries.put ("VNM", new Country ("VNM", "Vietnam", "Asia", 79832000,
                331689.00, 21929.00, 3770));
        countries.put ("VUT", new Country ("VUT", "Vanuatu", "Oceania", 190000,
                12189.00, 261.00, 3537));
        countries.put ("WLF", new Country ("WLF", "Wallis and Futuna", "Oceania",
                15000, 200.00, 0.00, 3536));
        countries.put ("WSM", new Country ("WSM", "Samoa", "Oceania", 180000,
                2831.00, 141.00, 3169));
        countries.put ("YEM", new Country ("YEM", "Yemen", "Asia", 18112000,
                527968.00, 6041.00, 1780));
        countries.put ("YUG", new Country ("YUG", "Yugoslavia", "Europe",
                10640000, 102173.00, 17000.00, 1792));
        countries.put ("ZAF", new Country ("ZAF", "South Africa", "Africa",
                40377000, 1221037.00, 116729.00, 716));
        countries.put ("ZMB", new Country ("ZMB", "Zambia", "Africa", 9169000,
                752618.00, 3377.00, 3162));
        countries.put ("ZWE", new Country ("ZWE", "Zimbabwe", "Africa", 11669000,
                390757.00, 5951.00, 4068));
    }

    @Override
    public Country findCountryByCode(String code) {
        return countries.get (code);
    }

    @Override
    public Country removeCountry(Country country) {
        return null;
    }



    @Override
    public Country addCountry(Country country) {
        continents.add (country.getContinent ());
        return countries.put (country.getCode (), country);
    }

    @Override
    public Country updateCountry(Country country) {
        if (countries.get (country.getCode ()) != null)
            return countries.put (country.getCode (), country);
        return null;
    }

    @Override
    public Set<String> getAllContinents() {
        return continents;
    }

    @Override
    public List<Country> readCountriesFromFile(String fileName) {
        List<String> lines = Collections.emptyList ();
        ArrayList<Country> countries = new ArrayList<> ();
        try {
            lines = Files.readAllLines (Paths.get (fileName));

            ListIterator iterator = lines.listIterator ();
            while (iterator.hasNext ()) {
                String line = (String) iterator.next ();
                StringTokenizer tokenizer = new StringTokenizer (line, ",");
                String token = tokenizer.nextToken ();
                String token1 = tokenizer.nextToken ();
                String token2 = tokenizer.nextToken ();
                Country country = new Country ();
                country.setCode (token);
                country.setName (token1);
                country.setPopulation (Integer.parseInt (token2.trim ()));
                countries.add (country);

            }

        } catch (IOException e) { // TODO Auto-generated catch block
            e.printStackTrace ();
        }
        return countries;
    }


    @Override
    public List<Country> findCountriesByContinent(String continent) {
        List<Country> result = new ArrayList<> ();
        for (Country country : countries.values ())
            if (continent.equals (country.getContinent ()))
                result.add (country);
        return result;
    }

    @Override
    public List<Country> findAllCountries() {
        return new ArrayList<> (countries.values ());
    }

    @Override
    public City findCityById(int id) {
        return cities.get (id);
    }

    @Override
    public City removeCity(City city) {
        return null;
    }



    @Override
    public City addCity(City city) {
        if (!cities.containsKey (city.getId ()))
            return cities.put (city.getId (), city);
        return null;
    }

    @Override
    public City updateCity(City city) {
        if (cities.containsKey (city.getId ()))
            return cities.put (city.getId (), city);
        return null;
    }

    @Override
    public List<City> findAllCities() {
        return new ArrayList<> (cities.values ());
    }

    @Override
    public List<City> findCitiesByCountryCode(String countryCode) {
        return findCountryByCode (countryCode).getCities ();
    }

    @Override
    public List<City> readCitiesFromFile(String fileName) {
        List<String> lines = Collections.emptyList ();
        ArrayList<City> cities = new ArrayList<> ();
        try {
            lines = Files.readAllLines (Paths.get (fileName));

            ListIterator iterator = lines.listIterator ();
            while (iterator.hasNext ()) {
                String line = (String) iterator.next ();
                StringTokenizer tokenizer = new StringTokenizer (line, ",");
                String id = tokenizer.nextToken ();
                String name = tokenizer.nextToken ();
                String population = tokenizer.nextToken ();
                String countryCode = tokenizer.nextToken ();
                City city = new City ();
                city.setId (Integer.parseInt (id.trim ()));
                city.setName (name);
                city.setPopulation (Integer.parseInt (population.trim ()));
                city.setCountryCode (countryCode);
                cities.add (city);

            }

        } catch (IOException e) { // TODO Auto-generated catch block
            e.printStackTrace ();
        }
        return cities;
    }

}
