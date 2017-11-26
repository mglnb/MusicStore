<?php
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "musicstore";

$modelo = $_POST['modelo'];
$marca = utf8_encode($_POST['marca']);
$cor = utf8_encode($_POST['cor']);
$categoria = utf8_encode($_POST['categoria']);
$preco = $_POST['preco'];

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);
// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
} 

$sql = $conn->prepare("INSERT INTO instrumento (modelo, marca, cor, categoria, preco)
VALUES (?, ?, ?, ?, ?)");
if($sql) {
    $sql->bind_param('ssssd', $modelo, $marca, $cor, $categoria, $preco);
    $sql->execute();

} else {
    var_dump($sql);
}

echo json_encode($sql->affected_rows);

$conn->close();
?>

<!-- 
{"modelo" : "Mg230",
"marca" : "Tagima Memphis",
"cor" : "Vermelho Metálico",
"preco" : 459.00,
"categoria" : "Guitarra"} -->