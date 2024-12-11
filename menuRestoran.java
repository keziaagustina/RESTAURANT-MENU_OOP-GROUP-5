import javax.swing.*; // Mengimpor paket Swing untuk membuat GUI (Graphical User Interface).
import java.awt.*; // Mengimpor paket AWT untuk pengaturan tata letak dan elemen GUI.
import java.awt.event.ActionEvent; // Mengimpor kelas yang digunakan untuk menangani aksi.
import java.awt.event.ActionListener; // Mengimpor antarmuka untuk menangani aksi tombol atau event.
import java.util.HashMap; // Mengimpor kelas HashMap untuk menyimpan data dalam bentuk pasangan key-value.
import java.util.Map; // Mengimpor antarmuka Map untuk representasi pasangan key-value.

public class menuRestoran {
    private static JPanel orderedItemPanel; // Panel GUI untuk menampilkan daftar item yang telah dipesan oleh pengguna.
    private static JPanel totalHargaPanel; // Panel GUI untuk menampilkan total harga pesanan.
    private static JLabel totalHargaLabel; // Label GUI untuk menampilkan teks total harga, kemungkinan termasuk nilai total harga.
    private static JTextArea catatanTextArea; // Area teks untuk pengguna menambahkan catatan khusus terkait pesanan, misalnya permintaan khusus.
    private static Map<String, Integer> orderCountMap = new HashMap<>(); // Menyimpan jumlah pesanan per item
    private static Map<String, Integer> hargaMakanan = new HashMap<>();
    private static Map<String, Integer> hargaMinuman = new HashMap<>();
    private static Map<String, Integer> hargaSnack = new HashMap<>();

    public static void main(String[] args) {
        JFrame frame = new JFrame("Menu Restoran");
        frame.setLayout(new BorderLayout());

//1. PANEL HEADER. Berisi logo, informasi restoran, nomor meja
        JPanel headerJPanel = new JPanel();
        headerJPanel.setPreferredSize(new Dimension(800, 100)); // Lebar 800, Tinggi 100
        headerJPanel.setBackground(new Color(0xFFB53D)); // Warna abu-abu terang
        headerJPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2)); // Border hitam tebal 2px
        headerJPanel.setLayout(new BorderLayout());
//1.1. LOGO RESTORAN
//1.1.1. Menambahkan panel untuk logo
        JPanel logoPanel = new JPanel();
        logoPanel.setPreferredSize(new Dimension(100, 100)); // Lebar 100, Tinggi
        logoPanel.setBackground(Color.WHITE); // Warna putih
        logoPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2)); // Border hitam tebal 2px
//1.1.2. Menambahkan gambar logo ke logoPanel
        JLabel logoLabel = new JLabel();
        ImageIcon logoIcon = new ImageIcon("Logo.jpg"); // Path file logo
        Image logoImage = logoIcon.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH); // Ubah ukuran gambar
        logoLabel.setIcon(new ImageIcon(logoImage));
        logoPanel.add(logoLabel);
//1.1.3. Memasukkan logo ke header
        headerJPanel.add(logoPanel, BorderLayout.WEST);
//1.2. INFORMASI RESTORAN
//1.2.1. Menambahkan panel untuk isi informasi
        JPanel infoPanel = new JPanel();
        infoPanel.setPreferredSize(new Dimension(600, 100)); // Lebar 600, Tinggi 100
        infoPanel.setBackground(new Color(0xFFB53D)); // Warna putih
        infoPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2)); // Border hitam tebal 2px
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS)); // Atur tata letak vertikal
//1.2.2. Menambahkan teks informasi ke infoPanel. Terdapat 3: nama restoran, alamat, email
        // Label untuk nama restoran
        JLabel infoLabel = new JLabel("PANDAWA DINER");
        infoLabel.setFont(new Font("Arial", Font.BOLD, 24));
        infoLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Pusatkan teks
        // Label untuk alamat restoran
        JLabel addressLabel = new JLabel("Alamat: Sepanjang Jalan Kenangan");
        addressLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        addressLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Pusatkan teks
        // Label untuk email restoran
        JLabel emailLabel = new JLabel("Email: info@restorankeluarga.com");
        emailLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        emailLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Pusatkan teks
        // Tambahkan semua label ke infoPanel
        infoPanel.add(Box.createVerticalStrut(10)); // Beri jarak atas
        infoPanel.add(infoLabel);
        infoPanel.add(Box.createVerticalStrut(10)); // Jarak antar label
        infoPanel.add(addressLabel);
        infoPanel.add(Box.createVerticalStrut(5)); // Jarak antar label
        infoPanel.add(emailLabel);
        infoPanel.add(Box.createVerticalStrut(10)); // Jarak antar label
