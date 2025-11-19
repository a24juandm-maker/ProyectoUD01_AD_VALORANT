/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import controller.modifyPJS.CreatePJController;
import controller.modifyPJS.DeleteController;
import controller.modifyPJS.ModifyPJController;
import controller.user.LoginController;
import controller.user.RegisterController;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import model.Pj;
import model.Pjs;
import model.UserUtilities;
import model.Users;
import view.MainJFrame;
import view.modifyPjs.CreateAndEditPJDialog;
import view.modifyPjs.DelPJ;
import view.user.UserJDialog;

/**
 *
 * @author W10-Portable
 */
public class FrontController {

    private MainJFrame view;
    private Pjs dataPjs;
    private Users dataUsuarios;
    private String usuarioActual = null;

    private static final int ANCHO_HABILIDAD = 60;
    private static final int ALTO_HABILIDAD = 60;

    public FrontController(MainJFrame view, Pjs data, Users dataUsuarios) throws URISyntaxException, MalformedURLException {
        this.view = view;
        this.dataPjs = data;
        this.dataUsuarios = dataUsuarios;

        this.view.setRegisterJButtonActionListener(this.getRegisterJButtonActionListener());
        this.view.setLoginJButtonActionListener(this.getLoginJButtonActionListener());
        this.view.setSearchTextFieldKeyListener(this.getSearchTextFieldKeyListener());
        this.view.setRoleComboJComboBoxActionListener(this.getRoleComboJComboBoxActionListener());
        this.view.setImageTitle(this.addTitleImage());
        this.view.setDelPjActionListener(this.addDelPjButtonActionListener());
        this.view.setCreatePjActionListener(this.addCreateButtonActionListener());
        this.view.setEditPjActionListener(this.addModifyPjButtonActionListener());

        initComboBox();

        List<Pj> dataPj = dataPjs.getListPj();
        addPjButtons(dataPj);
    }

    public void setUsuarioActual(String usuario) {
        this.usuarioActual = usuario;
    }

    public void guardarDatosUsuario() {
        if (usuarioActual != null && !usuarioActual.trim().isEmpty()) {
            UserUtilities.guardarPjsUsuario(usuarioActual, dataPjs.getListPj());
        }
    }

