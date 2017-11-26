<?php
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "musicstore";

$nome = utf8_encode($_POST['nome']);
$email = utf8_encode($_POST['email']);
$telefone = utf8_encode($_POST['telefone']);
$instrumento_id = utf8_encode($_POST['instrumento_id']);

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);
// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
} 

$sql = $conn->prepare("INSERT INTO compra (nome, email, telefone, instrumento_id)
VALUES (?, ?, ?, ?)");
if($sql) {
    $sql->bind_param('ssss', $nome, $email, $telefone, $instrumento_id);
    $sql->execute();

} else {
    var_dump($sql);
}

echo json_encode($sql->affected_rows);

$conn->close();
?>

<!-- 
{"nome" : "Mg230",
"email" : "Tagima Memphis",
"telefone" : "Vermelho Metálico",
"instrumento_id" : "Guitarra"} -->