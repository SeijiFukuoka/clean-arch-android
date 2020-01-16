package br.curitiba.android.remote.mapper

import br.curitiba.android.data.model.ProjectData
import br.curitiba.android.remote.fake.FakeProjectFactory
import br.curitiba.android.remote.model.ProjectDTO
import org.junit.Assert.*
import org.junit.Test

class ProjectsResponseDTOMapperTest {

    private val mapper = ProjectsResponseDTOMapper()

    @Test
    fun `it maps from Project DTO to Data`() {

        val dto = FakeProjectFactory.makeProjectDTO()
        val data = mapper.mapToData(dto)

        assertEqualsProject(dto, data)
    }

    private fun assertEqualsProject(dto: ProjectDTO, data: ProjectData) {
        assertEquals(dto.name, data.name)
        assertEquals(dto.fullName, data.fullName)
        assertEquals(dto.id, data.id)
        assertEquals(dto.starCount.toString(), data.starCount)
        assertEquals(dto.dateCreated, data.dateCreated)
        assertEquals(dto.owner.ownerName, data.ownerName)
        assertEquals(dto.owner.ownerAvatar, data.ownerAvatar)
    }
}