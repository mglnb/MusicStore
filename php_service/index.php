<?php
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "musicstore";

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);
// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
} 

$sql = "SELECT id, modelo, marca, cor, categoria, preco FROM instrumento";
$result = $conn->query($sql);
if ($result->num_rows > 0) {
    $data = array();
    while($row = $result->fetch_assoc()) {
        array_push($data, [
            'id' => $row["id"],
            'modelo' => $row["modelo"],
            'marca' => $row["marca"],
            'cor' => $row["cor"],
            'categoria' => $row["categoria"],
            'preco' => $row["preco"]
        ]);
    }
    echo json_encode($data);
} else {
    echo "0 results";
}
$conn->close();
?>