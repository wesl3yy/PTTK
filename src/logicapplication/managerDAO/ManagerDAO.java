/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicapplication.managerDAO;

import java.util.List;
import model.manager.Manager;

/**
 *
 * @author Cuong
 */
public interface ManagerDAO {
    // kiem tra dang nhap
    boolean checkLoginInfo(String username, String password);
}
