import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class World {

    List<List<Cell>> status = new ArrayList<>();

    public World(String initial) {
        for (String stringRow : initial.split(",")) {
            final ArrayList<Cell> row = new ArrayList<>();
            for (char cell : stringRow.toCharArray()) {
                row.add(new Cell(cell != '.'));
            }
            status.add(row);
        }
    }

    public World nextWorld() {
        for (int i = 0, statusSize = status.size(); i < statusSize; i++) {
            List<Cell> row = status.get(i);
            for (int j = 0, rowSize = row.size(); j < rowSize; j++) {
                Cell cell = row.get(j);

                cell = changeStatus(i, j);
            }
        }
        return null;
    }

    private Cell changeStatus(int x, int y) {
        return null;
    }


    @Override
    public String toString() {
        return status.stream()
                .map(x -> x.stream()
                        .map(Cell::toString)
                        .collect(Collectors.joining())
                )
                .collect(Collectors.joining(","));
    }
}