//1.2.3. Memasukan seluruh informasi ke header
        headerJPanel.add(infoPanel, BorderLayout.CENTER);
//1.3. NOMOR MEJA
//1.3.1. Menambahkan panel nomor meja
        JPanel tableNumberPanel = new JPanel();
        tableNumberPanel.setPreferredSize(new Dimension(100, 100)); // Lebar 100, Tinggi 100
        tableNumberPanel.setBackground(Color.WHITE); // Warna putih
        tableNumberPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2)); // Border hitam
        tableNumberPanel.setLayout(new BoxLayout(tableNumberPanel, BoxLayout.Y_AXIS)); // Atur tata letak vertical
//1.3.2. Menambahkan teks nomor meja
        // Label untuk meja
        JLabel tableLabel = new JLabel("Meja");
        tableLabel.setFont(new Font("Arial", Font.BOLD, 24));
        tableLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Pusatkan teks ke tengah
        // Label untuk nomor meja
        JLabel tableNumberLabel = new JLabel("??");
        tableNumberLabel.setFont(new Font("Arial", Font.BOLD, 24));
        tableNumberLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Pusatkan teks ke tengah
        // Menambahkan ke tableNumberPanel
        tableNumberPanel.add(Box.createVerticalStrut(10)); // Beri jarak atas
        tableNumberPanel.add(tableLabel);
        tableNumberPanel.add(Box.createVerticalStrut(10)); // Jarak antar label
        tableNumberPanel.add(tableNumberLabel);
//1.3.3 Memasukkan nomor meja ke header
        headerJPanel.add(tableNumberPanel, BorderLayout.EAST);

//2. PANEL BODY. Berisi panel menu dan panel pesanan
        JPanel bodyJPanel = new JPanel();
        bodyJPanel.setLayout(new BorderLayout()); // Menggunakan BorderLayout untuk menempatkan menu dan pesanan
        bodyJPanel.setPreferredSize(new Dimension(800, 500)); // Lebar 800, Tinggi 400
        bodyJPanel.setBackground(Color.WHITE); // Warna putih
//2.1. MENU PANEL. Berisi panel judul dan panel item menu
        JPanel menuPanel = new JPanel();
        menuPanel.setPreferredSize(new Dimension(600, 400)); // Lebar 600, Tinggi 400
        menuPanel.setBackground(Color.LIGHT_GRAY); // Warna abu-abu terang
        menuPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2)); // Border hitam tebal 2px
        menuPanel.setLayout(new BorderLayout());
//2.1.1 Panel Judul
        JPanel menuLabelPanel = new JPanel();
        menuLabelPanel.setBackground(Color.WHITE);
        menuLabelPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1)); // Border hitam
        menuLabelPanel.setPreferredSize(new Dimension(600, 50)); // Lebar 600, Tinggi 50
        // Label "Daftar Menu"
        JLabel menuLabel = new JLabel("Daftar Menu");
        menuLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        menuLabelPanel.add(menuLabel);
        // Menambahkan panel judul ke menu panel
        menuPanel.add(menuLabelPanel, BorderLayout.NORTH);
