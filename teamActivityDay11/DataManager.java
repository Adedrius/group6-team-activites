public class DataManager {
    public List<String> list = new ArrayList<>();

    // Adds a user and their metadata as a single string
    public void add(String fn, String ln, String e, String r) {
        String data = fn + ":" + ln + ":" + e + ":" + r;
        list.add(data);
    }

    public void find(String e) {
        for(String s : list) {
            if(s.contains(e)) {
                System.out.println("Found: " + s);
            }
        }
    }
}
