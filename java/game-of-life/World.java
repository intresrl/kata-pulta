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

    public World(List<List<Cell>> status){
        this.status = status;
    }

    public World nextWorld() {
        List<List<Cell>> nextStatus = new ArrayList<>();
        for (int i = 0, statusSize = status.size(); i < statusSize; i++) {
            List<Cell> row = status.get(i);
            List<Cell> nextRow = new ArrayList<Cell>();
            for (int j = 0, rowSize = row.size(); j < rowSize; j++) {
                Cell cell = changeStatus(i, j);
                nextRow.add(cell);
            }
            nextStatus.add(nextRow);
        }
        return new World(nextStatus);
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
        int dimension = status.get(row).size();
        for (int r = Math.max(0,row - 1); r < dimension; r += 1)
            for (int c = Math.max(0,col - 1); c < dimension; c += 1) {
                boolean isCurrent = r != row && c != col;
                if (status.get(r).get(c).isAlive() && isCurrent)
                    sum++;
            }
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
