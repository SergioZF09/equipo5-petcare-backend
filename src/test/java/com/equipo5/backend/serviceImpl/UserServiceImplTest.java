package com.equipo5.backend.serviceImpl;

import com.equipo5.backend.exception.EmailAlreadyExistsException;
import com.equipo5.backend.exception.NoResultsException;
import com.equipo5.backend.model.UserEntity;
import com.equipo5.backend.model.dtos.request.UserRequestDTO;
import com.equipo5.backend.model.dtos.response.*;
import com.equipo5.backend.model.enums.Role;
import com.equipo5.backend.model.mappers.UserEntityMapper;
import com.equipo5.backend.repository.UserRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.springframework.data.domain.*;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(org.mockito.junit.jupiter.MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private UserRepository repository;

    @Mock
    private UserEntityMapper mapper;

    @InjectMocks
    private UserServiceImpl service;

    private UserEntity user;
    private UserRequestDTO request;
    private UserResponseDTO response;


    @BeforeEach
    void setUp() {
        user = new UserEntity();
        user.setId(1L);
        user.setName("John Doe");
        user.setEmail("john@example.com");

        request = new UserRequestDTO("John Doe", "john@example.com", "pass", "123123", "address", "avatar");
        List<UserResponsePetsDTO> pets = mapper.toUserPetsDTOs(user.getPets());
        List<UserResponseServicesDTO> services = mapper.toUserResponseServicesDTOs(user.getServices());
        List<UserResponseBookingsDTO> bookings = mapper.toUserBookingsDTOs(user.getBookings());
        response = new UserResponseDTO(1L, Role.ADMINISTRATOR, "John Doe", "john@example.com", "123123", "address", "avatar", pets, services, bookings);
    }

    // ------------------ CREATE USER ------------------
    @Test
    void createUser_success() {
        when(repository.existsByEmail(request.email())).thenReturn(false);
        when(mapper.toUser(request)).thenReturn(user);
        when(repository.save(user)).thenReturn(user);

        Long id = service.createUser(request);

        assertEquals(1L, id);
        verify(repository).save(user);
    }

    @Test
    void createUser_emailExists_throwsException() {
        when(repository.existsByEmail(request.email())).thenReturn(true);

        assertThrows(EmailAlreadyExistsException.class, () -> service.createUser(request));
        verify(repository, never()).save(any());
    }

    // ------------------ READ USER ------------------
    @Test
    void readUser_success() {
        when(repository.findById(1L)).thenReturn(Optional.of(user));
        when(mapper.toUserDTO(user)).thenReturn(response);

        UserResponseDTO result = service.readUser(1L);

        assertEquals(response, result);
    }

    @Test
    void readUser_notFound_throwsException() {
        when(repository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(NoResultsException.class, () -> service.readUser(1L));
    }

    @Test
    void readUser_nullId_throwsException() {
        assertThrows(NoResultsException.class, () -> service.readUser(null));
    }

    // ------------------ READ ALL USERS ------------------
    @Test
    void readAll_success() {
        Pageable pageable = PageRequest.of(0, 10);
        Page<UserEntity> page = new PageImpl<>(List.of(user));
        when(repository.findAll(any(Pageable.class))).thenReturn(page);
        when(mapper.toUserDTO(user)).thenReturn(response);

        Page<UserResponseDTO> result = service.readAll(pageable);

        assertEquals(1, result.getTotalElements());
        assertEquals(response, result.getContent().get(0));
    }

    @Test
    void readAll_empty() {
        Pageable pageable = PageRequest.of(0, 10);
        Page<UserEntity> page = Page.empty();
        when(repository.findAll(any(Pageable.class))).thenReturn(page);

        Page<UserResponseDTO> result = service.readAll(pageable);

        assertTrue(result.isEmpty());
    }

    // ------------------ UPDATE USER ------------------
    @Test
    void updateUser_success() {
        when(repository.findById(1L)).thenReturn(Optional.of(user));
        when(repository.existsByEmail("njohn@example.com")).thenReturn(false);

        UserRequestDTO updateRequest  = new UserRequestDTO("John Updated", "njohn@example.com", "newPass", "1231234", "newAddress", "newAvatar");

        service.updateUser(updateRequest, 1L);

        assertEquals("John Updated", user.getName());
        assertEquals("njohn@example.com", user.getEmail());
        assertEquals("newPass", user.getPassword());
        assertEquals("1231234", user.getPhone());
        assertEquals("newAddress", user.getAddress());
        assertEquals("newAvatar", user.getAvatarUser());

        verify(repository).saveAndFlush(user);
    }

    @Test
    void updateUser_emailExists_throwsException() {
        when(repository.findById(1L)).thenReturn(Optional.of(user));
        when(repository.existsByEmail("existing@example.com")).thenReturn(true);

        UserRequestDTO updateRequest = new UserRequestDTO("John Doe", "existing@example.com", "pass", "123123", "address", "avatar");

        assertThrows(EmailAlreadyExistsException.class, () -> service.updateUser(updateRequest, 1L));
        verify(repository, never()).saveAndFlush(any());
    }

    @Test
    void updateUser_userNotFound_throwsException() {
        when(repository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(NoResultsException.class, () -> service.updateUser(request, 1L));
    }

    // ------------------ DELETE USER ------------------
    @Test
    void deleteUser_success() {
        when(repository.existsById(1L)).thenReturn(true);

        service.deleteUser(1L);

        verify(repository).deleteById(1L);
    }

    @Test
    void deleteUser_notFound_throwsException() {
        when(repository.existsById(1L)).thenReturn(false);

        assertThrows(NoResultsException.class, () -> service.deleteUser(1L));
    }

    // ------------------ READ ALL USERS WITH SORT ------------------
    @Test
    void readAll_defaultSortByName() {
        // pageable sin sort explícito
        Pageable pageable = PageRequest.of(0, 10);

        // Mock
        Page<UserEntity> page = new PageImpl<>(List.of(user));
        when(repository.findAll(any(Pageable.class))).thenReturn(page);
        when(mapper.toUserDTO(user)).thenReturn(response);

        Page<UserResponseDTO> result = service.readAll(pageable);

        // Verificamos que exista un Pageable que tenga sort por "name"
        ArgumentCaptor<Pageable> pageableCaptor = ArgumentCaptor.forClass(Pageable.class);
        verify(repository).findAll(pageableCaptor.capture());
        Pageable capturedPageable = pageableCaptor.getValue();

        assertTrue(capturedPageable.getSort().isSorted());
        assertEquals("name", capturedPageable.getSort().iterator().next().getProperty());
        assertEquals(Sort.Direction.ASC, capturedPageable.getSort().iterator().next().getDirection());

        // Verificamos que el contenido siga siendo el esperado
        assertEquals(1, result.getTotalElements());
        assertEquals(response, result.getContent().get(0));
    }

}