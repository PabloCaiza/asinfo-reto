package org.example.service;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import org.example.model.Item;
import lombok.AllArgsConstructor;
import java.util.stream.IntStream;
import java.util.stream.Collectors;
import org.example.model.Fileltem;
import org.example.model.DirectoryItem;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

@AllArgsConstructor
public class TextJsonService {

    private ObjectMapper objectMapper;


    public String createJson(List<String> paths) throws JsonProcessingException {
        var formatPaths = formatPaths(paths);
        List<Item> items = new ArrayList<>();
        IntStream.range(0, formatPaths.size())
                .forEach(i -> createItem(0, formatPaths.get(i), items));
        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(items);
    }

    public List<List<String>> formatPaths(List<String> paths) {
        return paths.stream()
                .map(i -> Arrays.stream(i.split("/"))
                        .skip(1).collect(Collectors.toList())).
                collect(Collectors.toList());
    }

    public void createItem(int i, List<String> labels, List<Item> items) {
        int n = labels.size() - 1;
        String label = labels.get(i);
        if (labelExist(label, items)) {
            DirectoryItem directoryItem = getSimpleItemThatAlreadyExist(label, items);
            createItem(i + 1, labels, directoryItem.getItems());
            return;
        }
        if (isLastItem(i, n)) {
            Item finalItem = new Fileltem(label, getPath(labels));
            items.add(finalItem);
            return;
        }
        DirectoryItem directoryItem = new DirectoryItem(label, new ArrayList<>());
        items.add(directoryItem);
        createItem(i + 1, labels, directoryItem.getItems());

    }

    public boolean isLastItem(int n, int i) {
        return i == n;
    }

    public String getPath(List<String> labels) {
        return labels.stream()
                .reduce("", (s, s2) -> String.format("%s/%s", s, s2));
    }

    public DirectoryItem getSimpleItemThatAlreadyExist(String label, List<Item> items) {
        return (DirectoryItem) items.stream().filter(item -> item.getLabel().equals(label)).findFirst().get();

    }

    public boolean labelExist(String label, List<Item> items) {
        return items.stream().anyMatch(l -> l.getLabel().equals(label));
    }


}