    public void addPjButtons(List<Pj> dataPjs) throws URISyntaxException, MalformedURLException {
        view.clearPanelPj();
        int tamanhoLista = dataPjs.size();
        System.out.println("Tenemos este numero de personajes " + tamanhoLista);

        int columnas = 6;

        // Calcular el número de filas necesarias, matematicas del infierno
        int filas = (int) Math.ceil(tamanhoLista / (double) columnas);
        int gap = 10;
        int contador = 0;
        int tamanhoBoton = 100;

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (contador < tamanhoLista) {
                    Pj boton = (Pj) dataPjs.get(contador);

                    boton.setLayout(null);

                    int xPos = j * (tamanhoBoton + gap);
                    int yPos = i * (tamanhoBoton + gap);
                    boton.setBounds(xPos, yPos, tamanhoBoton, tamanhoBoton);

                    URI linkImageCareto;
                    ImageIcon careto;
                    try {
                        linkImageCareto = new URI(boton.getDisplayImagePj());

                        careto = new ImageIcon(linkImageCareto.toURL());
                    } catch (Exception ex) {
                        linkImageCareto = new URI("https://cdn-icons-png.flaticon.com/512/5219/5219070.png");
                        careto = new ImageIcon(linkImageCareto.toURL());
                    }
                    Image image = careto.getImage();

                    //Tratamiento Imagen
                    Image imageRedimensity = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);

                    // Creacion  ImageIcon redimensionado
                    ImageIcon imagenBotonFinal = new ImageIcon(imageRedimensity);

                    boton.setIcon(imagenBotonFinal);

                    boton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            try {
                                System.out.println("presiono agente, muestro imagen");
                                URI linkImageFull = new URI(boton.getGreatPjImage());
                                //if(linkImageFull == null){
                                //linkImageFull = new URI("https://cdn-icons-png.flaticon.com/512/5219/5219070.png");
                                //}
                                view.addSetImageDisplayLabel(new ImageIcon(linkImageFull.toURL()));

                                view.setDescripcionPersonajeLabel(boton.getDescription());

                                URI linkImageHability1 = new URI(boton.getHability().get(0).getDisplayImageHability());
                                URI linkImageHability2 = new URI(boton.getHability().get(1).getDisplayImageHability());
                                URI linkImageHability3 = new URI(boton.getHability().get(2).getDisplayImageHability());
                                URI linkImageHability4 = new URI(boton.getHability().get(3).getDisplayImageHability());

                                view.setImagenhabilidad1Label(redimensionarImageLabel(new ImageIcon(linkImageHability1.toURL()),
                                        view.getImagenhabilidad1Label()));
                                view.setImagenhabilidad2Label(redimensionarImageLabel(new ImageIcon(linkImageHability2.toURL()),
                                        view.getImagenhabilidad2Label()));
                                view.setImagenhabilidad3Label(redimensionarImageLabel(new ImageIcon(linkImageHability3.toURL()),
                                        view.getImagenhabilidad3Label()));
                                view.setImagenhabilidad4Label(redimensionarImageLabel(new ImageIcon(linkImageHability4.toURL()),
                                        view.getImagenhabilidad4Label()));

                                // NOMBRE HABILIDADES
                                view.setNombrehabilidad1Label(boton.getHability().get(0).getName());
                                view.setNombrehabilidad2Label(boton.getHability().get(1).getName());
                                view.setNombrehabilidad3Label(boton.getHability().get(2).getName());
                                view.setNombrehabilidad4Label(boton.getHability().get(3).getName());

                                //DESCRIPCION HABILIDADES
                                view.setDescripcionhabilidad1Label(boton.getHability().get(0).getDescription());
                                view.setDescripcionhabilidad2Label(boton.getHability().get(1).getDescription());
                                view.setDescripcionhabilidad3Label(boton.getHability().get(2).getDescription());
                                view.setDescripcionhabilidad4Label(boton.getHability().get(3).getDescription());

                                view.saveActualPj(boton);
                                view.enableEditJButton();
                            } catch (URISyntaxException | MalformedURLException ex) {
                                System.err.println(ex.getMessage());
                            }
                        }

