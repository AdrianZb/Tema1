

import java.util.*;

public class PenguinFun {

    public static void main(String[] args) {

        List<Penguin> penguins = new ArrayList<Penguin>();
        Set<Penguin> setPenguins = new HashSet<Penguin>();

        populatePenguinsListOrSet(penguins);
        populatePenguinsListOrSet(setPenguins);

        printPenguinListOrSet(penguins);
        printPenguinListOrSet(setPenguins);
        //diferenta ar fi ca set-ul nu permite duplicate si ca nu garanteaza o ordine la afisare

        sortPenguinsListByRaceThenAge(penguins);

        printPenguinListOrSet(penguins);

        //pentru a sorta un set, il facem intr-o lista si sortam lista
        List<Penguin> sortedPenguinSet = new ArrayList<>(setPenguins);
        sortPenguinsListByRaceThenAge(sortedPenguinSet);
        printPenguinListOrSet(sortedPenguinSet);

        generatePenguinMate(penguins);
        printPenguinListOrSet(penguins);

        sortPenguinsListWithMatesByNumberOfMatingPenguinsThenAverageAgeThenNameInitialPenguin(penguins);
        printPenguinListOrSet(penguins);

        Map<String, List<Penguin>> penguinMap = new HashMap<String, List<Penguin>>();
        puplateMapOfPenguinsByRace(penguinMap, penguins);
        printMapOfPenguins(penguinMap);


        //optional exercise
        Map<Penguin, Integer> mapPenguin = new HashMap<Penguin, Integer>();
        Penguin penguin = populateMapWithManyPenguins(mapPenguin);
        getRandomElementFromHugeMap(mapPenguin, penguin);
        //if we change the result of the hashCode to return the same result always, the program takes much longer to complete

    }

    public static void printPenguinListOrSet(Collection<Penguin> penguins) {
        for (Penguin p : penguins) {
            System.out.println(p);
        }
        System.out.println("===========================================================================");
    }

    public static void sortPenguinsListByRaceThenAge(List<Penguin> penguins) {
        Collections.sort(penguins, new Comparator<Penguin>() {
            @Override
            public int compare(Penguin p1, Penguin p2) {
                if (p1.getRace().toString().compareTo(p2.getRace().toString()) == 0) {
                    if (p1.getAge() < p2.getAge()) {
                        return -1;
                    } else if (p1.getAge() == p2.getAge()) {
                        return 0;
                    } else {
                        return 1;
                    }
                }
                return p1.getRace().toString().compareTo(p2.getRace().toString());
            }
        });
    }

    public static void populatePenguinsListOrSet(Collection<Penguin> penguins) {
        PenguinHatchery penguinHatchery = new PenguinHatchery();
        for (int i = 0; i < 20; i++) {
            penguins.add(penguinHatchery.hatchPenguin());
        }
    }

    public static void generatePenguinMate(List<Penguin> penguins) {
        PenguinHatchery penguinHatchery = new PenguinHatchery();
        for (Penguin p : penguins) {
            List<Penguin> matingPartners = new ArrayList<Penguin>();
            for (int i = 0; i < (int) (Math.random() * 3 + 1); i++) {
                matingPartners.add(penguinHatchery.hatchPenguin());
            }
            p.setMatingPartners(matingPartners);
        }
    }

    public static void sortPenguinsListWithMatesByNumberOfMatingPenguinsThenAverageAgeThenNameInitialPenguin(List<Penguin> penguins) {
        Collections.sort(penguins, new Comparator<Penguin>() {
            @Override
            public int compare(Penguin p1, Penguin p2) {
                if (p1.getMatingPartners().size() < p2.getMatingPartners().size()) {
                    return -1;
                } else if (p1.getMatingPartners().size() > p2.getMatingPartners().size()) {
                    return 1;
                } else {
                    if (p1.getPenguinMatesAverageAge() < p2.getPenguinMatesAverageAge()) {
                        return -1;
                    } else if (p1.getPenguinMatesAverageAge() == p2.getPenguinMatesAverageAge()) {
                        return p1.getName().compareTo(p2.getName());
                    } else {
                        return 1;
                    }
                }
            }
        });
    }

    public static void puplateMapOfPenguinsByRace(Map<String, List<Penguin>> penguinMap, List<Penguin> penguins) {
        List<Penguin> africanPenguins = new ArrayList<Penguin>();
        List<Penguin> antarticPenguins = new ArrayList<Penguin>();
        List<Penguin> imperialPenguins = new ArrayList<Penguin>();
        List<Penguin> macaroniPenguins = new ArrayList<Penguin>();
        List<Penguin> regalPenguins = new ArrayList<Penguin>();
        for (Penguin penguin : penguins) {
            if (penguin.getRace().toString().equalsIgnoreCase(PenguinRace.AFRICAN.toString())) {
                africanPenguins.add(penguin);
            } else if (penguin.getRace().toString().equalsIgnoreCase(PenguinRace.ANTARCTIC.toString())) {
                antarticPenguins.add(penguin);
            } else if (penguin.getRace().toString().equalsIgnoreCase(PenguinRace.IMPERIAL.toString())) {
                imperialPenguins.add(penguin);
            } else if (penguin.getRace().toString().equalsIgnoreCase(PenguinRace.MACARONI.toString())) {
                macaroniPenguins.add(penguin);
            } else if (penguin.getRace().toString().equalsIgnoreCase(PenguinRace.REGAL.toString())) {
                regalPenguins.add(penguin);
            }
        }

        penguinMap.put(PenguinRace.AFRICAN.toString(), africanPenguins);
        penguinMap.put(PenguinRace.ANTARCTIC.toString(), antarticPenguins);
        penguinMap.put(PenguinRace.IMPERIAL.toString(), imperialPenguins);
        penguinMap.put(PenguinRace.MACARONI.toString(), macaroniPenguins);
        penguinMap.put(PenguinRace.REGAL.toString(), regalPenguins);
    }

    public static void printMapOfPenguins(Map<String, List<Penguin>> penguinMap) {
        for (PenguinRace penguinRace : PenguinRace.values()) {
            System.out.println(penguinMap.get(penguinRace.toString()));
        }
        System.out.println("===================================================================");
        //alternative print
        for(Map.Entry<String, List<Penguin>> entry : penguinMap.entrySet()){
            System.out.println(entry.getKey() + "/" + entry.getValue());
        }
        System.out.println("===================================================================");
    }

    public static Penguin populateMapWithManyPenguins(Map<Penguin, Integer> penguinMap) {
        PenguinHatchery penguinHatchery = new PenguinHatchery();
        Penguin penguin = null;
        for (int i = 0; i < 120000; i++) {
            penguin = penguinHatchery.hatchPenguin();
            penguinMap.put(penguin , 1);
        }
        return penguin;
    }

    public static void getRandomElementFromHugeMap(Map<Penguin, Integer> penguinMap, Penguin penguin){
        Long curent = System.nanoTime();
        Integer p = penguinMap.get(penguin);
        Long after = System.nanoTime();
        System.out.println("Initial time: " + curent);
        System.out.println("After time: " + after);
        System.out.println("Time spent: " + (after - curent));
        System.out.println(p);
    }

}
