/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domen.Program;
import java.util.List;

/**
 *
 * @author filip
 */
public abstract class DaoProgram {
    public abstract List<Program> getAllPrograms();
    public abstract void saveProgram(Program program);
    public abstract void deleteProgram(Program program);
    public abstract void updateProgram(Program program);
}
