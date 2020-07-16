package model.graphs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vertex {
    private int index;
    private Map<String, Object> properties = new HashMap<>();

    public Vertex(int index){
        this.index = index;
    }

    public void setProperty(String property, Object value) {
        this.properties.put(property, value);
    }

    public Object getProperty(String property) {
        return this.properties.get(property);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return index == vertex.index;
    }

    @Override
    public int hashCode() {
        return Objects.hash(index);
    }
}