//2.1.2 Panel item menu
        JPanel menuItemPanel = new JPanel();
        menuItemPanel.setBackground(Color.WHITE);
        menuItemPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1)); // Border hitam
        menuItemPanel.setLayout(new GridLayout(0, 3, 10, 10));
        menuItemPanel.setPreferredSize(new Dimension(578, 2000));
        // Array item
        String[] makanan = {"Ayam Bakar", "Bakso", "Gulai Kambing", "Lasagna", "Mie Ayam", "Mie Goreng", "Nasi Goreng", "Nasi Kebuli", "Sate Ayam", "Sate Kelinci", "Sop Iga", "Steak Ayam"};
        String[] minuman = {"Air Mineral", "Es Buah", "Es Dawet", "Es Degan", "Es Doger", "Es Jeruk", "Es Kolak", "Es Kuwud", "Es Teh", "Jus Mangga", "Kopi", "Susu Coklat"};
        String[] snack = {"Croissant", "Dimsum", "Donat", "French Fries", "Keripik Kentang", "Martabak Mini", "Mendoan", "Nugget", "Pisang Goreng", "Singkong Goreng", "Sushi", "Tahu Crispy"};
        // List harga makanan
        hargaMakanan.put("Ayam Bakar", 30000);
        hargaMakanan.put("Bakso", 15000);
        hargaMakanan.put("Gulai Kambing", 35000);
        hargaMakanan.put("Lasagna", 50000);
        hargaMakanan.put("Mie Ayam", 20000);
        hargaMakanan.put("Mie Goreng", 22000);
        hargaMakanan.put("Nasi Goreng", 25000);
        hargaMakanan.put("Nasi Kebuli", 27000);
        hargaMakanan.put("Sate Ayam", 18000);
        hargaMakanan.put("Sate Kelinci", 40000);
        hargaMakanan.put("Sop Iga", 40000);
        hargaMakanan.put("Steak Ayam", 60000);
        // List harga minuman
        hargaMinuman.put("Air Mineral", 4000);
        hargaMinuman.put("Es Buah", 12000);
        hargaMinuman.put("Es Dawet", 8000);
        hargaMinuman.put("Es Degan", 8000);
        hargaMinuman.put("Es Doger", 10000);
        hargaMinuman.put("Es Jeruk", 6000);
        hargaMinuman.put("Es Kolak", 7000);
        hargaMinuman.put("Es Kuwud", 9000);
        hargaMinuman.put("Es Teh", 5000);
        hargaMinuman.put("Jus Mangga", 15000);
        hargaMinuman.put("Kopi", 15000);
        hargaMinuman.put("Susu Coklat", 12000);
        // List harga snack
        hargaSnack.put("Croissant", 10000);
        hargaSnack.put("Dimsum", 20000);
        hargaSnack.put("Donat", 7000);
        hargaSnack.put("French Fries", 15000);
        hargaSnack.put("Keripik Kentang", 8000);
        hargaSnack.put("Martabak Mini", 15000);
        hargaSnack.put("Mendoan", 7000);
        hargaSnack.put("Nugget", 12000);
        hargaSnack.put("Pisang Goreng", 5000);
        hargaSnack.put("Singkong Goreng", 8000);
        hargaSnack.put("Sushi", 25000);
        hargaSnack.put("Tahu Crispy", 10000);
        // fungsi menambahkan item
        addMenuItems(menuItemPanel, makanan, Color.LIGHT_GRAY, "makanan/", hargaMakanan);
        addMenuItems(menuItemPanel, minuman, Color.LIGHT_GRAY, "minuman/", hargaMinuman);
        addMenuItems(menuItemPanel, snack, Color.LIGHT_GRAY, "snack/", hargaSnack);
        // Membungkus menuItemPanel dengan JScrollPane untuk membuatnya bisa di-scroll
        JScrollPane scrollPane = new JScrollPane(menuItemPanel);
        scrollPane.setPreferredSize(new Dimension(600, 300)); // Atur ukuran scrollPane jika perlu
        // Memasukkan item panel menu ke menu panel
        menuPanel.add(scrollPane, BorderLayout.CENTER);

