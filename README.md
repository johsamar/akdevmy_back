#Endpoints:

**Create module**

Verb: POST

Endpoint → http://localhost:8081/api/modules

Request example:

```
{
	"name": "Module 50",
	"description": "Module 50",	
	"classes":[
		{
			"type": "Type 1",
			"name": "name1",
			"description": "description 1",
			"duration": 3,
			"url": "",
			"image": "",
			"video": "",
			"audio": "",
			"article": "",
			"document": "",
			"position": 1
		},
		{
			"type": "Type 2",
			"name": "name2",
			"description": "description 2",
			"duration": 4,
			"url": "",
			"image": "",
			"video": "",
			"audio": "",
			"article": "",
			"document": "",
			"position": 2
		},
		{
			"type": "Type 3",
			"name": "name 3",
			"description": "description 3",
			"duration": 4,
			"url": "",
			"image": "",
			"video": "",
			"audio": "",
			"article": "",
			"document": "",
			"position": 3
		}
	],
	"idCourse": "6099f3a31c8cc7483c19b5f6"
}
```

Response example:


```
{
	"message": "Módulo creado con éxito",
	"data": {
		"_id": "645aaeb04b511c5d20b66698",
		"name": "Module 50",
		"description": "Module 50",
		"classes": [
			{
				"_id": "645aaeb04b511c5d20b66695",
				"type": "Type 1",
				"name": "name1",
				"description": "description 1",
				"duration": 3,
				"url": "",
				"image": "",
				"video": "",
				"audio": "",
				"article": "",
				"document": "",
				"position": 1
			},
			{
				"_id": "645aaeb04b511c5d20b66696",
				"type": "Type 2",
				"name": "name2",
				"description": "description 2",
				"duration": 4,
				"url": "",
				"image": "",
				"video": "",
				"audio": "",
				"article": "",
				"document": "",
				"position": 2
			},
			{
				"_id": "645aaeb04b511c5d20b66697",
				"type": "Type 3",
				"name": "name2",
				"description": "description 2",
				"duration": 4,
				"url": "",
				"image": "",
				"video": "",
				"audio": "",
				"article": "",
				"document": "",
				"position": 3
			}
		],
		"idCourse": "6099f3a31c8cc7483c19b5f6"
	}
}
```


**Get modules**

Verb: GET

Endpoint → http://localhost:8081/api/modules

Response example:


