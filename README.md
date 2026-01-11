NAMA APLIKASI
Tic Tac Toe Desktop Application

DESKRIPSI APLIKASI
Tic Tac Toe Desktop Application adalah aplikasi permainan Tic Tac Toe berbasis Java yang dikembangkan menggunakan konsep Object Oriented Programming (OOP).
Aplikasi ini memiliki antarmuka grafis (GUI) berbentuk window menggunakan Java Swing, sehingga pengguna dapat berinteraksi layaknya aplikasi desktop pada umumnya.

Aplikasi menyediakan fitur input nama pemain, permainan dua pemain, pencatatan history pertandingan dengan waktu (timestamp), scoreboard, serta navigasi antar menu yang mudah digunakan.
Desain aplikasi dibuat konsisten dengan satu tema warna dan font untuk meningkatkan kenyamanan pengguna.

CARA MENJALANKAN APLIKASI

Buka project menggunakan IDE Eclipse

Pastikan seluruh file Java berada dalam satu package yang sama (misalnya: tictactoe)

Pastikan file MainApp.java tersedia sebagai entry point

Jalankan file MainApp.java

Aplikasi akan menampilkan menu utama (Main Menu)

DAFTAR CLASS DAN FUNGSINYA

MainApp
Berfungsi sebagai entry point atau titik awal aplikasi.

MainMenu
Menampilkan menu utama aplikasi yang berisi pilihan Start Game dan View History.

PlayerForm
Digunakan untuk menginput nama Player 1 dan Player 2 sebelum permainan dimulai.

GameUI
Menampilkan tampilan utama permainan Tic Tac Toe, mengatur jalannya permainan, scoreboard, restart game, dan navigasi kembali ke menu utama.

Board
Menyimpan kondisi papan permainan Tic Tac Toe (3x3) dan mengatur pengisian sel.

GameLogic
Mengelola logika permainan seperti pengecekan kondisi menang dan draw.

GameState
Enum yang menyimpan status permainan (PLAYING, WIN, DRAW).

Score
Menyimpan dan mengelola skor Player 1 dan Player 2 selama sesi permainan.

HistoryManager
Mengelola penyimpanan, pembacaan, dan penghapusan history permainan ke dalam file teks.

HistoryView
Menampilkan daftar history pertandingan dalam bentuk window dengan fitur auto refresh dan clear history.

UIStyle
Mengatur tema warna dan font aplikasi agar tampilan konsisten di seluruh window.

PENJELASAN KONSEP OOP YANG DIGUNAKAN

Encapsulation
Data dan fungsi dibungkus dalam class tertentu, contohnya class Board, Score, dan HistoryManager yang menyembunyikan detail implementasi internal.

Abstraction
Setiap class memiliki tanggung jawab yang jelas, misalnya GameLogic hanya menangani logika permainan tanpa mengatur tampilan UI.

Separation of Concerns
Pemisahan antara tampilan (UI), logika permainan, dan manajemen data sehingga kode lebih mudah dipahami dan dirawat.

Reusability
Class seperti UIStyle, Score, dan HistoryManager dapat digunakan kembali tanpa perlu mengubah struktur utama aplikasi.

Maintainability
Dengan struktur OOP yang jelas, aplikasi mudah dikembangkan atau ditambahkan fitur baru di kemudian hari.