//2.2. PANEL PESANAN
        // Membuat panel pesanan. Berisi panel judul, list pesanan, total harga
        JPanel pesananPanel = new JPanel();
        pesananPanel.setPreferredSize(new Dimension(200, 400)); // Lebar 200, Tinggi 400
        pesananPanel.setBackground(Color.BLUE); // Warna biru
        pesananPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2)); // Border hitam tebal 2px
        pesananPanel.setLayout(new BorderLayout());
//2.2.1. Panel Judul
        JPanel pesananLabelPanel = new JPanel();
        pesananLabelPanel.setBackground(new Color(0xFFB53D)); // Warna biru agar sesuai dengan warna panel pesanan
        pesananLabelPanel.setPreferredSize(new Dimension(200, 50)); // Lebar 200, Tinggi 50
        pesananLabelPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1)); // Border hitam
        // Label "pesanan anda"
        JLabel pesananLabel = new JLabel("Pesanan Anda");
        pesananLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        pesananLabel.setForeground(Color.BLACK); // Warna teks putih
        pesananLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Pusatkan teks ke tengah
        // Memasukkan label ke panel label
        pesananLabelPanel.add(pesananLabel);
        // Memasukkan panel label ke panel pesanan
        pesananPanel.add(pesananLabelPanel, BorderLayout.NORTH);
//2.2.2. Panel list pesanan
        orderedItemPanel = new JPanel();
        orderedItemPanel.setBackground(Color.WHITE);
        orderedItemPanel.setLayout(new BoxLayout(orderedItemPanel, BoxLayout.Y_AXIS)); // Untuk susunan vertikal
        orderedItemPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        // Membuat scroll jika dibutuhkan. dan membungkus panel orderedItemPanel ke dalam scroll
        JScrollPane orderedItemScrollPane = new JScrollPane(orderedItemPanel);
        orderedItemScrollPane.setPreferredSize(new Dimension(200, 400));
        orderedItemScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        // Memasukkan ke dalam panel pesanan
        pesananPanel.add(orderedItemScrollPane, BorderLayout.CENTER);
//2.2.3. Panel total harga dan enter
        totalHargaPanel = new JPanel();
        totalHargaPanel.setBackground(Color.WHITE);
        totalHargaPanel.setLayout(new BorderLayout());
        totalHargaPanel.setPreferredSize(new Dimension(200,125));
        // Label "total harga"
        totalHargaLabel = new JLabel("Total Harga: Rp. 0", SwingConstants.CENTER);
        // Memasukkan label ke dalam panel total harga
        totalHargaPanel.add(totalHargaLabel, BorderLayout.NORTH);
