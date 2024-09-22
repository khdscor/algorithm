import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        ArrayList<Jewel> jewels = new ArrayList<>();
        PriorityQueue<Long> bags = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            String ste = br.readLine();
            StringTokenizer t = new StringTokenizer(ste);
            Long m = Long.valueOf(t.nextToken());
            Long v = Long.valueOf(t.nextToken());
            jewels.add(new Jewel(m, v));
        }
        jewels.sort(new JewelComparator());

        for (int i = 0; i < k; i++) {
            Long m = Long.valueOf(br.readLine());
            bags.add(m);
        }

        Long total = 0L;
        int idx=0;
        PriorityQueue<Long> values = new PriorityQueue<>(Collections.reverseOrder());
        while (bags.size() > 0) {
            Long m = bags.poll();
            while(idx < n && m >= jewels.get(idx).getWeight()){
                values.add(jewels.get(idx).getValue());
                idx++;
            }
            if (!values.isEmpty()) {
                total += values.poll();
            }
        }

        System.out.println(total);
    }

    public static class Jewel {

        private final Long weight;
        private final Long value;

        public Jewel(Long weight, Long value) {
            this.weight = weight;
            this.value = value;
        }

        public Long getWeight() {
            return weight;
        }

        public Long getValue() {
            return value;
        }
    }

    static class JewelComparator implements Comparator<Jewel> {

        @Override
        public int compare(Jewel a, Jewel b) {
            return Long.compare(a.getWeight(), b.getWeight());
        }
    }
}