                        private ImageIcon redimensionarImageLabel(ImageIcon image, JLabel label) {
                            // SETEAR IMAGEN HABILIDAD
                            ImageIcon iconoHabilidad = image;
                            Image imageHab = iconoHabilidad.getImage();
                            Image imageRedimensityHab = imageHab.getScaledInstance(ANCHO_HABILIDAD,
                                    ALTO_HABILIDAD,
                                    Image.SCALE_SMOOTH);
                            ImageIcon imagenHabFinal = new ImageIcon(imageRedimensityHab);
                            return imagenHabFinal;
                        }
                    });
                    boton.setToolTipText(boton.getName());
                    view.addButtonPj(boton);
                    contador++;
                } else {
                    JButton emptyButton = new JButton();
                    emptyButton.setEnabled(false); // Lo deshabilitamos
                    view.add(emptyButton);
                }
            }
        }
        view.revalidate();
        view.repaint();
    }

    private void initComboBox() {
        for (String p : dataPjs.getListRole()) {
            this.view.addItemRoleComboBox(p);

        }
    }

    private ActionListener getRegisterJButtonActionListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserJDialog viewLogin = new UserJDialog(view, true);
                RegisterController lc = new RegisterController(viewLogin, dataUsuarios, FrontController.this);

                viewLogin.setTextLoginJButton("Registrar");
                viewLogin.setTextLoginTitleJLabel("Register");

                viewLogin.setVisible(true);
            }
        };
        return al;
    }

    private ActionListener getLoginJButtonActionListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserJDialog viewLogin = new UserJDialog(view, true);
                LoginController lc = new LoginController(viewLogin, dataUsuarios, FrontController.this, dataPjs);

                viewLogin.setTextLoginJButton("Logear");
                viewLogin.setTextLoginTitleJLabel("Login");

                viewLogin.setVisible(true);
            }
        };
        return al;
    }

    private KeyListener getSearchTextFieldKeyListener() {
        KeyListener kl = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent ke) {
            }

            @Override
            public void keyPressed(KeyEvent ke) {
            }

            @Override
            public void keyReleased(KeyEvent ke) {
                String searchText = view.getSearchTextField();

                List<JButton> listaBotones = view.getButtonsPanelPjs();
                if (!searchText.isEmpty()) {
                    for (JButton botonPj : listaBotones) {
                        if (!botonPj.getName().toUpperCase().contains(searchText.toUpperCase()) || !botonPj.getName().toLowerCase().contains(searchText.toLowerCase())) {
                            botonPj.setEnabled(false);
                        } else {
                            botonPj.setEnabled(true);
                        }
                    }
                } else {
                    for (JButton botonPj : listaBotones) {
                        botonPj.setEnabled(true);
                    }
                }
            }
        };
        return kl;
    }

    private ActionListener getRoleComboJComboBoxActionListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Pj> dataPj = dataPjs.getListPj();
                List<Pj> rolDataPj = new ArrayList<>();
                Object selectedItem = view.getItemRoleComboJComboBox();
                if (!selectedItem.equals("Rol")) {
                    try {
                        for (Pj personaje : dataPj) {
                            if (personaje.getRole().equals(selectedItem.toString())) {
                                rolDataPj.add(personaje);
                            }
                        }
                        view.clearPanelPj();

                        addPjButtons(rolDataPj);
                    } catch (URISyntaxException | MalformedURLException ex) {
                        System.getLogger(FrontController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
                    }
                } else {
                    try {
                        view.clearPanelPj();
                        addPjButtons(dataPj);
                    } catch (URISyntaxException | MalformedURLException ex) {
                        System.getLogger(FrontController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
                    }
                }
            }
        };
        return al;
    }

    private ImageIcon addTitleImage() {
        ImageIcon titleImage = null;
        try {
            String urlImage = "https://logos-world.net/wp-content/uploads/2023/05/Valorant-Logo.png";

            //Cargar Imagen Titulo de internet
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(urlImage))
                    .build();

            //Cliente HTTP obtener imagen
            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<InputStream> response;
            response = client.send(request,
                    HttpResponse.BodyHandlers
                            .ofInputStream());

            //Leemos Flujo Imagen
            InputStream inputStream = response.body();
            Image image = ImageIO.read(inputStream);

            //Tratamiento Imagen
            Image imageRedimensity = image.getScaledInstance(1000, 220, Image.SCALE_SMOOTH);

            // Creacion  ImageIcon redimensionado
            titleImage = new ImageIcon(imageRedimensity);

        } catch (IOException ex) {
            System.out.println("Fallo entrada/salida lectura  imagen");
        } catch (InterruptedException ex) {
            Logger.getLogger(FrontController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return titleImage;
    }

    private ActionListener addDelPjButtonActionListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DelPJ delPJView = new DelPJ(view, true);
                DeleteController dc = new DeleteController(delPJView, dataPjs, FrontController.this);
                delPJView.setVisible(true);
            }
        };
        return al;
    }

    private ActionListener addCreateButtonActionListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CreateAndEditPJDialog createPJ = new CreateAndEditPJDialog(view, true);
                CreatePJController cc = new CreatePJController(createPJ, dataPjs, FrontController.this);
                createPJ.setVisible(true);
            }
        };
        return al;
    }

    private ActionListener addModifyPjButtonActionListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CreateAndEditPJDialog modify = new CreateAndEditPJDialog(view, true);
                ModifyPJController mPjContr = new ModifyPJController(modify, dataPjs, FrontController.this, view);
                modify.setVisible(true);
            }
        };
        return al;
    }

    public void enableDisableLoginRegisterButton(Boolean enableDisable) {
        view.enableDisableRegisterLoginButtons(enableDisable);
    }

    public void enableDisableEditCreateDeleteButton(Boolean enableDisable) {
        view.enableDisableButtonsAddEditCreateVisible(enableDisable);
    }

    public void usuarioSeLogueo() {
        view.seLogueo();
    }
}
