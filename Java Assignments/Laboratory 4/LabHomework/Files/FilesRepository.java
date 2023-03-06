package LabHomework.Files;

import LabHomework.Domain.Identifiable;

import LabHomework.Repository.MemoryRepository;

public abstract class FilesRepository<T extends Identifiable> extends MemoryRepository<T> {
    protected String fileName;


    public FilesRepository(String fileName) {
        this.fileName = fileName;
        readFromFile();
    }

    abstract protected void readFromFile();

    abstract protected void writeToFile();

    @Override
    public boolean add(T elem) {
        if (!super.add(elem))
            return false;
        writeToFile();
        return true;
    }

    @Override
    public boolean delete(T elem) {
        if (!super.delete(elem))
            return false;
        writeToFile();
        return true;
    }

    @Override
    public boolean update(Integer id, T elem) {
        if (!super.update(id, elem))
            return false;
        writeToFile();
        return true;
    }

}