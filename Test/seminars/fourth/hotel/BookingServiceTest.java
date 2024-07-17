package seminars.fourth.hotel;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


class BookingServiceTest {

    @Test
    public void testBookingService() {
        HotelService mockHotelService = mock(HotelService.class);
        when(mockHotelService.isRoomAvailable(ArgumentMatchers.anyInt())).thenAnswer((i) -> {
            return (Integer)i.getArgument(0) % 2 == 0;
        });
        BookingService bookingService = new BookingService(mockHotelService);
        assertTrue(bookingService.bookRoom(2));
        assertFalse(bookingService.bookRoom(3));
        verify(mockHotelService, times(2)).isRoomAvailable(ArgumentMatchers.anyInt());
    }
}
