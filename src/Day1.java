/**
 * Created by Zepur on 12/2/2016.
 */
public class Day1 {
    private static int horizontalDist = 0, verticalDist = 0, facing = 1;

    public static void main(String[] args) {
        String[] dirs = "L2, L5, L5, R5, L2, L4, R1, R1, L4, R2, R1, L1, L4, R1, L4, L4, R5, R3, R1, L1, R1, L5, L1, R5, L4, R2, L5, L3, L3, R3, L3, R4, R4, L2, L5, R1, R2, L2, L1, R3, R4, L193, R3, L5, R45, L1, R4, R79, L5, L5, R5, R1, L4, R3, R3, L4, R185, L5, L3, L1, R5, L2, R1, R3, R2, L3, L4, L2, R2, L3, L2, L2, L3, L5, R3, R4, L5, R1, R2, L2, R4, R3, L4, L3, L1, R3, R2, R1, R1, L3, R4, L5, R2, R1, R3, L3, L2, L2, R2, R1, R2, R3, L3, L3, R4, L4, R4, R4, R4, L3, L1, L2, R5, R2, R2, R2, L4, L3, L4, R4, L5, L4, R2, L4, L4, R4, R1, R5, L2, L4, L5, L3, L2, L4, L4, R3, L3, L4, R1, L2, R3, L2, R1, R2, R5, L4, L2, L1, L3, R2, R3, L2, L1, L5, L2, L1, R4".split(",");

        for (String direction : dirs) {
            int distance = Integer.parseInt(direction.trim().substring(1));
            char turning = direction.trim().charAt(0);
            switch (facing) {
                case 1:
                    horizontalDist += turning == 'L' ? -distance : distance;
                    break;
                case 2:
                    verticalDist += turning == 'L' ? -distance : distance;
                    break;
                case 3:
                    horizontalDist += turning == 'L' ? distance : -distance;
                    break;
                case 4:
                    verticalDist += turning == 'L' ? distance : -distance;
                    break;
            }
            facing += turning == 'L' ? 1 : -1;
            facing = facing == 5 ? 1 : facing == 0 ? 4 : facing;
        }
        int totalDistance = Math.abs(horizontalDist) + Math.abs(verticalDist);
        System.out.println("Easter Bunny is " +  totalDistance + " blocks away.");
    }
}