//2.2.4. Panel catatan
        // Membuat Panel catatan
        JPanel catatanPanel = new JPanel();
            catatanPanel.setLayout(new BorderLayout());
            catatanPanel.setPreferredSize(new Dimension(200,50));
            catatanPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        // Membuat label untuk catatan
        JLabel catatanLabel = new JLabel("Catatan:");
            catatanTextArea = new JTextArea(3, 20);
            catatanTextArea.setLineWrap(true);
            catatanTextArea.setWrapStyleWord(true);
        // Menambahkan label ke panel
        catatanPanel.add(catatanLabel, BorderLayout.NORTH);
        // Membungkus panel catatan ke dalam scollpane
        catatanPanel.add(new JScrollPane(catatanTextArea), BorderLayout.CENTER);
        // Menambahkan catatanPanel ke pesananPanel
        totalHargaPanel.add(catatanPanel, BorderLayout.CENTER);
        // Tombol enter
        JButton enterButton = new JButton("Enter");
        enterButton.setBackground(new Color(0x2F65DA));
        enterButton.setForeground(Color.WHITE);
        enterButton.setFont(new Font("Arial", Font.BOLD, 14));
        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cek apakah orderCountMap kosong
                if (orderCountMap.isEmpty() || orderCountMap.values().stream().allMatch(count -> count == 0)) {
                JOptionPane.showMessageDialog(frame, "Pesanan kosong. Silahkan pilih menu.", "Pesanan Kosong", JOptionPane.WARNING_MESSAGE);
                return; // Keluar dari metode jika tidak ada pesanan
                }
                // Menyiapkan string detail pesanan
                StringBuilder pesananDetail = new StringBuilder("Detail Pesanan:\n");
                int totalHarga = 0;
                // Fungsi memunculkan catatan
                for (Map.Entry<String, Integer> entry : orderCountMap.entrySet()) {
                    String item = entry.getKey();
                    int count = entry.getValue();
                    if (count > 0) {
                        int harga = getPrice(item);
                        pesananDetail.append(item).append(" ").append(count).append(" - Rp. ").append(harga * count).append("\n");
                        totalHarga += harga * count;
                    }
                }
                String catatan = catatanTextArea.getText().trim();
                if (!catatan.isEmpty()) {
                    pesananDetail.append("\nCatatan: ").append(catatan);
                }
        
                // Menyusun daftar pesanan dan menghitung total harga
                pesananDetail.append("\nTotal Harga: Rp. ").append(totalHarga);
                int option = JOptionPane.showConfirmDialog(frame, pesananDetail.toString(), "Konfirmasi Pesanan", JOptionPane.YES_NO_OPTION);                
                if (option == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(frame, "Pesanan sudah dipesan. Tolong tunggu.");
                    orderCountMap.clear(); 
                    updateOrderPanel(); 
                    ((JLabel) totalHargaPanel.getComponent(0)).setText("Total Harga: Rp. 0"); 
                    catatanTextArea.setText(""); // Reset JTextArea setelah pesanan
                }
        
                // Menambahkan total harga ke detail pesanan
                pesananDetail.append("\nTotal Harga: Rp. ").append(totalHarga);
            }
        });
        // Memasukkan tombol ke dalam panel total harga
        totalHargaPanel.add(enterButton, BorderLayout.SOUTH);
        // Memasukkan panel total harga ke dalam panel pesanan
        pesananPanel.add(totalHargaPanel, BorderLayout.SOUTH);
//2.3. Menambahkan panel menu dan panel pesanan ke bodyJPanel
        bodyJPanel.add(scrollPane, BorderLayout.WEST); // Panel menu di kiri
        bodyJPanel.add(pesananPanel, BorderLayout.EAST); // Panel pesanan di kanan

//3. Panel Footer
        JPanel footerJPanel = new JPanel();
        footerJPanel.setLayout(new BoxLayout(footerJPanel, BoxLayout.Y_AXIS)); // Tata letak vertikal
        footerJPanel.setPreferredSize(new Dimension(800, 50)); // Lebar 800, Tinggi 50
        footerJPanel.setBackground(new Color(0xFFB53D));
        footerJPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2)); // Border hitam tebal 2px
        // Label motto
        JLabel footerJLabel = new JLabel("Menyajikan Kenikmatan di Setiap Hidangan");
        footerJLabel.setFont(new Font("Arial", Font.BOLD, 14));
        footerJLabel.setForeground(Color.BLACK); // Teks putih
        footerJLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        //Memasukkan label ke dalam panel footer
        footerJPanel.add(Box.createVerticalGlue()); // Isi ruang kosong di atas
        footerJPanel.add(footerJLabel);
        footerJPanel.add(Box.createVerticalGlue()); // Isi ruang kosong di bawah

//4. Menambahkan panel header, body, dan footer ke frame
        frame.add(headerJPanel, BorderLayout.NORTH);
        frame.add(bodyJPanel, BorderLayout.CENTER);
        frame.add(footerJPanel, BorderLayout.SOUTH);

