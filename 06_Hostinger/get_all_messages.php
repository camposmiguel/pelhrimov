<?php

	require_once 'DbOperation.php';

	$db = new DbOperation();

	$messages = $db->getAllMessages();

	$response = array();

	$response['error'] = false;
	$response['messages'] = array();

	while($rest = $messages->fetch_assoc()){
		$temp = array();
		$temp['idMessage']=$rest['id'];
		$temp['textMessage']=$rest['text'];
		$temp['user']=$rest['user'];
		$temp['time']=$rest['datetime'];
		array_push($response['messages'],$temp);
	}

	echo json_encode($response);
