package com.kruger.microservice.controller;


import java.util.Optional;

import com.kruger.microservice.model.ErrorResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.*;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kruger.microservice.model.FootBallPlayer;
import com.kruger.microservice.model.service.FootballPlayerService;

@Tag(name = "FootBall Player Controller", description = "Crud operations for football players")
@RestController
@RequestMapping("/footballplayer")
public class FootballPlayerController {
	
	@Autowired
	private FootballPlayerService service;

	@Tag(name = "First tag")
	@Operation(summary = "Retrieves football players", description = "Provides a list of all football players")
	@ApiResponse(responseCode = "200", description = "Successful retrieval of football players",
			content = @Content(array = @ArraySchema(schema = @Schema(implementation = FootBallPlayer.class))))
	@RequestMapping(method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE )
	public Iterable<FootBallPlayer> findAll(){
		return service.findAll();
	}

	@Tag(name = "Second tag")
	@Operation(summary = "Create football player", description = "Creates a new football player")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Successful creation of new football player"),
			@ApiResponse(responseCode = "400", description = "Bad request: unsuccessful submission",
					content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
	})
	@RequestMapping(value = "/save", method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE )
	public FootBallPlayer save(@RequestBody FootBallPlayer entity) {
		return service.save(entity);
	}

	@Tag(name = "third tag")
	@Operation(summary = "Edit football player", description = "Edit info of a football player")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "404", description = "Football player doesn't exist",
					content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
			@ApiResponse(responseCode = "400", description = "Bad request: unsuccessful submission",
					content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
			@ApiResponse(responseCode = "200", description = "Successful update of football player",
					content = @Content(schema = @Schema(implementation = FootBallPlayer.class))),
	})
	@RequestMapping(value = "/update/{id}", method=RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE )
	public FootBallPlayer edit(@PathVariable Integer id, @RequestBody FootBallPlayer entity) {
		return service.save(entity);
	}

	@Tag(name = "Fourth tag")
	@Operation(summary = "Delete football player", description = "Delete a specific player")
	@RequestMapping(value = "/delete/{id}",method=RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE )
	@ApiResponses(value = {
			@ApiResponse(responseCode = "404", description = "Football player doesn't exist",
					content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
			@ApiResponse(responseCode = "200", description = "Football player deleted successfully",
					content = @Content(schema = @Schema(implementation = FootBallPlayer.class))),
	})
	public void delete(@PathVariable Integer id) {
		service.deleteById(id);
	}

	@Tag(name = "Fifth tag")
	@Operation(summary = "Get football player by Id", description = "Returns a football player based on an ID")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "404", description = "Football player doesn't exist",
					content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
			@ApiResponse(responseCode = "200", description = "Successful retrieval of football player",
					content = @Content(schema = @Schema(implementation = FootBallPlayer.class))),
	})
	@RequestMapping(value = "/get/{id}",method=RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE )
	public Optional<FootBallPlayer> findById(@PathVariable Integer id){
		return service.findById(id);
	}

}