//5. Properti frame
        frame.pack();
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    // Program fungsi addMenuItems
    private static void addMenuItems(JPanel menuItemPanel, String[] items, Color color, String imageFolder, Map<String, Integer> hargaMap) {
        for (String item : items) {
            JPanel itemPanel = new JPanel();
            itemPanel.setLayout(new BoxLayout(itemPanel, BoxLayout.Y_AXIS));
            itemPanel.setBackground(color);
            
            JLabel label = new JLabel(item);
            label.setAlignmentX(Component.CENTER_ALIGNMENT);

            ImageIcon imageIcon = new ImageIcon(imageFolder + item.toLowerCase().replaceAll(" ", "_") + ".jpg");
            Image image = imageIcon.getImage().getScaledInstance(150, 100, Image.SCALE_SMOOTH);
            imageIcon = new ImageIcon(image);
            JLabel imageLabel = new JLabel(imageIcon);
            imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

            int harga = hargaMap.get(item);
            JLabel priceLabel = new JLabel("Rp. " + harga);
            priceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

            JPanel buttonPanel = new JPanel();
            buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
            buttonPanel.setBackground(color);

            JButton addButton = new JButton("+");
            addButton.setPreferredSize(new Dimension(50, 18));
            addButton.setFont(new Font("Verdana", Font.BOLD, 16));
            addButton.setBackground(new Color(0xFFA70F));
            addButton.setForeground(Color.BLACK);
            addButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    addItemToOrder(item, harga);
                    updateTotalPrice();
                }
            });

            JButton removeButton = new JButton("-");
            removeButton.setPreferredSize(new Dimension(50, 18));
            removeButton.setFont(new Font("Verdana", Font.BOLD, 20));
            removeButton.setBackground(Color.RED);
            removeButton.setForeground(Color.WHITE);
            
            removeButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    removeItemFromOrder(item, harga);
                    updateTotalPrice();
                }
            });

            buttonPanel.add(addButton);
            buttonPanel.add(removeButton);

            itemPanel.add(label);
            itemPanel.add(imageLabel);
            itemPanel.add(priceLabel);
            itemPanel.add(buttonPanel);

            menuItemPanel.add(itemPanel);
        }
    }

    private static void addItemToOrder(String item, int harga) {
        orderCountMap.put(item, orderCountMap.getOrDefault(item, 0) + 1);
        updateOrderPanel();
    }

    private static void removeItemFromOrder(String item, int harga) {
        if (orderCountMap.containsKey(item) && orderCountMap.get(item) > 0) {
            orderCountMap.put(item, orderCountMap.get(item) - 1);
        }
        updateOrderPanel();
    }

    private static void updateOrderPanel() {
        orderedItemPanel.removeAll();

        for (Map.Entry<String, Integer> entry : orderCountMap.entrySet()) {
            String item = entry.getKey();
            int count = entry.getValue();
            if (count > 0) {
                int harga = getPrice(item);
                orderedItemPanel.add(new JLabel(item + " " + count + " = Rp. " + (harga * count)));
            }
        }

        orderedItemPanel.revalidate();
        orderedItemPanel.repaint();
    }

    private static void updateTotalPrice() {
        int totalPrice = 0;
        for (Map.Entry<String, Integer> entry : orderCountMap.entrySet()) {
            String item = entry.getKey();
            int count = entry.getValue();
            if (count > 0) {
                int harga = getPrice(item);
                totalPrice += harga * count;
            }
        }

        // Menggunakan totalHargaLabel yang sudah dideklarasikan untuk memperbarui harga
        totalHargaLabel.setText("Total Harga: Rp. " + totalPrice);
    }
    private static int getPrice(String item) {
        if (hargaMakanan.containsKey(item)) {
            return hargaMakanan.get(item);
        } else if (hargaMinuman.containsKey(item)) {
            return hargaMinuman.get(item);
        } else if (hargaSnack.containsKey(item)) {
            return hargaSnack.get(item);
        }
        return 0;
    }
}