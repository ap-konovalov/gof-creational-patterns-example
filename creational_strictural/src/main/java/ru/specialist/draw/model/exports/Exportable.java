package ru.specialist.draw.model.exports;

public interface Exportable {

    void accept(ExportVisitor v);
}
