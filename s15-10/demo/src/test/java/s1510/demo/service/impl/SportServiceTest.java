package s1510.demo.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import s1510.demo.dtos.request.SportRequest;
import s1510.demo.dtos.response.SportResponse;
import s1510.demo.model.Sport;
import s1510.demo.repository.SportRepository;
import s1510.demo.service.imp.SportServiceImplementation;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class SportServiceTest {

    @InjectMocks
    private SportServiceImplementation sportService;

    @Mock
    private SportRepository sportRepository;

    private Sport sport;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);

        sport = new Sport();
        sport.setId(1L);
        sport.setName("Football");
        sport.setStatus(true);
    }

    @Test
    public void testFindAll() {
        when(sportRepository.findAll()).thenReturn(Collections.singletonList(sport));

        List<SportResponse> foundSports = sportService.findAll();

        assertNotNull(foundSports);
        assertFalse(foundSports.isEmpty());
        assertEquals(sport.getId(), foundSports.get(0).id());

        verify(sportRepository, times(1)).findAll();
    }

    @Test
    public void testFindById() {
        when(sportRepository.findById(1L)).thenReturn(Optional.of(sport));

        SportResponse foundSport = sportService.findById(1L);

        assertNotNull(foundSport);
        assertEquals(sport.getId(), foundSport.id());
        assertEquals(sport.getName(), foundSport.name());
        assertEquals(sport.getStatus(), foundSport.status());

        verify(sportRepository, times(1)).findById(1L);
    }

    @Test
    public void testCreate() {
        // Arrange
        SportRequest sportRequest = new SportRequest("Valorant", 11, 2);
        Sport expectedSport = new Sport();
        expectedSport.setName(sportRequest.name());
        expectedSport.setTeamSize(sportRequest.teamSize());
        expectedSport.setRounds(sportRequest.rounds());
        expectedSport.setStatus(true);

        when(sportRepository.save(
                any(Sport.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));

        // Act
        SportResponse sportResponse = sportService.create(sportRequest);

        // Assert
        assertNotNull(sportResponse);
        assertEquals(expectedSport.getName(), sportResponse.name());
        assertEquals(expectedSport.getTeamSize(), sportResponse.teamSize());
        assertEquals(expectedSport.getRounds(), sportResponse.rounds());
        assertEquals(expectedSport.getStatus(), sportResponse.status());

        verify(sportRepository, times(1)).save(any(Sport.class));
    }

    @Test
    public void testUpdate() {
        // Arrange
        Long id = 1L;
        Sport sportDB = new Sport();
        sportDB.setId(id);
        sportDB.setName("Valorant");
        sportDB.setTeamSize(11);
        sportDB.setRounds(2);
        sportDB.setStatus(true);

        SportRequest sportRequest = new SportRequest("CS GO 2", 5, 4);

        when(sportRepository.findById(id)).thenReturn(Optional.of(sportDB));
        when(sportRepository.save(any(Sport.class))).thenAnswer(invocation -> invocation.getArgument(0));

        // Act
        SportResponse sportResponse = sportService.update(id, sportRequest);

        // Assert
        assertNotNull(sportResponse);
        assertEquals(sportRequest.name(), sportResponse.name());
        assertEquals(sportRequest.teamSize(), sportResponse.teamSize());
        assertEquals(sportRequest.rounds(), sportResponse.rounds());
        assertEquals(sportDB.getStatus(), sportResponse.status());

        verify(sportRepository, times(1)).findById(id);
        verify(sportRepository, times(1)).save(any(Sport.class));
    }

    @Test
    public void testDisabled() {
        // Arrange
        Long id = 1L;
        Sport sportDB = new Sport();
        sportDB.setId(id);
        sportDB.setName("League of Legends");
        sportDB.setStatus(true);

        when(sportRepository.findById(id)).thenReturn(Optional.of(sportDB));
        when(sportRepository.save(any(Sport.class))).thenAnswer(invocation -> {
            Sport sport = invocation.getArgument(0);
            sport.setStatus(false);
            return sport;
        });

        // Act
        sportService.disabled(id);

        // Assert
        assertFalse(sportDB.getStatus());
        verify(sportRepository, times(1)).findById(id);
        verify(sportRepository, times(1)).save(any(Sport.class));
    }

    @Test
    public void testEnabled() {
        // Arrange
        Long id = 1L;
        Sport sportDB = new Sport();
        sportDB.setId(id);
        sportDB.setName("League of Legends");
        sportDB.setStatus(false);

        when(sportRepository.findById(id)).thenReturn(Optional.of(sportDB));
        when(sportRepository.save(any(Sport.class))).thenAnswer(invocation -> {
            Sport sport = invocation.getArgument(0);
            sport.setStatus(true);
            return sport;
        });

        // Act
        sportService.enabled(id);

        // Assert
        assertTrue(sportDB.getStatus());
        verify(sportRepository, times(1)).findById(id);
        verify(sportRepository, times(1)).save(any(Sport.class));
    }

}
