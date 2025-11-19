/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.user;

import controller.FrontController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.List;
import javax.swing.JOptionPane;
import model.Pj;
import model.Pjs;
import model.User;
import model.UserUtilities;
import model.Users;
import view.user.UserJDialog;

/**
 *
 * @author dam2_alu02@inf.ald
 */
public class LoginController {

    private UserJDialog view;
    private Users dataUsuarios;
    private Pjs dataPjs;
    private FrontController parentController;

    public LoginController(UserJDialog view, Users dataUsuarios, FrontController parentController, Pjs dataPjs) {
        this.view = view;
        this.dataUsuarios = dataUsuarios;
        this.parentController = parentController;
        this.dataPjs = dataPjs;

        this.view.setCancelJButtonActionListener(this.getCancelJButtonActionListener());
        this.view.setLoginJButtonActionListener(this.getLoginJButtonActionListener());
    }

    private ActionListener getCancelJButtonActionListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.dispose();
            }
        };
        return al;
    }

    private ActionListener getLoginJButtonActionListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nameNewUser = view.getTextUserJTextField();
                String passwordNewUser = view.getTextPasswordJTextField();

                boolean match = false;
                List<User> listUsers = dataUsuarios.getListUsers();
                for (User usuarioExistente : listUsers) {
                    if (usuarioExistente.getUsuario().equals(nameNewUser)
                            && usuarioExistente.getPassword().equals(passwordNewUser)) {
                        match = true;
                        break;
                    }
                }

                if (!match) {
                    view.clearFields();
                    JOptionPane.showMessageDialog(view, "Usuario o Contraseña incorrectos", "Error de Login", JOptionPane.ERROR_MESSAGE);
                } else {
                    parentController.setUsuarioActual(nameNewUser);
                    parentController.usuarioSeLogueo();
                    view.dispose();

                    // Preguntar si cargar PJs guardados
                    List<Pj> pjsGuardados = UserUtilities.cargarPjsUsuario(nameNewUser);
                    if (pjsGuardados != null && !pjsGuardados.isEmpty()) {
                        int input = JOptionPane.showConfirmDialog(null, "¿Quieres recuperar tu lista editada?");
                        if (input == JOptionPane.YES_OPTION) { 
                            try {
                                dataPjs.getListPj().clear();
                                dataPjs.getListPj().addAll(pjsGuardados);
                                parentController.addPjButtons(dataPjs.getListPj());
                                JOptionPane.showMessageDialog(null, "Agentes cargados correctamente");
                            } catch (URISyntaxException | MalformedURLException ex) {
                                System.out.println("Error cargando agentes: " + ex.getMessage());
                            }
                        }
                    }

                    view.clearFields();
                    JOptionPane.showMessageDialog(null, "Login Realizado");
                    parentController.guardarDatosUsuario();  // Crea el JSON si no existe
                }
            }
        };
        return al;
    }
}
