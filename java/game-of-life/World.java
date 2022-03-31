import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class World {

    List<List<Cell>> status = new ArrayList<>();

    public World(String initial) {
        for (String stringRow : initial.split(",")) {
            List<Cell> row = new ArrayList<>();
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

    private Cell changeStatus(int row, int col) {
        switch (countNeighbors(row, col)) {
            case 2:
                if (status.get(row).get(col).isAlive())
                    return new Cell(false);
            case 3:
                return new Cell(true);
            default:
                return new Cell(false);
        }
    }

    private int countNeighbors(int row, int col) {
        int sum = 0;
        for (int r = row - 1; r >= 0 && r <= row + 1; r += 2)
            for (int c = col - 1; c >= 0 && c <= col + 1; c += 2)
                if (status.get(r).get(c).isAlive())
                    sum++;
        return sum;
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