```
{
	"message": "Módulos obtenidos con éxito",
	"data": [
		{
			"_id": "644f0abd6e9d54379b4e91ff",
			"name": "Module 15",
			"description": "Module 15",
			"classes": [
				{
					"_id": "644f0abd6e9d54379b4e91fc",
					"type": "Type 1",
					"name": "name1",
					"description": "description 1",
					"duration": 3,
					"url": "",
					"image": "",
					"video": "",
					"audio": null,
					"article": null,
					"document": "",
					"position": 1
				},
				{
					"_id": "644f0abd6e9d54379b4e91fd",
					"type": "Type 2",
					"name": "name2",
					"description": "description 2",
					"duration": 4,
					"url": "",
					"image": "",
					"video": "",
					"audio": null,
					"article": null,
					"document": "",
					"position": 2
				},
				{
					"_id": "644f0abd6e9d54379b4e91fe",
					"type": "Type 3",
					"name": "name2",
					"description": "description 2",
					"duration": 4,
					"url": "",
					"image": "",
					"video": "",
					"audio": null,
					"article": null,
					"document": "",
					"position": 2
				}
			],
			"idCourse": "6099f3a31c8cc7483c19b5f6"
		},
		{
			"_id": "644f0af96e9d54379b4e9204",
			"name": "Module 16",
			"description": "Module without classes",
			"classes": [],
			"idCourse": "6099f3a31c8cc7483c19b5f6"
		},
		{
			"_id": "644fde7da361c209eb73399e",
			"name": "Module 18",
			"description": "Module 18",
			"classes": [
				{
					"_id": "644fde7ca361c209eb73399b",
					"type": "Type 1",
					"name": "name1",
					"description": "description 1",
					"duration": 3,
					"url": "",
					"image": "",
					"video": "",
					"audio": null,
					"article": null,
					"document": "",
					"position": 1
				},
				{
					"_id": "644fde7ca361c209eb73399c",
					"type": "Type 2",
					"name": "name2",
					"description": "description 2",
					"duration": 4,
					"url": "",
					"image": "",
					"video": "",
					"audio": null,
					"article": null,
					"document": "",
					"position": 2
				},
				{
					"_id": "644fde7ca361c209eb73399d",
					"type": "Type 3",
					"name": "name2",
					"description": "description 2",
					"duration": 4,
					"url": "",
					"image": "",
					"video": "",
					"audio": null,
					"article": null,
					"document": "",
					"position": 2
				}
			],
			"idCourse": "6099f3a31c8cc7483c19b5f6"
		},
		{
			"_id": "644fe410a361c209eb7339c6",
			"name": "Module 19",
			"description": "Module 19",
			"classes": [
				{
					"_id": "644fe410a361c209eb7339c3",
					"type": "Type 1",
					"name": "name1",
					"description": "description 1",
					"duration": 3,
					"url": "",
					"image": "",
					"video": "",
					"audio": null,
					"article": null,
					"document": "",
					"position": 1
				},
				{
					"_id": "644fe410a361c209eb7339c4",
					"type": "Type 2",
					"name": "name2",
					"description": "description 2",
					"duration": 4,
					"url": "",
					"image": "",
					"video": "",
					"audio": null,
					"article": null,
					"document": "",
					"position": 2
				},
				{
					"_id": "644fe410a361c209eb7339c5",
					"type": "Type 3",
					"name": "name2",
					"description": "description 2",
					"duration": 4,
					"url": "",
					"image": "",
					"video": "",
					"audio": null,
					"article": null,
					"document": "",
					"position": 2
				}
			],
			"idCourse": "6099f3a31c8cc7483c19b5f6"
		},
		{
			"_id": "644fe655a361c209eb7339d8",
			"name": "Module 21",
			"description": "Module 2",
			"classes": [
				{
					"_id": "644fe655a361c209eb7339d5",
					"type": "Type 1",
					"name": "name1",
					"description": "description 1",
					"duration": 3,
					"url": "",
					"image": "",
					"video": "",
					"audio": null,
					"article": null,
					"document": "",
					"position": 1
				},
				{
					"_id": "644fe655a361c209eb7339d6",
					"type": "Type 2",
					"name": "name2",
					"description": "description 2",
					"duration": 4,
					"url": "",
					"image": "",
					"video": "",
					"audio": null,
					"article": null,
					"document": "",
					"position": 2
				},
				{
					"_id": "644fe655a361c209eb7339d7",
					"type": "Type 3",
					"name": "name2",
					"description": "description 2",
					"duration": 4,
					"url": "",
					"image": "",
					"video": "",
					"audio": null,
					"article": null,
					"document": "",
					"position": 2
				}
			],
			"idCourse": "6099f3a31c8cc7483c19b5f6"
		},
		{
			"_id": "645aaeb04b511c5d20b66698",
			"name": "Module 50",
			"description": "Module 50",
			"classes": [
				{
					"_id": "645aaeb04b511c5d20b66695",
					"type": "Type 1",
					"name": "name1",
					"description": "description 1",
					"duration": 3,
					"url": "",
					"image": "",
					"video": "",
					"audio": "",
					"article": "",
					"document": "",
					"position": 1
				},
				{
					"_id": "645aaeb04b511c5d20b66696",
					"type": "Type 2",
					"name": "name2",
					"description": "description 2",
					"duration": 4,
					"url": "",
					"image": "",
					"video": "",
					"audio": "",
					"article": "",
					"document": "",
					"position": 2
				},
				{
					"_id": "645aaeb04b511c5d20b66697",
					"type": "Type 3",
					"name": "name2",
					"description": "description 2",
					"duration": 4,
					"url": "",
					"image": "",
					"video": "",
					"audio": "",
					"article": "",
					"document": "",
					"position": 3
				}
			],
			"idCourse": "6099f3a31c8cc7483c19b5f6"
		}
	]
}
```

**Get a module by id**

Verb: GET

Endpoint → http://localhost:8081/api/modules/findById/{id}

Request example: http://localhost:8081/api/modules/findById/644fb84827d2cd43116e6467

Successful response example:


```
{
	"message": "Módulo encontrado con éxito",
	"data": {
		"_id": "644fb84827d2cd43116e6467",
		"name": "Module 16",
		"description": "Module 16",
		"classes": [
			{
				"_id": "644fb84727d2cd43116e6464",
				"type": "Type 1",
				"name": "name1",
				"description": "description 1",
				"duration": 3,
				"url": "",
				"image": "",
				"video": "",
				"audio": null,
				"article": null,
				"document": "",
				"position": 1
			},
			{
				"_id": "644fb84727d2cd43116e6465",
				"type": "Type 2",
				"name": "name2",
				"description": "description 2",
				"duration": 4,
				"url": "",
				"image": "",
				"video": "",
				"audio": null,
				"article": null,
				"document": "",
				"position": 2
			},
			{
				"_id": "644fb84727d2cd43116e6466",
				"type": "Type 3",
				"name": "name2",
				"description": "description 2",
				"duration": 4,
				"url": "",
				"image": "",
				"video": "",
				"audio": null,
				"article": null,
				"document": "",
				"position": 2
			}
		],
		"idCourse": "6099f3a31c8cc7483c19b5f6"
	}
}
```

Example of response when no module is found :

``` 
{
	"message": "El módulo con el id indicado no existe",
	"data": null
} 
```

**Delete a module by id**

Verb: DELETE

Endpoint → http://localhost:8081/api/modules/deleteById/{id}

Request example: http://localhost:8081/api/modules/deleteById/644fb84827d2cd43116e6467

Successful response example:


```
{
	"message": "Módulo eliminado con éxito",
	"data": true
}
```

Example of response when no module is found :

``` 
{
	"message": "Error al buscar el módulo: El módulo con el id indicado no existe",
	"data": null
} 
```
