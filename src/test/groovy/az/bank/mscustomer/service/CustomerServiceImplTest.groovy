package az.bank.mscustomer.service

import az.bank.mscustomer.mapper.CustomerMapper
import az.bank.mscustomer.mapper.CustomerMapperImpl
import az.bank.mscustomer.repository.CustomerRepository
import az.bank.mscustomer.repository.entity.AddressEntity
import az.bank.mscustomer.repository.entity.ContactType
import az.bank.mscustomer.repository.entity.CustomerEntity
import az.bank.mscustomer.service.dto.AddressDto
import az.bank.mscustomer.service.dto.ContactDto
import az.bank.mscustomer.service.dto.CustomerDto
import spock.lang.Specification

import java.time.LocalDate

class CustomerServiceImplTest extends Specification {
    private CustomerRepository customerRepository
    private CustomerMapper customerMapper
    private CustomerService customerService

    def setup() {
        customerRepository = Mock()
        customerMapper = new CustomerMapperImpl()
        customerService = new CustomerServiceImpl(
                customerRepository,
                customerMapper
        )
    }

    def "customerCreate success"() {
        given:
        def customerDto = new CustomerDto()
        customerDto.firstName = "Ferid"
        customerDto.lastName = "Quluzade"
        customerDto.birthDate = LocalDate.of(2000, 12, 06)
        def addressDto = new AddressDto()
        addressDto.city = "aslkgj"
        addressDto.street = "ahga"
        addressDto.country = "alkhgljah"
        customerDto.address = addressDto

        Set<ContactDto> contactDtos = new HashSet<>();
        contactDtos.add(ContactDto.builder()
                .contactType(ContactType.EMAIL)
                .contactValue("askuhykag").build())
        customerDto.customerContactAddress = contactDtos


        def entityPreSave = customerMapper.fromDto(customerDto)
        def entityPostSave = customerMapper.fromDto(customerDto)

        entityPostSave.id = 12
        when:
        def actual = customerService.createCustomer(customerDto)
        then:
        1 * customerRepository.save(entityPreSave) >> entityPostSave

        actual.id == 12
    }


    def "findCustomer by Id"() {
        given:
        Long id = 7
        def customerDto = new CustomerDto();
        customerDto.firstName = "Ferid"
        customerDto.lastName = "Quluzade"
        customerDto.birthDate = LocalDate.of(2000, 12, 06)
        def addressDto = new AddressDto()
        addressDto.id = id
        addressDto.city = "aslkgj"
        addressDto.street = "ahga"
        addressDto.country = "alkhgljah"
        customerDto.address = addressDto

        Set<ContactDto> contactDtos = new HashSet<>();
        contactDtos.add(ContactDto.builder()
                .id(id)
                .contactType(ContactType.EMAIL)
                .contactValue("askuhykag").build())
        customerDto.customerContactAddress = contactDtos

        def customerEntity = customerMapper.fromDto(customerDto)

        customerDto.id = id
        customerEntity.id = id
        when:
        def actual = customerService.getCustomer(id)
        then:
        1 * customerRepository.findById(id) >> Optional.of(customerEntity)

        customerEntity.id == actual.id
    }

    def "findCustomer failed"() {
        given:
        Long id = 7
        def customerDto = new CustomerDto()
        customerDto.firstName = "Ferid"
        customerDto.lastName = "Quluzade"
        customerDto.birthDate = LocalDate.of(2002, 02, 07)

        def addressDto = new AddressDto()
        addressDto.id = id
        addressDto.city = "aslkgj"
        addressDto.street = "ahga"
        addressDto.country = "alkhgljah"
        customerDto.address = addressDto

        Set<ContactDto> contactDtos = new HashSet<>();
        contactDtos.add(ContactDto.builder()
                .id(id)
                .contactType(ContactType.EMAIL)
                .contactValue("askuhykag").build())

        customerDto.customerContactAddress = contactDtos

        def customerEntity = customerMapper.fromDto(customerDto)

        customerDto.id = id
        when:
        def actual = customerService.getCustomer(id)

        then:
        1 * customerRepository.findById(id) >> Optional.empty()

    }

    def "deleteCustomer success"() {
        given:
        Long id = 7

        def customerEntity = new CustomerEntity()
        customerEntity.firstName = "Ferid"
        customerEntity.lastName = "Quluzade"
        customerEntity.birthDate = LocalDate.of(2002, 07, 02)

        def addressEntity = new AddressEntity()
        addressEntity.city = "Baku"
        addressEntity.country = "Azerbaijan"
        addressEntity.street = "Svetlana Memmedova home 12"
        customerEntity.address = addressEntity

        Set<ContactDto> contactDtos = new HashSet<>();
        contactDtos.add(ContactDto.builder()
                .id(id)
                .contactType(ContactType.EMAIL)
                .contactValue("askuhykag").build())

        customerEntity.customerContactAddress = contactDtos

        customerEntity.id = id
        when:
        customerService.deleteCustomer(id)

        then:
        customerRepository.findById(id) >> Optional.of(customerEntity)
        customerRepository.deleteById(customerEntity.id)
    }

    def "customerEdit success"() {

        given:
        Long id = 7

        def customerEntity = new CustomerEntity()
        customerEntity.firstName = "Ferid"
        customerEntity.lastName = "Quluzade"
        customerEntity.birthDate = LocalDate.of(2002, 07, 02)

        def addressEntity = new AddressEntity()
        addressEntity.id = id
        addressEntity.city = "Baku"
        addressEntity.country = "Azerbaijan"
        addressEntity.street = "Svetlana Memmedova home 12"
        customerEntity.address = addressEntity

        Set<ContactDto> contactDtosEntity = new HashSet<>();
        contactDtosEntity.add(ContactDto.builder()
                .id(id)
                .contactType(ContactType.EMAIL)
                .contactValue("askuhykag").build())

        customerEntity.customerContactAddress = contactDtosEntity

        customerEntity.id = id


        def customerDto = new CustomerDto()
        customerDto.firstName = "Ferid"
        customerDto.lastName = "Quluzade"
        customerDto.birthDate = LocalDate.of(2000, 12, 06)
        def addressDto = new AddressDto()
        addressDto.city = "aslkgj"
        addressDto.street = "ahga"
        addressDto.country = "alkhgljah"
        customerDto.address = addressDto

        Set<ContactDto> contactDtos = new HashSet<>();
        contactDtos.add(ContactDto.builder()

                .contactType(ContactType.EMAIL)
                .contactValue("askuhykag").build())
        customerDto.customerContactAddress = contactDtos

        def entityUpdate = customerMapper.fromDto(customerDto)
        entityUpdate.id = customerEntity.id
        entityUpdate.address.id = customerEntity.address.id



        when:
        customerService.editCustomer(customerDto, id)
        then:
        customerRepository.findById(id) >> Optional.of(customerEntity)
        customerRepository.save(entityUpdate) >> entityUpdate
    }
}
