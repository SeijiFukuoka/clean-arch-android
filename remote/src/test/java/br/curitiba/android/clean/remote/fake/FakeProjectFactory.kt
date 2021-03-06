package br.curitiba.android.clean.remote.fake

import br.curitiba.android.clean.data.model.ProjectData
import br.curitiba.android.clean.remote.model.OwnerDTO
import br.curitiba.android.clean.remote.model.ProjectDTO
import br.curitiba.android.clean.remote.model.ProjectsResponseDTO
import java.util.*
import java.util.concurrent.ThreadLocalRandom

object FakeProjectFactory {

    fun randomUuid(): String {
        return UUID.randomUUID().toString()
    }

    fun randomString(): String {
        return UUID.randomUUID().toString()
    }

    fun randomInt(): Int {
        return ThreadLocalRandom.current().nextInt(0, 1000 + 1)
    }

    fun randomLong(): Long {
        return randomInt().toLong()
    }

    fun randomBoolean(): Boolean {
        return Math.random() < 0.5
    }

    fun makeProjectData(): ProjectData {
        return ProjectData(
            randomString(), randomString(), randomString(),
            randomString(), randomString(), randomString(),
            randomString(), randomBoolean()
        )
    }

    fun makeRandomProjectDataList(size: Int): List<ProjectData> {
        val projects = mutableListOf<ProjectData>()
        repeat(size) {
            projects.add(makeProjectData())
        }
        return projects
    }

    fun makeRandomOwnerDTO() = OwnerDTO(randomUuid(), randomUuid())

    fun makeProjectDTO() =
        ProjectDTO(randomUuid(), randomUuid(), randomUuid(), randomInt(), randomUuid(), makeRandomOwnerDTO())

    fun makeProjectsDTOList(size: Int = randomInt()): List<ProjectDTO> {
        val projects = mutableListOf<ProjectDTO>()
        repeat(size) {
            projects.add(makeProjectDTO())
        }
        return projects
    }

    fun makeRandomProjectsResponse() =
        ProjectsResponseDTO(listOf(makeProjectDTO(), makeProjectDTO()))
}
